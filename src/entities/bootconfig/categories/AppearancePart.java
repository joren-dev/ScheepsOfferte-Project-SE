package entities.bootconfig.categories;


import java.util.ArrayList;
import java.util.List;


public class AppearancePart extends CategoryBase
{
    double price;

    public AppearancePart(final List<String> options, final double price)
    {
        this.values = options;
        this.price = price;
    }

    @Override
    public String get_price()
    {
        return String.valueOf(this.price);
    }

    @Override
    public ArrayList<String> get_values()
    {
        return new ArrayList<>(this.values);
    }

    @Override
    public int get_option_amount()
    {
        return this.values.size();
    }

    @Override
    public void remove(final String option)
    {
        this.values.remove(option);
    }

    @Override
    public boolean contains(final String category_option)
    {
        return category_option.equals("Uiterlijk");
    }

    @Override
    public void add(final String chosen_option)
    {
        this.values.add(chosen_option);
    }

    @Override
    public boolean isEmpty()
    {
        return this.values.isEmpty();
    }

    @Override
    public String toString()
    {
        return String.format("Uiterlijk: %s %.2f", this.values, this.price);
    }
}