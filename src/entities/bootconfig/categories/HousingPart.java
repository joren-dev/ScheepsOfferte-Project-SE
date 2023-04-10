package entities.bootconfig.categories;

import java.util.ArrayList;
import java.util.List;

public class HousingPart extends CategoryBase
{
    double price;
    public HousingPart(final List<String> housing, final double price)
    {
        this.values = housing;
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
        return (ArrayList<String>) this.values;
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
        return this.values.contains(category_option);
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
        return String.format("Behuizing: %s %.2f", this.values, this.price);
    }
}
