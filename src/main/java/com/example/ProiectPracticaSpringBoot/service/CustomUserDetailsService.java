package com.example.ProiectPracticaSpringBoot.service;

import com.example.ProiectPracticaSpringBoot.model.User;
import com.example.ProiectPracticaSpringBoot.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
//
//@Log4j2
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        log.info("Loading user");
//        log.info("Email received : " + email);
//        User user = userRepository.findByEmail(email);
//        log.info(user.toString());
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return mapToUserDetails(user);
//
//    }
//
//    private org.springframework.security.core.userdetails.User mapToUserDetails(User user) {
//        var email = user.getEmail();
//        var password = user.getPassword();
//
//
//        var roles = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//        return new org.springframework.security.core.userdetails.User(email, password, roles);
//    }
//}

@Log4j2
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        log.info( "usernameOrEmail: " + usernameOrEmail);
        User user = userRepository.findByEmail(usernameOrEmail);
        log.info(user.toString());
        if (user != null) {
            return mapToUserDetails(user);
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }

    private org.springframework.security.core.userdetails.User mapToUserDetails(User user) {
        var email = user.getEmail();
        var password = user.getPassword();
        var roles = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(email, password, roles);
    }
}


