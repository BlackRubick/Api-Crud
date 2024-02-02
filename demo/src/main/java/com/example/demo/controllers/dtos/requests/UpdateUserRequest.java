package com.example.demo.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateUserRequest {
    private String email;
    private String password;
    private String fechaRegistro;
    private String fechaEliminacion;
}
