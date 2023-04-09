package managers;

import entities.bootconfig.BootConfig;
import entities.klant.Klant;
import entities.klant.KlantType;
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

        ArrayList<KlantType> allKlantTypes = KlantManager.klantTypen;
        Map<String, BootConfig> allBoatConfigurations = BootManager.loadedConfigurations;
        KlantType selectedKlantType = null;
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

            for (KlantType huidigeKlantType : allKlantTypes) {
                if (Objects.equals(huidigeKlantType.getTypeNaam(), input)) {
                    selectedKlantType = huidigeKlantType;
                    isInputValid = true;
                    break;
                }
            }

            if (!isInputValid) {
                System.err.println("Klanttype niet gevonden");
            }
        }
        System.out.printf("Geselecteerde klanttype: %n%s%n%n", selectedKlantType.getTypeNaam());
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
        System.out.println("Klant email: " + email);

        System.out.println("Wat is het telefoon nummer van de klant?");
        telefoon = scanner.nextLine();
        System.out.println("Klant telefoon nummer: " + telefoon);

        System.out.println("Hoelang is de offerte geldig");
        aantalDagenTotVervallen = scanner.nextInt();
        String vervalDatum = LocalDateTime.now().plusDays(aantalDagenTotVervallen).toString();
        System.out.println("De vervaldatum is: " + vervalDatum);

        Klant klant = new Klant(naam, adres, email, telefoon, selectedKlantType);
        String offerteDatum = LocalDateTime.now().toString();

        BasicOfferte offerte = new BasicOfferte(klant, selectedKlantType, selectedBootConfig, offerteDatum, vervalDatum);

        // sout(Do you wish to use an existing configuration)
        // if(true)
//        BootManager.printLoadedConfigurations(false);
//        // request them to pick one, and check if its even valid/if it exists
//        BootConfig config_used = BootManager.getBootConfiguration("change this");
//        if (config_used == null)
//            System.out.println("De boot config die u opvroeg bestaat niet");


        // Now u can get the config's data by calling this or creating a new method that
        // references each category inside BootConfig seperately. E.G.:
        // UiterlijkOnderdeel uiterlijk_obj = config_used.get_category("Uiterlijk")
        // etc

        // config_used.print_all_options();
        // else
        // configuration from scratch...
//        offerteLijst.put(offerteNummer, offerte);
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
}
