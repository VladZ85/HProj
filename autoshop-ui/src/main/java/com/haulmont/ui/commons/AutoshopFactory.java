package com.haulmont.ui.commons;

import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Vlad on 25-Feb-17.
 */
@org.springframework.stereotype.Component
public class AutoshopFactory implements UIComponentBuilder {

    private class AutoshopMenu extends VerticalLayout {

        private Tree mainMenu;

        public AutoshopMenu init() {
            mainMenu = new Tree();
            return this;
        }

        public AutoshopMenu layout () {
            setWidth("100%");
            setHeightUndefined();

            mainMenu.addItem("CLIENT");
            mainMenu.addItem("ORDER");

            mainMenu.expandItem("CLIENT");
            mainMenu.expandItem("ORDER");

            mainMenu.addItem("Client list");
            mainMenu.addItem("Edit client");
            mainMenu.setChildrenAllowed("Client list", false);
            mainMenu.setChildrenAllowed("Edit client", false);
            mainMenu.setParent("Client list", "CLIENT");
            mainMenu.setParent("Edit client", "CLIENT");

            mainMenu.addItem("Order list");
            mainMenu.addItem("Edit order");
            mainMenu.setChildrenAllowed("Order list", false);
            mainMenu.setChildrenAllowed("Edit order", false);
            mainMenu.setParent("Order list", "ORDER");
            mainMenu.setParent("Edit order", "ORDER");

            addComponent(mainMenu);

            return this;
        }

    }

    public Component createComponent() {
        return new AutoshopMenu().init().layout();
    }
}
