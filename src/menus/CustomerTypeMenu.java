package menus;

import java.util.Scanner;

import managers.CustomerManager;
import utils.ConstantUtils.ClientTypeMenuOptions;
import utils.RequestInputUtils;

public class CustomerTypeMenu extends MenuBase {

    private Scanner scanner;

    public CustomerTypeMenu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void show_menu() {
        while (true) {
            System.out.println("\033[1m== Klanttypen ==\033[0m");

            System.out.println("Wat wilt u doen?");
            System.out.println("1. Klanttype toevoegen\n2. Klanttype wijzigen\n3. Klanttype verwijderen\n4. Klanttype lijst bekijken\n5. Terug naar hoofdmenu");

            final int max_option = ClientTypeMenuOptions.kNavigateToMainMenu.ordinal() + 1;
            final int choice = RequestInputUtils.request_valid_choice_in_range(
                    "Voer een getal tussen 1 en " + max_option + " in: ",
                    Integer::parseInt,
                    1, max_option);

            // Convert choice into specific option in enum.
            final ClientTypeMenuOptions enum_choice = ClientTypeMenuOptions.values()[choice - 1];

            switch (enum_choice) {
                case kAddClientType:
                    CustomerManager.add_client_type();
                    break;
                case kChangeClientType:
                    CustomerManager.edit_client_type();
                    break;
                case kRemoveClientType:
                    CustomerManager.delete_client_type();
                    break;
                case kViewClientType:
                    CustomerManager.view_client_type();
                    break;
                case kNavigateToMainMenu:
                    return;
                default:
                    break;
            }
        }
    }
}
