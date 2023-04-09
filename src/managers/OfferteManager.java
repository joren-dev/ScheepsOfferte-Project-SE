package managers;

import entities.bootconfig.BootConfig;
import entities.klant.Client;
import entities.klant.ClientType;

import entities.offerte.BasicOfferte;

import java.time.LocalDateTime;
import java.util.*;

public class OfferteManager {

    // <offerte_nummer, OfferteObject>
    // Map<String, BaseOfferte> offerte_list = ...
    public static Map<String, BasicOfferte> offerteLijst = new HashMap<>();
    private static int lastNumber = 10000;

    public OfferteManager() {
        // Check existing offertes /saves/offertes/
        //                                  offertenr12.txt
        //                                  offertenr134.txt
    }

    public static void createOfferte() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ClientType> allKlantTypes = ClientManager.client_types;
        Map<String, BootConfig> allBoatConfigurations = BootManager.loadedConfigurations;
        ClientType selectedKlantType = null;
        BootConfig selectedBootConfig= null;
        String input = "";
        boolean isInputValid = false;

        System.out.println("\033[1m== Offerte maken ==\033[0m");

        //Klanttype selecteren
        while (!isInputValid) {
            System.out.println("Voor welk klanttype maak je deze offerte?");
            System.out.println(allKlantTypes);
            System.out.print("Maak uw keuze: ");
            input = scanner.nextLine();

            for (ClientType huidigeKlantType : allKlantTypes) {
                if (Objects.equals(huidigeKlantType.get_type_name(), input)) {
                    selectedKlantType = huidigeKlantType;
                    isInputValid = true;
                    break;
                }
            }

            if (!isInputValid) {
                System.err.println("Klanttype niet gevonden");
            }
        }
        System.out.printf("Geselecteerde klanttype: %n%s%n%n", selectedKlantType.get_type_name());
        isInputValid = false;

        //Bootconfig selecteren
        while (!isInputValid) {
            System.out.println("Welke bootconfiguratie wilt u toevoegen aan de offerte?");
            System.out.println(allBoatConfigurations);
            System.out.print("Maak uw keuze: ");
            input = scanner.nextLine();

            for (Map.Entry<String, BootConfig> entry : allBoatConfigurations.entrySet()) {
                if (Objects.equals(entry.getKey(), input)) {
                    selectedBootConfig = entry.getValue();
                    isInputValid = true;
                    break;
                }
            }
            if (!isInputValid) {
                System.out.println("Bootconfiguratie niet gevonden.");
            }
        }

        System.out.printf("Geselecteerde boot configuratie: %n%s%n%n", selectedBootConfig.toString());
        isInputValid = false;

        String naam = "";
        String adres = "";
        String email = "";
        String telefoon = "";
        int aantalDagenTotVervallen = 0;

        System.out.println("Wat is de naam van de klant?");
        naam = scanner.nextLine();
        System.out.println("Klant naam: " + naam);

        System.out.println("Wat is het adres van de klant?");
        adres = scanner.nextLine();
        System.out.println("Klant adres: " + adres);

        System.out.println("Wat is de email van de klant?");
        email = scanner.nextLine();

        // TODO: Use a do while/while loop to keep asking for input if they input an invalid email address
        final boolean email_valid = is_valid_email(email);
        System.out.println("Klant email: " + email);

        System.out.println("Wat is het telefoon nummer van de klant?");
        telefoon = scanner.nextLine();
        System.out.println("Klant telefoon nummer: " + telefoon);

        System.out.println("Hoelang is de offerte geldig");
        aantalDagenTotVervallen = scanner.nextInt();
        String vervalDatum = LocalDateTime.now().plusDays(aantalDagenTotVervallen).toString();
        System.out.println("De vervaldatum is: " + vervalDatum);

        Client klant = new Client(naam, adres, email, telefoon, selectedKlantType);
        String offerteDatum = LocalDateTime.now().toString();

        BasicOfferte offerte = new BasicOfferte(klant, selectedKlantType, selectedBootConfig, offerteDatum, vervalDatum);

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

    private static boolean is_valid_email(final String email)
    {
        //  TODO: schrijf code die checkt op de email valid is...
        return true;
    }
}
