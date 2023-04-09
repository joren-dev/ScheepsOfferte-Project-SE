package menus;

import java.util.Arrays;
import java.util.Scanner;

import entities.klant.ClientType;
import managers.ClientManager;

public class KlantTypeMenu extends MenuBase {
    private Scanner scanner;

    public KlantTypeMenu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void show_menu() {
        while (true) {
            System.out.println("\033[1m== Klanttypen ==\033[0m");
            System.out.println("Wat wilt u doen?");
            System.out.println("1. Klanttype toevoegen\n2. Klanttype wijzigen\n3. Klanttype verwijderen\n4. Klanttype lijst bekijken\n5. Terug naar hoofdmenu");
            System.out.print("Voer in: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            final int kAddKlantType = 1, kChangeKlantType = 2, kRemoveKlantType = 3, kViewKlantType = 4, kNavigateToHoofdmenu = 5;

            switch (choice) {
                case kAddKlantType:
                    add_client_type();
                    break;
                case kChangeKlantType:
                    edit_client_type();
                    break;
                case kRemoveKlantType:
                    delete_client_type();
                    break;
                case kViewKlantType:
                    view_client_type();
                    break;
                case kNavigateToHoofdmenu:
                    return;
                default:
                    break;
            }
        }
    }

    private void add_client_type() {
        System.out.print("Hoe noemt u dit klanttype: ");
        final String name = scanner.nextLine();

        System.out.print("Hoeveel korting krijgt dit klanttype: ");

        final int discount = scanner.nextInt();
        scanner.nextLine();

        ClientManager.add_client_type(name, discount);
    }


    private void edit_client_type() {

        boolean found = false;
        String client_type_name;

        do {
            System.out.println("Welk klanttype wilt u bewerken?");
            System.out.println(Arrays.toString(ClientManager.loaded_client_types.stream().map(ClientType::get_type_name).toArray()));

            System.out.print("Maak uw keuze: ");
            client_type_name = scanner.nextLine();

            for (int i = 0; i != ClientManager.loaded_client_types.size(); i++) {
                ClientType found_client = ClientManager.loaded_client_types.get(i);

                if (found_client.get_type_name().equals(client_type_name)) {
                    found = true;
                    ClientManager.change_client_type(found_client.get_type_name());
                }
            }

        } while (!found);

    }

    private void delete_client_type() {
        boolean found = false;

        do {
            System.out.println("Welk klanttype wilt u verwijderen?");
            System.out.println(Arrays.toString(ClientManager.loaded_client_types.stream().map(ClientType::get_type_name).toArray()));

            System.out.print("Maak uw keuze: ");
            String name = scanner.nextLine();

            for (int i = 0; i != ClientManager.loaded_client_types.size(); i++) {
                ClientType found_client = ClientManager.loaded_client_types.get(i);

                if (found_client.get_type_name().equals(name)) {
                    found = true;
                    ClientManager.delete_client_type(name);
                    break;
                }
            }
        } while (!found);
    }

    private void view_client_type() {
        System.out.println(Arrays.toString(ClientManager.loaded_client_types.stream().map(ClientType::toString).toArray()));
    }
}
