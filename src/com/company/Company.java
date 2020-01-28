package com.company;

import java.util.HashSet;

public class Company {
    private String name;
    private HashSet<Buildings> listOfBuildings;
    private HashSet<Employee> listOfEmployees;

    public Company(){

    }

    public Company(String name){
        this.name = name;
        listOfBuildings = new HashSet<>();
        listOfEmployees = new HashSet<>();
    }

    public void addBuildings(Buildings buildings){
        if(!listOfBuildings.contains(buildings)){
            listOfBuildings.add(buildings);
        }
        else{
            throw new IllegalArgumentException("This building is already in the company!");
        }
    }

    public void hireEmployeeInTheCompany(Employee employee){
        if(!listOfEmployees.contains(employee)){
            listOfEmployees.add(employee);
        }
        else{
            throw new IllegalArgumentException("This employee is already in the company!");
        }
    }
    public void fireEmployeeFromTheCompany(Employee employee){
        if(listOfEmployees.contains(employee)){
            listOfEmployees.remove(employee);
        }
       else
        {
            throw new IllegalArgumentException("This employee is not in the company!");
        }

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HashSet<Buildings> getListOfBuildings() {
        return listOfBuildings;
    }
    public void setListOfBuildings(HashSet<Buildings> listOfBuildings) {
        this.listOfBuildings = listOfBuildings;
    }
    public HashSet<Employee> getListOfEmployees() {
        return listOfEmployees;
    }
    public void setListOfEmployees(HashSet<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", listOfBuildings=" + listOfBuildings +
                ", listOfEmployees=" + listOfEmployees +
                '}';
    }
}
