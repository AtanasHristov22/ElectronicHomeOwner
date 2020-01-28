package com.company;

public class Family {
    private String familyName;
    private int numberOfFamilyMembers;

    public Family(){

    }

    public Family(String familyName, int numberOfFamilyMembers){
        this.familyName = familyName;
        this.numberOfFamilyMembers = numberOfFamilyMembers;

    }
    public String getFamilyName(){return familyName;}

    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", numberOfFamilyMembers=" + numberOfFamilyMembers +
                '}';
    }
}
