package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Buildings {
    private String address;
    private int floors;
    private int apartments;
    private double area;
    private Taxes taxes;
    private HashMap<Integer, Family> registeredFamilies;
    private HashSet<Employee> employeesWorkingInTheBuilding;
    private HashSet<Taxes> listOfTaxes;
    private static int currentApartment;
    private boolean isServiced;
    private static int maxEmployeesOnBuilding = 2;
    private int currentEmployeeInBuilding = 0;

    public Buildings() {
    }

    public Buildings(String address, int floors, int apartments, double area, Taxes taxes) {
        this.address = address;
        this.floors = floors;
        this.apartments = apartments;
        this.area = area;
        this.taxes = taxes;
        registeredFamilies = new HashMap<>();
        employeesWorkingInTheBuilding = new HashSet<>();
        listOfTaxes = new HashSet<>();
        currentApartment = 1;
        isServiced = false;
    }

    public void addFamily(Family family) {
        if (currentApartment < apartments) {
            registeredFamilies.put(currentApartment, family);
            System.out.println(family + " added successfully in an apartment -> " + currentApartment);
            currentApartment++;
        } else {
            throw new IllegalArgumentException("All the apartments are occupied!");
        }
    }

    public void removeFamily(Family family) {
        if (registeredFamilies.containsValue(family)) {
            registeredFamilies.entrySet()
                    .removeIf(
                            entry -> (family.equals(entry.getValue())));
            currentApartment--;
            System.out.println("You have successfully removed " + family.getFamilyName() + " from the building!");
        } else {
            throw new IllegalArgumentException("This family does not exists!");
        }
    }

    public void addEmployeeToBuilding(Employee employee) {
        if (!employeesWorkingInTheBuilding.contains(employee) && currentEmployeeInBuilding < maxEmployeesOnBuilding) {
            employeesWorkingInTheBuilding.add(employee);
            currentEmployeeInBuilding++;
            isServiced = true;
            System.out.println("You have successfully added employee " + employee + " to the building!");

        } else if (currentEmployeeInBuilding >= maxEmployeesOnBuilding) {
            throw new IllegalArgumentException("Too many employees working in this building!");
        } else if (employeesWorkingInTheBuilding.contains(employee)) {
            throw new IllegalArgumentException("This employee is already working in this building or in another one!");
        }
    }

    public void addTaxToBuilding(Taxes taxes) {
        if (!listOfTaxes.contains(taxes)) {
            listOfTaxes.add(taxes);
        } else {
            throw new IllegalArgumentException("The building already has tax!");
        }
    }

    public void removeTaxFromBuilding(Taxes taxes) {
        if (listOfTaxes.contains(taxes)) {
            listOfTaxes.remove(taxes);
        } else {
            throw new IllegalArgumentException("The building has no taxes!");
        }
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public int getApartments() {
        return apartments;
    }

    public double getArea() {
        return area;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }

    public void setRegisteredFamilies(HashMap<Integer, Family> registeredFamilies) {
        this.registeredFamilies = registeredFamilies;
    }

    public void setEmployeesWorkingInTheBuilding(HashSet<Employee> employeesWorkingInTheBuilding) {
        this.employeesWorkingInTheBuilding = employeesWorkingInTheBuilding;
    }

    public void setListOfTaxes(HashSet<Taxes> listOfTaxes) {
        this.listOfTaxes = listOfTaxes;
    }

    public void setServiced(boolean serviced) {
        isServiced = serviced;
    }

    public static void setMaxEmployeesOnBuilding(int maxEmployeesOnBuilding) {
        Buildings.maxEmployeesOnBuilding = maxEmployeesOnBuilding;
    }

    public void setCurrentEmployeeInBuilding(int currentEmployeeInBuilding) {
        this.currentEmployeeInBuilding = currentEmployeeInBuilding;
    }

    public void setApartments(int apartments) {
        this.apartments = apartments;
    }

    public static void setCurrentApartment(int currentApartment) {
        Buildings.currentApartment = currentApartment;
    }

    public HashMap<Integer, Family> getRegisteredFamilies() {
        return registeredFamilies;
    }

    public HashSet<Employee> getEmployeesWorkingInTheBuilding() {
        return employeesWorkingInTheBuilding;
    }

    public HashSet<Taxes> getListOfTaxes() {
        return listOfTaxes;
    }

    public static int getCurrentApartment() {
        return currentApartment;
    }

    public boolean isServiced() {
        return isServiced;
    }

    public static int getMaxEmployeesOnBuilding() {
        return maxEmployeesOnBuilding;
    }

    public int getCurrentEmployeeInBuilding() {
        return currentEmployeeInBuilding;
    }

    @Override
    public String toString() {
        return "Buildings{" +
                "address='" + address + '\'' +
                ", floors=" + floors +
                ", apartments=" + apartments +
                ", area=" + area +
                ", taxes=" + taxes +
                ", registeredFamilies=" + registeredFamilies +
                ", employeesWorkingInTheBuilding=" + employeesWorkingInTheBuilding +
                ", isServiced=" + isServiced +
                '}';
    }
}
