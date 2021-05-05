package com.laba9.lizunova.controller.impl;

import com.laba9.lizunova.controller.ClientsController;
import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;
import com.laba9.lizunova.service.users.ClientsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ClientsControllerImpl implements ClientsController {

    private final ClientsService clientService;

    @Override
    public List<ClientDto> addNewClients(@Valid @RequestBody List<Client> clients){
        log.info("IN addNewClients");
        return clientService.addNewClients(clients);
    }

    @Override
    public List<ClientDto> showClients(@RequestBody List<UUID> usersId){
        log.info("IN showClients");
        return clientService.showAllClientsByListId(usersId);
    }

    @Override
    public List<ClientDto> deleteClients(@RequestBody List<UUID> usersId){
        log.info("IN deleteClients");
        return clientService.deleteClients(usersId);
    }

    @Override
    public List<ClientDto> changeClients(@RequestBody List<Client> clients){
        log.info("IN changeClients");
        return clientService.changeClients(clients);
    }

    @Override
    public List<Client> showAllClients(){
        log.info("IN showAllClients");
        return clientService.showAllClients();
    }


}
