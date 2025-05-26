package ru.oldzoomer.test_task.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ru.oldzoomer.test_task.dto.WebAppInitDataDto;
import ru.oldzoomer.test_task.entity.WebAppInitData;
import ru.oldzoomer.test_task.mapper.WebAppInitDataMapper;
import ru.oldzoomer.test_task.service.AuthService;


@RestController
@RequiredArgsConstructor
public class AuthController {
    private final WebAppInitDataMapper webAppInitDataMapper;
    private final AuthService authService;

    @PostMapping("/auth")
    public void postMethodName(@RequestBody WebAppInitDataDto webAppInitDataDto, HttpSession session) {
        WebAppInitData entity = webAppInitDataMapper.toEntity(webAppInitDataDto);
        if (authService.validate(entity)) {
            session.setAttribute("user", entity.user());
        }
    }
}
