package ru.oldzoomer.test_task.entity;

public record WebAppInitData(
        String queryId,
        User user,
        User receiver,
        Chat chat,
        String startParam,
        String canSendAfter,
        int authDate,
        String hash
) {
    public record User(
            long id,
            String firstName,
            String lastName,
            String username,
            String languageCode,
            boolean isPremium,
            boolean addedToAttachmentMenu,
            boolean allowsWriteToPm
    ) {}

    public record Chat(
            long id,
            String type,
            String title,
            String username,
            String photoUrl
    ) {}
}
