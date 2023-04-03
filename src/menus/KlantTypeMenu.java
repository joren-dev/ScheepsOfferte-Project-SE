package menus;

import java.util.Arrays;
import java.util.Scanner;

import entities.klant.KlantType;
import managers.KlantManager;

public class KlantTypeMenu extends MenuBase {
    private Scanner scanner;

    public KlantTypeMenu() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\033[1m== Klanttypen ==\033[0m");
            System.out.println("Wat wilt u doen?");
            System.out.println("1. Klanttype toevoegen\n2. Klanttype wijzigen\n3. Klanttype verwijderen\n4. Terug naar hoofdmenu");
            System.out.print("Voer in: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            final int kVoegKlantType = 1, kWijzigKlantType = 2, kVerwijderKlantType = 3, kNavigeerHoofdmenu = 4;

            switch (choice) {
                case kVoegKlantType:
                    addKlantType();
                    break;
                case kWijzigKlantType:
                    editKlantType();
                    break;
                case kVerwijderKlantType:
                    deleteKlantType();
                    break;
                case kNavigeerHoofdmenu:
                    return;
                default:
                    break;
            }
        }
    }

    private void addKlantType() {
        System.out.print("Hoe noemt u dit klanttype: ");
        String naam = scanner.nextLine();

        System.out.print("Hoeveel korting krijgt dit klanttype: ");
        double korting = scanner.nextDouble();
        scanner.nextLine();
        korting /= 100.0;

        KlantManager.addKlantType(naam, korting);
    }


    private void editKlantType() {
        System.out.println("Welk klanttype wilt u bewerken?");
        System.out.println(
                Arrays.toString(
                        KlantManager.klantTypen.stream().map(KlantType::getTypeNaam).toArray()
                )
        );

        System.out.print("Maak uw keuze: ");
        String klant_type_naam = scanner.nextLine();

        KlantManager.wijzigKlantType(klant_type_naam);
    }

    private void deleteKlantType() {
        System.out.println("Welk klanttype wilt u verwijderen?");
        System.out.println(Arrays.toString(KlantManager.klantTypen.stream().map(KlantType::getTypeNaam).toArray()));

        System.out.print("Maak uw keuze: ");
        String naam = scanner.nextLine();

        KlantManager.deleteKlantType(naam);
    }

}
