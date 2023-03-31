import managers.MenuManager;
import menus.KlantTypeMenu;
import menus.ExampleMenu;

public class Main {
    public static void main(String[] args) {

        // Start up menu manager
        MenuManager manager = new MenuManager();

        // Add menu items here...
        manager.addMenu("Klant Type", new KlantTypeMenu());
        manager.addMenu("Example optie", new ExampleMenu());

        // Starts the menu manager
        manager.start();
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