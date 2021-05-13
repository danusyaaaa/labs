package com.example.yakshuk.lab5.controllers;

import com.example.yakshuk.lab5.models.Department;
import com.example.yakshuk.lab5.models.Employee;
import com.example.yakshuk.lab5.settings.DataConfig;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

@ManagedBean
@SessionScoped
public class EmployeeController {
    private static EntityManager em;

    @EJB
    private DataConfig dataConfig;
    private Employee item = new Employee();
    private boolean edit;
    private int idEmpl = -1;
    private String nameSearchEmpl = "";
    private String resultSearch = "";
    private Department department_for_selected = new Department();

    public EmployeeController(){
        dataConfig = new DataConfig();
        em = dataConfig.getEntityManager();
    }
    public void delete(Employee item) throws IOException {
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, item.getId());
        em.remove(employee);
        em.getTransaction().commit();
    }

    public List<Employee> getList() {
        Query q = em.createQuery("select d from Employee d");
        return (List<Employee>) q.getResultList();
    }
    public void valueChanged(ValueChangeEvent e){
        Department department = (Department) e.getNewValue();
        item.setDepartment(department);
    }
    public void add() {
        em.getTransaction().begin();
        System.out.println(item);
        Department foundDep = em.find(Department.class, item.getDepartment().getId());
        item.setDepartment(foundDep);
        em.persist(item);
        em.getTransaction().commit();
        item = new Employee();
    }
    public void saveEditedEmpl() {
        em.getTransaction().begin();
        Employee foundEmpl = em.find(Employee.class, idEmpl);
        foundEmpl.setName(item.getName());
        foundEmpl.setSalary(item.getSalary());
        foundEmpl.setDeg(item.getDeg());
        edit = false;
        idEmpl = -1;
        this.item = new Employee();
        em.getTransaction().commit();
    }

    public void onButtonEditClick(Employee employee){
        this.idEmpl = employee.getId();
        this.edit = true;
    }
    public String search(String search) {
        if (search != null && !search.equals("")) {
            Employee foundEmpl = em.find(Employee.class, Integer.parseInt(search));
            if (foundEmpl == null) {
                return "Not founded";
            }
            return foundEmpl.toString();
        }
        return "";

    }

    public Department getDepartment_for_selected() {
        return department_for_selected;
    }

    public void setDepartment_for_selected(Department department){
        this.department_for_selected = department;
    }

    public boolean isEdit() {
        return this.edit;
    }
    public Employee getItem() {
        return item;
    }
    public int getIdEmpl(){
        return idEmpl;
    }
    public void setNameSearchEmpl(String str){
        this.nameSearchEmpl = str;
    }

    public String getNameSearchEmpl(){
        return nameSearchEmpl;
    }
    public String getResultSearch(){
        return  search(nameSearchEmpl);
    }
    public void setResultSearch(String str){
        this.resultSearch = str;
    }
}
