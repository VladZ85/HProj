package com.haulmont.ui.clients;

import com.haulmont.ui.commons.AutoshopMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Vlad on 02-Mar-17.
 */
@SpringView(name = ClientsLayoutFactory.NAME, ui = AutoshopMainUI.class)
public class ClientsLayoutFactory extends VerticalLayout implements View {
    public static final String NAME = "editclients";

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        addComponent(new Label("Clients layout"));
    }
}
