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

    public static void generateQuotation(
            String companyAddress,
            String companyWebsite,
            int quotationNumber,
            String dateOfQuotation,
            Klant target,
            String productDescription,
            String dateOfService,
            int count,
            double priceForEach,
            int daysToPay,
            int daysToDeliver,
            String expireDateOfQuotation,
            String nameAndSignature,
            String companyName
    ) {
        System.out.println(companyAddress);
        System.out.println(target.getTelefoon());
        System.out.println(target.getEmail());
        System.out.println(companyWebsite);
        System.out.printf("%nOffertenummer: %d%n", quotationNumber);
        System.out.printf("Datum: %s%n%n", dateOfQuotation);
        System.out.printf("Aan: %s%n", target.getNaam());
        System.out.println(target.getBedrijf());
        System.out.println(target.getAdres());
        System.out.println(target.getTelefoon());
        System.out.println(target.getEmail());
        System.out.println();
        System.out.printf("Geachte heer/mevrouw %s,%n%n", target.getNaam());
        System.out.printf("Hartelijk dank voor uw interesse in onze diensten/producten. Wij zijn verheugd om u een offerte aan te bieden voor %s zoals besproken op %s.%n%n", productDescription, dateOfService);
        System.out.println("Hieronder vindt u de details van onze offerte:");

        double subtotaal = 0.0;
        // for all products in quotation {
        System.out.println();
        System.out.printf("Product/dienst: %s%n", productDescription);
        System.out.printf("Hoeveelheid: %d%n", count);
        System.out.printf("Eenheidsprijs: € %.2f%n", priceForEach);
        System.out.printf("Korting: %.1f%%%n", target.getKlantKorting() * 100.0);
        System.out.printf("Totaalbedrag: € %.2f%n", count * priceForEach * (1.0 - target.getKlantKorting()));
        subtotaal += count * priceForEach * (1.0 - target.getKlantKorting());
        // }
        double btwBedrag = subtotaal * 0.21;    // Assuming 21 % BTW
        System.out.printf("Subtotaal: € %.2f%n", subtotaal);
        System.out.printf("Btw: € %.2f%n", btwBedrag);
        System.out.printf("Totaal: € %.2f%n%n", subtotaal + btwBedrag);

        System.out.printf("Betalingstermijn: %d%n", daysToPay);
        System.out.printf("Levertermijn: %d%n%n", daysToDeliver);

        System.out.printf("De bovenstaande bedragen zijn geldig tot %s.%n%n", expireDateOfQuotation);

        System.out.println("Wij streven ernaar om hoogwaardige producten/diensten te leveren en uitstekende klantenservice te bieden. Mocht u nog vragen hebben of meer informatie nodig hebben, aarzel dan niet om contact met ons op te nemen. Wij kijken uit naar de samenwerking met u.");
        System.out.println("Met vriendelijke groet,");
        System.out.println();
        System.out.printf("%s%n%s%n", nameAndSignature, companyName);
    }
}