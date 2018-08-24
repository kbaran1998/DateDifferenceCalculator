package datePackage;

import java.time.LocalDate;
import java.time.LocalTime;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Calculations class for the datePackage.Date object.
 */
public class DateCalculations {
    private int normalDaysInYear;
    private int daysInLeapYear;

    /**
     * Set days for leap year and normal year.
     */
    public DateCalculations() {
        normalDaysInYear = 365;
        daysInLeapYear = 366;
    }

    /**
     * A method to calculate the amoint of days in-between the dates.
     * @param current The current date we want.
     * @param other The date we want to calculate the date from.
     * @return number of days.
     */
    public int getDaysInBetween(datePackage.Date current, datePackage.Date other) {
        int currentYear = current.getYear();
        int otherYear = other.getYear();
        if (abs(currentYear - otherYear) < 2) {
            return 0;
        }
        int daysCounter = 0;
        int beginYear = min(currentYear, otherYear);
        int endYear = max(currentYear, otherYear);
        for (int i = beginYear + 1; i < endYear; i++) {
            if (isLeapYear(i)) {
                daysCounter += daysInLeapYear;
            }
            else {
                daysCounter += normalDaysInYear;
            }
        }
        return daysCounter;
    }

    /**
     *  A method to return number of days starting from January.
     * @param current Your provided date.
     * @return number of days from January.
     */
    public int daysFromJanuary(datePackage.Date current) {
        int days = 0;
        int [] daysInMonth = current.getDaysInMonths();
        for (int i = 0; i < current.getMonth() - 1; i++) {
            days += daysInMonth[i];
        }
        days += current.getDay();
        return days;
    }

    /**
     * Calculates the days from your current day to December (same year).
     * @param current Your input date.
     * @return Days that passes.
     */
    public int daysFromDecember(datePackage.Date current) {
        int days = daysFromJanuary(current);
        if(current.isLeapYear()) {
            days = daysInLeapYear - days;
        }
        else {
            days = normalDaysInYear - days;
        }
        return days;
    }
    /**
     *  Check if the year is leap year.
     * @param year the given year
     * @return if the year is leap or not.
     */
    public boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    /**
     * Check whether this daye is earlier than the other.
     * @param thisDate this given date
     * @param otherDate other given date
     * @return bool to check if this current date is early.
     */
    public boolean isEarly(Date thisDate, Date otherDate) {
        if (thisDate.getYear() == otherDate.getYear()) {
            int daysForThis = 0;
            int daysForOther = 0;
            daysForThis += thisDate.getDay();
            daysForOther += otherDate.getDay();
            for (int i = 0; i < thisDate.getMonth() - 1; i++) {
                daysForThis += thisDate.getDaysInMonths()[i];
            }
            for (int i = 0; i < otherDate.getMonth() - 1; i++) {
                daysForOther += otherDate.getDaysInMonths()[i];
            }
            return daysForThis < daysForOther;
        }
        return thisDate.getYear() < otherDate.getYear();
    }

    /**
     * Get the current date right now.
     */
    public datePackage.Date getCurrentDate() {
        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();
        int hour = nowTime.getHour();
        int min = nowTime.getMinute();
        int sec = nowTime.getSecond();
        return new datePackage.Date(day, month, year, hour, min, sec);
    }
}
