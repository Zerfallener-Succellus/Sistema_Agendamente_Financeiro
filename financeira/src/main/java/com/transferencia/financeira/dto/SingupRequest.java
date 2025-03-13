package com.transferencia.financeira.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingupRequest {

    @NotBlank(message = "O Username nao pode ser vazio")
    @Size(min = 3, max = 20, message = "O username precisa ter entre 3 e 20 caracteres")
    private String username;

    @NotBlank(message = "Senha nao pode ser vaziua")
    @Size(min = 6, max = 40, message = "A senha precisa ter entre 6 e 50 caracteres")
    private String password;

    private String role;
}
