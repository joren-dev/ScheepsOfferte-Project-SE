package e.onderdelen;

import java.util.*;

public class Onderdelen {
    private static final Map<String, List<String>> OPTIES_PER_CATEGORIE = new HashMap<String, List<String>>() {{
        put("Motor", List.of("Standaard motor", "Opgevoerde motor", "Dubbele motor", "Duurzame motor"));
        put("Veiligheid", List.of("Standaard veiligheidspakket", "Extra veiligheidspakket"));
        put("Behuizing", List.of("Metaal", "Goud", "Hout"));
        put("Extras", List.of("Airco", "Ingebouwde koelkast", "GPS-Systeem", "Dieptemeter", "Radar"));
        put("Uiterlijk", List.of("Biologische verf", "Standaard verf", "LED verlichting"));
    }};

    public static final String[] ESSENTIAL_CATEGORIES = {"Motor", "Veiligheid", "Behuizing"};
    public static final String[] OPTIONAL_CATEGORIES = {"Uiterlijk", "Extras"};

    public static List<String> gekozenOpties = new ArrayList<>();

    public static void essentialsList() {
        Scanner scanner = new Scanner(System.in);
        for (String categorie : ESSENTIAL_CATEGORIES) {
            System.out.println(categorie);
            System.out.println("===============");
            int i = 1;
            for (String optie : OPTIES_PER_CATEGORIE.get(categorie)) {
                System.out.printf("%d. %s%n", i, optie);
                i++;
            }
            int input = scanner.nextInt();
            String optie = OPTIES_PER_CATEGORIE.get(categorie).get(input-1);
            gekozenOpties.add(optie);

            System.out.println();
        }
    }

    public static void optionalList() {
        Scanner scanner = new Scanner(System.in);
        for (String categorie : OPTIONAL_CATEGORIES) {
            System.out.println(categorie);
            System.out.println("===============");
            int i = 1;
            for (String optie : OPTIES_PER_CATEGORIE.get(categorie)) {
                System.out.printf("%d. %s%n", i, optie);
                i++;
            }
            System.out.print("Wil je een optie toevoegen? (j/n): ");
            String antwoord = scanner.next();
            while (antwoord.equalsIgnoreCase("j")) {
                System.out.print("Welke optie wil je toevoegen? (1-" + (i - 1) + "): ");
                int input = scanner.nextInt();
                String optie = OPTIES_PER_CATEGORIE.get(categorie).get(input - 1);
                gekozenOpties.add(optie);
                System.out.print("Wil je nog een optie toevoegen? (j/n): ");
                antwoord = scanner.next();
            }
            System.out.println();
        }
    }

}
