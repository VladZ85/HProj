package com.haulmont.repository.client;

import com.haulmont.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vlad on 15-Mar-17.
 */
@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {
}
