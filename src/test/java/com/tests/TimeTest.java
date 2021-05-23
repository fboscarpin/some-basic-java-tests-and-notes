package com.tests;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

    @Test
    public void workingWithDates(){

        Date myDate = new Date();
        Date myDate2 = new Date(System.currentTimeMillis());
        System.out.println(myDate); // Sat May 22 21:51:35 CEST 2021
        System.out.println(myDate2); // same as above

        Date seven = new Date();
        System.out.println(String.format("Time now is: " + seven));

        // create long variables to calculate the time
        long nowTime = seven.getTime();
        long oneWeekFromNow = nowTime + (24 * 60 * 60 * 7 * 1000);

        Date oneWeekFromNowTime = new Date(oneWeekFromNow);
        System.out.println("One week from now time is: " + oneWeekFromNowTime);
    }

    @Test
    public void setTimeMethod(){
        Date originalTime = new Date();
        Date setTimeVar = new Date();
        setTimeVar.setTime(System.currentTimeMillis());
        System.out.println("Set date result: " + setTimeVar);
        Assert.assertTrue("Assert that times are equal - true", setTimeVar.equals(originalTime));
        Assert.assertTrue("Assert that times are equal - compare to", setTimeVar.compareTo(originalTime)==0);
    }

    @Test
    public void formattingDates(){
        SimpleDateFormat time = new SimpleDateFormat("dd/MM/yyyy");
        //time.applyPattern("dd/MM/yyyy"); // I could also format the date after instantiating the object
        String currentDate = time.format(new Date());
        System.out.println("Date on format MM/dd/yyyy:\n" + currentDate);
    }

    @Test
    public void parseDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String myDate = format.format(new Date());
        System.out.println("myDate in current date is: " +myDate);

        Date secondDate =  format.parse("10/10/2020");
        System.out.println("Print with parse: "+ secondDate);
    }

}
