package com.transferencia.financeira.controller;

import com.transferencia.financeira.dto.MessageResponse;
import com.transferencia.financeira.dto.SingupRequest;
import com.transferencia.financeira.model.User;
import com.transferencia.financeira.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegistrationControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private RegistrationController registrationController;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    private SingupRequest signupRequest;

    @BeforeEach
    void setUp() {
        signupRequest = new SingupRequest();
        signupRequest.setUsername("novo_usuario");
        signupRequest.setPassword("senha123");
        signupRequest.setRole("USER");
    }

    @Test
    void registrarUsuarioSucesso() {
        // Arrange
        when(userRepository.existsByUsername("novo_usuario")).thenReturn(false);
        when(passwordEncoder.encode("senha123")).thenReturn("senha_criptografada");

        // Act
        ResponseEntity<?> response = registrationController.registerUser(signupRequest);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof MessageResponse);
        assertEquals("User registered successfully!", ((MessageResponse) response.getBody()).getMessage());

        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        assertEquals("novo_usuario", savedUser.getUsername());
        assertEquals("senha_criptografada", savedUser.getPassword());
        assertEquals("USER", savedUser.getRole());
    }

    @Test
    void registrarUsuarioUsernameExistente() {

        when(userRepository.existsByUsername("novo_usuario")).thenReturn(true);


        ResponseEntity<?> response = registrationController.registerUser(signupRequest);


        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody() instanceof MessageResponse);
        assertEquals("Error: Username is already taken!", ((MessageResponse) response.getBody()).getMessage());

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void registrarUsuarioSemDefinirRole() {

        signupRequest.setRole(null);
        when(userRepository.existsByUsername("novo_usuario")).thenReturn(false);
        when(passwordEncoder.encode("senha123")).thenReturn("senha_criptografada");


        ResponseEntity<?> response = registrationController.registerUser(signupRequest);


        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        assertEquals("USER", savedUser.getRole()); // Verifica se o valor padrão foi aplicado
    }
}