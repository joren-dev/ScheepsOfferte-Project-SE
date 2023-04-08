package managers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import menus.MenuBase;

public class  MenuManager {
    private Scanner scanner;
    private Map<String, MenuBase> menus;

    public MenuManager() {
        scanner = new Scanner(System.in);
        menus = new HashMap<>();
    }

    public void addMenu(String name, MenuBase menuBase) {
        menus.put(name, menuBase);
    }

    public void showMenu(String name) {
        MenuBase menuBase = menus.get(name);
        if (menuBase != null) {
            menuBase.showMenu();
        } else {
            System.out.println("Menu niet gevonden");
        }
    }

    public void showMenuOptions() {
        System.out.println("Beschikbare menus:");

        for (String name : menus.keySet())
            System.out.println("- " + name);
    }

    public void start() {
        while (true) {
            System.out.println("\033[1m== Main menu ==\033[0m");
            System.out.println("Type in de gewenste menu optie:");
            int optionNumber = 1;

            for (String name : menus.keySet()) {
                System.out.println(optionNumber + ". " + name);
                optionNumber++;
            }

            System.out.print("Jouw keuze: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > menus.size()) {
                System.out.println("Ongeldige keuze, probeer het AUB opnieuw");
            } else {
                MenuBase selectedMenuBase = (MenuBase) menus.values().toArray()[choice - 1];
                selectedMenuBase.showMenu();
            }
        }
    }

}
