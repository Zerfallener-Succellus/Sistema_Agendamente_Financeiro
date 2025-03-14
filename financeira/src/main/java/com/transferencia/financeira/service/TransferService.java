package com.transferencia.financeira.service;

import com.transferencia.financeira.model.Transfer;
import com.transferencia.financeira.model.User;
import com.transferencia.financeira.repository.TransferRepository;
import com.transferencia.financeira.repository.UserRepository;
import com.transferencia.financeira.util.FeeCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;
    private final UserRepository userRepository;


    public Transfer saveTransfer(Transfer transfer) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("Usuário não encontrado: " + username));


        transfer.setUser(currentUser);


        BigDecimal fee = FeeCalculator.calculateFee(transfer.getTransferDate(), transfer.getAmount());

        if (fee == null || fee.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Erro: Sem taxa aplicavel.");
        }

        transfer.setFee(fee);
        transfer.setTotalAmount(transfer.getAmount().add(fee));
        transfer.setScheduleDate(LocalDate.now());

        return transferRepository.save(transfer);
    }


    public List<Transfer> getCurrentUserTransfers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Usar getName() em vez de getPrincipal()

        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("usuário não encontrado: " + username));

        return transferRepository.findByUserId(currentUser.getId());
    }


    public List<Transfer> getTransfersByUserId(Long userId) {
        return transferRepository.findByUserId(userId);
    }
}