package ru.oldzoomer.test_task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ru.oldzoomer.test_task.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/userInfo")
    public ResponseEntity<JsonNode> getUser(HttpSession session) {
        JsonNode userInfo = userService.getUserInfo(session);
        return ResponseEntity.ok(userInfo);
    }
}