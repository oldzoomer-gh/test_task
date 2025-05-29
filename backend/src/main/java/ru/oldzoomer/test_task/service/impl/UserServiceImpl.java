package ru.oldzoomer.test_task.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;
import ru.oldzoomer.test_task.exceptions.UserNotFound;
import ru.oldzoomer.test_task.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    @Transactional
    public JsonNode getUserInfo(HttpSession session) {
        try {
            if (session.getAttribute("user") instanceof String user) {
                return new ObjectMapper().readTree(user);
            } else {
                throw new UserNotFound();
            }
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}