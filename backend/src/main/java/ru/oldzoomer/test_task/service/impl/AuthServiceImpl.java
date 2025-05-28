package ru.oldzoomer.test_task.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import ru.oldzoomer.test_task.service.AuthService;
import ru.oldzoomer.test_task.utils.TelegramWebApp;

@Service
public class AuthServiceImpl implements AuthService {
    @Value("${telegram.bot.token}")
    private String botToken;

    @Override
    public void auth(String webAppInitData, HttpSession session) {
        Map<String, String> webAppInitDataMap = TelegramWebApp.parseInitData(webAppInitData, botToken);
        session.setAttribute("user", webAppInitDataMap.get("user"));
    }
}
