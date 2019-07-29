package sevenkey.open.utils.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 日历工具类
 *
 * @author weijianyu
 */
public class CalendarUtil {

    private static final int START_YEAR = 1990;

    /**
     * 包含31天的月份
     */
    private static final List<Integer> THIRTY_ONE_DAYS_MONTH = Lists.newArrayList(1, 3, 5, 7, 8, 10, 12);
    /**
     * 特殊2月份
     */
    private static final List<Integer> SPECIAL_MONTH = Lists.newArrayList(2);
    /**
     * 正常30天月份
     */
    private static final List<Integer> THIRTY_DAYS_MONTH = Lists.newArrayList(4, 6, 9, 11);

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
            // 2月份
            if (SPECIAL_MONTH.contains(currentMonth)) {
                if (isLeapYear(year)) {
                    totalDays += 29;
                } else {
                    totalDays += 28;
                }
            }
            // 普通月份
            if (THIRTY_DAYS_MONTH.contains(currentMonth)) {
                totalDays += 30;
            }
            // 1,3,5,7,8,10,12 特殊月份
            if (THIRTY_ONE_DAYS_MONTH.contains(currentMonth)) {
                totalDays += 31;
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
        int monthDay = 0;
        // 2月份
        if (SPECIAL_MONTH.contains(month)) {
            if (isLeapYear(year)) {
                monthDay = 29;
            } else {
                monthDay = 28;
            }
        }
        if (THIRTY_DAYS_MONTH.contains(month)) {
            monthDay = 30;
        }
        if (THIRTY_ONE_DAYS_MONTH.contains(month)) {
            monthDay = 31;
        }

        int weekDay = getWeek(year, month);
        List<Integer> firstLine = Lists.newArrayList();
        for (int day = 0; day < 7; day++) {
            if (day < weekDay) {
                firstLine.add(0);
                continue;
            }
            firstLine.add(countDay++);
        }
        calendar.add(firstLine);

        while (countDay <= monthDay) {
            List<Integer> line = Lists.newArrayList();
            for (int day = 0; day < 7; day++) {
                line.add(countDay++);

                if (countDay > monthDay) {
                    break;
                }
            }
            calendar.add(line);
        }

        calendar.forEach(line -> {
            line.forEach(day -> {
                System.out.print(String.format("%02d", day) + "  ");
            });
            System.out.println();
        });
    }
}
