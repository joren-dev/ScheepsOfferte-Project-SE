package entities.klant;


public class Customer {
    private String name;
    private String company;
    private String address;
    private String email;
    private String phone_number;
    private CustomerType customer_type;

    public Customer(final String name, final String company, final String address, final String email,
                    final String phone_number, final CustomerType customer_type) {
        this.name = name;
        this.company = company;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
        this.customer_type = customer_type;
    }

    public Customer(final String name, final String address, final String email, final String phone_number,
                    final CustomerType customer_type) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
        this.customer_type = customer_type;
    }

    public String get_name() {
        return name;
    }

    public String get_address() {
        return address;
    }

    public String get_email() {
        return email;
    }

    public String get_phone_number() {
        return phone_number;
    }

    public int get_client_discount() {
        return customer_type.get_discount();
    }
}
