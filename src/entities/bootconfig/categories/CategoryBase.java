package entities.bootconfig.categories;

import java.util.ArrayList;
import java.util.List;

public abstract class CategoryBase {
    public List<String> waardes;

    public abstract String get_price();

    public void printOptions()
    {
        System.out.println(this.waardes);
    }

    public abstract ArrayList<String> getWaardes();

    public abstract int getNrOfOptions();

    public abstract void remove(String option);

    public abstract boolean contains(String categoryOption);

    public abstract void add(String gekozenOptie);

    public abstract boolean isEmpty();

    public abstract String toString();
    // setters

}
