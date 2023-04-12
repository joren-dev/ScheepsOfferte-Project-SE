package entities.offerte;

import entities.bootconfig.BoatConfig;
import entities.klant.Customer;

public class BasicOfferte extends OfferteBase {
    public BasicOfferte(Customer klant, BoatConfig config, String offerteDatum, String vervalDatum) {
        super(klant, config, offerteDatum, vervalDatum);
    }
}
