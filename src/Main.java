import managers.MenuManager;
import menus.KlantTypeMenu;
import menus.OfferteMenu;
import menus.BootConfiguratieMenu;

public class Main {
    public static void main(String[] args) {

        // Start up menu manager
        MenuManager manager = new MenuManager();

        // Add menu items here...
        manager.addMenu("Beheer Klanttype(s)", new KlantTypeMenu());
        manager.addMenu("Beheer Offerte(s)", new OfferteMenu());
        manager.addMenu("Beheer Boot Configuraties", new BootConfiguratieMenu());

        // Starts the menu manager
        manager.start();
    }
}