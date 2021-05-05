package com.laba9.lizunova.service.users;

import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;

import java.util.List;
import java.util.UUID;

public interface ClientsService {

    List<ClientDto> addNewClients(List<Client> clients);

    List<ClientDto> showAllClientsByListId(List<UUID> usersId);

    List<Client> showAllClients();

    List<ClientDto> deleteClients(List<UUID> usersId);

    List<ClientDto> changeClients(List<Client> clients);

}
