package entities.offerte;

import entities.bootconfig.BoatConfig;
import entities.klant.Client;
import entities.klant.ClientType;

public abstract class OfferteBase {
    private Client client;
    private ClientType client_type;
    private BoatConfig config;
    private String offerte_date;
    private String expiry_date;

    public OfferteBase(Client client, ClientType client_type, BoatConfig config, String offerte_date, String expiry_date)
    {
        this.client = client;
        this.client_type = client_type;
        this.config = config;
        this.offerte_date = offerte_date;
        this.expiry_date = expiry_date;
    }

    public Client get_client()
    {
        return client;
    }

    public void set_client(Client client) {

        this.client = client;
    }

    public BoatConfig get_config()
    {
        return config;
    }

    public void set_config(BoatConfig config)
    {
        this.config = config;
    }

    public String get_offerte_date()
    {
        return offerte_date;
    }

    public void set_offerte_date(String offerte_date)
    {
        this.offerte_date = offerte_date;
    }

    public String get_expiry_date()
    {
        return expiry_date;
    }

    public void set_expiry_date(String expiry_date)
    {
        this.expiry_date = expiry_date;
    }

    public ClientType get_client_type()
    {
        return client_type;
    }

    public void set_client_type(ClientType client_type)
    {
        this.client_type = client_type;
    }
}
