package entities.bootconfig.categories;

import java.util.ArrayList;
import java.util.List;


public abstract class CategoryBase {
    public List<String> values;
    double price;

    public CategoryBase(final List<String> options, final double price)
    {
        this.values = options;
        this.price = price;
    }

    public abstract String get_price();

    public void print_options()
    {
        System.out.println(this.values);
    }

    public abstract ArrayList<String> get_values();

    public abstract int get_option_amount();

    public abstract void remove(final String option);

    public abstract boolean contains(final String category_option);

    public abstract void add(final String chosen_option);

    public abstract boolean isEmpty();

    public abstract String toString();

    public String offerte_format_str()
    {
        return String.format("Uiterlijk | %s | %.2f", this.values, this.price);
    }
}
