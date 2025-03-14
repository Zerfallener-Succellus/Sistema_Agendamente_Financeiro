package com.transferencia.financeira.controller;

import com.transferencia.financeira.model.Transfer;
import com.transferencia.financeira.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;


    @PostMapping
    public ResponseEntity<Transfer> saveTransfer(@RequestBody Transfer transfer) {
        try {
            Transfer savedTransfer = transferService.saveTransfer(transfer);
            return ResponseEntity.ok(savedTransfer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping("/extrato")
    public ResponseEntity<List<Transfer>> getMyTransfers() {
        List<Transfer> transfers = transferService.getCurrentUserTransfers();
        return ResponseEntity.ok(transfers);
    }


    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Transfer>> getTransfersByUserId(@PathVariable Long userId) {
        List<Transfer> transfers = transferService.getTransfersByUserId(userId);
        return ResponseEntity.ok(transfers);
    }
}