package managers;

import entities.bootconfig.BootConfig;

public class OfferteManager {

    // <offerte_nummer, OfferteObject>
    // Map<String, BaseOfferte> offerte_list = ...


    public OfferteManager()
    {
        // Check existing offertes /saves/offertes/
        //                                  offertenr12.txt
        //                                  offertenr134.txt
    }

    public static void addOfferte() {

        // Bedrijfsgegevens/particulier

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

}
