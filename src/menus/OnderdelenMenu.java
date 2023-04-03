package menus;

import java.util.Scanner;

public class OnderdelenMenu extends MenuBase {
    private Scanner scanner;
    public OnderdelenMenu() {
        scanner = new Scanner(System.in);
    }
    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\033[1m== Onderdelen ==\033[0m");
            System.out.println("Wat wilt u doen?");
            System.out.println("1. Onderdelen toevoegen\n2. Onderdelen wijzigen\n3. Terug naar hoofdmenu");
            System.out.print("Voer in: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            final int kOnderdelenToevoegen = 1, kOnderdelenWijzigen = 2, kTerugHoofdmenu = 3;

            switch (choice) {
                case kOnderdelenToevoegen:
                    addOnderdelen();
                    break;
                case kOnderdelenWijzigen:
                    editOnderdelen();
                    break;
                case kTerugHoofdmenu:
                    return;
                default:
                    break;
            }
        }
    }

    private void addOnderdelen() {

    }

    private void editOnderdelen() {

    }
}
