package com.laba9.lizunova.convert;

import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientConvert {

    Client toClient(ClientDto clientDto);

    ClientDto toClientDto(Client client);

}
