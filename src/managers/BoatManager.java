package managers;

import entities.bootconfig.*;
import entities.bootconfig.categories.*;
import utils.InputValidators;

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


public class BoatManager {
    public static final String[] kEssentialCategories = {"Motor", "Veiligheid", "Behuizing"};
    public static final String[] kOptionalCategories = {"Uiterlijk", "Extras"};
    private static final Map<String, List<String>> kOptiesPerCategorie = new HashMap<String, List<String>>() {{
        put("Motor", List.of("Standaard motor", "Opgevoerde motor", "Dubbele motor", "Duurzame motor"));
        put("Veiligheid", List.of("Standaard veiligheidspakket", "Extra veiligheidspakket"));
        put("Behuizing", List.of("Metaal", "Goud", "Hout"));
        put("Extras", List.of("Airco", "Ingebouwde koelkast", "GPS-Systeem", "Dieptemeter", "Radar"));
        put("Uiterlijk", List.of("Biologische verf", "Standaard verf", "LED verlichting"));
    }};
    public static Map<String, BoatConfig> loaded_boat_configurations = new HashMap<>();

    public static void print_loaded_configs(final boolean print_options) {
        System.out.println("\nLoaded Configurations:");

        loaded_boat_configurations.forEach((configName, config_value) -> {
            if (!print_options) {
                System.out.println("- " + configName);
                return;
            }

            System.out.printf("%s: %n", configName);
            config_value.print_all_options();
            System.out.println("---------------");
        });
    }

