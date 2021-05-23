package com.tests;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;

public class StringsTest {

    @Test
    public void oneStringMethod(){
        String a = "a";
        String b = "b";
        //String c = a + b;
        String c = a.concat(b);
        Assert.assertThat(c, is("ab"));

        String d = Integer.toString(3);
        Assert.assertThat(d, is("3"));

        String e = String.valueOf(4);
        Assert.assertThat(e, is("4"));

        char[] myCharArray = {'2', '3'};
        for (char myVar: myCharArray) {
            System.out.println(myVar);
        }
    }

    @Test
    public void stringConvertionChar(){
        char[] myCharArray = {'2', '3'};
        for (char myVar: myCharArray) {
            System.out.println(myVar);
        }

        //convert a string to charArray and assert that it worked
        String convert = "23";
        Assert.assertThat(convert.toCharArray(), is(myCharArray));
    }

    @Test
    public void stringConvertByte() throws UnsupportedEncodingException {
        // we need to add the throw exception because we are converting to a specific encoding
        byte[] myByteArray = "this string".getBytes("UTF8");

        for (Byte printing:
             myByteArray) {
            System.out.println(printing);
        }

    }

    @Test
    public void stringConvert() throws UnsupportedEncodingException {
        // we need to add the throw exception because we are converting to a specific encoding
        byte[] myByteArray = "this string".getBytes("UTF8");
        // create another string and convert the array to string:
        String converted = new String(myByteArray);
        System.out.println(converted);
    }

    @Test
    public void stringComparing() {
        String myNumberOne = "This";
        Assert.assertEquals(myNumberOne.compareTo("Thisss"),-2);
        Assert.assertEquals(myNumberOne.compareTo("This"),-0);

        Assert.assertTrue(myNumberOne.contains("T"));

        // the content must be the same and the type must be a string as well
        Assert.assertTrue(myNumberOne.contentEquals("This"));

        Assert.assertTrue(myNumberOne.startsWith("Th"));
        Assert.assertTrue(myNumberOne.endsWith("his"));

        String hello = "Hello fella";
        // in effect, I'm looking for the string "fe" as the length is 2
        Assert.assertTrue(hello.regionMatches(true, 6, "fezjjjkjkj", 0, 2));

        //Index of
        Assert.assertEquals(hello.indexOf("l"), 2);
        Assert.assertEquals(hello.indexOf("l", 3), 3);
        Assert.assertEquals(hello.lastIndexOf("l", 7), 3);
    }

    @Test
    public void validateRegex() {
        String regexValidateNumber = ".*[0-9]+.*";
        Assert.assertTrue("789".matches(regexValidateNumber));

        String regexValidateCapitelLetter = ".*[A-Z]+.*";
        Assert.assertTrue("toR".matches(regexValidateCapitelLetter));
    }

    @Test
    public void replacing() {
        String hello = "Hello fella fella fella";
        System.out.println(hello.replace("fella", "*"));
        Assert.assertEquals(hello.replace("fella", "world"), "Hello world world world");

        String numbers = "0123456789";
        System.out.println(numbers.replaceAll("[0-5]", "*"));
        Assert.assertEquals(numbers.replaceAll("[0-5]", "*"), "******6789");
    }

    @Test
    public void trimAndCases() {
        String name = "  My Name ";
        Assert.assertEquals(name.trim(), "My Name");

        String trimmed = name.trim();
        Assert.assertEquals(trimmed.toUpperCase(), "MY NAME");
    }

    @Test
    public void subStrings() {
        String mySrt = "0123456789";
        System.out.println(mySrt.substring(5));
        Assert.assertEquals(mySrt.substring(5), "56789");
        Assert.assertEquals(mySrt.substring(7, 9), "78");
    }

    @Test
    public void stringFormating() {
        String txt = "A %s summer evening in %d";
        System.out.println(String.format(txt, "romantic", 2020));
        Assert.assertEquals(String.format(txt, "romantic", 2020), "A romantic summer evening in 2020");
    }

    @Test
    public void stringSplit() {
        String txt = "Name,Adress,Age,Profession";
        String [] mySplit = txt.split(",");

        for (String values:
             mySplit) {
            System.out.println(values);
        }
        Assert.assertEquals(mySplit[0], "Name");
    }

    @Test
    public void stringBuilder() {
        StringBuilder myBuilder = new StringBuilder();
        myBuilder.append("Sum");
        myBuilder.append(": ");
        char [] sum = {'1', ' ', '+', ' ', '3'};
        myBuilder.append(sum);
        myBuilder.append(" = 4");
        Assert.assertEquals(myBuilder.toString(), "Sum: 1 + 3 = 4");
        System.out.println(myBuilder.toString());
    }

}
