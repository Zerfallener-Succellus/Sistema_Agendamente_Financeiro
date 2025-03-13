package com.transferencia.financeira.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Username nao pode ser vazio")
    private String username;

    @NotBlank(message = "A senha nao pode ser vazia")
    @Size(min = 6, message = "A senha tem de ter no minimo 6 caracteres")
    private String password;
}


