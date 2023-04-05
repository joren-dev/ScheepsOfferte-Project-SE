package managers;

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;


public class BootManager {
    public static final String[] kEssentialCategories = {"Motor", "Veiligheid", "Behuizing"};
    public static final String[] kOptionalCategories = {"Uiterlijk", "Extras"};
    private static final Map<String, List<String>> kOptiesPerCategorie = new HashMap<String, List<String>>() {{
        put("Motor", List.of("Standaard motor", "Opgevoerde motor", "Dubbele motor", "Duurzame motor"));
        put("Veiligheid", List.of("Standaard veiligheidspakket", "Extra veiligheidspakket"));
        put("Behuizing", List.of("Metaal", "Goud", "Hout"));
        put("Extras", List.of("Airco", "Ingebouwde koelkast", "GPS-Systeem", "Dieptemeter", "Radar"));
        put("Uiterlijk", List.of("Biologische verf", "Standaard verf", "LED verlichting"));
    }};

    public static Map<String, List<String>> loadedConfigurations = new HashMap<>();

    public static void printLoadedConfigurations() {
        System.out.println("\nLoaded Configurations:");
        loadedConfigurations.forEach((configName, configOptions) -> {
            System.out.printf("%s:%n", configName);
            configOptions.forEach(option -> System.out.printf("- %s%n", option));
            System.out.println();
        });
    }

    public static void addBootConfiguratie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Boot Configuratie toevoegen ==\033[0m");

        System.out.print("Vul in de naam van uw configuratie: ");
        String configuratie_naam = scanner.nextLine();

        Map<String, List<String>> gekozenOpties = new HashMap<>();

        requestListOptions(List.of(kEssentialCategories), "Essentials", gekozenOpties, scanner);
        requestListOptions(List.of(kOptionalCategories), "Optionals", gekozenOpties, scanner);

        loadedConfigurations.put(configuratie_naam, gekozenOpties.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList()));

        System.out.printf("%s: %s%n", configuratie_naam, loadedConfigurations.get(configuratie_naam));
    }

    private static void requestListOptions(List<String> categories, String categoryName,
                                           Map<String, List<String>> configuration, Scanner scanner) {

        for (String categorie : categories) {
            System.out.printf("%s%n===============%n", categorie);

            int i = 1;
            List<String> opties = kOptiesPerCategorie.get(categorie);
            for (String optie : opties) {
                System.out.printf("%d. %s%n", i++, optie);
            }

            List<String> selectedOpties = new ArrayList<>();
            String antwoord;
            do {
                System.out.printf("Welke %s wil je toevoegen? (1-%d): ", categoryName, i - 1);
                int input = scanner.nextInt();
                selectedOpties.add(opties.get(input - 1));

                System.out.print("Wil je nog een optie toevoegen? (j/n): ");
                antwoord = scanner.next();
            } while (antwoord.equalsIgnoreCase("j"));

            configuration.put(categorie, selectedOpties);
            System.out.println();
        }
    }

    public static void changeBootConfiguration()
    {
        // List all current boot configs

        // Make them chose a boat based on boatname (key value in loadedConfigurations map).

        // List all options they can modify or add
        // Geen dubbel, kan dingen toevoegen.

        // Confirm if new config is correct
    }

    public static void removeBootConfiguration()
    {
        // List boot configs
        // Remove based on boat name
        // Confirmation for deletion
    }
}
