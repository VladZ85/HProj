package com.haulmont.ui.commons;

import com.haulmont.navigator.AutoshopNavigator;
import com.haulmont.ui.clients.ClientLayoutFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by Vlad on 23-Feb-17.
 */
@SpringUI(path=AutoshopMainUI.NAME)
@Title("Autoshop")
@Theme("valo")
public class AutoshopMainUI extends UI {

    public static final String NAME = "/ui";

    private Panel changeTab = new Panel();

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AutoshopMenuFactory autoshopMenuFactory;

    @Autowired
    private SpringViewProvider viewProvider;


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        changeTab.setHeight("100%");

        VerticalLayout rootLayout = new VerticalLayout();
        rootLayout.setSizeFull();
        rootLayout.setMargin(true);

        Panel contentPanel = new Panel();
        contentPanel.setWidth("70%");
        contentPanel.setHeight("100%");

        HorizontalLayout uiLayout = new HorizontalLayout();
        uiLayout.setSizeFull();
        uiLayout.setMargin(true);

        Component menu = autoshopMenuFactory.createComponent();

        uiLayout.addComponent(menu);
        uiLayout.addComponent(changeTab);

        //uiLayout.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
        //uiLayout.setComponentAlignment(menu, Alignment.TOP_CENTER);

        uiLayout.setExpandRatio(menu, 1);
        uiLayout.setExpandRatio(changeTab, 7);

        contentPanel.setContent(uiLayout);

        rootLayout.addComponent(contentPanel);
        rootLayout.setComponentAlignment(contentPanel, Alignment.TOP_CENTER);
        rootLayout.setExpandRatio(contentPanel, 1);

        initNavigator();

        setContent(rootLayout);

    }
    private void initNavigator () {
        AutoshopNavigator navigator = new AutoshopNavigator(this, changeTab);
        //insertion to application context
        applicationContext.getAutowireCapableBeanFactory().autowireBean(navigator);
        navigator.addProvider(viewProvider);
        navigator.navigateTo(ClientLayoutFactory.NAME);
    }
}
