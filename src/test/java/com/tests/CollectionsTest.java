package com.tests;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

public class CollectionsTest {

    @Test
    public void oneNewCollection() {

        List<String> myCollection = new ArrayList<String>();
        myCollection.add("first");
        myCollection.add("second");
        myCollection.add("lastOne");

        int control = 0;
        for (String forVarv : myCollection) {
            if(forVarv.equals("second")){
                Assert.assertEquals("Second element is second","second",forVarv);
                Assert.assertEquals("Second element ID",1,control);
                Assert.assertThat("Using assert that 1 is 1", 1, is(control));
                System.out.println("1st method - Element found: "+ forVarv);

                //Other assertions
                Assert.assertThat("Banana", startsWith("B"));

                //Strings
                System.out.println("Test \btest");
            }
            control++;
        }
    }

    @Ignore("The second method was ignore - this is the descriptive message")
    @Test
    public void TwoNewCollection() {

        List<String> myCollection = new ArrayList<String>();
        myCollection.add("first");
        myCollection.add("second");
        myCollection.add("lastOne");

        int control = 0;
        for (String forVarv : myCollection) {
            if(forVarv.equals("second")){
                Assert.assertEquals("Second element is second","second",forVarv);
                Assert.assertEquals("Second element ID",1,control);
                System.out.println("2nd method - Element found: "+ forVarv);
            }
            control++;
        }
    }


    @AfterClass
    public static void beforeMethod() {
        // the method needs to be static
        System.out.println("This is the @before method");
    }
}
