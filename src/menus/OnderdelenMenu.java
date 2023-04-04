package menus;

import e.onderdelen.Onderdelen;

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
            System.out.println("1. Onderdelen toevoegen\n2. Onderdelen wijzigen\n3. Onderdelen bekijken\n4. Terug naar hoofdmenu");
            System.out.print("Voer in: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            final int kOnderdelenToevoegen = 1, kOnderdelenWijzigen = 2, kOnderdelenBekijken = 3, kTerugHoofdmenu = 4;

            switch (choice) {
                case kOnderdelenToevoegen:
                    addOnderdelen();
                    break;
                case kOnderdelenWijzigen:
                    editOnderdelen();
                    break;
                case kOnderdelenBekijken:
                    viewOnderdelen();
                    break;
                case kTerugHoofdmenu:
                    return;
                default:
                    break;
            }
        }
    }

    private void viewOnderdelen() {
        System.out.printf("%n\033[1mGekozen onderdelen:\033[0m%n%s%n%n", Onderdelen.gekozenOpties);
    }

    private void addOnderdelen() {
        Onderdelen.essentialsList();
        Onderdelen.optionalList();
    }

    private void editOnderdelen() {

    }
}
