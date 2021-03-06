package com.lepetit.gettimehelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

        if (month >= 6) {
            String string = String.valueOf(year) + "-" + String.valueOf(year + 1) + "-1";
            list.add(string);
        }
        return list;
    }

    private String _getSimpleTime() {
        if (month > 7) {
            return String.valueOf(year) + "-" + String.valueOf(year + 1) + "-1";
        }
        else if (month < 2) {
            return String.valueOf(year - 1) + "-" + String.valueOf(year) + "-1";
        }
        else {
            return String.valueOf(year - 1) + "-" + String.valueOf(year) + "-2";
        }
    }

    private String _getDate() {
        String mMonth = (month < 10) ? "0" + String.valueOf(month) : String.valueOf(month);
        String mDay = (day < 10) ? "0" + String.valueOf(day) : String.valueOf(day);
        return String.valueOf(year) + "-" + mMonth + "-" + mDay;
    }

    private long _getPastDay(String dateNow, String dateExam) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date mDateNow = new Date();
        Date mDateExam = new Date();
        try {
            mDateNow = format.parse(dateNow);
            mDateExam = format.parse(dateExam);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (mDateExam.after(mDateNow) || mDateExam.equals(mDateNow)) {
            long temp = mDateExam.getTime() - mDateNow.getTime();
            return temp / (1000 * 3600 * 24);
        }
        else {
            return -1;
        }
    }

    private int _getPastWeek(String dateNow, String startWeek, String endWeek) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		Date mDateNow = new Date();
		Date mStartWeek = new Date();
		Date mEndWeek = new Date();
		try {
			mDateNow = format.parse(dateNow);
			mStartWeek = format.parse(startWeek);
			mEndWeek = format.parse(endWeek);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long temp = mDateNow.getTime() - mStartWeek.getTime();
		long isLaterThanEndWeek = mDateNow.getTime() - mEndWeek.getTime();
		if (temp < 0 || isLaterThanEndWeek > 0) {
		    temp = 0;
        }
		return (int)(temp / (1000 * 3600 * 24 * 7) + 1);
	}

    public static List<String> getTimeList() {
        return getInstance()._getTimeList();
    }

    public static String getSimpleTime() {
        return getInstance()._getSimpleTime();
    }

    public static String getDate() {
        return getInstance()._getDate();
    }

    public static long getPastDay(String dateNow, String dateExam) {
        return getInstance()._getPastDay(dateNow, dateExam);
    }

    public static int getWeek() {
        return getInstance().getTime.getWeek();
    }

    public static int getMonth() {
    	return getInstance().month;
	}

	public static int getPastWeek(String dateNow, String startWeek, String endWeek) {
    	return getInstance()._getPastWeek(dateNow, startWeek, endWeek);
	}
}
