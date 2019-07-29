package utils;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.utils.CalendarUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtilTest {

    @Test
    public void testIsLeapYear() {
        Assert.assertTrue(CalendarUtil.isLeapYear(1968));
        Assert.assertTrue(CalendarUtil.isLeapYear(2000));
        Assert.assertTrue(CalendarUtil.isLeapYear(2004));
        Assert.assertTrue(CalendarUtil.isLeapYear(2012));


        Assert.assertFalse(CalendarUtil.isLeapYear(2013));
        Assert.assertFalse(CalendarUtil.isLeapYear(2019));
        Assert.assertFalse(CalendarUtil.isLeapYear(2010));
        Assert.assertFalse(CalendarUtil.isLeapYear(2015));
    }

    @Test
    public void testGetTotalDays() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("1990-01-01");

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long startTime = cal.getTimeInMillis();

        Date date1 = sdf.parse("2019-04-01");
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        Long betweenDays = (time1 - startTime) / (1000 * 3600 * 24);
        Assert.assertEquals(betweenDays.intValue(), CalendarUtil.getTotalDays(2019, 4));
    }

    @Test
    public void testGetWeek() {
        Assert.assertEquals(2, CalendarUtil.getWeek(2019, 1));
        Assert.assertEquals(5, CalendarUtil.getWeek(2019, 2));
    }

    @Test
    public void testGetCalendar() {
        CalendarUtil.getCalendar(2019, 1);
    }
}
