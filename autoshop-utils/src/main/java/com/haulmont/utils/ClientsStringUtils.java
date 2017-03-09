package com.haulmont.utils;

/**
 * Created by Vlad on 05-Mar-17.
 */
public enum  ClientsStringUtils {

    MAIN_MENU("MAIN MENU"),
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
