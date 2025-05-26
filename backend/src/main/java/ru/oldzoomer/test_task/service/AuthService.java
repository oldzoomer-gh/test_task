package ru.oldzoomer.test_task.service;

import ru.oldzoomer.test_task.entity.WebAppInitData;

public interface AuthService {
    boolean validate(WebAppInitData webAppInitData);
}
