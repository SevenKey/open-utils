package sevenkey.open.utils.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 日历工具类
 *
 * @author weijianyu
 */
public class CalendarUtil {

    /**
     * 其实年份
     */
    private static final int START_YEAR = 1990;
    /**
     * 特殊2月份
     */
    private static final Integer SPECIAL_MONTH = 2;
    /**
     * 星期数
     */
    private static final Integer WEEK_DAYS = 7;
    /**
     * 12月
     */
    private static final List<Integer> MONTH_DAYS = Lists.newArrayList(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    /**
     * 判断输入的年份是否是闰年
     *
     * @param year 年份
     * @return
     */
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * 距离1900-1-1 天数
     *
     * @param year  年份
     * @param month 月份
     * @return
     */
    public static int getTotalDays(int year, int month) {
        int totalDays = 0;

        for (int currentYear = START_YEAR; currentYear < year; currentYear++) {
            if (isLeapYear(currentYear)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        for (int currentMonth = 1; currentMonth < month; currentMonth++) {
            totalDays += MONTH_DAYS.get(currentMonth);
            // 2月份
            if (SPECIAL_MONTH == currentMonth && isLeapYear(year)) {
                totalDays += 1;
            }
        }

        return totalDays;
    }

    /**
     * 判断月份第一个星期
     *
     * @param year  年份
     * @param month 月份
     * @return
     */
    public static int getWeek(int year, int month) {
        return (getTotalDays(year, month) + 1) % 7;
    }

    /**
     * 画日历
     *
     * @param year  年份
     * @param month 月份
     */
    public static void getCalendar(int year, int month) {
        List<List<Integer>> calendar = Lists.newArrayList();

        int countDay = 1;
        int monthDay = MONTH_DAYS.get(month);
        // 润2月份
        if (SPECIAL_MONTH == month && isLeapYear(year)) {
            monthDay += 1;
        }

        while (countDay <= monthDay) {
            List<Integer> line = Lists.newArrayList();
            int day = 0;

            if (countDay == 1) {
                day = getWeek(year, month);
                for (int i = 0; i < day; i++) {
                    line.add(0);
                }
            }

            for (; day < WEEK_DAYS; day++) {
                line.add(countDay++);
                if (countDay > monthDay) {
                    break;
                }
            }
            calendar.add(line);
        }

        printCalendar(calendar);
    }

    private static void printCalendar(List<List<Integer>> calendar) {
        calendar.forEach(line -> {
            line.forEach(day -> {
                System.out.print(String.format("%02d", day) + "  ");
            });
            System.out.println();
        });
    }
}
