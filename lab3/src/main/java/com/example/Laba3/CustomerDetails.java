package com.example.Laba3;

import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/search-customer")
public class CustomerDetails extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory;
    private static  EntityManager em;

    public void init() {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        Query q = em.createQuery("select t from Customer t");

        List<Customer> customerList = q.getResultList();

        for (Customer todo : customerList) {
            System.out.println(todo);
        }
        if (customerList.size()==0){
            em.getTransaction().begin();

            Customer customerNew = Customer.builder()
                    .id(UUID.randomUUID())
                    .name("Last Name")
                    .address("New Address")
                    .numberFax("213mdwe")
                    .build();
            System.out.println(customerNew);
            em.persist(customerNew);
            em.getTransaction().commit();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("search-customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UUID idFind = UUID.fromString(request.getParameter("id"));
        Customer customer = em.find(Customer.class, idFind);

        if(customer!=null) {
            request.setAttribute("customer", customer.toString());
        }
        else {
            request.setAttribute("customer", "Not founded");
        }
        request.getRequestDispatcher("result-customer.jsp").forward(request, response);
    }

    public void destroy() {
        em.close();
    }

}