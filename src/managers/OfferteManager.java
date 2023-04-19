package managers;

import entities.bootconfig.BoatConfig;
import entities.bootconfig.categories.CategoryBase;
import entities.klant.Customer;
import entities.klant.CustomerType;

import entities.offerte.BasicOfferte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import entities.offerte.OfferteBase;
import utils.InputValidators;
import utils.ValidationUtils;

public class OfferteManager {
    public static Map<String, BasicOfferte> offerte_list = new HashMap<>();

    public OfferteManager() {
    }

    public static void create_offerte() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Offerte maken ==\033[0m");

        if (BoatManager.get_all_boat_configs().isEmpty()) {
            System.out.println("U heeft geen boot configuraties, stel eerst een configuratie samen.\n");
            return;
        }

        if (CustomerManager.get_all_client_types().isEmpty()) {
            System.out.println("U heeft geen klanttypes, voeg eerst een klanttype toe.\n");
            return;
        }


        CustomerManager.print_client_types();
        final String customer_type_choice = InputValidators.request_valid_input(
                "Voor welk klanttype maak je deze offerte: ",
                Function.identity(),
                CustomerManager::contains_client_type);

        final CustomerType selected_klant_type = CustomerManager.get_client_type(customer_type_choice);

        BoatManager.print_loaded_configs(false);
        final String boot_config_choice = InputValidators.request_valid_input(
                "Welke bootconfiguratie wilt u toevoegen aan de offerte: ",
                Function.identity(),
                BoatManager::contains_boat_config);

        final BoatConfig selected_boot_config = BoatManager.get_config(boot_config_choice);


        final String offerte_nummer = InputValidators.request_valid_input("Geef het offerte nummer op (minimaal 1 cijfer): ",
                Function.identity(),
                ValidationUtils::is_valid_offerte_number);

        final String client_name = InputValidators.request_valid_input("Wat is de naam van de klant? (a-Z): ",
                String::toLowerCase, ValidationUtils::is_valid_full_name);

        final String client_address = InputValidators.request_valid_input("Wat is het adres van de klant? (Straat 23, postcode, stad/dorp): ",
                String::toLowerCase, ValidationUtils::is_valid_address);

        final String client_email = InputValidators.request_valid_input("Wat is de email van de klant? (example@email.com): ",
                String::toLowerCase, ValidationUtils::is_valid_email);

        final String client_phone_number = InputValidators.request_valid_input("Wat is het telefoonnummer van de klant? (tussen 8-10 digits): ",
                Function.identity(), ValidationUtils::is_valid_phone_number);

        final int days_till_expiry = InputValidators.request_valid_input("Hoelang is de offerte geldig (dagen): ",
                Integer::parseInt,
                days -> days > 0);


        System.out.println("\n");

        Map<String, Double> category_prices = new HashMap<>();
        for (final String each : selected_boot_config.get_all_categories()) {
            final double price = InputValidators.request_valid_choice_in_range(
                    String.format("Geef een prijs voor categorie %s (geld waarde): €", each),
                    Double::parseDouble,
                    0.0,
                    Double.MAX_VALUE);

            category_prices.put(each, price);
        }

        System.out.println();

        selected_boot_config.set_prices_per_category(category_prices);

        // Calculate expiry date
        final String offerte_date = LocalDateTime.now().toString();
        final String verval_date = LocalDateTime.now().plusDays(days_till_expiry).toString();

        final Customer customer = new Customer(client_name, client_address, client_email,
                client_phone_number, selected_klant_type
        );

        final BasicOfferte offerte = new BasicOfferte(customer, selected_boot_config,
                offerte_date, verval_date
        );

        // Add freshly created offerte to the list.
        offerte_list.put(offerte_nummer, offerte);
    }

