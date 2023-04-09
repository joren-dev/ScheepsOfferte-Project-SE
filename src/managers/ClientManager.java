package managers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import entities.klant.ClientType;

public class ClientManager {

    // Class members
    public static ArrayList<ClientType> loaded_client_types = new ArrayList<>();

    public ClientManager()
    {
        // Default client types
        add_client_type("Overheid klant", 4);
        add_client_type("Zakelijke klant", 2);
        add_client_type("Particuliere klant", 0);
    }

    public static void add_client_type(final String type_name, final int discount)
    {
        for (final ClientType each : loaded_client_types) {
            if (each.get_type_name().equals(type_name)) {
                System.out.println("Deze klanttype bestaat al.");
                return;
            }
        }

        loaded_client_types.add(new ClientType(type_name.toLowerCase(), discount));
    }

    public static void delete_client_type(final String type_name)
    {
        ClientManager.loaded_client_types.removeIf((x) -> x.get_type_name().equals(type_name.toLowerCase()));
    }

    public static void change_client_type(final String client_type_name)
    {
        Scanner scanner = new Scanner(System.in);

        Optional<ClientType> optional_client_type = ClientManager.loaded_client_types.stream().filter((client_type) -> client_type.get_type_name().equals(client_type_name.toLowerCase())).findFirst();
        System.out.println(optional_client_type.get());

        System.out.print("Nieuwe klanttype naam: ");
        String new_client_type_name = scanner.nextLine();

        System.out.print("Nieuwe klanttype korting: ");
        final int new_client_type_discount = scanner.nextInt();
        scanner.nextLine();

        if (optional_client_type.isPresent())
        {
            // Reference naar object in arraylist
            ClientType client_type = optional_client_type.get();

            client_type.set_type_name(new_client_type_name);
            client_type.set_discount(new_client_type_discount);
        }
    }

    public static ArrayList<ClientType> get_all_client_types()
    {
        return loaded_client_types;
    }

    public static boolean contains_client_type(final String client_type_name)
    {
        for (final ClientType client_type : loaded_client_types) {
            if (client_type.get_type_name().equals(client_type_name))
                return true;
        }

        return false;
    }

    public static void print_client_types()
    {
        for (final ClientType client_type : loaded_client_types)
            System.out.println("- " + client_type.get_type_name());
    }

    public static ClientType get_client_type(final String client_type_name)
    {

        for (final ClientType client_type : loaded_client_types) {
            if (client_type.get_type_name().equals(client_type_name))
                return client_type;
        }

        return null;
    }

}

