package com.laba8.laba8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private int id;
    private String surname;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String passwordSeries;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Set<City> cityes = new HashSet<>();
    private String addressFact;
    private String phoneNumber;
    private String email;
    private boolean isEmployed;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Set<Positions> positions = new HashSet<>();
    private String addressRegistration;
    private int citizenShip;

}
