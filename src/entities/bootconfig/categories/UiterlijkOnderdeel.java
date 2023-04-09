package entities.bootconfig.categories;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UiterlijkOnderdeel extends CategoryBase implements Serializable
{
    double price;

    public UiterlijkOnderdeel(List<String> options, double price) {
        if (options == null)
            throw new RuntimeException("Options was null");

        this.waardes = options;
        this.price = price;
    }

    @Override
    public String get_price()
    {
        return String.valueOf(this.price);
    }

    @Override
    public ArrayList<String> getWaardes() {
        return new ArrayList<>(this.waardes);
    }

    @Override
    public int getNrOfOptions() {
        return this.waardes.size();
    }

    @Override
    public void remove(String option) {
        this.waardes.remove(option);
    }

    @Override
    public boolean contains(String categoryOption) {
        return categoryOption.equals("Uiterlijk");
    }

    @Override
    public void add(String gekozenOptie) {
        this.waardes.add(gekozenOptie);
    }

    @Override
    public boolean isEmpty() {
        return this.waardes.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Uiterlijk: %s %.2f", this.waardes, this.price);
    }

    // set_verf
    // ...
}
