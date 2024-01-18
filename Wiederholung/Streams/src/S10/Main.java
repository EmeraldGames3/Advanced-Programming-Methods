package S10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Auto> autos = Arrays.asList(
                new Auto("Dacia", "Papuc", 1995),
                new Auto("Dacia", "None", 1997),
                new Auto("Dacia", "Fiesta", 1997),
                new Auto("Dacia", "Lupo", 1999)
        );

        Map<Integer, List<String>> autosNachBaujahr = autos.stream()
                .filter(auto -> Objects.equals(auto.getMark(), "Dacia"))
                .filter(auto -> !Objects.equals(auto.getModell(), "None"))
                .collect(Collectors.groupingBy(Auto::getBaujahr,
                        Collectors.mapping(Auto::getModell, Collectors.toList())));
        System.out.println(autosNachBaujahr);

        List<String> modells = autos.stream()
                .map(Auto::getModell)
                .filter(modell -> !Objects.equals(modell, "None"))
                .toList();
        System.out.println(modells);

        String text = "Ana are kox long";
        String newText = Arrays.stream(text.split(" "))
                .reduce("  ", (string, string2) -> string + "  " + string2);
        System.out.println(newText);

        List<String> bigWords = Arrays.stream(text.split(" "))
                .filter(word -> Character.isUpperCase(word.charAt(0))).toList();
        System.out.println(bigWords);

        String text2 = "Anaete are mere ete ete are kox";
        String newText2 = Arrays.stream(text2.split(" "))
                .filter(word -> word.contains("ete") || word.contains("ar"))
                .sorted()
                .reduce("", ((string, string2) -> string + " !" + string2.toUpperCase()));
        System.out.println(newText2);

        String newText1_2 = Arrays.stream(text.split(" "))
                .filter(word -> word.contains("e"))
                .filter(word -> word.length() < 4)
                .map(String::toUpperCase)
                .reduce("", ((string, string2) -> string + " " + string2))
                .substring(1);
        System.out.println(newText1_2);

        String newText1_3 = "Start " + Arrays.stream(text.split(" "))
                .map(String::toUpperCase)
                .reduce("", (string, string2) -> string + "   " + string2)
                .substring(3)
                + " End";

        System.out.println(newText1_3);

        List<String> passwords = Arrays.asList(
                "Password123!",
                "12345678",
                "ComplexPassword!123",
                "short",
                "NoNumbers!",
                "noupper123",
                "VALIDPASSWORD123$",
                "lowercaseonly",
                "1234567890",
                "SpecialChar#1"
        );

        passwords.stream().filter(password -> password.length() > 8)
                .filter(password -> password.contains("0") || password.contains("1") || password.contains("2")
                        || password.contains("3") || password.contains("4") || password.contains("5")
                        || password.contains("6") || password.contains("7") || password.contains("8")
                        || password.contains("9"))
                .filter(password -> password.contains("!") || password.contains("@")|| password.contains("#")
                        || password.contains("$") || password.contains("%") || password.contains("^")
                        || password.contains("&") || password.contains("*") || password.contains("(")
                        || password.contains(")"))
                .forEach(System.out::println);

        System.out.println();
        try {
            Path filePath = Path.of("src/S10/text.csv");

            List<String> totals = Files.lines(filePath)
                    .skip(1) // Skip header line
                    .map(line -> {
                        String[] parts = line.split(",");
                        String item = parts[0];
                        int quantity = Integer.parseInt(parts[1]);
                        double pricePerItem = Double.parseDouble(parts[2]);
                        double total = quantity * pricePerItem;
                        return item + ": " + total;
                    })
                    .toList();

            totals.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
