package com.haulmont.ui.clients;

import com.haulmont.model.entity.Client;
import com.haulmont.service.addclient.AddClientService;
import com.haulmont.utils.ClientsStringUtils;
import com.haulmont.utils.NotificationMessages;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.*;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Vlad on 06-Mar-17.
 */
@org.springframework.stereotype.Component
public class AddClientMainLayoutFactory {

    private class AddClientMainLayout extends VerticalLayout implements Button.ClickListener {

        private TextField firstName;
        private TextField middleName;
        private TextField lastName;
        private TextField phoneNumber;

        private Button okButton;
        private Button cancelButton;

        private BeanFieldGroup<Client> fieldGroup;
        private Client client;

        private StudentSavedListener studentSavedListener;

        public AddClientMainLayout (StudentSavedListener studentSavedListener) {
            this.studentSavedListener = studentSavedListener;
        }

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

            okButton.addClickListener(this);
            cancelButton.addClickListener(this);

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

        public void buttonClick(Button.ClickEvent clickEvent) {
            if (clickEvent.getSource() == this.okButton) {
                save();
            }
            else {
                clearField();
            }

        }

        private void save () {
            try {
                fieldGroup.commit();
            } catch (FieldGroup.CommitException e) {
                Notification.show(NotificationMessages.CLIENT_SAVE_VALIDATION_ERROR_TITLE.getString(),
                    NotificationMessages.CLIENT_SAVE_VALIDATION_ERROR_DESCRIPTION.getString(),
                        Notification.Type.ERROR_MESSAGE );
                return;
            }
            addClientService.saveClient(client);
            studentSavedListener.studentSaved();
            clearField();

            Notification.show(NotificationMessages.CLIENT_SAVE_SUCCESS_TITLE.getString(),
                    NotificationMessages.CLIENT_SAVE_SUCCESS_DESCRIPTION.getString(),
                    Notification.Type.WARNING_MESSAGE );
        }

        private void clearField() {
            firstName.setValue(null);
            middleName.setValue(null);
            lastName.setValue(null);
            phoneNumber.setValue(null);
        }
    }

    @Autowired
    private AddClientService addClientService;

    public Component createComponent(StudentSavedListener studentSavedListener) {
        return new AddClientMainLayout(studentSavedListener).init().bind().layout();
    }

}
