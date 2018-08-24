import datePackage.Date;
import datePackage.DateCalculations;

import java.util.Scanner;

/**
 * Class that will provide a GUI such that you will be provided with.
 */
public class Launcher {
    private static int [] daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Main method.
     * @param args random
     */
    public static void main(String[]args) {
        System.out.println("Welcome to Date Calculator!!!");
        Scanner sc = new Scanner(System.in);
        DateCalculations cal = new DateCalculations();
        char number;
        do {
            System.out.println("To use the app, type in a number.");
            System.out.println("1. Get current date.");
            System.out.println("2. Get number of days between now and a given day.");
            System.out.println("3. Get number of days between a date and other date.");
            System.out.println("4. EXIT.");
            System.out.print("Your number: ");
            number = sc.next().charAt(0);
            switch (number) {
                case '1':
                    System.out.println("Current date: " + cal.getCurrentDate().toSring());
                    break;

                case '2':
                    int day;
                    int month;
                    int year;
                    boolean correct = false;
                    Date givenDate;
                    while (!correct) {
                        try {
                            Scanner scan1 = new Scanner(System.in);
                            System.out.println("Enter day: ");
                            day = scan1.nextInt();
                            System.out.println("Enter month: ");
                            month = scan1.nextInt();
                            System.out.println("Enter year: ");
                            year = scan1.nextInt();
                            correct = isCorrectFormat(day, month, year);
                            if (!correct) {
                                System.out.println("Wrong date format!!!");
                            }
                            givenDate = new Date(day, month, year, 0, 0, 0);
                            Date currentDate = cal.getCurrentDate();
                            int diffDays = 0;
                            if (cal.isEarly(currentDate, givenDate)) {
                                if (currentDate.getYear() == givenDate.getYear()) {
                                    diffDays += cal.getDaysInBetween(currentDate, givenDate);
                                }
                                else {
                                    diffDays += cal.daysFromDecember(currentDate);
                                    diffDays += cal.getDaysInBetween(currentDate, givenDate);
                                    diffDays += cal.daysFromJanuary(givenDate);
                                }
                            }
                            else {
                                if (currentDate.getYear() == givenDate.getYear()) {
                                    diffDays += cal.getDaysInBetween(givenDate, currentDate);
                                }
                                else {
                                    diffDays += cal.daysFromDecember(givenDate);
                                    diffDays += cal.getDaysInBetween(givenDate, currentDate);
                                    diffDays += cal.daysFromJanuary(currentDate);
                                }

                            }
                            System.out.println("Diffrence between " + currentDate.getDay() + "/"
                                    + currentDate.getMonth() + "/" + currentDate.getYear() + " and "
                                    + givenDate.getDay() + "/"
                                    + givenDate.getMonth() + "/" + givenDate.getYear()
                                    + " is: " + diffDays + ".");
                        }
                        catch (Exception e) {
                            System.out.println("Try again!");
                        }
                    }
                    break;
                case '3':
                    break;

                case '4':
                    break;

                default:
                    System.out.println("Choose a number!!!");
                    break;
            }

        }
        while (number != '4');
    }

    /**
     * Method to check if the date uses correct date format.
     * @param day Day
     * @param month Month
     * @param year Year
     * @return a bool whether given date is in the correct format
     */
    public static boolean isCorrectFormat(int day, int month, int year) {
        if (year % 4 == 0) {
            daysInMonths[1] = 29;
        }

        if (month <= 0 || month > 12) {
            return false;
        }

        if (day <= 0 || daysInMonths[month - 1] < day) {
            return false;
        }
        return true;
    }
}
