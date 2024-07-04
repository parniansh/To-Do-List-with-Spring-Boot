package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
 private final AppUserRepository appUserRepository;
 private final JwtService jwtService;
 private final AuthenticationManager authenticationManager;
 private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse register(AppUser requestUser){
        AppUser appUser = new AppUser();
        appUser.setFirstName(requestUser.getFirstName());
        appUser.setLastName(requestUser.getLastName());
        appUser.setUsername(requestUser.getUsername());
        appUser.setPassword(passwordEncoder.encode(requestUser.getPassword()));
        appUser.setAppUserRole(requestUser.getAppUserRole());

        appUserRepository.save(appUser);

        String token = jwtService.generateToken(appUser);

        return new AuthenticationResponse(token);

    }

    public AuthenticationResponse authenticate(AppUser requestUser){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestUser.getUsername(),
                        requestUser.getPassword()
                )
        );

        AppUser user = appUserRepository.findByUsername(requestUser.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return  new AuthenticationResponse(token);

    }


}
