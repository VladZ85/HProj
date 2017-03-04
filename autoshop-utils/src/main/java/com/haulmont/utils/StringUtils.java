package com.haulmont.utils;

/**
 * Created by Vlad on 28-Feb-17.
 */
public enum StringUtils {

    MENU_CLIENT("CLIENTS"),
    MENU_ORDER("ORDERS"),
    MENU_CLIENT_LIST("Clients list"),
    MENU_CLIENT_EDIT ("Edit clients"),
    MENU_ORDER_LIST("Orders list"),
    MENU_ORDER_EDIT ("Edit orders");

    private final String string;

    private StringUtils(String string) {
        this.string = string;
    }

    public String getString () {
        return this.string;
    }
}
