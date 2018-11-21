package ar.fiuba.tdd.tp2.offer_validator_client;

public class PurchaseDate {
    Integer year, day_number, week_number;
    String month, week_day;

    public PurchaseDate(Integer year, Integer day_number, Integer week_number, String month, String week_day) {
        this.year = year;
        this.day_number = day_number;
        this.week_number = week_number;
        this.month = month;
        this.week_day = week_day;
    }

    public Integer getDay_number() {
        return day_number;
    }

    public Integer getWeek_number() {
        return week_number;
    }

    public Integer getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getWeek_day() {
        return week_day;
    }
}
