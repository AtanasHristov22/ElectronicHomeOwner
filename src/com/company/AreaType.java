package com.company;

public enum AreaType {
    WEST(2),
    SOUTH(3),
    CENTER(10),
    EAST(5);

    private double tax;

    private AreaType(double tax){this.tax = tax;}
    public double getTax(){return tax;}

}
