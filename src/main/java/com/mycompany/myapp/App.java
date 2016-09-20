package com.mycompany.myapp;

import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {

    // non compliant logger
    public Logger logger15;

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //lets make code dupes here
    public String myMethod() {
        int a = 1;
        int b = 3;

        if (a == 1) { b = 2;}

        if (a == 1) {
            b = 2;
            executeTest();
        }

        if (a == 1) {
            b = 2;
            executeTest();
        }

        if (a == 1) { b = 2;}

        System.out.println("Hello World!" + b);

        int c = a + b;
        System.out.println("Hello World!" + c);

        c = a + b;
        System.out.println("Hello World!" + c);
        try {
            String test = "string";
        } catch (Throwable e) {
            System.out.println("test");
        }

        return "tryout";
    }

    /**
     * let's document this one
     */
    public void executeTest() {
        // noop
    }

    public int calculate1(int a, int b){
        int c = a + b;
        return c;
    }

    public int calculate2(int a, int b){
        int c = a + b;
        return c;
    }
}
