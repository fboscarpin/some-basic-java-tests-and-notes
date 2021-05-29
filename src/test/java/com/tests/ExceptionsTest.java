package com.tests;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;


public class ExceptionsTest {

    @Test
    public void printAge() {

        Integer age = null;
        String finalAge;

        try {
            finalAge = age.toString();
        } catch (NullPointerException e) {
            System.out.println("There was an exception:");
            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void throwExceptionMethodA() {

        String password = "123456";

        if (password.length() < 7){
            throw new IllegalArgumentException("Error: the password is too short.");
        }
    }

}
