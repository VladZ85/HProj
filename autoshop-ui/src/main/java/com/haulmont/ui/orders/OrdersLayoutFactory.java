package com.haulmont.ui.orders;

import com.haulmont.ui.commons.AutoshopMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Vlad on 02-Mar-17.
 */
@SpringView(name = OrdersLayoutFactory.NAME, ui = AutoshopMainUI.class)
public class OrdersLayoutFactory extends VerticalLayout implements View {
    public static final String NAME = "editorders";

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        addComponent(new Label("Orders layout"));
    }
}
