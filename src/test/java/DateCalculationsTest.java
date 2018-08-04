import datePackage.Date;
import datePackage.DateCalculations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 * Tests for calculating the days.
 */
public class DateCalculationsTest {
    DateCalculations calc = new DateCalculations();
    /**
     * Verify that the getDaysInBetween() returns 0 when the year difference is 0.
     */
    @Test
    void daysInBetweenHas0YearDifference() {
        Date thisDate = new Date(1, 1,2000, 0, 0, 0);
        Date otherDate = new Date(1, 1,2000, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(0);
    }

    /**
     * Verify that the getDaysInBetween() returns 0 when the year difference is 1.
     */
    @Test
    void daysInBetweenHas1YearDifference() {
        Date thisDate = new Date(1, 1,2000, 0, 0, 0);
        Date otherDate = new Date(1, 1,2001, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(0);
    }

    /**
     * Verify that the getDaysInBetween() returns 365 when the year difference is 2
     * and the year in-between these two years is NOT a leap year.
     */
    @Test
    void daysInBetweenHas2YearDifferenceNotLeap() {
        Date thisDate = new Date(1, 1,2000, 0, 0, 0);
        Date otherDate = new Date(1, 1,2002, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(365);
    }

    /**
     * Verify that the getDaysInBetween() returns 365 when the year difference is 2
     * and the year in-between these two years IS a leap year.
     */
    @Test
    void daysInBetweenHas2YearDifferenceLeap() {
        Date thisDate = new Date(1, 1,1999, 0, 0, 0);
        Date otherDate = new Date(1, 1,2001, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(366);
    }

    /**
     * Verify that the getDaysInBetween() returns 365 when the year difference is 3
     * and the year in-between these two years is NOT a leap year.
     */
    @Test
    void daysInBetweenHas3YearDifferenceNotLeap() {
        Date thisDate = new Date(1, 1,2000, 0, 0, 0);
        Date otherDate = new Date(1, 1,2003, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(730);
    }

    /**
     * Verify that the getDaysInBetween() returns 365 when the year difference is 3
     * and the year in-between these two years IS a leap year.
     */
    @Test
    void daysInBetweenHas3YearDifferenceLeap() {
        Date thisDate = new Date(1, 1,1999, 0, 0, 0);
        Date otherDate = new Date(1, 1,2002, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(731);
    }

    /**
     * Test B.C. years for year difference if it is 0, that it would return 0.
     */
    @Test
    void BCYearsYearDifference0() {
        Date thisDate = new Date(1, 1,-1, 0, 0, 0);
        Date otherDate = new Date(1, 1,-1, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(0);
    }

    /**
     * Test B.C. years for year difference if it is 1, that it would return 0.
     */
    @Test
    void YearsBCYearDifference1() {
        Date thisDate = new Date(1, 1,-1, 0, 0, 0);
        Date otherDate = new Date(1, 1,-2, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(0);
    }

    /**
     * Test B.C. years for year difference if it is 2, that it would return 365 if the year
     * in-between is NOT leap.
     */
    @Test
    void YearsBCYearDifference2NotLeapYear() {
        Date thisDate = new Date(1, 1,-1, 0, 0, 0);
        Date otherDate = new Date(1, 1,-3, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(365);
    }

    /**
     * Test B.C. years for year difference if it is 2, that it would return 365 if the year
     * in-between is  leap.
     */
    @Test
    void YearsBCYearDifference2LeapYear() {
        Date thisDate = new Date(1, 1,-3, 0, 0, 0);
        Date otherDate = new Date(1, 1,-5, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(366);
    }

    /**
     * Test B.C. years for year difference if it is 3, that it would return 730 if the year
     * in-between is NOT leap.
     */
    @Test
    void YearsBCYearDifference3NotLeapYear() {
        Date thisDate = new Date(1, 1,-1, 0, 0, 0);
        Date otherDate = new Date(1, 1,-4, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(730);
    }

    /**
     * Test B.C. years for year difference if it is 3, that it would return 731 if the year
     * in-between is  leap.
     */
    @Test
    void YearsBCYearDifference3LeapYear() {
        Date thisDate = new Date(1, 1,-3, 0, 0, 0);
        Date otherDate = new Date(1, 1,-6, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(731);
    }

    /**
     * Test if the date is given correctly when you mix B.C and A.C years.
     */
    @Test
    void BCandACyears() {
        Date thisDate = new Date(1, 1,1, 0, 0, 0);
        Date otherDate = new Date(1, 1,-1, 0, 0, 0);
        assertThat(calc.getDaysInBetween(thisDate, otherDate)).isEqualTo(366);
    }

    /**
     * Test daysFromJanuary() for each of the beginning days of each month.
     */
    @ParameterizedTest
    @CsvSource({"1,1,1,1", "1,2,1,32", "1,3,1,60", "1,3,0,61", "1,4,1,91", "1,4,0,92", "1,5,1,121",
            "1,5,0,122", "1,6,1,152", "1,6,0,153", "1,7,1,182", "1,7,0,183", "1,8,1,213",
            "1,8,0,214", "1,9,1,244", "1,9,0,245", "1,10,1,274", "1,10,0,275", "1,11,1,305",
            "1,11,0,306", "1,12,1,335", "1,12,0,336"})
    void daysFromJanuaryBeginningDays(int day, int month, int year, int result) {
        Date thisDate = new Date(day, month, year, 0, 0,0);
        assertThat(calc.daysFromJanuary(thisDate)).isEqualTo(result);
    }

    /**
     * Test daysFromJanuary() for each of the end days of each month.
     */
    @ParameterizedTest
    @CsvSource({"31,1,1,31", "28,2,1,59", "29,2,0,60", "31,3,1,90", "31,3,0,91", "30,4,1,120",
            "30,4,0,121", "31,5,1,151", "31,5,0,152", "30,6,1,181", "30,6,0,182",
            "31,7,1,212", "31,7,0,213", "31,8,1,243", "31,8,0,244", "30,9,1,273", "30,9,0,274",
            "31,10,1,304", "31,10,0,305", "30,11,1,334", "30,11,0,335", "31,12,1,365", "31,12,0,366"})
    void daysFromJanuaryEndDays(int day, int month, int year, int result) {
        Date thisDate = new Date(day, month, year, 0, 0,0);
        assertThat(calc.daysFromJanuary(thisDate)).isEqualTo(result);
    }

    /**
     * Test daysFromDecember() for each of the beginning days of each month.
     */
    @ParameterizedTest
    @CsvSource({"1,1,1,364", "1,2,1,333", "1,3,1,305", "1,3,0,305", "1,4,1,274", "1,4,0,274", "1,5,1,244",
            "1,5,0,244", "1,6,1,213", "1,6,0,213", "1,7,1,183", "1,7,0,183", "1,8,1,152",
            "1,8,0,152", "1,9,1,121", "1,9,0,121", "1,10,1,91", "1,10,0,91", "1,11,1,60",
            "1,11,0,60", "1,12,1,30", "1,12,0,30"})
    void daysFromDecemberBeginningDays(int day, int month, int year, int result) {
        Date thisDate = new Date(day, month, year, 0, 0,0);
        assertThat(calc.daysFromDecember(thisDate)).isEqualTo(result);
    }

    /**
     * Test daysFromDecember() for each of the end days of each month.
     */
    @ParameterizedTest
    @CsvSource({"31,1,1,334", "28,2,1,306", "29,2,0,306", "31,3,1,275", "31,3,0,275", "30,4,1,245",
            "30,4,0,245", "31,5,1,214", "31,5,0,214", "30,6,1,184", "30,6,0,184",
            "31,7,1,153", "31,7,0,153", "31,8,1,122", "31,8,0,122", "30,9,1,92", "30,9,0,92",
            "31,10,1,61", "31,10,0,61", "30,11,1,31", "30,11,0,31", "31,12,1,0", "31,12,0,0"})
    void daysFromDecemberEndDays(int day, int month, int year, int result) {
        Date thisDate = new Date(day, month, year, 0, 0,0);
        assertThat(calc.daysFromDecember(thisDate)).isEqualTo(result);
    }

    /**
     * Verify that the leap years are leap years.
     * @param year Year input.
     */
    @ParameterizedTest
    @CsvSource({"0", "4", "8", "12", "2000", "2004", "2008", "2012", "2016"})
    void isLeapYearTrue(int year) {
        Date date = new Date(1, 1, year, 0, 0, 0);
        assertThat(date.setLeapYear(year)).isTrue();
    }

    /**
     * Verify that the not leap years are not leap years.
     * @param year Year input.
     */
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "5", "2001", "2002", "2003", "2013", "2017"})
    void isLeapYearFalse(int year) {
        Date date = new Date(1, 1, year, 0, 0, 0);
        assertThat(date.setLeapYear(year)).isFalse();
    }

}
