package com.gigamog.herostory.enums;

public enum Months {


    JAN("January", 1),
    FEB("February", 2),
    MAR("March", 3),
    APR("April", 4),
    MAY("May", 5),
    JUN("June", 6),
    JUL("July", 7),
    AUG("August", 8),
    SEP("September", 9),
    OCT("October", 10),
    NOV("November", 11),
    DEC("December", 12)

    ;

    String name;
    int value;

    public String getName(){return name;}
    public int getValue(){return value;}

    private Months(String n, int v) {
        name = n;
        value = v;
    }

}
