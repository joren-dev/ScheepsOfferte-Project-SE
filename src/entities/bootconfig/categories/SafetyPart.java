package entities.bootconfig.categories;

import java.util.ArrayList;
import java.util.List;


public class SafetyPart extends CategoryBase {
    public SafetyPart(final List<String> options, final double price)
    {
        super(options, price);
    }

    @Override
    public void remove(String option)
    {
        this.values.remove(option);
    }

    @Override
    public boolean contains(String category_option)
    {
        return this.values.contains(category_option);
    }

    @Override
    public void add(String chosen_option)
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
        return String.format("Veiligheid | %s | ", this.values);
    }
}
