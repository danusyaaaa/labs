package com.laba9.lizunova.service.users.impl;

import com.laba9.lizunova.convert.ClientConvert;
import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;
import com.laba9.lizunova.repository.ClientRepository;
import com.laba9.lizunova.service.users.ClientService;
import com.laba9.lizunova.service.users.ClientsService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Service
@Slf4j
public class ClientServiceImpl implements ClientService, ClientsService {

    private final ClientRepository clientRepository;
    private final ClientConvert clientConvert;

    @Override
    public ClientDto addNewClient(ClientDto client) {
        log.info("Save new client in database {} ", client);
        Client newClient = clientConvert.toClient(client);
        newClient.setId(UUID.randomUUID());
        return clientConvert.toClientDto(clientRepository.save(newClient));
    }

    @Override
    public ClientDto showClientById(UUID id) {
        return clientConvert.toClientDto(clientRepository.findClientById(id));
    }

    @Override
    public ClientDto deleteClient(UUID id) {
        Client client = clientRepository.findClientById(id);
        clientRepository.delete(client);
        return clientConvert.toClientDto(client);
    }

    @Override
    public List<ClientDto> addNewClients(List<Client> clients) {
        return clientRepository.saveAll(clients).stream()
                .map(clientConvert::toClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> showAllClientsByListId(List<UUID> usersId) {
        return clientRepository.findClientsByIdIn(usersId).stream()
                .map(clientConvert::toClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> showAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<ClientDto> deleteClients(List<UUID> usersId) {
        return clientRepository.findClientsByIdIn(usersId).stream()
                .peek(clientRepository::delete)
                .map(clientConvert::toClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto changeClient(UUID id, ClientDto clientRedaction) {
        Client clientFind = clientRepository.findClientById(id);
        if (clientFind == null) {
            log.error("Client not founded ...");
            return null;
        }
        clientFind = clientConvert.toClient(clientRedaction);
        log.info("Client was changed : {}", clientFind);
        clientFind.setId(id);
        clientRepository.save(clientFind);
        return clientConvert.toClientDto(clientFind);
    }

    @Override
    public List<ClientDto> changeClients(List<Client> clients) {
        return clients.stream()
                .filter(user -> clientRepository.findClientById(user.getId()) != null)
                .map(clientRepository::save)
                .map(clientConvert::toClientDto)
                .collect(Collectors.toList());
    }
}
