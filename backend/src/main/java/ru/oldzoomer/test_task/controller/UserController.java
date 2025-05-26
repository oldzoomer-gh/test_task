package ru.oldzoomer.test_task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import ru.oldzoomer.test_task.dto.WebAppInitDataDto;
import ru.oldzoomer.test_task.entity.WebAppInitData;
import ru.oldzoomer.test_task.mapper.WebAppInitDataMapper;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final WebAppInitDataMapper webAppInitDataMapper;

    @GetMapping("/userInfo")
    public WebAppInitDataDto.User getUser(HttpSession session) {
        return (WebAppInitDataDto.User) webAppInitDataMapper.toDto(
            (WebAppInitData.User) session.getAttribute("user"));
    }
}
