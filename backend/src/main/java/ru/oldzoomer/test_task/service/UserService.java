package ru.oldzoomer.test_task.service;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.servlet.http.HttpSession;

public interface UserService {
    JsonNode getUserInfo(HttpSession session);
}
