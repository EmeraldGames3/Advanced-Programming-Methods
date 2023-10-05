public class Main {
    public static String reverse(String input){
        StringBuilder result= new StringBuilder();
        for(int i = input.length(); i > 0; i--){
            result.append(input.charAt(i - 1));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        System.out.println(weatherStation.medianTemperature());
        System.out.println(weatherStation.highestLowest());
        System.out.println(weatherStation.highestRise());
        System.out.println(weatherStation.toString());
    }
}