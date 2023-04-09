import managers.MenuManager;
import managers.KlantManager;
import managers.OfferteManager;
import menus.KlantTypeMenu;
import menus.OfferteMenu;
import menus.BootConfiguratieMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("\033[1m|| ShipFlex offerte software ||\033[0m");

        // Start up menu manager
        MenuManager manager = new MenuManager();
        KlantManager klant_manager = new KlantManager();
        OfferteManager offerte_manager = new OfferteManager();

        // Add menu items here...
        manager.addMenu("Beheer Klanttype(s)", new KlantTypeMenu());
        manager.addMenu("Beheer Offerte(s)", new OfferteMenu());
        manager.addMenu("Beheer Boot Configuraties", new BootConfiguratieMenu());

        // Starts the menu manager
        manager.start();
    }
}