package com.example.ProiectPracticaSpringBoot.mapper;

import com.example.ProiectPracticaSpringBoot.dto.UserDto;
import com.example.ProiectPracticaSpringBoot.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;


@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User mapToUser(UserDto userDto){
        return User.builder()
                .email(userDto.getEmail())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
    }

}
