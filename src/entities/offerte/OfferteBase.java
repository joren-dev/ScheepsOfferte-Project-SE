package entities.offerte;

import entities.bootconfig.BoatConfig;
import entities.klant.Customer;
import entities.klant.CustomerType;


public abstract class OfferteBase {
    private Customer customer;
    private CustomerType client_type;
    private BoatConfig config;
    private String offerte_date;
    private String expiry_date;

    public OfferteBase(Customer customer, CustomerType client_type, BoatConfig config, String offerte_date, String expiry_date)
    {
        this.customer = customer;
        this.client_type = client_type;
        this.config = config;
        this.offerte_date = offerte_date;
        this.expiry_date = expiry_date;
    }

    public Customer get_client()
    {
        return customer;
    }

    public void set_client(Customer customer) {

        this.customer = customer;
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

    public CustomerType get_client_type()
    {
        return client_type;
    }

    public void set_client_type(CustomerType client_type)
    {
        this.client_type = client_type;
    }
}
