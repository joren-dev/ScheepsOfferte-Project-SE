package entities.bootconfig;

import entities.bootconfig.categories.*;

import java.util.HashMap;
import java.util.Map;


public class BoatConfig
{
    private String boat_name;
    private String boat_type;

    // Defines standard categories for a configuration.
    public static Map<String, CategoryBase> categories = new HashMap<>();

    public BoatConfig(String boat_name, String boat_type)
    {
        this.boat_name = boat_name;
        this.boat_type = boat_type;
    }

    public String get_boat_type()
    {
        return this.boat_type;
    }

    public void print_all_options()
    {
        for(CategoryBase category : categories.values())
            category.print_options();
    }

    public String toString()
    {
        final StringBuilder formatted_options = new StringBuilder();

        for (final CategoryBase option : categories.values())
            formatted_options.append(option.toString()).append("\n");

        return String.format("Naam (Boot type): %s (%s)%n%s", this.boat_name, this.boat_type, formatted_options);
    }

    public void add_category(final String category_name, final CategoryBase category)
    {
        categories.put(category_name, category);
    }

    public static CategoryBase get_category(final String category_name)
    {
        return categories.get(category_name);
    }
}




