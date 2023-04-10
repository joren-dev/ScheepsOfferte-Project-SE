package menus;

import java.util.Scanner;

import managers.OfferteManager;
import utils.RequestInputUtils;

public class OfferteMenu extends MenuBase {
    private final int kMaakOfferte = 1, kWijzigOfferte = 2, kToonOfferteLijst = 3, kVerwijderOfferte = 4,
            kNavigeerHoofdmenu = 5;

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

            final int choice = RequestInputUtils.request_data("Vul in een (valide) getal in (1-5): ",
                    Integer::parseInt, num -> num >= 1 && num <= 5);

            switch (choice) {
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
