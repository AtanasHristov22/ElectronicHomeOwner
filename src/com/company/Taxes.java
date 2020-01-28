package com.company;

import java.util.HashMap;

public class Taxes {
    private double maintenanceTax;
    private double elevatorTax;
    private double cleaner;
    private double taxPerMembers;
    private AreaType placeOnMap;
    private HashMap<Integer, Family> listOfFamiliesThatOweTaxes;
    private HashMap<Integer, Family> listOfFamiliesPayedTaxes;
    int taxedFamily = 1;
    int notTaxedFamily = 1;

    public Taxes(){

    }

    public Taxes(double maintenanceTax, double elevatorTax, double cleaner, double taxPerMembers, AreaType placeOnMap){
        this.maintenanceTax = maintenanceTax * placeOnMap.getTax();
        this.elevatorTax = elevatorTax * placeOnMap.getTax();
        this.cleaner = cleaner * placeOnMap.getTax();
        this.taxPerMembers = (taxPerMembers < 4) ? taxPerMembers * 5 : taxPerMembers  * 10;
        this.placeOnMap = placeOnMap;
        listOfFamiliesThatOweTaxes = new HashMap<>();
        listOfFamiliesPayedTaxes = new HashMap<>();

    }
    public void taxFamily(Family family){
        if(!listOfFamiliesPayedTaxes.containsValue(family)){
            listOfFamiliesPayedTaxes.put(taxedFamily, family);
            taxedFamily++;
            System.out.println("Family: " + family.getFamilyName() + " is successfully taxed!" );
        }
        else{
            throw new IllegalArgumentException("The family is already taxed!");
        }
    }

    public void checkIfFamilyPayedTaxes(Family family){
        if(!listOfFamiliesPayedTaxes.containsValue(family)){
            listOfFamiliesThatOweTaxes.put(notTaxedFamily, family);
            notTaxedFamily++;
            System.out.println("This family: " + family + " must pay by the end of the month!");
        }
        else{
            throw new IllegalArgumentException("This family has payed all taxes!");
        }
    }

    public HashMap<Integer, Family> getListOfFamiliesThatOweTaxes() {
        return listOfFamiliesThatOweTaxes;
    }
    public void setListOfFamiliesThatOweTaxes(HashMap<Integer, Family> listOfFamiliesThatOweTaxes) {
        this.listOfFamiliesThatOweTaxes = listOfFamiliesThatOweTaxes;
    }
    public HashMap<Integer, Family> getListOfFamiliesPayedTaxes() {
        return listOfFamiliesPayedTaxes;
    }
    public void setListOfFamiliesPayedTaxes(HashMap<Integer, Family> listOfFamiliesPayedTaxes) {
        this.listOfFamiliesPayedTaxes = listOfFamiliesPayedTaxes;
    }
    public int getTaxedFamily() {
        return taxedFamily;
    }
    public void setTaxedFamily(int taxedFamily) {
        this.taxedFamily = taxedFamily;
    }
    public int getNotTaxedFamily() {
        return notTaxedFamily;
    }
    public void setNotTaxedFamily(int notTaxedFamily) {
        this.notTaxedFamily = notTaxedFamily;
    }

    @Override
    public String toString() {
        return "Taxes{" +
                "maintenanceTax=" + maintenanceTax +
                ", elevatorTax=" + elevatorTax +
                ", cleaner=" + cleaner +
                ", taxPerMembers=" + taxPerMembers +
                ", placeOnMap=" + placeOnMap +
                ", listOfFamiliesThatOweTaxes=" + listOfFamiliesThatOweTaxes +
                ", listOfFamiliesPayedTaxes=" + listOfFamiliesPayedTaxes +
                '}';
    }
}
