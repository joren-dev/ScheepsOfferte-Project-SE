package menus;

import java.util.Scanner;

import managers.OfferteManager;

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
            System.out.println("1. Offerte maken\n2. Offerte wijzigen\n3. Offerte lijst weergeven\n4. Offerte verwijderen\n5. Terug naar hoofdmenu");
            System.out.print("Voer in: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            final int kMaakOfferte = 1, kWijzigOfferte = 2, kToonOfferteLijst = 3, kVerwijderOfferte = 4, kNavigeerHoofdmenu = 5;

            switch (choice) {
                case kMaakOfferte:
                    OfferteManager.createOfferte();
                    break;
                case kWijzigOfferte:
                    OfferteManager.editOfferte();
                    break;
                case kToonOfferteLijst:
                    OfferteManager.showOfferte();
                    break;
                case kVerwijderOfferte:
                    OfferteManager.deleteOfferte();
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
