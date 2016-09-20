package com.mycompany.myapp;

/**
 * TODO: Add brief class description here.
 */
public class Dupe2 extends DupeBaseClass {

    private String test;

    public boolean isValidForString(String test) {
        return test!= null;
    }

    public Dupe2() {
        isValidForString("pepik");
    }
}
