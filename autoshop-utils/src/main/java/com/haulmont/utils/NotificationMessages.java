package com.haulmont.utils;

/**
 * Created by Vlad on 13-Mar-17.
 */
public enum NotificationMessages {
    CLIENT_SAVE_VALIDATION_ERROR_TITLE("ERROR"),
    CLIENT_SAVE_VALIDATION_ERROR_DISCRIPTION("Fields must be filled!");

    private final String string;

    private NotificationMessages (String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
