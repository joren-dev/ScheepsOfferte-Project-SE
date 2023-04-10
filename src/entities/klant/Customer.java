package entities.klant;

public class Customer {

    public int discount;
    private String name;
    private String company;
    private String address;
    private String email;
    private String phone_number;
    private CustomerType type;

    public Customer(final String name, final String company, final String address, final String email,
                    final String phone_number, final CustomerType type) {
        this.name = name;
        this.company = company;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
        this.type = type;

    }

    public Customer(final String name, final String address, final String email, final String phone_number,
                    final CustomerType type) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
        this.type = type;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_company() {
        return company;
    }

    public void set_company(String company) {
        this.company = company;
    }

    public String get_address() {
        return address;
    }

    public void set_address(String address) {
        this.address = address;
    }

    public String get_email() {
        return email;
    }

    public void set_email(String email) {
        this.email = email;
    }

    public String get_phone_number() {
        return phone_number;
    }

    public void set_phone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public CustomerType get_client_type() {
        return type;
    }

    public void set_client_type(CustomerType type) {
        this.type = type;
    }

    public int get_client_discount() {
        return type.get_discount();
    }
}
