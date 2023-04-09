package managers;

import entities.bootconfig.BootConfig;
import entities.klant.KlantType;
import entities.offerte.BasicOfferte;
import entities.offerte.OfferteBase;
import managers.KlantManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        String offerteNummer = generateOfferteNummer();
        // Klanttype
        System.out.println("\033[1m== Offerte maken ==\033[0m");
        System.out.println("Voor welk klanttype maak je deze offerte?");
        ArrayList<KlantType> allKlantTypes = KlantManager.getAllKlantTypes();
        System.out.println(allKlantTypes);
        System.out.println(offerteNummer);
        String klantTypeInput = scanner.nextLine();


        // sout(Do you wish to use an existing configuration)
        // if(true)
        BootManager.printLoadedConfigurations(false);
        // request them to pick one, and check if its even valid/if it exists
        BootConfig config_used = BootManager.getBootConfiguration("change this");
        if (config_used == null)
            System.out.println("De boot config die u opvroeg bestaat niet");


        // Now u can get the config's data by calling this or creating a new method that
        // references each category inside BootConfig seperately. E.G.:
        // UiterlijkOnderdeel uiterlijk_obj = config_used.get_category("Uiterlijk")
        // etc

        // config_used.print_all_options();
        // else
        // configuration from scratch...

    }

    public static void editOfferte() {

    }

    public static void deleteOfferte() {

    }

    public static void showOfferte() {

    }

    public static String generateOfferteNummer() {
        lastNumber++;
        String offerteNummer = "";
        offerteNummer = "SF" + lastNumber;
        return offerteNummer;
    }

}
