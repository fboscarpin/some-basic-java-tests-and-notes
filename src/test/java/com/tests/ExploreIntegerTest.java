package com.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExploreIntegerTest {

    @Test
    public void exploreInteger(){
        //Will set a value (4) wich can be manipulated via the methods from Integer
        //valueOf is a constructor in the class Integer
        int non_used_var = 10; // this is a primitive type
        Integer four = 4; // this is an object from the class Integer
        //intValue() is a method from Integer class.
        assertEquals("check integer",4,four.intValue());
    }

    @Test
    public void exploreIntegerViaString(){
        //Will set a value (4) wich can be manipulated via the methods from Integer
        // Integer.parseInt(String s) would also work
        Integer four = Integer.valueOf("5");
        //intValue() is a method from Integer class.
        assertEquals("check integer",5,four.intValue());
    }

    @Test
    public void exploreIntegerToHex(){
        Integer number = 11;
        assertEquals("11 toHexString is b","b",Integer.toHexString(number));
    }

    @Test
    public void exploreIntegerMaxInt(){
        Integer number = Integer.MAX_VALUE; // Integer.MIN_VALUE; is another possibility
        System.out.println(number);
        assertEquals("Max Int test",2147483647,Integer.MAX_VALUE);
        assertEquals(2147483647,Integer.MAX_VALUE);
        assertTrue(number==Integer.MAX_VALUE); // Java is checking if the two object variables refer to the same instantiation
        assertTrue(number.equals(Integer.MAX_VALUE));
    }
}
