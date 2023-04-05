import managers.MenuManager;
import managers.KlantManager;
import menus.KlantTypeMenu;
import menus.OfferteMenu;
import menus.BootConfiguratieMenu;

public class Main {
    public static void main(String[] args) {

        // Start up menu manager
        MenuManager manager = new MenuManager();
        KlantManager klant_manager = new KlantManager();

        // Add menu items here...
        manager.addMenu("Beheer Klanttype(s)", new KlantTypeMenu());
        manager.addMenu("Beheer Offerte(s)", new OfferteMenu());
        manager.addMenu("Beheer Boot Configuraties", new BootConfiguratieMenu());

        // Starts the menu manager
        manager.start();
    }
}