package datePackage;

public class Date {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;
    private int seconds;
    private int [] daysInMonths;
    private boolean leapYear;

    public Date(int day, int month, int year, int hour, int minutes, int seconds) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
        daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        leapYear = setLeapYear(year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int[] getDaysInMonths() {
        return daysInMonths;
    }
    public boolean isLeapYear() {
        return leapYear;
    }

    public boolean setLeapYear(int year) {
        if (year % 4 == 0) {
            daysInMonths[1] = 29;
            return true;
        }
        return false;
    }

    public String toSring() {
        String time = "";
        if (minutes < 10) {
            time = hour + " : 0" + minutes;
        }
        else {
            time += hour + " : " + minutes;
        }
        return "Date: " + day + "/" + month + "/" + year + "\nTime: " + time;
    }
}
