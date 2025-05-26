package ru.oldzoomer.test_task.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;
import ru.oldzoomer.test_task.service.AuthService;
import ru.oldzoomer.test_task.utils.TelegramWebApp;

@Service
public class AuthServiceImpl implements AuthService {
    @Value("${telegram.bot.token}")
    private String botToken;

    @Override
    public void auth(String webAppInitData, HttpSession session) throws JsonProcessingException, InvalidKeyException,
            UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String, String> webAppInitDataMap = TelegramWebApp.parseInitData(webAppInitData, botToken);
        if (session.getAttribute("user") == null
                && !session.getAttribute("user").equals(webAppInitDataMap.get("user"))) {
            session.setAttribute("user", webAppInitDataMap.get(new ObjectMapper().writeValueAsString(webAppInitDataMap)));
        }
    }
}
