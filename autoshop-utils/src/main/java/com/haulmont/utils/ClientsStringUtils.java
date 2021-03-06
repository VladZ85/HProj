package com.haulmont.utils;

/**
 * Created by Vlad on 05-Mar-17.
 */
public enum  ClientsStringUtils {

    ADD_EDIT_CLIENT("ADD/EDIT CLIENT"),
    SHOW_ALL("SHOW ALL CLIENTS"),
    FIRST_NAME("First name"),
    MIDDLE_NAME("Middle name"),
    LAST_NAME("Last name"),
    PHONE_NUMBER("Phone Number"),
    OK_BUTTON("OK"),
    CANCEL_BUTTON("Cancel");

    private final String string;


    ClientsStringUtils(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