    public static void edit_offerte() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Offerte aanpassen ==\033[0m");

        // Print all the offertes on the screen
        for (final String key : offerte_list.keySet())
            System.out.printf("- %s%n", key);

        // Pick the offerte you want to change
        String offerte_nummer = InputValidators.request_valid_input("Kies een (valide) offerte die u wilt wijzigen: ",
                input -> input,
                input -> !input.isEmpty() && contains_offerte(input));

        // Moved the selected offerte to its own variable so we dont have to call the get function every time
        BasicOfferte old_offerte = offerte_list.get(offerte_nummer);
        BoatConfig boat_config = old_offerte.get_config();

        // Split the code to edit the customer to a separate function for readability
        Customer customer = edit_customer(scanner, old_offerte);

        // Get the offerte date from the old offerte, reuse it in the prompt and use it as the new date if the
        // user does not wish to edit the value
        String offerte_date = old_offerte.get_offerte_date();
        System.out.printf("Uw offerte datum: %s%n", offerte_date);
        System.out.print("Wilt u de offerte datum aanpassen? (j/n) ");

        // Reversed the check, so I could remove the else from the if statement
        if (scanner.nextLine().equals("j")) {
            final int days_till_start = InputValidators.request_valid_input("Wanneer begint de offerte (dagen, 0 is vandaag): ",
                    Integer::parseInt,
                    days -> days >= 0);

            // Calculate start date
            offerte_date = LocalDateTime.now().plusDays(days_till_start).toString();
        }

        String offerte_expiry = old_offerte.get_expiry_date();
        System.out.printf("Uw offerte datum: %s%n", offerte_expiry);
        System.out.print("Wilt u de offerte verval datum aanpassen? (j/n) ");

        // Reversed the check, so I could remove the else from the if statement
        if (scanner.nextLine().equals("j")) {
            final int days_till_expiry = InputValidators.request_valid_input("Hoelang is de offerte geldig (dagen): ",
                    Integer::parseInt,
                    days -> days > 0);

            // Calculate expiry date
            offerte_expiry = LocalDateTime.now().plusDays(days_till_expiry).toString();
        }

        // Create the new offerte based on the new input and remove old offerte from the list
        final BasicOfferte new_offerte = new BasicOfferte(customer, boat_config, offerte_date, offerte_expiry);
        offerte_list.remove(offerte_nummer);

        System.out.printf("Uw offerte nummer: %s%n", offerte_nummer);
        System.out.print("Wilt u het offerte nummer aanpassen? (j/n) ");

        if (scanner.nextLine().equals("j")) {
            offerte_nummer = InputValidators.request_valid_input("Geef het offerte nummer op (minimaal 1 cijfer): ",
                    Function.identity(),
                    ValidationUtils::is_valid_offerte_number);
        }

        // Add the new offerte to the list
        offerte_list.put(offerte_nummer, new_offerte);
    }

    public static void delete_offerte() {
        System.out.println("\033[1m== Offerte verwijderen ==\033[0m");

        for (String offerte_number : offerte_list.keySet())
            System.out.println("Offerte nummer: " + offerte_number);

        final String offerte_nummer = InputValidators.request_valid_input(
                "Vul in het (valide) offerte nummer die u wilt weergeven (digits only): ",
                Function.identity(), offerte_list::containsKey
        );

        offerte_list.remove(offerte_nummer);
    }

    public static void show_offerte() {
        System.out.println("\n\033[1m== Offerte weergeven ==\033[0m");

        for (final String offerte_number : offerte_list.keySet())
            System.out.println("Offerte nummer: " + offerte_number);

        // Get requested instance
        final String offerte_nummer = InputValidators.request_valid_input(
                "Vul in het (valide) offerte nummer die u wilt weergeven (digits only): ",
                Function.identity(), offerte_list::containsKey
        );

        // Grab the right offerte by number
        final BasicOfferte selected_offerte = offerte_list.get(offerte_nummer);

        // Pull out the customer connected to offerte
        final Customer customer = selected_offerte.get_customer();


        // Print basic offerte details
        System.out.println("\n\033[1m== Offerte voor ==\033[0m");
        System.out.println("| T.a.v " + customer.get_name());
        System.out.printf("| %s", customer.get_address());
        System.out.println("\n| Email: " + customer.get_email());
        System.out.printf("| Phone number: %s \n\n", customer.get_phone_number());


        System.out.println("Geachte " + customer.get_name() + ",");
        System.out.println("Hartelijk dank voor uw interesse in onze diensten/producten. Wij zijn verheugd om u een offerte aan te bieden voor uw boot configuratie.");


        System.out.println("\n\033[1mOfferte nummer: \033[0m " + offerte_nummer);
        System.out.println("=================================================");
        // Grab boat config connected to offerte
        final BoatConfig selected_boat_config = selected_offerte.get_config();

        // Filter out the categories that weren't instantiated with the boat config
        final ArrayList<String> valid_categories = selected_boat_config.get_all_categories();

        // Calls each valid category and prints its contents
        for (final String each : valid_categories) {
            // Must be CategoryBase, as each category derives from that.
            CategoryBase cat = selected_boat_config.get_category(each, CategoryBase.class);
            System.out.println(cat.offerte_format_str() + "€" + selected_boat_config.prices_per_category.get(each));
        }

        System.out.println("=================================================");
        System.out.println("Totaal zonder milieukorting: €(prijs)");
        System.out.println("Totaal na milieukorting excl. btw: €(prijs)");
        System.out.println("===================");
        System.out.println("     Totaal (incl. 21% btw en korting aftrek): €(prijs)");

        System.out.println("\nDe bovenstaande prijzen zijn geldig tot." + selected_offerte.get_expiry_date());

        System.out.println("\nWij hopen u zo goed mogelijk geinformeerd te hebben en kijken uit naar de samenwerking met u.");
        System.out.println("\nMet vriendelijke groet,");
        System.out.println("ShipFlex Bv.");
        System.out.println("079-19040126");
        System.out.println("Kvk: 08234771 ");
        System.out.println("Iban: NL83INGB0845370391");

        System.out.println("\n");
    }

