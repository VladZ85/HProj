package com.haulmont.repository.client;

import com.haulmont.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vlad on 15-Mar-17.
 */
@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {

    @Query("select c from Client c order by c.firstName")
    List<Client> getAllClients();
}
