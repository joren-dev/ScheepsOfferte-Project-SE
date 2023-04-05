package menus;

import managers.BootManager;

import java.util.Scanner;

public class BootConfiguratieMenu extends MenuBase {
    private Scanner scanner;

    public BootConfiguratieMenu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\033[1m== Onderdelen ==\033[0m");
            System.out.println("Wat wilt u doen?");
            System.out.println("1. Boot Configuratie toevoegen\n2. Boot Configuratie wijzigen\n3. Boot Configuratie bekijken\n4. Terug naar hoofdmenu");
            System.out.print("Voer in: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            final int kBootConfiguratieToevoegen = 1, kBootConfiguratieWijzigen = 2, kBootConfiguratieBekijken = 3, kTerugHoofdmenu = 4;

            switch (choice) {
                case kBootConfiguratieToevoegen:
                    BootManager.addBootConfiguratie();
                    break;
                case kBootConfiguratieWijzigen:
                    // soon
                    break;
                case kBootConfiguratieBekijken:
                    BootManager.printLoadedConfigurations();
                    break;
                case kTerugHoofdmenu:
                    return;
                default:
                    break;
            }
        }
    }

}
