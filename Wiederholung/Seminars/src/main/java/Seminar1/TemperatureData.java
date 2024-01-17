package Seminar1;

public class TemperatureData {
    public double calculateAverageTemp(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException("Temperature array is empty or null");
        }
        int sum = 0;
        for (int temp : temperatures) {
            sum += temp;
        }
        return (double) sum / temperatures.length;
    }

    public int findMaxTemp(int[] temperatures) {
        int max = temperatures[0];
        for (int temp : temperatures) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public int findMinTemp(int[] temperatures) {
        int min = temperatures[0];
        for (int temp : temperatures) {
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public int findLargestTempChange(int[] temperatures) {
        if (temperatures.length < 2) {
            throw new IllegalArgumentException("At least twotemperatures are required to calculate a change.");
        }
        int maxChange = 0;
        for (int i = 1; i < temperatures.length; i++) {
            int change = Math.abs(temperatures[i] - temperatures[i - 1]);
            if (change > maxChange) {
                maxChange = change;
            }
        }
        return maxChange;
    }
}