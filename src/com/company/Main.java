package com.company;

public class Main {

    public static void main(String[] args) {
        Company company1 = new Company("Home Cleaner");
        Taxes centerTaxes = new Taxes(2, 5, 10, 3, AreaType.CENTER);

        Buildings building1 = new Buildings("Building1", 5, 15, 60000, centerTaxes);

        Family goshovi = new Family("Goshovi", 4);
        Family toshovi = new Family("Toshovi", 2);
        //Family ivanovi = new Family("Ivanovi", 6); exception test

        Employee stan = new Employee("Stan","Stanov","Stanov");
        Employee tod = new Employee("Tod","Todov", "Todov");

        company1.addBuildings(building1);
        company1.hireEmployeeInTheCompany(tod);
        company1.hireEmployeeInTheCompany(stan);
        System.out.println(company1.toString());
        //company1.fireEmployeeFromTheCompany(tod); exception test

        building1.addFamily(goshovi);
        System.out.println(building1.toString());

        building1.addFamily(toshovi);
        System.out.println(building1.toString());

        building1.removeFamily(toshovi);
        building1.addEmployeeToBuilding(tod);
        building1.addEmployeeToBuilding(stan);
        //building1.addEmployeeToBuilding(tod); exception test
        System.out.println(building1.toString());

        building1.addTaxToBuilding(centerTaxes);
        centerTaxes.taxFamily(toshovi);
        //centerTaxes.taxFamily(toshovi); exception test
        System.out.println(centerTaxes.toString());
        centerTaxes.checkIfFamilyPayedTaxes(goshovi);
        centerTaxes.checkIfFamilyPayedTaxes(toshovi);

    }
}
