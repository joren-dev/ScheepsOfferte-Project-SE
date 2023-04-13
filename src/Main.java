import managers.MenuManager;
import managers.OfferteManager;
import managers.CustomerManager;

import menus.CustomerTypeMenu;
import menus.OfferteMenu;
import menus.BoatConfigurationMenu;


public class Main {
    public static void main(String[] args) {
        System.out.println("\033[1m|| ShipFlex offerte software ||\033[0m");

        // Initialize managers
        MenuManager menu_manager = new MenuManager();
        OfferteManager offerte_manager = new OfferteManager();
        CustomerManager customer_manager = new CustomerManager();

        // Add menu items here...
        menu_manager.add_menu("Beheer Klanttype(s)", new CustomerTypeMenu());
        menu_manager.add_menu("Beheer Offerte(s)", new OfferteMenu());
        menu_manager.add_menu("Beheer Boot Configuraties", new BoatConfigurationMenu());

        // Starts the menu manager
        menu_manager.start();
    }
}