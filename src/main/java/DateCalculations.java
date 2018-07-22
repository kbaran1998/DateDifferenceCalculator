import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class DateCalculations {

    public DateCalculations(){

    }

    public int getDaysInBetween(Date current, Date other){
        if(abs(current.getYear() - other.getYear()) <2){
            return 0;
        }
        int daysCounter = 0;
        int beginYear = min(current.getYear(),other.getYear());
        int endYear = max(current.getYear(),other.getYear());
        for(int i = beginYear +1; i < endYear; i++){
            if (isLeapYear(i)){
                daysCounter += 366;
            }
            else{
                daysCounter += 365;
            }
        }
        return daysCounter;
    }

    public boolean isLeapYear(int year){
        return year % 4 == 0;
    }
}
