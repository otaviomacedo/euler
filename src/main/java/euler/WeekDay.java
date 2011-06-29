package euler;

public enum WeekDay {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    public WeekDay plusDays(int offset){
        return WeekDay.values()[(this.ordinal() + offset) % 7];
    }
}
