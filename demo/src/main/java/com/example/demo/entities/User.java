package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "users")
@Getter @Setter
public class User {
    @Id
    private String id;

    private String email;
    private String password;
    private String fechaRegistro;
    private String fechaEliminacion;
}
