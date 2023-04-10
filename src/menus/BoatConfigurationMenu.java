package menus;

import managers.BoatManager;
import utils.RequestInputUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoatConfigurationMenu extends MenuBase {
    private final int kAddBootConfiguration = 1, kChangeBootConfiguration = 2, kViewBootConfigurations = 3,
            kRemoveBootConfiguration = 4, kReturnToMainMenu = 5;

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

            final int choice = RequestInputUtils.request_data("Voer in (valide) getal (1-5): ",
                    Integer::parseInt,
                    num -> num >= 1 && num <= 5);

            switch (choice) {
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

                case kReturnToMainMenu:
                    return;

                default:
                    break;
            }
        }
    }
}
