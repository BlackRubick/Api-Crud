package com.example.demo.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateUserResponse {
    private String email;
    private String password;
    private String fechaRegistro;
    private String fechaEliminacion;
}
