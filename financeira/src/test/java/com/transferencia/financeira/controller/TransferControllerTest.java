package com.transferencia.financeira.controller;

import com.transferencia.financeira.model.Transfer;
import com.transferencia.financeira.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransferControllerTest {

    @Mock
    private TransferService transferService;

    @InjectMocks
    private TransferController transferController;

    private Transfer transfer;
    private List<Transfer> transferList;

    @BeforeEach
    void setUp() {
        transfer = new Transfer();
        transfer.setAmount(new BigDecimal("1000.00"));
        transfer.setTransferDate(LocalDate.now());
        transfer.setFee(new BigDecimal("30.00"));
        transfer.setTotalAmount(new BigDecimal("1030.00"));

        transferList = Arrays.asList(
                transfer,
                new Transfer(null, "XXXXXXXXXX", "XXXXXXXXXX", new BigDecimal("500.00"),
                        new BigDecimal("15.00"), LocalDate.now().plusDays(15),
                        LocalDate.now(), new BigDecimal("515.00"), null)
        );
    }

    @Test
    void salvarTransferenciaSucesso() {

        when(transferService.saveTransfer(any(Transfer.class))).thenReturn(transfer);


        ResponseEntity<Transfer> response = transferController.saveTransfer(transfer);


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transfer, response.getBody());
        verify(transferService).saveTransfer(transfer);
    }

    @Test
    void salvarTransferenciaErro() {

        when(transferService.saveTransfer(any(Transfer.class)))
                .thenThrow(new IllegalArgumentException("Erro na transferência"));


        ResponseEntity<Transfer> response = transferController.saveTransfer(transfer);


        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
        verify(transferService).saveTransfer(transfer);
    }

    @Test
    void buscarMinhasTransferencias() {

        when(transferService.getCurrentUserTransfers()).thenReturn(transferList);


        ResponseEntity<List<Transfer>> response = transferController.getMyTransfers();


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transferList, response.getBody());
        assertEquals(2, response.getBody().size());
        verify(transferService).getCurrentUserTransfers();
    }

    @Test
    void buscarTransferenciasPorUsuarioId() {

        Long userId = 1L;
        when(transferService.getTransfersByUserId(userId)).thenReturn(transferList);


        ResponseEntity<List<Transfer>> response = transferController.getTransfersByUserId(userId);


        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transferList, response.getBody());
        assertEquals(2, response.getBody().size());
        verify(transferService).getTransfersByUserId(userId);
    }
}