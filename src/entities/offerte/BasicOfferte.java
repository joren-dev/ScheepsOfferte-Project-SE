package entities.offerte;

import entities.bootconfig.BootConfig;
import entities.klant.Klant;
import entities.klant.KlantType;

public class BasicOfferte extends OfferteBase {
    public BasicOfferte(Klant klant, KlantType klantType, BootConfig config, String offerteDatum, String vervalDatum) {
        super(klant, klantType, config, offerteDatum, vervalDatum);
    }
}
