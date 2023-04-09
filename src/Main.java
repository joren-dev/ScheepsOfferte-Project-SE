import managers.MenuManager;
import managers.ClientManager;
import menus.KlantTypeMenu;
import menus.OfferteMenu;
import menus.BoatConfigurationMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("\033[1m|| ShipFlex offerte software ||\033[0m");

        // Initialize managers
        MenuManager menu_manager = new MenuManager();
        ClientManager client_manager = new ClientManager();

        // Add menu items here...
        menu_manager.add_menu("Beheer Klanttype(s)", new KlantTypeMenu());
        menu_manager.add_menu("Beheer Offerte(s)", new OfferteMenu());
        menu_manager.add_menu("Beheer Boot Configuraties", new BoatConfigurationMenu());

        // Starts the menu manager
        menu_manager.start();
    }
}