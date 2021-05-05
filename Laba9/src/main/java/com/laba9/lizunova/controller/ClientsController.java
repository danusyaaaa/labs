package com.laba9.lizunova.controller;

import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("rest/users")
public interface ClientsController {

    @PostMapping(value = "/add-new/list-users", produces = MediaType.APPLICATION_XML_VALUE)
    List<ClientDto> addNewClients(@Valid @RequestBody List<Client> clients);

    @PostMapping(value = "/show-clients/by-list-id", produces = MediaType.APPLICATION_XML_VALUE)
    List<ClientDto> showClients(@RequestBody List<UUID> usersId);

    @DeleteMapping(value = "/delete/list-clients", produces = MediaType.APPLICATION_XML_VALUE)
    List<ClientDto> deleteClients(@RequestBody List<UUID> usersId);

    @PutMapping(value = "/change/by-list-clients", produces = MediaType.APPLICATION_XML_VALUE)
    List<ClientDto> changeClients(@RequestBody List<Client> clients);

    @GetMapping(value = "/show-all-users")
    List<Client> showAllClients();

}
