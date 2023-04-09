package managers;

import entities.bootconfig.BootConfig;
import entities.klant.KlantType;
import entities.offerte.BasicOfferte;
import entities.offerte.OfferteBase;
import managers.KlantManager;

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

        BasicOfferte offerte = new BasicOfferte();
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
