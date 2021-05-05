package com.laba8.laba8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Position")
@XmlRootElement(name = "positions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Positions {

    @Id
    private int id;

    private String name;

}
