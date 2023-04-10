package menus;

import entities.bootconfig.BoatConfig;
import entities.klant.ClientType;
import managers.BoatManager;
import managers.ClientManager;
import managers.FileManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class FileMenu extends MenuBase implements Serializable {
    private Scanner scanner;

    public FileMenu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void show_menu() {
        //TODO, ALLE DATA SERIALIZEREN OF DESERIALIZEREN (afhankelijk van of je het opslaat of inlaad)
        while (true) {
            System.out.println("\033[1m== File Manager ==\033[0m");
            System.out.println("Wat wilt u doen?");
            System.out.println("1. Data lezen\n2. Data opslaan\n3. Terug naar hoofdmenu");
            System.out.print("Voer in: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            final int kDataLezen = 1, kDataOpslaan = 2, kNavigateToHoofdmenu = 3;

            switch (choice) {
                case kDataLezen:
                    readData();
                    break;
                case kDataOpslaan:
                    saveData();
                    break;
                case kNavigateToHoofdmenu:
                    return;
                default:
                    break;
            }
        }
    }

    private void readData() {
        FileManager fileManager = new FileManager();

        BoatManager.loaded_boat_configurations = (Map<String, BoatConfig>) fileManager.importFile("boatconfigs.bin");
        ClientManager.loaded_client_types = (ArrayList<ClientType>) fileManager.importFile("clienttypes.bin");
    }

    private void saveData() {
        FileManager fileManager = new FileManager();

        fileManager.exportFile("boatconfigs.bin", BoatManager.loaded_boat_configurations);
        fileManager.exportFile("clienttypes.bin", ClientManager.loaded_client_types);
    }
}
