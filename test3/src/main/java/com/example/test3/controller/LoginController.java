package com.example.test3.controller;

import com.example.test3.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logins")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/parse")
    public ResponseEntity<?> getPostingsByPeriod() {
        loginService.saveLoginsFromFile("D:\\Java\\A1_Test\\test3\\src\\main\\resources\\files\\logins.csv");
        return ResponseEntity.ok(null);
    }
}
