package utils;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.utils.CalendarUtil;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    @Test
    public void test11233() {

        List<Integer> tests = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            tests.add(i);
        }

        int step = 15;
        int i = 0;
        int j = i + step;

        while (i < tests.size()) {

            List<Integer> temp = tests.subList(i, j);
            i = j;
            j = i + step;
        }
    }

    @Data
    @Builder
    public static class Demo {
        Integer id;
        String no;
    }

    @Test
    public void test321123() {
        List<Demo> list = Lists.newArrayList();
        list.add(Demo.builder().id(2).no("123").build());
        list.add(Demo.builder().id(3).no("123").build());
        list.add(Demo.builder().id(3).no("123").build());
        list.add(Demo.builder().id(3).no("321").build());
        list.add(Demo.builder().id(4).no("321").build());
        list.add(Demo.builder().id(5).no("321").build());
        list.add(Demo.builder().id(6).no("321").build());
        list.add(Demo.builder().id(7).no("4").build());


        Map<String, List<Demo>> map = list.stream().collect(Collectors.groupingBy(Demo::getNo));
        System.out.println(map);
    }


    private String decrypt(String data, String privateKey) {
        try {
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key priKey = keyFactory.generatePrivate(pkcs8KeySpec);

            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(2, priKey);
            return new String(cipher.doFinal(Base64.decodeBase64(data)), "UTF-8");
        } catch (Exception e) {
            Assert.fail();
        }
        return StringUtils.EMPTY;
    }
}
