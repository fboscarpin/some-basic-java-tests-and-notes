package com.tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class CalendarTest {

    @Test
    public void simpleCalendar(){
        Calendar calOne = Calendar.getInstance();
        Calendar calTwo = Calendar.getInstance();

        System.out.println(calOne);
        System.out.println(calTwo);
        // All the properties that I can work are printed:
        // java.util.GregorianCalendar[time=1621716366429,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Europe/Berlin",offset=3600000,dstSavings=3600000,useDaylight=true,transitions=143,lastRule=java.util.SimpleTimeZone[id=Europe/Berlin,offset=3600000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=2,startMonth=2,startDay=-1,startDayOfWeek=1,startTime=3600000,startTimeMode=2,endMode=2,endMonth=9,endDay=-1,endDayOfWeek=1,endTime=3600000,endTimeMode=2]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2021,MONTH=4,WEEK_OF_YEAR=21,WEEK_OF_MONTH=4,DAY_OF_MONTH=22,DAY_OF_YEAR=142,DAY_OF_WEEK=7,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=10,HOUR_OF_DAY=22,MINUTE=46,SECOND=6,MILLISECOND=429,ZONE_OFFSET=3600000,DST_OFFSET=3600000]

        calOne.setTime(calTwo.getTime()); // if we don't do this, the property time will be different

        Assert.assertTrue("CalOne and CalTwo are equal", calOne.equals(calTwo));
    }

    @Test
    public void addDate(){
        Calendar cal = Calendar.getInstance();
        Calendar oneWeekFromNow = Calendar.getInstance();
        oneWeekFromNow.setTime(cal.getTime());
        oneWeekFromNow.add(Calendar.DATE, 7);
        System.out.println("Seven days added: " + oneWeekFromNow);
    }

    @Test
    public void setCalendarProperties(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 10);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.YEAR, 2022);
        System.out.println("New calendar date: " + cal);

        //Set and print date from calendar
        cal.set(2023, 11, 15);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH) +"/"+ cal.get(Calendar.MONTH) +"/"+ cal.get(Calendar.YEAR));
    }

}
