package entities.bootconfig.categories;

import java.util.ArrayList;
import java.util.List;


public class MotorPart extends CategoryBase {
    public MotorPart(final List<String> options, final double price) {
        super(options, price);
    }

    @Override
    public void remove(final String option) {
        this.values.remove(option);
    }

    @Override
    public boolean contains(final String category_option) {
        return category_option.equalsIgnoreCase("motor");
    }

    @Override
    public void add(final String chosen_option) {
        this.values.add(chosen_option);
    }

    @Override
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Motor | %s | ", this.values);
    }
}
