package utils;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.utils.CalendarUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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


    @Test
    public void test() {
        ArrayList<Object> list = Lists.newArrayList();
        list.addAll(null);
    }

    @Test
    public void test1() {
        List<Integer> list = Lists.newArrayList(1, 4, 2, 6, 8, 8, 3);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() > o2.intValue()) {
                    return -1;
                } else if (o1.intValue() == o2.intValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        System.out.println(list);
    }
}
