package entities.bootconfig.categories;

import java.util.ArrayList;
import java.util.List;

public class BehuizingOnderdeel extends CategoryBase {

    double price;
    public BehuizingOnderdeel(List<String> behuizing, double price) {
        this.waardes = behuizing;
        this.price = price;
    }

    @Override
    public String get_price() {
        return String.valueOf(this.price);
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
        return String.format("Behuizing: %s %.2f", this.waardes, this.price);
    }
}