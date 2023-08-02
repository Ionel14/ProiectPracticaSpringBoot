package com.example.ProiectPracticaSpringBoot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;

    @NotEmpty(message = "Please enter valid firstname.")
    private String firstname;

    @NotEmpty(message = "Please enter valid lastname.")
    private String lastname;

    @NotEmpty(message = "Please enter valid email.")
    @Email
    private String email;

    @NotEmpty(message = "Please enter valid password.")
    private String password;

    private String role;
}