package ru.oldzoomer.test_task.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.servlet.http.HttpSession;

public interface AuthService {
    void auth(String webAppInitData, HttpSession session)
        throws JsonProcessingException, InvalidKeyException,
        UnsupportedEncodingException, NoSuchAlgorithmException;
}