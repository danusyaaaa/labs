package com.laba9.lizunova.controller;

import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("rest/user")
public interface ClientController {

    @PostMapping(value = "/add-new-client/0", produces = MediaType.APPLICATION_XML_VALUE)
    ClientDto addNewClient(@Valid @RequestBody ClientDto client);

    @GetMapping(value = "/show-client/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ClientDto showClient(@PathVariable("id") UUID id);

    @DeleteMapping(value = "/delete-client/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ClientDto deleteClient(@PathVariable("id") UUID id);

    @PutMapping(value = "/change-client/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    ClientDto changeClient(@PathVariable("id") UUID id, @Valid @RequestBody ClientDto clientDto);

}
