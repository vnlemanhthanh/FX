package Lab8.Lab89;

public class TimeSpan {
    private int hours;
    private int minutes;

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

    public void scale(int factor) {
        this.hours = this.minutes * factor / 60 + factor * this.hours;
        this.minutes = this.minutes * factor % 60;
    }
}
