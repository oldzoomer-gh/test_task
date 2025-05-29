package ru.oldzoomer.test_task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ru.oldzoomer.test_task.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<Void> auth(@RequestBody String webAppInitData, HttpSession session) {
        authService.auth(webAppInitData, session);
        return ResponseEntity.ok().build();
    }
}