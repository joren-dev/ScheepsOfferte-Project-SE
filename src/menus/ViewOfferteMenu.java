package menus;

import entities.klant.Klant;
import menus.MenuBase;

import java.util.Scanner;

public class ViewOfferteMenu extends MenuBase {

    private Scanner scanner;

    public ViewOfferteMenu() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\033[1m== Weergeven Offerte ==\033[0m");
            System.out.println("Wat wilt u doen?");
            System.out.println("1. Offerte toevoegen\n2. Offerte wijzigen wijzigen\n3. Offerte lijst weergeven\n4. Offerte verwijderen\n5. Terug naar hoofdmenu");
            System.out.print("Voer in: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // ..
                    break;
                case 2:
                    // ..
                    break;
                case 3:
                    // ..
                    break;
                case 4:
                    // ..
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    public void generateQuotation(
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
        System.out.printf("Hartelijk dank voor uw interesse in onze diensten/producten. Wij zijn verheugd om u een entities.klant.offerte aan te bieden voor %s zoals besproken op %s.%n%n", productDescription, dateOfService);
        System.out.println("Hieronder vindt u de details van onze entities.klant.offerte:");

        double subtotaal = 0.0;
        // for all products in quotation {
        System.out.println();
        System.out.printf("Product/dienst: %s%n", productDescription);
        System.out.printf("Hoeveelheid: %d%n", count);
        System.out.printf("Eenheidsprijs: € %.2f%n", priceForEach);
        System.out.printf("Korting: %d%%%n", target.getKlantKorting());
        System.out.printf("Totaalbedrag: € %.2f%n", count * priceForEach * ((100.0 - target.getKlantKorting()) / 100.0));
        subtotaal += count * priceForEach * ((100.0 - target.getKlantKorting()) / 100.0);
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
