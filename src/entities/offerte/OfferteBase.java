package entities.offerte;

import entities.bootconfig.BootConfig;
import entities.klant.Klant;
import entities.klant.KlantType;

public abstract class OfferteBase {
    private Klant klant;
    private KlantType klantType;
    private BootConfig config;
    private String offerteDatum;
    private String vervalDatum;

    public OfferteBase(Klant klant, KlantType klantType, BootConfig config, String offerteDatum, String vervalDatum) {
        this.klant = klant;
        this.klantType = klantType;
        this.config = config;
        this.offerteDatum = offerteDatum;
        this.vervalDatum = vervalDatum;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public BootConfig getConfig() {
        return config;
    }

    public void setConfig(BootConfig config) {
        this.config = config;
    }

    public String getOfferteDatum() {
        return offerteDatum;
    }

    public void setOfferteDatum(String offerteDatum) {
        this.offerteDatum = offerteDatum;
    }

    public String getVervalDatum() {
        return vervalDatum;
    }

    public void setVervalDatum(String vervalDatum) {
        this.vervalDatum = vervalDatum;
    }

    public KlantType getKlantType() {
        return klantType;
    }

    public void setKlantType(KlantType klantType) {
        this.klantType = klantType;
    }
}
