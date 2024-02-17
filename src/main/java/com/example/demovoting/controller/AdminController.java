package com.example.demovoting.controller;

import com.example.demovoting.dto.AdminRegisterRequest;
import com.example.demovoting.dto.AuthenticationRequest;
import com.example.demovoting.dto.AuthenticationResponse;
import com.example.demovoting.model.Admin;
import com.example.demovoting.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    public AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<Admin> register(@RequestBody AdminRegisterRequest request){
        return new ResponseEntity<>(adminService.register(request), HttpStatusCode.valueOf(200));
    }


    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request){
        return adminService.authenticate(request);
    }

}
