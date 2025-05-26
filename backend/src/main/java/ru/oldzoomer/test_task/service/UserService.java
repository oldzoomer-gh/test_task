package ru.oldzoomer.test_task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import jakarta.servlet.http.HttpSession;

public interface UserService {
    JsonNode getUserInfo(HttpSession session)
        throws JsonMappingException, JsonProcessingException;
}
