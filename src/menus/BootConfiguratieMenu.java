package menus;

import managers.BootManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BootConfiguratieMenu extends MenuBase {
    private Scanner scanner;

    public BootConfiguratieMenu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
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

            final int kBootConfiguratieToevoegen = 1, kBootConfiguratieWijzigen = 2, kBootConfiguratieBekijken = 3,
                    kBootConfiguratieVerwijderen = 4, kTerugHoofdmenu = 5;

            switch (choice) {
                case kBootConfiguratieToevoegen:
                    BootManager.addBootConfiguratie();
                    break;

                case kBootConfiguratieWijzigen:
                    BootManager.changeBootConfiguration();
                    break;

                case kBootConfiguratieBekijken:
                    BootManager.printLoadedConfigurations(true);
                    break;

                case kBootConfiguratieVerwijderen:
                    BootManager.removeBootConfiguration();
                    break;

                case kTerugHoofdmenu:
                    return;

                default:
                    break;
            }
        }
    }
}
