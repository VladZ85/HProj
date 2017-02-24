package com.haulmont.ui.commons;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Vlad on 23-Feb-17.
 */
@SpringUI(path=AutoshopMainUI.NAME)
@Title("Autoshop")
@Theme("valo")
public class AutoshopMainUI extends UI {

    public static final String NAME = "/ui";

    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout rootLayout = new VerticalLayout();
        rootLayout.addComponent(new Label("Hello world!"));
        setContent(rootLayout);

    }
}
