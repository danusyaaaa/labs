package com.laba8.laba8.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laba8.laba8.model.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@Configuration
public class ConvertConfig {

    @SneakyThrows
    public JAXBContext jaxbContext() {
        return JAXBContext.newInstance(User.class);
    }

    @SneakyThrows
    @Bean
    public Unmarshaller jaxbUnmarshaller() {
        return jaxbContext().createUnmarshaller();
    }

    @SneakyThrows
    @Bean
    public Marshaller jaxbMarshaller() {
        return jaxbContext().createMarshaller();
    }

    @Bean
    public Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }
}
