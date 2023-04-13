package entities.offerte;

import entities.bootconfig.BoatConfig;
import entities.klant.Customer;
import entities.klant.CustomerType;


public abstract class OfferteBase {
    private Customer customer;
    private BoatConfig config;
    private String offerte_date;
    private String expiry_date;

    public OfferteBase(Customer customer, BoatConfig config, String offerte_date, String expiry_date)
    {
        this.customer = customer;
        this.config = config;
        this.offerte_date = offerte_date;
        this.expiry_date = expiry_date;
    }

    public Customer get_customer()
    {
        return customer;
    }

    public BoatConfig get_config()
    {
        return config;
    }

    public String get_offerte_date()
    {
        return offerte_date;
    }

    public String get_expiry_date()
    {
        return expiry_date;
    }
}
