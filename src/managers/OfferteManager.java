package managers;

import entities.bootconfig.BoatConfig;
import entities.klant.Customer;
import entities.klant.CustomerType;

import entities.offerte.BasicOfferte;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import utils.RequestInputUtils;
import utils.ValidationUtils;

public class OfferteManager {
    public static Map<String, BasicOfferte> offerteLijst = new HashMap<>();
    private static int lastNumber = 10000;

    public OfferteManager() {
        // Check existing offertes /saves/offertes/
        //                                  offertenr12.txt
        //                                  offertenr134.txt
    }

    public static void create_offerte() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Offerte maken ==\033[0m");

        if (BoatManager.get_all_boat_configs().isEmpty()) {
            System.out.println("U heeft geen boot configuraties, stel eerst een configuratie samen.\n");
            return;
        }

        if(CustomerManager.get_all_client_types().isEmpty())
        {
            System.out.println("U heeft geen klanttypes, voeg eerst een klanttype toe.\n");
            return;
        }

        CustomerType selected_klant_type;
        while (true) {
            System.out.println("Voor welk klanttype maak je deze offerte?");
            CustomerManager.print_client_types();

            System.out.print("Maak uw keuze: ");
            String input = scanner.nextLine();

            if (CustomerManager.contains_client_type(input)) {
                selected_klant_type = CustomerManager.get_client_type(input);
                break;
            }

            System.err.println("Klanttype niet gevonden");
        }

        BoatConfig selected_boot_config;
        while (true) {
            System.out.println("Welke bootconfiguratie wilt u toevoegen aan de offerte?");
            BoatManager.print_loaded_configs(false);
            System.out.print("Maak uw keuze: ");
            String input = scanner.nextLine();

            if (BoatManager.contains_boat_config(input)) {
                selected_boot_config = BoatManager.get_config(input);
                break;
            }

            System.err.println("Bootconfiguratie niet gevonden.");
        }

        final String client_name = RequestInputUtils.request_raw_data("Wat is de naam van de klant? (a-Z): ",
                String::toLowerCase, ValidationUtils::is_valid_name);

        final String client_address = RequestInputUtils.request_raw_data("Wat is het adres van de klant? (Straat 23, postcode, stad/dorp): ",
                String::toLowerCase, ValidationUtils::is_valid_address);

        final String client_email = RequestInputUtils.request_raw_data("Wat is de email van de klant? (example@email.com): ",
                Function.identity(), ValidationUtils::is_valid_email);

        final String client_phone_number = RequestInputUtils.request_raw_data("Wat is het telefoonnummer van de klant? (tussen 8-10 digits): ",
                Function.identity(), ValidationUtils::is_valid_phone_number);

        final int days_till_expiry = RequestInputUtils.request_raw_data("Hoelang is de offerte geldig (dagen): ",
                Integer::parseInt,
                days -> days > 0);


        // Calculate expiry date
        String offerte_date = LocalDateTime.now().toString();
        String verval_date = LocalDateTime.now().plusDays(days_till_expiry).toString();
        System.out.println("De vervaldatum is: " + verval_date);

        Customer customer = new Customer(client_name, client_address, client_email, client_name, selected_klant_type);

        BasicOfferte offerte = new BasicOfferte(customer, selected_klant_type, selected_boot_config, offerte_date, verval_date);
    }

    public static void edit_offerte() {

    }

    public static void delete_offerte() {

    }

    public static void show_offerte() {

    }

    public static String gen_offerte_nr() {
        lastNumber++;
        return "SF-%d" + lastNumber;
    }

}
