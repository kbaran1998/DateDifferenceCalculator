import datePackage.Date;
import datePackage.DateCalculations;

import java.util.Scanner;

/**
 * Class that will provide a GUI such that you will be provided with.
 */
public class Launcher {
    private static int [] daysInMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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
                        }
                        catch (Exception e) {
                            System.out.println("Try again!");
                        }
                    }
                    Date currentDate = cal.getCurrentDate();
                    //Make a comparator for dates (I.e. which one is smaller and which is bigger)

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
