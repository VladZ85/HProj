package com.haulmont.service.addclient;

import com.haulmont.model.entity.Client;
import com.haulmont.repository.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vlad on 15-Mar-17.
 */
@Service
public class AddClientServiceImpl implements AddClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(Client clientDAO) {

        Client client = new Client();
        client.setFirstName(clientDAO.getFirstName());
        client.setMiddleName(clientDAO.getMiddleName());
        client.setLastName(clientDAO.getLastName());
        client.setPhoneNumber(clientDAO.getPhoneNumber());

        clientRepository.save(client);
    }
}
