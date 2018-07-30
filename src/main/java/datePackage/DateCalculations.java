package datePackage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
     *
     */
    public DateCalculations() {
        normalDaysInYear = 365;
        daysInLeapYear = 366;
    }

    /**
     * A method to calculate the amoint of days in-between the
     * @param current The current date we want.
     * @param other The
     * @return
     */
    public int getDaysInBetween(datePackage.Date current, datePackage.Date other) {
        if(abs(current.getYear() - other.getYear()) < 2) {
            return 0;
        }
        int daysCounter = 0;
        int beginYear = min(current.getYear(), other.getYear());
        int endYear = max(current.getYear(), other.getYear());
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
     * @param current
     * @return
     */
    public int daysFromJanuary(datePackage.Date current) {
        int days = 0;
        int [] daysInMonth = current.getDaysInMonths();
        for (int i = 0; i < current.getMonth()-1; i++){
            days += daysInMonth[i];
        }
        days += current.getDay();
        return days;
    }

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
     * @param year
     * @return
     */
    public boolean isLeapYear(int year) {
        return year % 4 == 0;
    }


    /**
     * Get the current date right now.
     */
    public datePackage.Date getCurrentDate(){
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
