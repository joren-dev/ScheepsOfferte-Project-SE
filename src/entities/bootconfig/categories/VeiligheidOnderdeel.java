package entities.bootconfig.categories;

import entities.bootconfig.BootConfigBase;

import java.util.ArrayList;
import java.util.List;

public class VeiligheidOnderdeel extends CategoryBase {
    double price;

    public VeiligheidOnderdeel(List<String> veiligheid, double price) {
        this.waardes = veiligheid;
        this.price = price;
    }

    @Override
    public String get_price() {
        return String.valueOf(this.price);
    }

    @Override
    public void printOptions() {
        System.out.println(this.waardes);
    }

    @Override
    public ArrayList<String> getWaardes() {
        return (ArrayList<String>) this.waardes;
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
        return this.waardes.contains(categoryOption);
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
        return String.format("Veiligheid: %s %.2f", this.waardes, this.price);
    }
}
