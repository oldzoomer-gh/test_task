package ru.oldzoomer.test_task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ru.oldzoomer.test_task.service.UserService;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/userInfo")
    public JsonNode getUser(HttpSession session)
        throws JsonMappingException, JsonProcessingException {
        return userService.getUserInfo(session);
    }
}
