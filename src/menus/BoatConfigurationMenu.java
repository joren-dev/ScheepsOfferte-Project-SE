package menus;

import managers.BoatManager;

import utils.ConstantUtils.BoatConfigurationMenuOptions;
import utils.RequestInputUtils;
import java.util.Scanner;

public class BoatConfigurationMenu extends MenuBase {
    private Scanner scanner;

    public BoatConfigurationMenu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void show_menu() {

        while (true) {
            System.out.println("\033[1m== Boot Configuratie Beheer ==\033[0m");

            System.out.println("Wat wilt u doen?");
            System.out.println("1. Boot Configuratie toevoegen\n2. Boot Configuratie wijzigen\n" +
                    "3. Boot Configuratie bekijken\n4. Boot Configuratie verwijderen\n5. Terug naar hoofdmenu");

            final int max_option = BoatConfigurationMenuOptions.kNavigateToMainMenu.ordinal() + 1;
            final int choice = RequestInputUtils.request_valid_choice_in_range(
                    "Voer een getal tussen 1 en " + max_option + " in: ",
                    Integer::parseInt,
                    1, max_option);

            // Convert choice into specific option in enum.
            final BoatConfigurationMenuOptions enum_choice = BoatConfigurationMenuOptions.values()[choice - 1];

            switch (enum_choice) {
                case kAddBootConfiguration:
                    BoatManager.add_boat_config();
                    break;

                case kChangeBootConfiguration:
                    BoatManager.change_boat_config();
                    break;

                case kViewBootConfigurations:
                    BoatManager.print_loaded_configs(true);
                    break;

                case kRemoveBootConfiguration:
                    BoatManager.remove_boat_config();
                    break;

                case kNavigateToMainMenu:
                    return;

                default:
                    break;
            }
        }
    }
}
