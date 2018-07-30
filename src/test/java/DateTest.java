import datePackage.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Date class tests.
 */
public class DateTest {
    private Date defaultDate = new Date(1, 1, 2010, 0, 0, 0);
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

    /**
     * Check day getter.
     */
    @Test
    void getDayTest() {
        assertThat(defaultDate.getDay()).isEqualTo(1);
    }

    /**
     * Check month getter.
     */
    @Test
    void getMonthTest() {
        assertThat(defaultDate.getMonth()).isEqualTo(1);
    }

    /**
     * Check year getter.
     */
    @Test
    void getYearTest() {
        assertThat(defaultDate.getYear()).isEqualTo(2010);
    }

    /**
     * Check hours getter.
     */
    @Test
    void getHoursTest() {
        assertThat(defaultDate.getHour()).isEqualTo(0);
    }

    /**
     * Check minutes getter.
     */
    @Test
    void getMinutesTest() {
        assertThat(defaultDate.getMinutes()).isEqualTo(0);
    }

    /**
     * Check seconds getter.
     */
    @Test
    void getSecondsTest() {
        assertThat(defaultDate.getSeconds()).isEqualTo(0);
    }


    /**
     * Days in month getter for normal year.
     */
    @Test
    void getDayInMonthNormalTest() {
        assertThat(defaultDate.getDaysInMonths()).isEqualTo(new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31});
    }

    /**
     * Days in month getter for a leap year.
     */
    @Test
    void getDayInMonthLeapYearTest() {
        Date leap = new Date(1, 1, 2012, 0, 0, 0);
        assertThat(leap.getDaysInMonths()).isEqualTo(new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31});
    }

    /**
     * Test for leap year checker for true value.
     */
    @Test
    void isLeapTrue() {
        Date leap = new Date(1, 1, 2012, 0, 0, 0);
        assertThat(leap.isLeapYear()).isTrue();
    }

    /**
     * Test for leap year checker for false value.
     */
    @Test
    void isLeapFalse() {
        assertThat(defaultDate.isLeapYear()).isFalse();
    }


}
