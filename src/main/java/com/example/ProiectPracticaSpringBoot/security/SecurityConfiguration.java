package com.example.ProiectPracticaSpringBoot.security;

        import com.example.ProiectPracticaSpringBoot.service.CustomUserDetailsService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.security.web.SecurityFilterChain;

        import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
                http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/bootstrap/**").permitAll()
                        .requestMatchers(toH2Console()).permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/register/**").permitAll()
                        .requestMatchers("/home").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/view-team").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/team-form").hasAnyRole("ADMIN")
                        .requestMatchers("/submit-form").hasAnyRole("ADMIN")
                        .requestMatchers("/team-update").hasAnyRole("ADMIN")
                        .requestMatchers("/team-update-form/**").hasAnyRole("ADMIN")
                        .requestMatchers("/delete-team/**").hasAnyRole("ADMIN")
                        .requestMatchers("/footballers").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/footballer-form").hasAnyRole("ADMIN")
                        .requestMatchers("/submit-footballer/**").hasAnyRole("ADMIN")
                        .requestMatchers("/footballer-update-form/**").hasAnyRole("ADMIN")
                        .requestMatchers("/footballer-update").hasAnyRole("ADMIN")
                        .requestMatchers("/delete-footballer/**").hasAnyRole("ADMIN")
                        .requestMatchers("/access-denied").permitAll()
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()))
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .exceptionHandling().accessDeniedPage("/access-denied");
        return http.build();
    }
}

