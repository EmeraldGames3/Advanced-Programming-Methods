import java.lang.reflect.Array;
import java.util.Arrays;

public class WeatherStation {
    public int[] days;

    public WeatherStation() {
        days = new int[14];
        days[0] = 12;
        days[1] = 14;
        days[2] = 9;
        days[3] = 12;
        days[4] = 15;
        days[5] = 16;
        days[6] = 15;
        days[7] = 15;
        days[8] = 11;
        days[9] = 8;
        days[10] = 13;
        days[11] = 13;
        days[12] = 15;
        days[13] = 12;
    }

    // You can also provide methods to access and modify the days array
    public int[] getDays() {
        return days;
    }

    public void setDays(int[] days) {
        this.days = days;
    }

    public int medianTemperature() {
        int sum = 0;
        for (int i = 0; i < 14; i++) {
            sum += days[i];
        }
        return sum / 14;
    }

    public Pair<Integer, Integer> highestLowest() {
        int min = 100;
        int max = 0;
        for (int i = 0; i < 14; i++) {
            if (min > days[i])
                min = days[i];
            if (max < days[i])
                max = days[i];
        }

        return new Pair<>(min, max);
    }

    public Pair<Integer, Integer> highestRise() {
        int day1 = 0;
        int day2 = 1;

        for (int i = 1; i < 14; i++) {
            if (Math.abs(days[i] - days[i - 1]) > Math.abs(days[day2] - days[day1])) {
                day2 = i;
                day1 = i - 1;
            }
        }
        return new Pair<>(day1 + 1, day2 + 1);
    }

    @Override
    public String toString() {

        StringBuilder table = new StringBuilder();

        table.append("Day\tTemp\n");

        for(int i = 0; i < days.length; i++) {
            table.append((i + 1)).append("\t").append(days[i]).append("\n");
        }

        return table.toString();

    }
}