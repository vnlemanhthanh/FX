package Lab8.Lab87;

public class TimeSpan {
    private int hours;
    private int minutes;

    public void add(int hours, int minutes) {
        this.minutes += minutes;
        this.hours += hours + this.minutes / 60;
        this.minutes %= 60;
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public String toString() {
        return "Hours: " + getHours() + " , " +
                "Minutes: " + getMinutes();
    }

    public void add(TimeSpan span) {
        this.minutes += span.minutes;
        this.hours += span.hours + this.minutes / 60;
        this.minutes %= 60;
    }
}
