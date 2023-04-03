import managers.MenuManager;
import managers.KlantManager;
import menus.KlantTypeMenu;
import menus.ViewOfferteMenu;

public class Main {
    public static void main(String[] args) {

        // Start up menu manager
        MenuManager manager = new MenuManager();
        KlantManager klant_manager = new KlantManager();

        // Add menu items here...
        manager.addMenu("Klant Type", new KlantTypeMenu());
        manager.addMenu("View Offerte", new ViewOfferteMenu());

        // Starts the menu manager
        manager.start();
    }
}