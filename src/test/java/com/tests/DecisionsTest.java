package com.tests;

import org.junit.Assert;
import org.junit.Test;

public class DecisionsTest {

    @Test
    public void ternaryOperator() {
        String url = "www.testers.com";
        url = url.startsWith("http") ? url : fixUrl(url);
        Assert.assertTrue(url.startsWith("http://"));
        Assert.assertEquals("Full comparison for url", "http://www.testers.com", url);
    }

    private String fixUrl(String url) {
        return "http://"+url;
    }

}
