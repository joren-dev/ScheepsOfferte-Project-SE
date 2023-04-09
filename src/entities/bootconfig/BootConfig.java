package entities.bootconfig;

import entities.bootconfig.categories.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// this one is saved in the map in BootManager
public class BootConfig {

    private String boat_name;
    private String boat_type;
    private Map<String, CategoryBase> options = new HashMap<>();

    public BootConfig(String boat_name, String boat_type)
    {
        this.boat_name = boat_name;
        this.boat_type = boat_type;

    }

    public String get_boat_type() {
        return this.boat_type;
    }

    public void print_all_options()
    {
        for(CategoryBase category : options.values())
            category.printOptions();
    }

    public String toString() {
        StringBuilder formatted_options = new StringBuilder();

        for (CategoryBase option : options.values())
            formatted_options.append(option.toString()).append("\n");

        return String.format("Naam (Boot type): %s (%s)%n%s", this.boat_name, this.boat_type, formatted_options);
    }

    public void add_category(String category_name, CategoryBase category)
    {
        options.put(category_name, category);
    }

    // Defines standard categories for a configuration.
    public static Map<String, CategoryBase> categories = new HashMap<>();

    /*
     {{
        put("Behuizing", new BehuizingOnderdeel(List.of(), 0.0));
        put("Extras", new ExtrasOnderdeel(List.of(), 0.0));
        put("Motor", new MotorOnderdeel(List.of(), 0.0));
        put("Uiterlijk", new UiterlijkOnderdeel(List.of(), 0.0));
        put("Veiligheid", new VeiligheidOnderdeel(List.of(), 0.0));
    }}
    */


    public void save(String file_name){
        File file = new File(file_name);

        try {
            FileWriter writer = new FileWriter(file);

            String content = "";
            for (Map.Entry<String, CategoryBase> entry : this.options.entrySet()) {
                content += String.format("%s:%s", entry.getKey(), entry.getValue().waardes);
            }

            content = String.format("%s%n%s%n%s", this.boat_name, this.boat_type, content);;
            writer.write(content);

            writer.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void viewSavedFile(String file_name){
        File file = new File(file_name);
        try {
            FileReader reader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
