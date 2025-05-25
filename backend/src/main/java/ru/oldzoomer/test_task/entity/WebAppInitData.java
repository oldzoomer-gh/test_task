package ru.oldzoomer.test_task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WebAppInitData {
    private String queryId;
    private User user;
    private User receiver;
    private Chat chat;
    private String startParam;
    private String canSendAfter;
    private int authDate;
    private String hash;

    @Getter
    @AllArgsConstructor
    public static class User {
        private long id;
        private String firstName;
        private String lastName;
        private String username;
        private String languageCode;
        private boolean isPremium;
        private boolean addedToAttachmentMenu;
        private boolean allowsWriteToPm;
    }

    @Getter
    @AllArgsConstructor
    public static class Chat {
        private long id;
        private String type;
        private String title;
        private String username;
        private String photoUrl;
    }
}

