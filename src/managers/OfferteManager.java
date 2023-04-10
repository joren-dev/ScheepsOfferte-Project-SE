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

    public static void create_offerte() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("\033[1m== Offerte maken ==\033[0m");

        if (BoatManager.get_all_boat_configs().isEmpty())
        {
            System.out.println("U heeft geen boot configuraties, stel eerst een configuratie samen.\n");
            return;
        }

        ClientType selected_klant_type;
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

        System.out.println("Hoelang is de offerte geldig (dagen): ");
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

    private static boolean is_valid_email(final String email) {
        //  TODO: schrijf code die checkt op de email valid is...
        return true;
    }
}
