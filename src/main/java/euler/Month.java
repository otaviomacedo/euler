package euler;

import com.google.common.collect.ImmutableList;

public class Month {

    private final int number;
    private final int year;

    public Month(int number, int year) {
        this.number = number;
        this.year = year;
    }

    public int numberOfDays() {
        // February
        if (number == 2) {
            if (year % 4 == 0) {
                if (year % 100 != 0) {
                    return 29;
                }
            }
            return 28;
        } else {
            return ImmutableList.of(9, 4, 6, 11).contains(number) ? 30 : 31;
        }
    }

    public Month next() {
        return number == 12
                ? new Month(1, year + 1)
                : new Month(number + 1, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Month month = (Month) o;

        if (number != month.number) {
            return false;
        }
        if (year != month.year) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + year;
        return result;
    }


    @Override
    public String toString() {
        return String.format("%d/%d", number, year);
    }

    public static int countWeekDaysIn(WeekDay weekDay, Month firstMonth, Month lastMonth){
        int count = 0;
        while (!firstMonth.equals(lastMonth)){
            weekDay = weekDay.plusDays(firstMonth.numberOfDays());
            firstMonth = firstMonth.next();
            if (weekDay == WeekDay.SUNDAY){
                count++;
            }
        }
        return count;
    }
}