    public static void add_boat_config() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Boot Configuratie toevoegen ==\033[0m");

        String configuration_name = InputValidators.request_valid_input("Vul een (valide) naam in voor uw nieuwe configuratie: ",
                String::trim,
                input -> !input.isEmpty() && !loaded_boat_configurations.containsKey(input));

        String boat_type = InputValidators.request_valid_input("Welke boot type is het? : ",
                String::trim,
                input -> !input.isEmpty());

        BoatConfig new_boat_config = new BoatConfig(configuration_name, boat_type);
        Map<String, List<String>> chosen_options = new HashMap<>();

        request_options(chosen_options, new_boat_config);

        for (String optional_category : kOptionalCategories) {
            if (chosen_options.get(optional_category).isEmpty() || !chosen_options.containsKey(optional_category))
                continue;

            if (optional_category.equals("Uiterlijk"))
                new_boat_config.add_category("Uiterlijk", new AppearancePart(chosen_options.get("Uiterlijk"), 0.0));

            if (optional_category.equals("Extras"))
                new_boat_config.add_category("Extras", new ExtrasPart(chosen_options.get("Extras"), 0.0));
        }

        // Add config to list of loaded configurations
        loaded_boat_configurations.put(configuration_name, new_boat_config);

        System.out.printf("Boot configuratie \033[1m'%s'\033[0m is toegevoegd met de volgende opties: %n%s%n",
                configuration_name, loaded_boat_configurations.get(configuration_name));

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

            String input_add_option;
            do {
                final int max_input = i - 1;
                final int tmp_int_input = InputValidators.request_valid_input(String.format(
                                "Welke %s onderdeel wil je toevoegen? (1-%s): ", category, max_input),
                        Integer::parseInt,
                        input -> input >= 1 && input <= max_input
                );

                if (allow_skip && tmp_int_input == 1)
                    break;

                selected_options.add(options.get(tmp_int_input - (allow_skip ? 2 : 1)));

                input_add_option = InputValidators.request_valid_input("Wil je nog een optie toevoegen? (j/n): ",
                        input -> input.trim().toLowerCase(),
                        input -> input.equals("j") || input.equals("n"));

            } while (input_add_option.equalsIgnoreCase("j"));

            configuration.put(category, selected_options);
            System.out.println();
        }
    }

    public static void change_boat_config() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Boot Configuratie aanpassen ==\033[0m");

        for (final String key : loaded_boat_configurations.keySet())
            System.out.printf("- %s%n", key);

        String configuration_name = InputValidators.request_valid_input("Kies een (valide) configuratie naam die u wilt wijzigen: ",
                input -> input,
                input -> !input.isEmpty() && contains_boat_config(input));

        System.out.printf("Boot type: %s%n", loaded_boat_configurations.get(configuration_name).get_boat_type());
        System.out.print("Wilt u het type aanpassen (j/n)? ");

        String boat_type;
        if (scanner.nextLine().equals("n"))
            boat_type = loaded_boat_configurations.get(configuration_name).get_boat_type();
        else
            boat_type = InputValidators.request_valid_input("Voer nieuw boot type in: ",
                    String::trim,
                    input -> !input.isEmpty());

        final BoatConfig new_boat_config = new BoatConfig(configuration_name, boat_type);

        System.out.println("\nDe huidige opties:");
        loaded_boat_configurations.get(configuration_name).print_all_options();

        // TODO: Make the below code more user-friendly. The exact way to do this might need to be discussed.
        System.out.println("\nSelecteer welke u wilt behouden:");

        Map<String, List<String>> chosen_options = new HashMap<>();
        request_options(chosen_options, new_boat_config);

        for (final String optional_category : kOptionalCategories) {
            if (chosen_options.containsKey(optional_category)) {
                switch (optional_category) {
                    case "Uiterlijk":
                        new_boat_config.add_category("Uiterlijk", new AppearancePart(chosen_options.get("Uiterlijk"), 0.0));
                        break;
                    case "Extras":
                        new_boat_config.add_category("Extras", new ExtrasPart(chosen_options.get("Extras"), 0.0));
                        break;
                    default:
                        throw new RuntimeException("Make sure to keep this up-to-date!");
                }
            }
        }

        // Add config to list of loaded configurations
        loaded_boat_configurations.put(configuration_name, new_boat_config);

        System.out.printf("Boot configuratie \033[1m'%s'\033[0m is toegevoegd met de volgende opties: %n%s%n",
                configuration_name, loaded_boat_configurations.get(configuration_name));
    }

    public static void remove_boat_config() {
        // List boot configs
        print_loaded_configs(false);

        // Remove based on boat name
        String name = InputValidators.request_valid_input("Type in de (valide) naam van de configuratie: ",
                String::trim,
                loaded_boat_configurations::containsKey);

        String sure = InputValidators.request_valid_input("Weet u het zeker? (j/n): ",
                String::trim,
                input -> input.equals("j") || input.equals("n"));

        if (sure.equals("j"))
            loaded_boat_configurations.remove(name);

        System.out.println(sure.equals("j") ? "Succesvol verwijderd!" : "Bewerking geannuleerd door de gebruiker.");
    }

    private static void request_options(Map<String, List<String>> ref_options, BoatConfig ref_boatconfig) {
        final Scanner scanner = new Scanner(System.in);

        // For the essential components it's a requirement you pick at least one. Hence, the allow_skip = false.
        // Requests all options
        request_list_options(List.of(kEssentialCategories), "Essentials", ref_options, scanner, false);
        request_list_options(List.of(kOptionalCategories), "Optionals", ref_options, scanner, true);

        // Add categories to config
        ref_boatconfig.add_category("Motor", new MotorPart(ref_options.get("Motor"), 0.0));
        ref_boatconfig.add_category("Veiligheid", new SafetyPart(ref_options.get("Veiligheid"), 0.0));
        ref_boatconfig.add_category("Behuizing", new HousingPart(ref_options.get("Behuizing"), 0.0));
    }

    public static boolean contains_boat_config(final String boat_config_name) {
        return loaded_boat_configurations.containsKey(boat_config_name);
    }

    public static Map<String, BoatConfig> get_all_boat_configs() {
        return loaded_boat_configurations;

    }

    public static BoatConfig get_config(final String config_name) {
        return loaded_boat_configurations.get(config_name);
    }
}
