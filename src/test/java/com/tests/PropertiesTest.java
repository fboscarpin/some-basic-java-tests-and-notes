package com.tests;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void firstMethodProperties() {
        Properties prop = new Properties();
        prop.setProperty("device", "iPhone 7");
        prop.setProperty("platform", "iOS");

        // assert value from property
        Assert.assertEquals("iPhone 7", prop.getProperty("device"));

        // when using getProperty, the second argument is the default value to be returned in case the property doesn't exist
        Assert.assertEquals("default value", prop.getProperty("OS", "default value"));

        // iterate the properties to print out all the key, values
        for (String key :
                prop.stringPropertyNames()) {
            System.out.println("Key is:" + key +
                    "Value is :" + prop.getProperty(key, "default value"));
        }

        // assert that size is 2
        Assert.assertEquals(2, prop.size());
    }

    @Test
    public void simplePrint() {
        Properties prop = new Properties();
        Assert.assertEquals(0, prop.size());
        prop.setProperty("device", "iPhone 8");
        prop.setProperty("platform", "iOS");
        prop.list(System.out);
    }

    @Test
    public void checkIfPropertyExists() {
        Properties prop = new Properties();
        Assert.assertEquals(0, prop.size());
        prop.setProperty("device", "iPhone 8");
        prop.setProperty("platform", "iOS");
        Assert.assertTrue("Assert that key exists", prop.containsKey("device"));
    }

    @Test
    public void systemProperties() {

        // working directory
        System.out.println("My working directory is: " + System.getProperty("user.dir") + "\n" +
                "User home: " + System.getProperty("user.home") + "\n" +
                "file separator: " + System.getProperty("file.separator")
        );

        // print out system properties
        Properties sys = System.getProperties();
        sys.list(System.out);

    }

    @Test
    public void storeProperties() throws IOException {
        String tempPath = System.getProperty("java.io.tmpdir");
        String tempResourceFilePath = tempPath + "myPropeties.properties";

        Properties properties = new Properties();
        properties.setProperty("computer", "macbook");
        properties.setProperty("owner", "admin");

        FileOutputStream fileOutput = new FileOutputStream(tempResourceFilePath);
        properties.store(fileOutput, "First record");
        fileOutput.close();
        System.out.println(tempResourceFilePath);

        // read the properties from the file

        FileReader reader = new FileReader(tempResourceFilePath);

        Properties propertiesRead = new Properties();
        propertiesRead.load(reader);
        reader.close();

        System.out.println("Value from the property 'computer': " + propertiesRead.getProperty("computer"));

        // delete the file
        new File(tempResourceFilePath).delete();
    }




}
