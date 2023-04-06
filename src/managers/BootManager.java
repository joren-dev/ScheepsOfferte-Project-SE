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

    public static void printLoadedConfigurations(final boolean print_options) {
        System.out.println("\nLoaded Configurations:");

        loadedConfigurations.forEach((configName, configOptions) -> {
            if (print_options) {
                System.out.printf("%s: %n", configName);
                configOptions.forEach(option -> System.out.printf("- %s%n", option));

                System.out.println("---------------");
            } else {
                System.out.println("- " + configName);
            }
        });
    }

    public static void addBootConfiguratie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Boot Configuratie toevoegen ==\033[0m");

        System.out.print("Vul in de naam van uw configuratie: ");
        String configuratie_naam = scanner.nextLine();

        // TODO: Store boot type in some way (joren)
        // TODO: Link prices to items (joren)

        // Check if name is duplicate
        while (loadedConfigurations.containsKey(configuratie_naam)) {
            System.out.println("Deze naam bestaat al. Kies een andere naam: ");
            configuratie_naam = scanner.nextLine();
        }

        Map<String, List<String>> chosen_options = new HashMap<>();

        // For the essential components its a requirement you pick at least one. Hence the allow_skip = false.
        request_list_options(List.of(kEssentialCategories), "Essentials", chosen_options, scanner, false);
        request_list_options(List.of(kOptionalCategories), "Optionals", chosen_options, scanner,  true);

        loadedConfigurations.put(configuratie_naam, chosen_options.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList()));

        if (loadedConfigurations.get(configuratie_naam).isEmpty())
            System.out.println("Let op: deze configuratie bevat geen opties.");

        System.out.printf("Boot configuratie \033[1m'%s'\033[0m is toegevoegd met de volgende opties: %s%n%n",
                configuratie_naam, loadedConfigurations.get(configuratie_naam));

    }

    private static void request_list_options(final List<String> categories, final String category_name,
                                             final Map<String, List<String>> configuration, final Scanner scanner,
                                             final boolean allow_skip) {

        for (final String category : categories) {
            System.out.printf("%s%n===============%n", category);

            int i = 1;
            final List<String> options = kOptiesPerCategorie.get(category);

            if (allow_skip)
                System.out.printf("%d. (Skip)%n", i++);

            for (final String option : options)
                System.out.printf("%d. %s%n", i++, option);

            final List<String> selected_options = new ArrayList<>();
            String antwoord;
            do {
                System.out.printf("Welke %s onderdeel wil je toevoegen? (1-%s): ", category, i - 1);

                final int input = scanner.nextInt();
                if (allow_skip && input == 1)
                    break;

                selected_options.add(options.get(input - (allow_skip ? 2 : 1)));

                System.out.print("Wil je nog een optie toevoegen? (j/n): ");
                antwoord = scanner.next();
            } while (antwoord.equalsIgnoreCase("j"));

            configuration.put(category, selected_options);
            System.out.println();
        }
    }

    public static void changeBootConfiguration()
    {
        final Scanner scanner = new Scanner(System.in);

        // Copy the loaded-configurations
        final Map<String, List<String>> original_contents = new HashMap<>(loadedConfigurations);

        // List all current boot configs
        printLoadedConfigurations(false);

        // Prompt the user to choose a boat based on boat name (key value in loadedConfigurations map).
        System.out.print("Welke boot wilt u wijzigen: ");
        final String boat_name = scanner.nextLine();

        boolean has_more_changes = true;
        while (has_more_changes) {
            System.out.printf("%n%s onderdelen%n===============%n", boat_name);

            // List all options they can modify or add with an index
            int index = 1;
            for (final String option : loadedConfigurations.get(boat_name)) {
                System.out.printf("%d. %s%n", index++, option);
            }

            final int max_option = index - 1;
            System.out.printf("Welke optie wilt u aanpassen? (1-%d) (0 om te stoppen): ", max_option);

            int choice;
            do {
                choice = scanner.nextInt();

                if (choice < 0 || choice > max_option)
                    System.out.printf("Ongeldige keuze. Kies een optie tussen 0 en %d: ", max_option);

            } while (choice < 0 || choice > max_option);
            scanner.nextLine(); // consume the newline character

            if (choice == 0) {
                has_more_changes = false;
                continue;
            }

            final String option = loadedConfigurations.get(boat_name).get(choice - 1);

            kOptiesPerCategorie.forEach((categoryName, values) -> {
                if (!values.contains(option))
                    return; // Skip to the next iteration

                System.out.print("Wilt u deze verwijderen? (j/n): ");
                final boolean wants = scanner.nextLine().equals("j");
                if (!wants)
                    loadedConfigurations.get(boat_name).removeIf((item) -> item.equals(option));
            });


            for (final String category : kEssentialCategories) {
                boolean is_fine = false;

                for (final String category_option : kOptiesPerCategorie.get(category)) {
                    if (loadedConfigurations.get(boat_name).contains(category_option)) {
                        is_fine = true;
                        break;
                    }
                }

                if (!is_fine) {
                    System.out.print("Deze optie is verplicht, kies een waarde als vervanging: ");

                    for (final String category_option : kOptiesPerCategorie.get(category))
                        System.out.println(category_option);

                    String gekozen_optie = "";

                    while (!kOptiesPerCategorie.get(category).contains(gekozen_optie)) {
                        System.out.print("Welke optie wilt u toevoegen? (onderdeel naam): ");
                        gekozen_optie = scanner.nextLine();
                    }

                    loadedConfigurations.get(boat_name).add(gekozen_optie);
                }
            }
        }

        // Confirm if new config is correct
        System.out.println(loadedConfigurations.get(boat_name));
        System.out.print("Is deze configuratie correct? (j/n): ");

        if (!scanner.nextLine().equals("j")) {
            // Set back original configuration in case canceled.
            loadedConfigurations = original_contents;
            System.out.println("De wijziging is gecanceld, er is niks veranderd");
        }
    }

    public static void removeBootConfiguration()
    {
        Scanner scanner = new Scanner(System.in);

        // List boot configs
        printLoadedConfigurations(false);

        // Remove based on boat name
        System.out.println("Welke configuratie wilt u verwijderen?");
        final String name = scanner.nextLine();

        // Confirmation for deletion
        System.out.println("Weet u het zeker (j/n)?");
        boolean sure = scanner.nextLine().equals("j");

        if (sure)
            loadedConfigurations.remove(name);

        System.out.println(sure ? "Succesvol verwijderd!" : "Bewerking geannuleerd door de gebruiker.");
    }
}
