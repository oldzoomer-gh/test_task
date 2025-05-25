package ru.oldzoomer.test_task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ru.oldzoomer.test_task.dto.WebAppInitDataDto;


@RestController
@RequiredArgsConstructor
public class UserController {
    // private final WebAppInitDataMapper webAppInitDataMapper;
    // private final UserService userService;

    @GetMapping("/userInfo")
    public WebAppInitDataDto.User getUser(HttpSession session) {
        return null;
    }
}
