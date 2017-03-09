package com.haulmont.ui.clients;

import com.haulmont.model.entity.Client;
import com.haulmont.utils.ClientsStringUtils;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.*;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.*;


/**
 * Created by Vlad on 06-Mar-17.
 */
@org.springframework.stereotype.Component
public class AddClientMainLayoutFactory {

    private class AddClientMainLayout extends VerticalLayout {

        private TextField firstName;
        private TextField middleName;
        private TextField lastName;
        private TextField phoneNumber;

        private Button okButton;
        private Button cancelButton;

        private BeanFieldGroup<Client> fieldGroup;
        private Client client;

        public AddClientMainLayout init() {

            fieldGroup = new BeanFieldGroup<Client>(Client.class);
            client = new Client();
            firstName = new TextField(ClientsStringUtils.FIRST_NAME.getString());
            middleName = new TextField(ClientsStringUtils.MIDDLE_NAME.getString());
            lastName = new TextField(ClientsStringUtils.LAST_NAME.getString());
            phoneNumber = new TextField(ClientsStringUtils.PHONE_NUMBER.getString());

            okButton = new Button(ClientsStringUtils.OK_BUTTON.getString());
            cancelButton = new Button(ClientsStringUtils.CANCEL_BUTTON.getString());

            okButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
            cancelButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

            firstName.setNullRepresentation("");
            middleName.setNullRepresentation("");
            lastName.setNullRepresentation("");
            phoneNumber.setNullRepresentation("");

            return this;
        }

        public AddClientMainLayout bind() {
            fieldGroup.bindMemberFields(this);
            fieldGroup.setItemDataSource(client);
            return this;
        }

        public Component layout() {
            setMargin(true);
            GridLayout gridLayout = new GridLayout(2, 3);
            gridLayout.setSizeUndefined();
            gridLayout.setSpacing(true);

            gridLayout.addComponent(firstName, 0, 0);
            gridLayout.addComponent(middleName, 1, 0);

            gridLayout.addComponent(lastName, 0, 1);
            gridLayout.addComponent(phoneNumber, 1, 1);

            gridLayout.addComponent(new HorizontalLayout(okButton, cancelButton), 0, 2);

            return gridLayout;
        }

    }

    public Component createComponent() {
        return new AddClientMainLayout().init().bind().layout();
    }

}