    private static boolean contains_offerte(final String offerte_nummer) {
        return offerte_list.containsKey(offerte_nummer);
    }

    private static Customer edit_customer(Scanner scanner, BasicOfferte old_offerte) {
        Customer customer = old_offerte.get_customer();

        System.out.printf("Uw klant: %s%n", customer.get_name());
        System.out.print("Wilt u de klant aanpassen? (j/n) ");

        if (scanner.nextLine().equals("j")) {
            String customer_name = customer.get_name();

            System.out.printf("Uw klant naam is: %s%n", customer_name);
            System.out.print("Wilt u de klant naam aanpassen? (j/n) ");

            if (scanner.nextLine().equals("j")) {
                customer_name = InputValidators.request_valid_input("Wat is de naam van de klant? (a-Z): ",
                        String::toLowerCase, ValidationUtils::is_valid_full_name);
            }

            String customer_address = customer.get_address();

            System.out.printf("Uw klant adres is: %s%n", customer_address);
            System.out.print("Wilt u het klant adres aanpassen? (j/n) ");

            if (scanner.nextLine().equals("j")) {
                customer_address = InputValidators.request_valid_input("Wat is het adres van de klant? (Straat 23, postcode, stad/dorp): ",
                        String::toLowerCase, ValidationUtils::is_valid_address);
            }

            String customer_email = customer.get_email();

            System.out.printf("Uw klant email is: %s%n", customer_email);
            System.out.print("Wilt u de klant email aanpassen? (j/n) ");

            if (scanner.nextLine().equals("j")) {
                customer_email = InputValidators.request_valid_input("Wat is de email van de klant? (example@email.com): ",
                        String::toLowerCase, ValidationUtils::is_valid_email);
            }

            String customer_phone_number = customer.get_phone_number();

            System.out.printf("Uw klant telefoon nummer is: %s%n", customer_phone_number);
            System.out.print("Wilt u het klant telefoon nummer aanpassen? (j/n) ");

            if (scanner.nextLine().equals("j")) {
                customer_phone_number = InputValidators.request_valid_input("Wat is het telefoonnummer van de klant? (tussen 8-10 digits): ",
                        Function.identity(), ValidationUtils::is_valid_phone_number);
            }

            CustomerManager.print_client_types();

            CustomerType customer_type = customer.get_client_type();

            System.out.printf("Uw klant type is: %s%n", customer_type.get_type_name());
            System.out.print("Wilt u het klant type aanpassen? (j/n) ");

            if (scanner.nextLine().equals("j")) {
                CustomerManager.print_client_types();

                final String customer_type_choice = InputValidators.request_valid_input(
                        "Selecteer een klant type: ",
                        Function.identity(),
                        CustomerManager::contains_client_type);

                customer_type = CustomerManager.get_client_type(customer_type_choice);
            }

            customer = new Customer(customer_name, customer_address, customer_email, customer_phone_number, customer_type);
        }

        return customer;
    }
}
