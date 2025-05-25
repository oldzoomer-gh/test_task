package ru.oldzoomer.test_task.service;

import java.util.UUID;

import ru.oldzoomer.test_task.entity.WebAppInitData;

public interface UserService {
    WebAppInitData.User getUser(UUID sessionUuid);
}
