package com.transferencia.financeira.controller;

import com.transferencia.financeira.dto.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(Principal principal) {
        log.info("Usuario {} est'a autenticado", principal.getName());
        return ResponseEntity.ok(new MessageResponse("Usuário autenticado: " + principal.getName()));

    }
}