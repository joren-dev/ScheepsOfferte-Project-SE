package entities.offerte;

import entities.bootconfig.BoatConfig;
import entities.klant.ClientType;
import entities.klant.Client;

public class BasicOfferte extends OfferteBase {
    public BasicOfferte(Client klant, ClientType klantType, BoatConfig config, String offerteDatum, String vervalDatum) {
        super(klant, klantType, config, offerteDatum, vervalDatum);
    }
}
