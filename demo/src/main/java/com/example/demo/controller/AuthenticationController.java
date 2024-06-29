package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AppUser request
            ){
        System.out.println("request isssssssss  " + request.getAppUserRole());
          return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AppUser request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

//    @PostMapping("/register")
//    public void register(
//            HttpRequest request){
//        System.out.println("resuest isssssssss  " + request.toString());
//    }

}
