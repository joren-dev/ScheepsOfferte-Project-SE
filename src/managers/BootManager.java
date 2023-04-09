package managers;

import entities.bootconfig.*;
import entities.bootconfig.categories.*;

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


/*
- [x] Non-essentials worden niet toegevoegd, of niet geprint.
- [x] Na het maken van config print het de class obj, niet de opties (memory)
- [ ] Change config functionaliteit werkt niet
*/

public class BootManager {
    public static final String[] kEssentialCategories = {"Motor", "Veiligheid", "Behuizing"};
    public static final String[] kOptionalCategories = {"Uiterlijk", "Extras"};
    // Note to group: Wat doen we met dubbele waardes in de configuratie? 2 motoren kan, gewoon een backup motor
    // 2 veiligheidspakketten kan ook, 2 EHBO-dozen bijvoorbeeld
    // 2 behuizingen kan ook, voor een ongeluk, dan kan je gewoon vervangen
    // 2 koelkasten en 2 GPS-systemen is ook niet raar
    // 2 lagen verf of 2 sets LED-verlichting is volgens mij ook niet echt een probleem
    private static final Map<String, List<String>> kOptiesPerCategorie = new HashMap<String, List<String>>() {{
        put("Motor", List.of("Standaard motor", "Opgevoerde motor", "Dubbele motor", "Duurzame motor"));
        put("Veiligheid", List.of("Standaard veiligheidspakket", "Extra veiligheidspakket"));
        put("Behuizing", List.of("Metaal", "Goud", "Hout"));
        put("Extras", List.of("Airco", "Ingebouwde koelkast", "GPS-Systeem", "Dieptemeter", "Radar"));
        put("Uiterlijk", List.of("Biologische verf", "Standaard verf", "LED verlichting"));
    }};

    public static Map<String, BootConfig> loadedConfigurations = new HashMap<>();

