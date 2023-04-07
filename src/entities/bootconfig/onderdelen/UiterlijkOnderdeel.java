package entities.bootconfig.onderdelen;

<<<<<<< HEAD:src/entities/bootconfig/UiterlijkOnderdeel.java
import java.util.ArrayList;
import java.util.List;

public class UiterlijkOnderdeel extends BootConfigBase
=======
public class UiterlijkOnderdeel extends OnderdeelBase
>>>>>>> 7388aab989569174f900a2946bfdad6f65d04041:src/entities/bootconfig/onderdelen/UiterlijkOnderdeel.java
{
    double price;

    public UiterlijkOnderdeel(List<String> options, double price) {
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
