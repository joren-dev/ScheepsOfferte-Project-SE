package menus;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import entities.klant.ClientType;
import managers.ClientManager;
import utils.ConstantUtils.ClientTypeMenuOptions;
import utils.RequestInputUtils;


public class KlantTypeMenu extends MenuBase implements Serializable {
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

            final int max_option = ClientTypeMenuOptions.kNavigateToMainMenu.ordinal() + 1;
            final int choice = RequestInputUtils.request_valid_choice(
                    "Voer een getal tussen 1 en " + max_option + " in: ",
                    Integer::parseInt,
                    1, max_option);

            // Convert choice into specific option in enum.
            final ClientTypeMenuOptions enum_choice = ClientTypeMenuOptions.values()[choice - 1];

            switch (enum_choice) {
                case kAddClientType:
                    add_client_type();
                    break;
                case kChangeClientType:
                    edit_client_type();
                    break;
                case kRemoveClientType:
                    delete_client_type();
                    break;
                case kViewClientType:
                    view_client_type();
                    break;
                case kNavigateToMainMenu:
                    return;
                default:
                    break;
            }
        }
    }

    private void add_client_type() {

        String client_type_name = "";
        while (!client_type_name.matches("^[a-zA-Z][a-zA-Z ]*$")) {
            System.out.print("Vul een (valide) klanttype naam in (a-Z): ");
            client_type_name = scanner.nextLine();
        }

        String discount = "";

        while (!discount.matches("^[0-9]{1,2}$")) {
            System.out.print("Vul in een (valide) procent korting voor dit klanttype (0-100): ");
            discount = scanner.nextLine();
        }

        ClientManager.add_client_type(client_type_name, Integer.parseInt(discount));
    }


    private void edit_client_type() {
        String client_type_name;

        while (true) {
            System.out.println("Welk klanttype wilt u bewerken?");
            System.out.println(Arrays.toString(ClientManager.loaded_client_types.stream().map(ClientType::get_type_name).toArray()));

            client_type_name = "";

            while (!client_type_name.matches("^[a-zA-Z][a-zA-Z ]*$")) {
                System.out.print("Vul in een (valide) klant-type naam in (a-Z): ");
                client_type_name = scanner.nextLine();
            }

            for (int i = 0; i != ClientManager.loaded_client_types.size(); i++) {
                ClientType found_client = ClientManager.loaded_client_types.get(i);

                if (found_client.get_type_name().equals(client_type_name)) {
                    ClientManager.change_client_type(found_client.get_type_name());
                    return;
                }
            }
        }
    }

    private void delete_client_type() {
        while (true) {
            System.out.println("Welk klanttype wilt u verwijderen?");
            System.out.println(Arrays.toString(ClientManager.loaded_client_types.stream().map(ClientType::get_type_name).toArray()));

            System.out.print("Maak uw keuze: ");
            String name = scanner.nextLine();

            for (int i = 0; i != ClientManager.loaded_client_types.size(); i++) {
                ClientType found_client = ClientManager.loaded_client_types.get(i);

                if (found_client.get_type_name().equals(name)) {
                    ClientManager.delete_client_type(name);
                    return;
                }
            }
        }
    }

    private void view_client_type() {
        System.out.println(Arrays.toString(ClientManager.loaded_client_types.stream().map(ClientType::toString).toArray()));
    }
}
