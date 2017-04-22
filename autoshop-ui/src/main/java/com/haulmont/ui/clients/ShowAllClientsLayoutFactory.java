package com.haulmont.ui.clients;

import com.haulmont.model.entity.Client;
import com.haulmont.service.showallstudents.ShowAllStudentsService;
import com.haulmont.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Vlad on 21-Mar-17.
 */
@org.springframework.stereotype.Component
public class ShowAllClientsLayoutFactory implements UIComponentBuilder {

    public static final String NAME = "clientslist";

    private List<Client> clients;
    private BeanItemContainer <Client> container;

    private class ShowAllClientsLayout extends VerticalLayout {

        private Grid clientsTable;

        public  ShowAllClientsLayout init() {
            setMargin(true);
            container = new BeanItemContainer<Client>(Client.class, clients);
            clientsTable = new Grid(container);
            clientsTable.setColumnOrder("firstName", "lastName", "middleName", "phoneNumber");
            clientsTable.removeColumn("id");
            clientsTable.setWidth("100%");
            clientsTable.setImmediate(true);
            return this;
        }

        public ShowAllClientsLayout load () {
            clients = showAllStudentsService.getAllClients();
            return this;
        }


        public ShowAllClientsLayout layout() {
            addComponent(clientsTable);
            return this;
        }

    }

    public void refreshTable() {
        clients = showAllStudentsService.getAllClients();
        container.removeAllItems();
        container.addAll(clients);
    }

    @Autowired
    private ShowAllStudentsService showAllStudentsService;

    public Component createComponent() {
        return new ShowAllClientsLayout().load().init().layout() ;
    }
}
