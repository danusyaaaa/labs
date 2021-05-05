package com.laba9.lizunova.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
public class ClientDto {

    @Size(min = 5, max = 30)
    private String lastName;

    @Length(min = 5, max = 30)
    private String firstName;

    @Length(min = 5, max = 30)
    private String patronymic;

    @JsonProperty(value = "dateBorn")
    @NotNull
    private LocalDate dateBorn;

    @Length(min = 7)
    private String numberPassport;

    @Size(min = 1)
    private String country;

    @Length(min = 4)
    private String address;

    @Length(min = 6)
    private String numberPhone;

    @Email
    private String email;

    @NotNull
    private Boolean workHave;

    @Size(min = 6)
    private String position;

    @Size(min = 1)
    private String countryLive;

    @NotNull
    private Boolean liableForMilitaryService;

}
