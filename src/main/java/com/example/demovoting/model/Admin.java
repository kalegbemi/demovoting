package com.example.demovoting.model;

import com.example.demovoting.enom.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class Admin extends {

    private int Id;

    private String password;

    @Column(name = "full_name")
    @Length(min = 6, message ="Enter your first and last name")
    private String fullName;

    @Email(message = "Enter a valid email")
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.ADMIN;

}
