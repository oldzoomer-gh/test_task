package ru.oldzoomer.test_task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WebAppInitDataDto(
    @JsonProperty("query_id") String queryId,
    @JsonProperty("user") User user,
    @JsonProperty("receiver") User receiver,
    @JsonProperty("chat") Chat chat,
    @JsonProperty("start_param") String startParam,
    @JsonProperty("can_send_after") String canSendAfter,
    @JsonProperty("auth_date") int authDate,
    @JsonProperty("hash") String hash
) {
    public record User(
        @JsonProperty("id") long id,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("username") String username,
        @JsonProperty("language_code") String languageCode,
        @JsonProperty("is_premium") boolean isPremium,
        @JsonProperty("added_to_attachment_menu") boolean addedToAttachmentMenu,
        @JsonProperty("allows_write_to_pm") boolean allowsWriteToPm
    ) {}

    public record Chat(
        @JsonProperty("id") long id,
        @JsonProperty("type") String type,
        @JsonProperty("title") String title,
        @JsonProperty("username") String username,
        @JsonProperty("photo_url") String photoUrl
    ) {}
}


