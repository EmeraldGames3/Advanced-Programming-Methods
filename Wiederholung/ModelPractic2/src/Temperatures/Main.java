package Temperatures;

import Temperatures.Tests.Test;
import Temperatures.View.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.addTemperature();
        view.convertTemperature();

        Test test = new Test();
        test.testAll();
    }
}
