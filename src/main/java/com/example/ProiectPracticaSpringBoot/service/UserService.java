package com.example.ProiectPracticaSpringBoot.service;

import com.example.ProiectPracticaSpringBoot.dto.UserDto;
import com.example.ProiectPracticaSpringBoot.mapper.UserMapper;
import com.example.ProiectPracticaSpringBoot.model.User;
import com.example.ProiectPracticaSpringBoot.repository.RoleRepository;
import com.example.ProiectPracticaSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserMapper userMapper;

    public void register(UserDto userDto){
        User user = userMapper.mapToUser(userDto);
        user.setRoles(Arrays.asList(roleRepository.findByName("USER")));
        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
