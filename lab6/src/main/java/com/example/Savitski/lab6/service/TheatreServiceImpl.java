package com.example.yakshuk.lab6Yakshuk.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import com.example.yakshuk.lab6Yakshuk.bean.Theatre;

@WebService(endpointInterface = "com.example.yakshuk.lab6Yakshuk.service.TheatreService")
public class TheatreServiceImpl implements TheatreService {

    public  ArrayList<Theatre> theatres;

    @PostConstruct
    private void initData(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            theatres = new ArrayList<>();
            theatres.add(new Theatre("Кошкин дом",formatter.parse("11-04-2021"),"Опера"));
            theatres.add(new Theatre("Я счастье",formatter.parse("11-04-2021"),"Комедия"));
            theatres.add(new Theatre("Интерактивный спектакль \"Щенячий патруль и спасение праздника\"",formatter.parse("12-04-2021"),"Для детей"));
            theatres.add(new Theatre("Жмурик",formatter.parse("13-04-2021"),"Комедия"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Theatre> findByName(String name) {
        return (ArrayList<Theatre>) theatres.stream().filter(item -> item.getName().startsWith(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Theatre> findByDate(Date date) {
        return (ArrayList<Theatre>) theatres.stream().filter(item -> item.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Theatre> getAllTheatre() {
        //initData();
        return theatres;
    }
}

