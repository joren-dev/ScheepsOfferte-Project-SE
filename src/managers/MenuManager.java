package managers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import menus.MenuBase;
import utils.RequestInputUtils;


public class  MenuManager implements Serializable {
    private Scanner scanner;
    private Map<String, MenuBase> menus;

    public MenuManager() {
        scanner = new Scanner(System.in);
        menus = new HashMap<>();
    }

    public void add_menu(String name, MenuBase menuBase) {
        menus.put(name, menuBase);
    }

    public void show_menu(final String name) {
        final MenuBase menuBase = menus.get(name);

        if (menuBase != null)
            menuBase.show_menu();
        else
            System.out.println("Menu niet gevonden");
    }

    public void show_menu_options() {
        System.out.println("Beschikbare menus:");

        for (final String name : menus.keySet())
            System.out.println("- " + name);
    }

    public void start() {

        while (true) {
            System.out.println("\033[1m== Main menu ==\033[0m");
            System.out.println("Type in de gewenste menu optie:");

            int optionNumber = 1;
            for (final String name : menus.keySet()) {
                System.out.println(optionNumber + ". " + name);
                optionNumber++;
            }

            final int choice = RequestInputUtils.request_valid_choice(
                    "Uw keuze: ", Integer::parseInt, 1, menus.size()
            );

            MenuBase selectedMenuBase = (MenuBase) menus.values().toArray()[choice - 1];

            selectedMenuBase.show_menu();
        }
    }
}
