package com.example.yakshuk.lab6Yakshuk.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.example.yakshuk.lab6Yakshuk.bean.Theatre;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface TheatreService {

    @WebMethod
    public List<Theatre> findByName(String name);

    @WebMethod
    public List<Theatre> findByDate(Date date);

    @WebMethod
    public List<Theatre> getAllTheatre();
}