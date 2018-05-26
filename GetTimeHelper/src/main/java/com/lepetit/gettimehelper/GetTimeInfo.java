package com.lepetit.gettimehelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetTimeInfo {
    private GetTime getTime;
    private int year;
    private int month;
    private int day;
    private static GetTimeInfo instance;

    private GetTimeInfo() {
        getTime = new GetTime();
        year = getTime.getYear();
        month = getTime.getMonth();
        day = getTime.getDay();
    }

    private static GetTimeInfo getInstance() {
        if (instance == null) {
            instance = new GetTimeInfo();
        }
        return instance;
    }

    private List<String> _getTimeList() {
        List<String> list = new ArrayList<>();

        for (int i = 2014; i < year; i++) {
            String string1 = String.valueOf(i) + "-" + String.valueOf(i + 1) + "-1";
            String string2 = String.valueOf(i) + "-" + String.valueOf(i + 1) + "-2";
            list.add(string1);
            list.add(string2);
        }

        if (month > 7) {
            String string = String.valueOf(year) + "-" + String.valueOf(year + 1) + "-1";
            list.add(string);
        }
        return list;
    }

    private String _getSimpleTime() {
        if (month > 7) {
            return String.valueOf(year) + "-" + String.valueOf(year + 1) + "-1";
        }
        else {
            return String.valueOf(year - 1) + "-" + String.valueOf(year) + "-2";
        }
    }

    private String _getDate() {
        return String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
    }

    private int _getPastDay(String dateNow, String dateExam) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(dateNow);
        Date date2 = format.parse(dateExam);
        System.out.println(date1);
        System.out.println(date2);
        int temp = (int)(date2.getTime() - date1.getTime());
        if (temp < 0) {
            return -1;
        }
        return temp / (1000*3600*24);
    }

    public static List<String> getTimeList() {
        return getInstance()._getTimeList();
    }

    public static String getSimpleSTime() {
        return getInstance()._getSimpleTime();
    }

    public static String getDate() {
        return getInstance()._getDate();
    }

    public static int getPastDay(String dateNow, String dateExam) throws ParseException {
        return getInstance()._getPastDay(dateNow, dateExam);
    }

    public static int getWeek() {
        return getInstance().getTime.getWeek();
    }
}