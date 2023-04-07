package entities.bootconfig.categories;

import java.util.ArrayList;
import java.util.List;


public class MotorOnderdeel extends CategoryBase
{
    double price;

    public MotorOnderdeel(List<String> options, double price) {
        if (options == null) {
            throw new RuntimeException("OOPS");
        }
        this.waardes = options;
        this.price = price;
    }

    @Override
    public String get_price()
    {
        return String.valueOf(this.price);
    }

    @Override
    public void printOptions() {
        for (String option : this.waardes) {
            System.out.println(option);
        }
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
        return categoryOption.equalsIgnoreCase("motor");
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
        return String.format("Motor: %s %.2f", this.waardes, this.price);
    }

    // set_dubbele_motor(boolean)
}
