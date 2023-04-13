package managers;

import entities.bootconfig.BoatConfig;
import entities.bootconfig.categories.CategoryBase;
import entities.klant.Customer;
import entities.klant.CustomerType;

import entities.offerte.BasicOfferte;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;

import entities.offerte.OfferteBase;
import utils.InputValidators;
import utils.ValidationUtils;

import java.io.FileWriter;
import java.io.IOException;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM, yyyy", Locale.forLanguageTag("nl-NL"));
        final String offerte_date = LocalDateTime.now().format(formatter);
        final String verval_date = LocalDateTime.now().plusDays(days_till_expiry).format(formatter);

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
    }

    public static void delete_offerte() {
        System.out.println("\033[1m== Offerte verwijderen ==\033[0m");

        if (offerte_list.isEmpty()) {
            System.out.println("U heeft geen offertes om te verwijderen.\n");
            return;
        }

        for (String offerte_number : offerte_list.keySet())
            System.out.println("Offerte nummer: " + offerte_number);

        final String offerte_nummer = InputValidators.request_valid_input(
                "Vul in het (valide) offerte nummer die u wilt verwijderen (digits only): ",
                Function.identity(), offerte_list::containsKey
        );

        offerte_list.remove(offerte_nummer);

        System.out.println("Offerte " + offerte_nummer + " succesvol verwijderd.");
    }

    public static void show_offerte() {
        System.out.println("\n\033[1m== Offerte weergeven ==\033[0m");

        if (offerte_list.isEmpty()) {
            System.out.println("U heeft geen offertes om weer te geven.\n");
            return;
        }

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

        // Grab boat config connected to offerte
        final BoatConfig selected_boat_config = selected_offerte.get_config();

        // Print basic offerte details
        System.out.println("\n\033[1m== Offerte voor " + selected_boat_config.get_boat_name() + " ==\033[0m");
        System.out.println("| T.a.v " + customer.get_name());
        System.out.printf("| %s", customer.get_address());
        System.out.println("\n| Email: " + customer.get_email());
        System.out.println("| Offerte datum: " + selected_offerte.get_offerte_date());
        System.out.println("| Offerte verval datum: " + selected_offerte.get_expiry_date());
        System.out.printf("| Phone number: %s \n\n", customer.get_phone_number());


        System.out.println("Geachte " + customer.get_name() + ",");
        System.out.println("Hartelijk dank voor uw interesse in onze dienst(en)/product(en). Wij zijn verheugd om u een offerte aan te bieden voor uw boot configuratie.");


        System.out.println("\n\033[1mOfferte nummer: \033[0m " + offerte_nummer);
        System.out.println("\n\033[1mBoot type: \033[0m " + selected_boat_config.get_boat_type());
        System.out.println("=================================================");


        // Filter out the categories that weren't instantiated with the boat config
        final ArrayList<String> valid_categories = selected_boat_config.get_all_categories();

        // Calls each valid category and prints its contents
        double gross_total_price = 0.0;
        for (final String each : valid_categories) {
            // Must be CategoryBase, as each category derives from that.
            CategoryBase cat = selected_boat_config.get_category(each, CategoryBase.class);
            System.out.println(cat.offerte_format_str() + "€" + selected_boat_config.prices_per_category.get(each));

            gross_total_price += selected_boat_config.prices_per_category.get(each);
        }

        // After environment discount (10%)
        double after_environ_discount = gross_total_price * (1 - 0.1);

        // After environment and customer discount
        double customer_discount = customer.get_client_discount() / 100.0; // Convert percentage to decimal
        double after_environ_and_customer_discount = after_environ_discount * (1 - customer_discount);

        // Total price (including VAT)
        double total_price = after_environ_and_customer_discount * 1.21;


        System.out.println("=================================================");
        System.out.println("Totaal zonder kortingen: €" + String.format("%.2f", gross_total_price));
        System.out.println("Totaal na milieukorting (10%) excl. btw: €" + String.format("%.2f", after_environ_discount));
        System.out.println("Totaal na milieukorting en klant korting (a.i.) excl. btw: €" + String.format("%.2f", after_environ_and_customer_discount));
        System.out.println("===================");
        System.out.println("     Totaal (incl. 21% btw en korting aftrek): €" + String.format("%.2f", total_price));

        System.out.println("\n\nWij hopen u zo goed mogelijk geïnformeerd te hebben en kijken uit naar de samenwerking met u.");
        System.out.println("\nMet vriendelijke groet,");
        System.out.println("ShipFlex Bv.");
        System.out.println("079-19040126");
        System.out.println("Kvk: 08234771 ");
        System.out.println("Iban: NL83INGB0845370391");

        System.out.println("\n");

        String input_add_option = InputValidators.request_valid_input("Wil je de offerte exporteren? (j/n): ",
                input -> input.trim().toLowerCase(),
                input -> input.equals("j") || input.equals("n"));

        if (input_add_option.equals("j"))
            export_offerte(selected_offerte, offerte_nummer);

    }

    static void export_offerte(final OfferteBase offerte, final String offerte_number) {
        final String currentDir = System.getProperty("user.dir");
        final File dir = new File(currentDir + "/saves/offertes");

        System.out.println("Current directory is: " + dir);

        // check if directory already exists
        if (!dir.exists()) {
            try {
                // create directory if it does not exist
                dir.mkdirs();
                System.out.println("Directories created.");
            } catch (Exception e) {
                System.err.println("Error creating directories: " + e.getMessage());
            }
        }

        try {
            FileWriter writer = new FileWriter(dir + "/" + offerte_number + ".txt");
            writer.write("Hello, world!");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}


