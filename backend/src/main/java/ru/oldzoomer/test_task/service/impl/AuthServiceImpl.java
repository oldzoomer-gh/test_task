package ru.oldzoomer.test_task.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpSession;
import ru.oldzoomer.test_task.service.AuthService;
import ru.oldzoomer.test_task.utils.TelegramWebApp;

@Service
public class AuthServiceImpl implements AuthService {
    private final String botToken;

    public AuthServiceImpl(@Value("${telegram.bot.token}") String botToken) {
        this.botToken = botToken;
    }

    @Override
    @Transactional
    public void auth(String webAppInitData, HttpSession session) {
        Map<String, String> webAppInitDataMap = TelegramWebApp.parseInitData(webAppInitData, botToken);
        session.setAttribute("user", webAppInitDataMap.get("user"));
    }
}