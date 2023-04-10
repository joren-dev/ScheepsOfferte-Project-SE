package menus;

import java.util.Scanner;

import managers.OfferteManager;
import utils.ConstantUtils;
import utils.RequestInputUtils;
import utils.ConstantUtils.OfferteMenuOptions;

public class OfferteMenu extends MenuBase {

    private Scanner scanner;

    public OfferteMenu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void show_menu() {
        while (true) {
            System.out.println("\033[1m== Weergeven Offerte ==\033[0m");

            System.out.println("Wat wilt u doen?");
            System.out.println("1. Offerte toevoegen\n2. Offerte wijzigen \n3. Offerte lijst weergeven\n4. Offerte verwijderen\n5. Terug naar hoofdmenu");

            final int max_option = OfferteMenuOptions.kNavigeerHoofdmenu.ordinal() + 1;
            final int choice = RequestInputUtils.request_valid_choice(
                    "Voer een getal tussen 1 en " + max_option + " in: ",
                    Integer::parseInt,
                    1, max_option);

            // Convert choice into specific option in enum.
            final OfferteMenuOptions enum_choice = OfferteMenuOptions.values()[choice - 1];

            switch (enum_choice) {
                case kMaakOfferte:
                    OfferteManager.create_offerte();
                    break;
                case kWijzigOfferte:
                    OfferteManager.edit_offerte();
                    break;
                case kToonOfferteLijst:
                    OfferteManager.show_offerte();
                    break;
                case kVerwijderOfferte:
                    OfferteManager.delete_offerte();
                    break;
                case kNavigeerHoofdmenu:
                    return;
                default:
                    break;
            }
        }
    }

    public void addQuotation()
    {

    }

    public void editQuotation()
    {

    }

    public void showQuotationList()
    {

    }

    public void deleteQuotation()
    {

    }
}
