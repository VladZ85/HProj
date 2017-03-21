package com.haulmont.service.showallstudents;

import com.haulmont.model.entity.Client;
import com.haulmont.repository.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vlad on 21-Mar-17.
 */
@Service
public class ShowAllStudentsImpl implements ShowAllStudentsService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }
}
