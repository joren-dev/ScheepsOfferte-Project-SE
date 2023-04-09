package entities.offerte;

import entities.bootconfig.BootConfig;
import entities.klant.Client;
import entities.klant.ClientType;

public abstract class OfferteBase {
    private Client klant;
    private ClientType klantType;
    private BootConfig config;
    private String offerteDatum;
    private String vervalDatum;

    public OfferteBase(Client klant, ClientType klantType, BootConfig config, String offerteDatum, String vervalDatum) {
        this.klant = klant;
        this.klantType = klantType;
        this.config = config;
        this.offerteDatum = offerteDatum;
        this.vervalDatum = vervalDatum;
    }

    public Client getKlant() {
        return klant;
    }

    public void setKlant(Client klant) {
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

    public ClientType getKlantType() {
        return klantType;
    }

    public void setKlantType(ClientType klantType) {
        this.klantType = klantType;
    }
}
