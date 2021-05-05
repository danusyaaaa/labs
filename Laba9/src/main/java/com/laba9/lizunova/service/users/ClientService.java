package com.laba9.lizunova.service.users;

import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;

import java.util.UUID;

public interface ClientService {

    ClientDto addNewClient(ClientDto client);

    ClientDto showClientById(UUID id);

    ClientDto deleteClient(UUID id);

    ClientDto changeClient(UUID id, ClientDto user);
}
