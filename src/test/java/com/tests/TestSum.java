package com.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

// the class name has to have the name "Test" to make it work with maven
// to run via maven, go to the project's root folder and run $ mvn test
// the class has to be public to be run via maven

public class TestSum {

    //@Test makes the method a test

    @Test
    public void addTwoPlusTwo(){
        int answer = 2+2;
        assertEquals("2+2=4 assertion", 4, answer);
    }
}
