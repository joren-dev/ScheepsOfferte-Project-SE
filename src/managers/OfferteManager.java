package managers;

import entities.bootconfig.BoatConfig;
import entities.klant.Client;
import entities.klant.ClientType;

import entities.offerte.BasicOfferte;

import java.time.LocalDateTime;
import java.util.*;

public class OfferteManager {
    public static Map<String, BasicOfferte> offerteLijst = new HashMap<>();
    private static int lastNumber = 10000;

    public OfferteManager() {
        // Check existing offertes /saves/offertes/
        //                                  offertenr12.txt
        //                                  offertenr134.txt
    }

    public static void createOfferte() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Offerte maken ==\033[0m");

        // Create instances that'll hold currently selected client type & boat config
        ClientType selected_klant_type = null;
        BoatConfig selected_boot_config = null;

        while (true) {
            System.out.println("Voor welk klanttype maak je deze offerte?");
            ClientManager.print_client_types();

            System.out.print("Maak uw keuze: ");
            String input = scanner.nextLine();

            if (ClientManager.contains_client_type(input)) {
                selected_klant_type = ClientManager.get_client_type(input);
                break;
            }

            System.err.println("Klanttype niet gevonden");
        }

        System.out.printf("Geselecteerde klanttype: %n%s%n%n", selected_klant_type.get_type_name());

        while (true) {
            System.out.println("Welke bootconfiguratie wilt u toevoegen aan de offerte?");
            BoatManager.print_loaded_configs(false);
            System.out.print("Maak uw keuze (Skip voor geen): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Skip")) {
                break;
            }


            if (BoatManager.contains_boat_config(input)) {
                selected_boot_config = BoatManager.get_config(input);
                break;
            }

            System.err.println("Bootconfiguratie niet gevonden.");
        }
        // if boat config present
        if (selected_boot_config != null) {
            System.out.printf("Geselecteerde boot configuratie: %n%s%n%n", selected_boot_config.toString());
        } else {
            System.out.println("Geen boot geselecteerd.");
        }

        int aantal_dagen_tot_vervallen = 0;

        System.out.println("Wat is de naam van de klant?");
        String naam = scanner.nextLine();
        System.out.println("Klant naam: " + naam);

        System.out.println("Wat is het adres van de klant?");
        String adres = scanner.nextLine();
        System.out.println("Klant adres: " + adres);

        System.out.println("Wat is de email van de klant?");
        String email = scanner.nextLine();

        // TODO: Use a do while/while loop to keep asking for input if they input an invalid email address

        final boolean email_valid = is_valid_email(email);
        System.out.println("Klant email: " + email);

        System.out.println("Wat is het telefoon nummer van de klant?");
        String telefoon = scanner.nextLine();
        System.out.println("Klant telefoon nummer: " + telefoon);

        System.out.println("Hoelang is de offerte geldig");
        aantal_dagen_tot_vervallen = scanner.nextInt();
        String verval_datum = LocalDateTime.now().plusDays(aantal_dagen_tot_vervallen).toString();
        System.out.println("De vervaldatum is: " + verval_datum);

        Client klant = new Client(naam, adres, email, telefoon, selected_klant_type);
        String offerte_datum = LocalDateTime.now().toString();

        BasicOfferte offerte = new BasicOfferte(klant, selected_klant_type, selected_boot_config, offerte_datum, verval_datum);

        // TODO:
        /*
            - Verbeter representatie van data
            - Geef aan dat datum in aantal dagen is
            - Valideer telefoon nummer lengte
            - Valideer of het een geldig email adres is
        */
    }

    public static void editOfferte() {

    }

    public static void deleteOfferte() {
        
    }

    public static void showOfferte() {

    }

    public static String generateOfferteNumber() {
        lastNumber++;
        return "SF-%d" + lastNumber;
    }

    private static boolean is_valid_email(final String email) {
        //  TODO: schrijf code die checkt op de email valid is...
        return true;
    }
}
