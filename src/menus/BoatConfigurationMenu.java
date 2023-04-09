package menus;

import managers.BootManager;

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

            int choice = -1;
            while (choice < 1 || choice > 5) {
                System.out.print("Voer in: ");
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException identifier) {
                    System.out.println("Vul alstublieft een getal in.");
                }
                scanner.nextLine();
            }

            final int kAddBootConfiguration = 1, kChangeBootConfiguration = 2, kViewBootConfigurations = 3,
                    kRemoveBootConfiguration = 4, kReturnToMainMenu = 5;

            switch (choice) {
                case kAddBootConfiguration:
                    BootManager.add_boat_config();
                    break;

                case kChangeBootConfiguration:
                    BootManager.change_boat_config();
                    break;

                case kViewBootConfigurations:
                    BootManager.print_loaded_configs(true);
                    break;

                case kRemoveBootConfiguration:
                    BootManager.remove_boat_config();
                    break;

                case kReturnToMainMenu:
                    return;

                default:
                    break;
            }
        }
    }
}
