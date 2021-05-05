package com.laba9.lizunova.controller.impl;

import com.laba9.lizunova.controller.ClientController;
import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;
import com.laba9.lizunova.service.users.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;


@RestController
@Slf4j
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    @Override
    public ClientDto addNewClient(@Valid @RequestBody ClientDto client) {
        log.info("IN addNewUser client :{}", client.toString());
        return clientService.addNewClient(client);
    }

    @Override
    public ClientDto showClient(@PathVariable("id") UUID id) {
        log.info("In showClient with ID : {} ", id);
        return clientService.showClientById(id);
    }

    @Override
    public ClientDto deleteClient(@PathVariable("id") UUID id) {
        log.info("In deleteClient with ID : {} ", id);
        return clientService.deleteClient(id);
    }

    @Override
    public ClientDto changeClient(@PathVariable("id") UUID id, @Valid @RequestBody ClientDto clientDto) {
        log.info("In changeClient with ID: {} , clientNew :{}  ", id, clientDto.toString());
        return clientService.changeClient(id, clientDto);
    }

}
