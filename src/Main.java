import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\033[1m== Klanttypen ==\033[0m");
            System.out.println("Wat wilt u doen?");
            System.out.println("1. Klanttype toevoegen\n2. Klanttype wijzigen\n3. Klanttype verwijderen\n4. Terug naar hoofdmenu");
            System.out.print("Voer in: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Hoe noemt u dit klanttype?");
                    System.out.print("Voer in: ");
                    String naam = scanner.nextLine();
                    System.out.println("Hoeveel korting krijgt dit klanttype?");
                    System.out.print("Voer in: ");
                    double korting = scanner.nextDouble();
                    scanner.nextLine();
                    korting /= 100.0;
                    KlantType klantType = new KlantType(naam, korting);
                    break;
                case 2:
                    System.out.println("Welk klanttype wilt u wijzigen?");
                    System.out.println(Arrays.toString(KlantType.klantTypen.stream().map(KlantType::getTypeNaam).toArray()));
                    System.out.print("Voer in: ");
                    String naam2 = scanner.nextLine();
                    Optional<KlantType> klantType1 = KlantType.klantTypen.stream().filter((x) -> x.getTypeNaam().equals(naam2)).findFirst();
                    System.out.println(klantType1);
                    System.out.println("Nieuwe klanttype naam: ");
                    System.out.print("Voer in: ");
                    String naam3 = scanner.nextLine();
                    System.out.println("Nieuwe klanttype korting: ");
                    double korting2 = scanner.nextDouble() / 100.0;
                    scanner.nextLine();
                    if (Objects.requireNonNull(klantType1).isPresent()) {
                        KlantType klant = Objects.requireNonNull(klantType1).get();
                        klant.setTypeNaam(naam3);
                        klant.setKorting(korting2);
                    }
                    break;
                case 3:
                    System.out.println("Welk klanttype wilt u verwijderen?");
                    System.out.println(Arrays.toString(KlantType.klantTypen.stream().map(KlantType::getTypeNaam).toArray()));
                    System.out.print("Voer in: ");
                    String naam4 = scanner.nextLine();
                    Optional<KlantType> klantType2 = KlantType.klantTypen.stream().filter((x) -> x.getTypeNaam().equals(naam4)).findFirst();
                    KlantType klant = Objects.requireNonNull(klantType2).get();
                    klant.deleteKlantType(naam4);
                    break;
                case 4:
                    
                default:
                    break;
            }

            System.out.println(KlantType.klantTypen);
        }
    }
}