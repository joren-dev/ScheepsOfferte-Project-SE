package menus;

import managers.BoatManager;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;

public class BoatConfigurationMenu extends MenuBase implements Serializable {
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

            String invoer = "";
            while (!invoer.matches("^[12345]$")) {  // TODO: make dynamic
                System.out.print("Voer in (valide) getal (1-5): ");
                invoer = scanner.nextLine();
            }

            final int choice = Integer.parseInt(invoer);

            final int kAddBootConfiguration = 1, kChangeBootConfiguration = 2, kViewBootConfigurations = 3,
                    kRemoveBootConfiguration = 4, kReturnToMainMenu = 5;

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
