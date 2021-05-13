package com.example.yakshuk.lab5.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department
{
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private int id;
    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName( )
    {
        return name;
    }

    public void setName( String deptName )
    {
        this.name = deptName;
    }
}