package com.haulmont.navigator;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

/**
 * Created by Vlad on 02-Mar-17.
 */
public class AutoshopNavigator extends Navigator {

    public AutoshopNavigator (UI ui, SingleComponentContainer container) {
        super(ui,container);
    }

    public static AutoshopNavigator getNavigator () {
        UI ui = UI.getCurrent();
        Navigator navigator = ui.getNavigator();
        return (AutoshopNavigator) navigator;
    }

    public static void navigate(String path) {
        try {
            AutoshopNavigator.getNavigator().navigateTo(path);
        } catch (Exception e) {
            return;
        }

    }

    @Override
    public void navigateTo(String viewName) {
        super.navigateTo(Strings.nullToEmpty(viewName));
    }

}
