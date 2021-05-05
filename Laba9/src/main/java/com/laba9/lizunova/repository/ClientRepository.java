package com.laba9.lizunova.repository;

import com.laba9.lizunova.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findClientById(UUID id);

    List<Client> findClientsByIdIn(List<UUID> usersId);

}
