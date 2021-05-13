package com.example.yakshuk.lab5.controllers;

import com.example.yakshuk.lab5.models.Department;
import com.example.yakshuk.lab5.settings.DataConfig;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;


@ManagedBean
@SessionScoped
public class DepartmentController {
    private static EntityManager em;

    @EJB
    private DataConfig dataConfig;
    private Department item = new Department();
    private boolean edit;
    private int idDepartment = -1;
    private String nameSearchDepa = "";
    private String resultSearch = "";

    public DepartmentController(){
        dataConfig = new DataConfig();
        em = dataConfig.getEntityManager();
    }

    public List<Department> getList() {
        Query q = em.createQuery("select d from Department d");
        return (List<Department>) q.getResultList();
    }

    public void add() {
        em.getTransaction().begin();
        em.persist(item);
        System.out.println(item.toString());
        em.getTransaction().commit();
        item = new Department();
    }

    public void saveEditedDepartment() {
        em.getTransaction().begin();
        Department foundDep = em.find(Department.class, idDepartment);
        foundDep.setName(item.getName());
        edit = false;
        idDepartment = -1;
        this.item = new Department();
        em.getTransaction().commit();
    }
    public void onButtonEditClick(Department department){
        this.idDepartment = department.getId();
        this.edit = true;
    }

    public String search(String search) {
        if (search != null && !search.equals("")) {
            Department foundDepartment = em.find(Department.class, Integer.parseInt(search));
            if (foundDepartment == null) {
                return "Not founded";
            }
            return foundDepartment.toString();
        }
        return "";
    }

    public void delete(Department item) throws IOException {
        em.getTransaction().begin();
        Department department = em.find(Department.class, item.getId());
        em.remove(department);
        em.getTransaction().commit();
    }
    public boolean isEdit() {
        return this.edit;
    }
    public Department getItem() {
        return item;
    }
    public int getIdDepartment(){
        return idDepartment;
    }
    public void setNameSearchDepa(String str){
        this.nameSearchDepa = str;
    }

    public String getNameSearchDepa(){
        return nameSearchDepa;
    }
    public String getResultSearch(){
        return  search(nameSearchDepa);
    }
    public void setResultSearch(String str){
        this.resultSearch = str;
    }

}
