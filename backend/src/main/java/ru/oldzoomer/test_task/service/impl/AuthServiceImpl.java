package ru.oldzoomer.test_task.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ru.oldzoomer.test_task.entity.WebAppInitData;
import ru.oldzoomer.test_task.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    @Value("${telegram.bot.token}")
    private String botToken;

    @Override
    public boolean validate(WebAppInitData webAppInitData) {
        if (webAppInitData == null) {
            return false;
        }

        String dataCheckString = Arrays.stream(new String[]{
                "auth_date=" + webAppInitData.authDate(),
                "query_id=" + webAppInitData.queryId(),
                "user=" + webAppInitData.user().id(),
                "hash=" + webAppInitData.hash()
        }).sorted().collect(Collectors.joining("\n"));

        String secretKey = MessageDigest.isEqual(
                dataCheckString.getBytes(),
                webAppInitData.hash().getBytes()
        ) ? botToken : null;

        if (secretKey == null) {
            return false;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest((dataCheckString + secretKey).getBytes());
            String calculatedHash = bytesToHex(hashBytes);

            return calculatedHash.equals(webAppInitData.hash());
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
}
