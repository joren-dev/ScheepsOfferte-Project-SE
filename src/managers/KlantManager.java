package managers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import entities.klant.KlantType;

public class KlantManager {

    // Class members
    public static ArrayList<KlantType> klantTypen = new ArrayList<>();

    public KlantManager(){
        // Standaard klant types
        addKlantType("Zakelijke klant", 10);
        addKlantType("Particuliere klant", 0);
    }

    public static void addKlantType(String type_naam, int korting) {
        for (KlantType each : klantTypen) {
            if (each.getTypeNaam().equals(type_naam)) {
                System.out.println("Dat entities.klant type bestaat al.");
                return;
            }
        }

        klantTypen.add(new KlantType(type_naam.toLowerCase(), korting));
    }

    public static void deleteKlantType(String typenaam) {
        // Verwijderd de entities.klant type als het bestaat.
        KlantManager.klantTypen.removeIf((x)
                -> x.getTypeNaam().equals(typenaam.toLowerCase()));

    }

    public static void wijzigKlantType(String klant_type_naam) {
        Scanner scanner = new Scanner(System.in);

        Optional<KlantType> optioneel_klant_type = KlantManager.klantTypen.stream().filter((klant_type) -> klant_type.getTypeNaam().equals(klant_type_naam.toLowerCase())).findFirst();
        System.out.println(optioneel_klant_type.get().toString());

        System.out.print("Nieuwe klanttype naam: ");
        String nieuwe_klant_type_naam = scanner.nextLine();

        System.out.print("Nieuwe klanttype korting: ");
        final int nieuwe_klant_type_korting = scanner.nextInt();
        scanner.nextLine();

        if (optioneel_klant_type.isPresent()) {
            // Reference naar object in arraylist
            KlantType klant_type = optioneel_klant_type.get();

            klant_type.setTypeNaam(nieuwe_klant_type_naam);
            klant_type.setKorting(nieuwe_klant_type_korting);
        }
    }
}
