package ar.fiuba.tdd.tp2;

import java.util.Calendar;
import java.util.Date;

public class PurchaseDate {

    private Date date;
    private String year;
    private String month;
    private int dayNumber;
    private String weekDay;
    private int weekNumber;
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public PurchaseDate() {
        this.date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        this.year = ((Integer) cal.get(Calendar.YEAR)).toString();
        this.month = Month.values()[cal.get(Calendar.MONTH)].toString();
        this.dayNumber = cal.get(Calendar.DAY_OF_MONTH);
        this.weekDay = Day.values()[cal.get(Calendar.DAY_OF_WEEK)].toString();
        this.weekNumber = cal.get(Calendar.WEEK_OF_MONTH);
    }

    public String getYear() {
        return this.year;
    }
    public String getMonth() {
        return this.month;
    }
    public int getDayNumber() {
        return this.dayNumber;
    }
    public String getWeekDay() {
        return this.weekDay;
    }
    public int getWeekNumber() {
        return this.weekNumber;
    }
}
