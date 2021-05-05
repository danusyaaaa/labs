package com.laba9.lizunova.database;

import com.laba9.lizunova.model.Client;
import com.laba9.lizunova.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;



@Slf4j
@AllArgsConstructor
public class DatabaseInitClientImpl implements DatabaseInit {

    private final ClientRepository clientRepository;

    @PostConstruct
    @Override
    public void initializationDataInDatabase() {
        LinkedList<Client> newClients = new LinkedList<>();
        Client client1 = Client.builder()
                .id(UUID.randomUUID())
                .lastName("Lizunova")
                .firstName("Viktoria")
                .patronymic("Olegovna")
                .dateBorn(LocalDate.now())
                .numberPassport("AB12312")
                .countryLive("Minsk, Moscow")
                .address("Gomel")
                .numberPhone("+3729123431")
                .email("vika_ll@gmail.com")
                .workHave(false)
                .position("Senior")
                .country("Rio")
                .liableForMilitaryService(true)
                .build();
        Client client2 = Client.builder()
                .id(UUID.randomUUID())
                .lastName("Ananenko")
                .firstName("Veronika")
                .patronymic("Vladimirovna")
                .dateBorn(LocalDate.now())
                .numberPassport("AB12315")
                .countryLive("Minsk, Moscow")
                .address("Korma")
                .numberPhone("+3729123435")
                .email("nika_aa@gmail.com")
                .workHave(false)
                .position("Analyst")
                .country("Bel")
                .liableForMilitaryService(true)
                .build();
        Client client3 = Client.builder()
                .id(UUID.randomUUID())
                .lastName("Kirienko")
                .firstName("Nastya")
                .patronymic("Denisovna")
                .dateBorn(LocalDate.now())
                .numberPassport("AB12615")
                .countryLive("Minsk, Bel")
                .address("Brest")
                .numberPhone("+3729125435")
                .email("dana_aa@gmail.com")
                .workHave(false)
                .position("BackEnd")
                .country("Belarus")
                .liableForMilitaryService(true)
                .build();
        Client client4 = Client.builder()
                .id(UUID.randomUUID())
                .lastName("Yarohno")
                .firstName("Nastya")
                .patronymic("Aleksandrovna")
                .dateBorn(LocalDate.now())
                .numberPassport("AB15815")
                .countryLive("Gomel, Bel")
                .address("Gomel")
                .numberPhone("+3729125435")
                .email("nastya_aa@gmail.com")
                .workHave(false)
                .position("Doctor")
                .country("Belarus")
                .liableForMilitaryService(true)
                .build();
        Client client5 = Client.builder()
                .id(UUID.randomUUID())
                .lastName("Agievich")
                .firstName("Tanya")
                .patronymic("Aleksandrovna")
                .dateBorn(LocalDate.now())
                .numberPassport("AB15315")
                .countryLive("Minsk, Belarus")
                .address("Minsk")
                .numberPhone("+3729625435")
                .email("tanya_aa@gmail.com")
                .workHave(false)
                .position("Manager")
                .country("Belarus")
                .liableForMilitaryService(true)
                .build();

        newClients.add(client1);
        newClients.add(client2);
        newClients.add(client3);
        newClients.add(client4);
        newClients.add(client5);

        clientRepository.saveAll(newClients);
        log.info("New users was created ...");
    }

}
