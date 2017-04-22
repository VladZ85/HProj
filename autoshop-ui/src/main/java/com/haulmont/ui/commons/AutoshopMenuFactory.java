package com.haulmont.ui.commons;

import com.haulmont.navigator.AutoshopNavigator;
import com.haulmont.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Vlad on 25-Feb-17.
 */
@org.springframework.stereotype.Component
public class AutoshopMenuFactory implements UIComponentBuilder {

    private class AutoshopMenu extends VerticalLayout implements Property.ValueChangeListener {

        private Tree mainMenu;

        public AutoshopMenu init() {
            mainMenu = new Tree();
            mainMenu.addValueChangeListener(this);
            return this;
        }

        public AutoshopMenu layout () {
            setWidth("100%");
            setHeightUndefined();

            mainMenu.addItem(StringUtils.MENU_CLIENT.getString());
            mainMenu.addItem(StringUtils.MENU_ORDER.getString());

            mainMenu.expandItem(StringUtils.MENU_CLIENT.getString());
            mainMenu.expandItem(StringUtils.MENU_ORDER.getString());

            mainMenu.addItem(StringUtils.MENU_CLIENT_LIST.getString());
            mainMenu.addItem(StringUtils.MENU_CLIENT_EDIT.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_CLIENT_LIST.getString(), false);
            mainMenu.setChildrenAllowed(StringUtils.MENU_CLIENT_EDIT.getString(), false);
            mainMenu.setParent(StringUtils.MENU_CLIENT_LIST.getString(), StringUtils.MENU_CLIENT.getString());
            mainMenu.setParent(StringUtils.MENU_CLIENT_EDIT.getString(), StringUtils.MENU_CLIENT.getString());

            mainMenu.addItem(StringUtils.MENU_ORDER_LIST.getString());
            mainMenu.addItem(StringUtils.MENU_ORDER_EDIT.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_ORDER_LIST.getString(), false);
            mainMenu.setChildrenAllowed(StringUtils.MENU_ORDER_EDIT.getString(), false);
            mainMenu.setParent(StringUtils.MENU_ORDER_LIST.getString(), StringUtils.MENU_ORDER.getString());
            mainMenu.setParent(StringUtils.MENU_ORDER_EDIT.getString(), StringUtils.MENU_ORDER.getString());

            addComponent(mainMenu);

            return this;
        }

        public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
            String selectedItemPath = (String) valueChangeEvent.getProperty().getValue();
            if (selectedItemPath == null) return;
            String path = selectedItemPath.toLowerCase().replaceAll("\\s+", "");
            AutoshopNavigator.navigate(path);
        }
    }

    public Component createComponent() {
        return new AutoshopMenu().init().layout();
    }
}
