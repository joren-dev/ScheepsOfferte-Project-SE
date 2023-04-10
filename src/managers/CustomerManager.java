package managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import entities.klant.CustomerType;
import utils.RequestInputUtils;
import utils.ValidationUtils;

public class CustomerManager {

    // Class members
    public static ArrayList<CustomerType> loaded_client_types = new ArrayList<>();

    public CustomerManager() {
        // Default client types
        // add_client_type("Overheid klant", 4);
        // add_client_type("Zakelijke klant", 2);
        // add_client_type("Particuliere klant", 0);
    }

    public static void add_client_type() {
        Scanner scanner = new Scanner(System.in);

        String client_type_name = "";
        while (!client_type_name.matches("^[a-zA-Z][a-zA-Z ]*$")) {
            System.out.print("Vul een (valide) klanttype naam in (a-Z): ");
            client_type_name = scanner.nextLine();
        }

        String discount = "";
        while (!discount.matches("^[0-9]{1,2}$")) {
            System.out.print("Vul in een (valide) procent korting voor dit klanttype (0-100): ");
            discount = scanner.nextLine();
        }

        for (final CustomerType each : loaded_client_types) {
            if (each.get_type_name().equals(client_type_name)) {
                System.out.println("Deze klanttype bestaat al.");
                return;
            }
        }

        loaded_client_types.add(new CustomerType(client_type_name.toLowerCase(), Integer.parseInt(discount)));
    }

    public static void delete_client_type() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welk klanttype wilt u verwijderen?");
            System.out.println(Arrays.toString(loaded_client_types.stream().map(CustomerType::get_type_name).toArray()));

            System.out.print("Maak uw keuze: ");
            final String type_name = scanner.nextLine();

            for (CustomerType client_type : loaded_client_types) {
                if (!client_type.get_type_name().equals(type_name))
                    continue;

                loaded_client_types.removeIf((x) -> x.get_type_name().equals(type_name.toLowerCase()));
                return;
            }
        }
    }

    public static void edit_client_type() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welk klanttype wilt u bewerken?");
            System.out.println(Arrays.toString(CustomerManager.loaded_client_types.stream().map(CustomerType::get_type_name).toArray()));

            final String client_type_name = RequestInputUtils.request_raw_data(
                    "Welk klanttype wilt u bewerken?",
                    str -> str,
                    ValidationUtils::is_valid_full_name
            );

            Optional<CustomerType> optional_client_type = CustomerManager.loaded_client_types.stream()
                    .filter(client_type -> client_type.get_type_name().equalsIgnoreCase(client_type_name))
                    .findFirst();

            if (optional_client_type.isPresent()) {
                final String new_client_type_name = RequestInputUtils.request_raw_data(
                        "Nieuwe klanttype naam: ",
                        str -> str,
                        ValidationUtils::is_valid_full_name);

                final int new_client_type_discount = RequestInputUtils.request_valid_choice(
                        "Nieuwe klanttype korting (0-100): ",
                        Integer::parseInt,
                        0,
                        100);

                CustomerType client_type = optional_client_type.get();
                client_type.set_type_name(new_client_type_name);
                client_type.set_discount(new_client_type_discount);

                return;
            } else {
                System.out.println("Geen klanttype gevonden met de opgegeven naam.");
            }
        }
    }

    public static ArrayList<CustomerType> get_all_client_types() {
        return loaded_client_types;
    }

    public static boolean contains_client_type(final String client_type_name) {
        for (final CustomerType client_type : loaded_client_types) {
            if (client_type.get_type_name().equals(client_type_name))
                return true;
        }

        return false;
    }

    public static void print_client_types() {
        for (final CustomerType client_type : loaded_client_types)
            System.out.println("- " + client_type.get_type_name());
    }

    public static CustomerType get_client_type(final String client_type_name) {

        for (final CustomerType client_type : loaded_client_types) {
            if (client_type.get_type_name().equals(client_type_name))
                return client_type;
        }

        return null;
    }

    public static void view_client_type() {
        System.out.println(Arrays.toString(CustomerManager.loaded_client_types.stream().map(CustomerType::toString).toArray()));
    }
}

