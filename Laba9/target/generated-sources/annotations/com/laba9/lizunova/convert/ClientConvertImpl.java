package com.laba9.lizunova.convert;

import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.model.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-27T22:41:51+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class ClientConvertImpl implements ClientConvert {

    @Override
    public Client toClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setLastName( clientDto.getLastName() );
        client.setFirstName( clientDto.getFirstName() );
        client.setPatronymic( clientDto.getPatronymic() );
        client.setDateBorn( clientDto.getDateBorn() );
        client.setNumberPassport( clientDto.getNumberPassport() );
        client.setCountry( clientDto.getCountry() );
        client.setAddress( clientDto.getAddress() );
        client.setNumberPhone( clientDto.getNumberPhone() );
        client.setEmail( clientDto.getEmail() );
        client.setWorkHave( clientDto.getWorkHave() );
        client.setPosition( clientDto.getPosition() );
        client.setCountryLive( clientDto.getCountryLive() );
        client.setLiableForMilitaryService( clientDto.getLiableForMilitaryService() );

        return client;
    }

    @Override
    public ClientDto toClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setLastName( client.getLastName() );
        clientDto.setFirstName( client.getFirstName() );
        clientDto.setPatronymic( client.getPatronymic() );
        clientDto.setDateBorn( client.getDateBorn() );
        clientDto.setNumberPassport( client.getNumberPassport() );
        clientDto.setCountry( client.getCountry() );
        clientDto.setAddress( client.getAddress() );
        clientDto.setNumberPhone( client.getNumberPhone() );
        clientDto.setEmail( client.getEmail() );
        clientDto.setWorkHave( client.getWorkHave() );
        clientDto.setPosition( client.getPosition() );
        clientDto.setCountryLive( client.getCountryLive() );
        clientDto.setLiableForMilitaryService( client.getLiableForMilitaryService() );

        return clientDto;
    }
}
