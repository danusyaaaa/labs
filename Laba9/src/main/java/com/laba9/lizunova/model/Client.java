package com.laba9.lizunova.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
@Builder
public class Client {

    @Id
    @NotNull(message = "Id not can be null")
    @Column(name="ID")
    private UUID id;

    @Size(min = 5, max = 30)
    @Column(name="LAST_NAME")
    private String lastName;

    @Length(min = 5, max = 30)
    @Column(name="FIRST_NAME")
    private String firstName;

    @Length(min = 5, max = 30)
    @Column(name="PATRONYMIC")
    private String patronymic;

    @JsonProperty(value = "dateBorn")
    @NotNull
    @Column(name="DATE_BORN")
    private LocalDate dateBorn;

    @Length(min = 7)
    @Column(name="NUMBER_PASSPORT")
    private String numberPassport;

    @Size(min = 1)
    @Column(name="COUNTRY")
    private String country;

    @Length(min = 4)
    @Column(name="ADDRESS")
    private String address;

    @Length(min = 6)
    @Column(name="NUMBER_PHONE")
    private String numberPhone;

    @Email
    @Column(name="EMAIL")
    private String email;

    @NotNull
    @Column(name="WORK_HAVE")
    private Boolean workHave;

    @Size(min = 6)
    @Column(name="POSITION")
    private String position;

    @Column(name="COUNTRY_LIVE")
    private String countryLive;

    @NotNull
    @Column(name="LIABLE_FOR_MILITARY_SERVICE")
    private Boolean liableForMilitaryService;

}
