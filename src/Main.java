import managers.MenuManager;
import menus.KlantTypeMenu;
import menus.ExampleMenu;
import menus.OfferteMenu;

public class Main {
    public static void main(String[] args) {

        // Start up menu manager
        MenuManager manager = new MenuManager();

        // Add menu items here...
        manager.addMenu("Klant Type", new KlantTypeMenu());
        manager.addMenu("View Offerte", new OfferteMenu());
        manager.addMenu("Example optie", new ExampleMenu());

        // Starts the menu manager
        manager.start();
    }
}