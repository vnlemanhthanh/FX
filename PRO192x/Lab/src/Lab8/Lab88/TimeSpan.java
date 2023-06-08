package Lab8.Lab88;

public class TimeSpan {
    private int hours;
    private int minutes;

    public void add(int hours, int minutes) {  }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }

    public void subtract(TimeSpan span) {
        int minutesThis = this.hours * 60 + this.minutes;
        int minutesSpan = span.hours * 60 + span.minutes;
        int dm = minutesThis - minutesSpan;
        this.hours = dm / 60;
        this.minutes = dm % 60;
    }
}
