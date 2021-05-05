package com.laba9.lizunova.config;

import com.laba9.lizunova.database.DatabaseInit;
import com.laba9.lizunova.database.DatabaseInitClientImpl;
import com.laba9.lizunova.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(name = "database",havingValue = "true")
@Configuration
@RequiredArgsConstructor
public class DatabaseConfig {

    private final ClientRepository clientRepository;

    @Bean
    public DatabaseInit databaseInitUser(){
        return new DatabaseInitClientImpl(clientRepository);
    }

}