    public static void printLoadedConfigurations(final boolean print_options) {
        System.out.println("\nLoaded Configurations:");

        loadedConfigurations.forEach((configName, config_value) -> {
            if (print_options) {
                System.out.printf("%s: %n", configName);
                config_value.print_all_options();

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

        // Check if name is duplicate
        while (loadedConfigurations.containsKey(configuratie_naam) || configuratie_naam.equals("")) {
            System.out.print("Deze naam bestaat al of is leeg. Kies een andere naam: ");
            configuratie_naam = scanner.nextLine();
        }

        String boat_type = "";
        while (boat_type.length() == 0) {
            System.out.print("Welke boot type is het? : ");
            boat_type = scanner.nextLine();
        }

        BootConfig new_boat_config = new BootConfig(configuratie_naam, boat_type);

        Map<String, List<String>> chosen_options = new HashMap<>();

        // For the essential components it's a requirement you pick at least one. Hence, the allow_skip = false.
        // Requests all options
        request_list_options(List.of(kEssentialCategories), "Essentials", chosen_options, scanner, false);
        request_list_options(List.of(kOptionalCategories), "Optionals", chosen_options, scanner, true);

        // Add categories to config
        new_boat_config.add_category("Motor", new MotorOnderdeel(chosen_options.get("Motor"), 0.0));
        new_boat_config.add_category("Veiligheid", new VeiligheidOnderdeel(chosen_options.get("Veiligheid"), 0.0));
        new_boat_config.add_category("Behuizing", new BehuizingOnderdeel(chosen_options.get("Behuizing"), 0.0));

        for (String optional_category : kOptionalCategories) {
            if (chosen_options.get(optional_category).isEmpty() || !chosen_options.containsKey(optional_category))
                continue;

            if (optional_category.equals("Uiterlijk"))
                new_boat_config.add_category("Uiterlijk", new UiterlijkOnderdeel(chosen_options.get("Uiterlijk"), 0.0));

            if (optional_category.equals("Extras"))
                new_boat_config.add_category("Extras", new ExtrasOnderdeel(chosen_options.get("Extras"), 0.0));
        }

        // Add config to list of loaded configurations
        loadedConfigurations.put(configuratie_naam, new_boat_config);

        System.out.printf("Boot configuratie \033[1m'%s'\033[0m is toegevoegd met de volgende opties: %n%s%n",
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
            String antwoord = "j";
            do {
                System.out.printf("Welke %s onderdeel wil je toevoegen? (1-%s): ", category, i - 1);

//                final int input = scanner.nextInt();
                String tmp_input = scanner.nextLine();
                if (!tmp_input.matches("^\\d+$")) {
                    System.out.println("Voer alstublieft een getal in.");
                    continue;
                }
                int input = Integer.parseInt(tmp_input);

                if (allow_skip && input == 1)
                    break;
                if (input > (i - 1) || input == 0)
                    continue;

                selected_options.add(options.get(input - (allow_skip ? 2 : 1)));

                antwoord = "ongeldige waarde";
                while (!antwoord.equals("j") && !antwoord.equals("n")) {
                    System.out.print("Wil je nog een optie toevoegen? (j/n): ");
                    antwoord = scanner.next();
                }
            } while (antwoord.equalsIgnoreCase("j"));

            configuration.put(category, selected_options);
            System.out.println();
        }
    }

    public static void changeBootConfiguration() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Boot Configuratie aanpassen ==\033[0m");

        for (String key : loadedConfigurations.keySet()) {
            System.out.printf("- %s%n", key);
        }

        System.out.print("Vul in de naam van uw configuratie: ");
        String configuratie_naam = scanner.nextLine();

        // Check if name is duplicate
        while (!loadedConfigurations.containsKey(configuratie_naam)) {
            System.out.println("Deze naam bestaat niet. Kies een andere naam: ");
            configuratie_naam = scanner.nextLine();
        }

        System.out.printf("Boot type: %s%n", loadedConfigurations.get(configuratie_naam).get_boat_type());

        String boat_type = "";
        while (boat_type.length() == 0) {
            System.out.print("Welke boot type moet het worden? : ");
            boat_type = scanner.nextLine();
        }

        BootConfig new_boat_config = new BootConfig(configuratie_naam, boat_type);

        System.out.println("\nDe huidige opties:");
        loadedConfigurations.get(configuratie_naam).print_all_options();
        System.out.println("\nSelecteer welke u wilt behouden:");

        Map<String, List<String>> chosen_options = new HashMap<>();

        // For the essential components it's a requirement you pick at least one. Hence, the allow_skip = false.
        // Requests all options
        request_list_options(List.of(kEssentialCategories), "Essentials", chosen_options, scanner, false);
        request_list_options(List.of(kOptionalCategories), "Optionals", chosen_options, scanner, true);

        // Add categories to config
        new_boat_config.add_category("Motor", new MotorOnderdeel(chosen_options.get("Motor"), 0.0));
        new_boat_config.add_category("Veiligheid", new VeiligheidOnderdeel(chosen_options.get("Veiligheid"), 0.0));
        new_boat_config.add_category("Behuizing", new BehuizingOnderdeel(chosen_options.get("Behuizing"), 0.0));

        for (String optional_category : kOptionalCategories) {
            if (chosen_options.containsKey(optional_category)) {
                switch (optional_category) {
                    case "Uiterlijk":
                        new_boat_config.add_category("Uiterlijk", new UiterlijkOnderdeel(chosen_options.get("Uiterlijk"), 0.0));
                        break;
                    case "Extras":
                        new_boat_config.add_category("Extras", new ExtrasOnderdeel(chosen_options.get("Extras"), 0.0));
                        break;
                    default:
                        throw new RuntimeException("Make sure to keep this up-to-date!");
                }
            }
        }

        // Add config to list of loaded configurations
        loadedConfigurations.put(configuratie_naam, new_boat_config);

        System.out.printf("Boot configuratie \033[1m'%s'\033[0m is toegevoegd met de volgende opties: %n%s%n",
                configuratie_naam, loadedConfigurations.get(configuratie_naam));

    }

    public static void removeBootConfiguration() {
        Scanner scanner = new Scanner(System.in);

        // List boot configs
        printLoadedConfigurations(false);

        // Remove based on boat name

        String name = "niet bestaande configuratienaam";

        while (!loadedConfigurations.containsKey(name)) {
            System.out.println("Welke configuratie wilt u verwijderen?");
            name = scanner.nextLine();
        }

        // Confirmation for deletion
        String sure = "";
        while (!sure.equals("j") && !sure.equals("n")) {
            System.out.println("Weet u het zeker (j/n)?");
            sure = scanner.nextLine();
        }

        if (sure.equals("j"))
            loadedConfigurations.remove(name);

        System.out.println(sure.equals("j") ? "Succesvol verwijderd!" : "Bewerking geannuleerd door de gebruiker.");
    }
}
