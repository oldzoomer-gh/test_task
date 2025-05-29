package ru.oldzoomer.test_task.service;

import jakarta.servlet.http.HttpSession;

public interface AuthService {
    void auth(String webAppInitData, HttpSession session);
}