package ru.oldzoomer.test_task.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ru.oldzoomer.test_task.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    
    @PostMapping("/auth")
    public void auth(@RequestBody String webAppInitData, HttpSession session)
        throws JsonProcessingException, InvalidKeyException,
        UnsupportedEncodingException, NoSuchAlgorithmException {
        authService.auth(webAppInitData, session);
    }
}
