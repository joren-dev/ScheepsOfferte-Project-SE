package entities.offerte;

import entities.bootconfig.BoatConfig;
import entities.klant.CustomerType;
import entities.klant.Customer;

public class BasicOfferte extends OfferteBase {
    public BasicOfferte(Customer klant, CustomerType klantType, BoatConfig config, String offerteDatum, String vervalDatum) {
        super(klant, klantType, config, offerteDatum, vervalDatum);
    }
}
