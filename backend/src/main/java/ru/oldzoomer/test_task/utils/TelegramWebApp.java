package ru.oldzoomer.test_task.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class TelegramWebApp {

    public static Map<String, String> parseInitData(String initData, String botToken) {
        Map<String, String> params = new TreeMap<>();
        if (initData != null) {
            String[] pairs = initData.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                if (idx > 0) {
                    try {
                        String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8.name());
                        String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8.name());
                        params.put(key, value);
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        if (!validate(params, botToken)) {
            throw new IllegalArgumentException("Invalid init data");
        }

        return params;
    }

    private static boolean validate(Map<String, String> params, String botToken) {
        String hash = params.remove("hash");
        if (hash == null) {
            return false;
        }
        String dataCheckString = createDataCheckString(params);
        try {
            String computedHash = computeHash(dataCheckString, botToken);
            return hash.equals(computedHash);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            return false;
        }
    }

    private static String createDataCheckString(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("\n"));
    }

    private static String computeHash(String data, String botToken)
            throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(hmacSha256("WebAppData", botToken), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hashBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static byte[] hmacSha256(String data, String secret) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);
        return mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }
}
