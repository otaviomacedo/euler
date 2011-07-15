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
        return isFebruary()
                ? isLeapYear() ? 29 : 28
                : isThirtyDaysMonth() ? 30 : 31;
    }

    private boolean isThirtyDaysMonth() {
        return ImmutableList.of(9, 4, 6, 11).contains(number);
    }

    private boolean isFebruary() {
        return number == 2;
    }

    private boolean isLeapYear() {
        return year % 4 == 0 && year % 100 != 0;
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

        return number == month.number && year == month.year;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%d/%d", number, year);
    }

    public static int countWeekDaysIn(WeekDay weekDay, Month firstMonth, Month lastMonth) {
        int count = 0;
        while (!firstMonth.equals(lastMonth)) {
            weekDay = weekDay.plusDays(firstMonth.numberOfDays());
            firstMonth = firstMonth.next();
            if (weekDay == WeekDay.SUNDAY) {
                count++;
            }
        }
        return count;
    }
}
