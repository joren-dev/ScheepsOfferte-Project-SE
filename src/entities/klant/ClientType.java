package entities.klant;

public class ClientType {
    private String type_name;
    private int discount;

    public ClientType(final String type_name, final int discount) {
        this.discount = discount;
        this.type_name = type_name;
    }

    public String get_type_name() {
        return type_name;
    }

    public void set_type_name(final String type_name) {
        this.type_name = type_name;
    }

    public int get_discount() {
        return discount;
    }

    public void set_discount(final int discount) {
        this.discount = discount;
    }

    public String toString() {
        return String.format("Huidige waardes: naam=%s korting=%d", this.type_name, this.discount);
    }
}
