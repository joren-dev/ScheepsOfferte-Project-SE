package e.onderdelen;

import java.util.*;

public class Onderdelen {
    private static final Map<String, List<String>> OPTIES_PER_CATEGORIE = new HashMap<String, List<String>>() {{
        put("Motor", List.of("Standaard motor", "Opgevoerde motor", "Dubbele motor", "Duurzame motor"));
        put("Veiligheid", List.of("Standaard veiligheidspakket", "Extra veiligheidspakket"));
        put("Behuizing", List.of("Metaal", "Goud", "Hout"));
        put("Extras", List.of("Airco"));
        put("Uiterlijk", List.of("Biologische verf", "LED verlichting"));
    }};

    public static final String[] ESSENTIAL_CATEGORIES = {"Motor", "Veiligheid"};
    public static final String[] OPTIONAL_CATEGORIES = {"Behuizing", "Uiterlijk", "Extras"};

    private static List<String> gekozenOpties = new ArrayList<>();

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
            int input = scanner.nextInt();
            String optie = OPTIES_PER_CATEGORIE.get(categorie).get(input-1);
            gekozenOpties.add(optie);

            System.out.println();
        }
    }
}
