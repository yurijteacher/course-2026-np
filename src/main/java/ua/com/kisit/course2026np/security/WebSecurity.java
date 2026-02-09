package ua.com.kisit.course2026np.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.kisit.course2026np.service.UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity {

    private final UserService userService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/login", "/registration", "/static/**"
                                        , "/categories", "/category/", "/addItemFromCart", "/cart",
                                        "/addItemFromCart", "/updateItemFromCart", "/deleteItemFromCart")
                                .permitAll()
                                .requestMatchers("/user").hasAuthority("ROLE_user")
                                .requestMatchers("/manager").hasAuthority("ROLE_manager")
                                .requestMatchers("/admin").hasAuthority("ROLE_admin")
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .defaultSuccessUrl("/")
                                .permitAll()
                )
                .logout(
                        logout -> logout
                                .permitAll().logoutSuccessUrl("/")
                );


        return http.build();
    }


}
