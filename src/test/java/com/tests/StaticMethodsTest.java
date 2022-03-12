package com.tests;

import supportMethods.TestAppEnv;
import org.junit.Test;
import static org.junit.Assert.assertEquals; // static import

public class StaticMethodsTest {

    @Test
    public void canGetUrlStatically(){
        assertEquals("Returns Hard Coded URL",
                "http://192.123.0.3:67",
                TestAppEnv.getUrl());
    }

    @Test
    public void canGetDomainAndPortStatically(){
        assertEquals("Just the Domain",
                "192.123.0.3",
                TestAppEnv.DOMAIN);
        assertEquals("Just the port",
                "67",
                TestAppEnv.PORT);
    }

}
