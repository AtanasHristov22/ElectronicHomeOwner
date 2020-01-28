package com.company;

public class Employee {
    private String ownName;
    private String familyName;
    private String middleName;

    public Employee(){

    }

    public Employee(String ownName, String middleName, String familyName){
        this.ownName = ownName;
        this.middleName = middleName;
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ownName='" + ownName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", middleName='" + middleName + '\'' +
                '\'' +
                '}';
    }
}
