package com.haulmont.ui.clients;

import com.haulmont.ui.commons.AutoshopMainUI;
import com.haulmont.utils.ClientsStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vlad on 02-Mar-17.
 */
@SpringView(name = ClientLayoutFactory.NAME, ui = AutoshopMainUI.class)
public class ClientLayoutFactory extends VerticalLayout implements View {
    public static final String NAME = "editclients";

    @Autowired
    private AddClientMainLayoutFactory mainLayoutFactory;

    private TabSheet tabSheet;

    private void addLayout() {
        setMargin(true);

        tabSheet = new TabSheet();
        tabSheet.setWidth("100%");

        Component addClientMainTab = mainLayoutFactory.createComponent();

        tabSheet.addTab(addClientMainTab, ClientsStringUtils.MAIN_MENU.getString());

        addComponent(tabSheet);
    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        removeAllComponents();
        addLayout();
    }
}
