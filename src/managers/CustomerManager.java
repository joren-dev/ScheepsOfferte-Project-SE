package managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import entities.klant.CustomerType;
import utils.InputValidators;
import utils.ValidationUtils;

public class CustomerManager {

    // Class members
    public static ArrayList<CustomerType> loaded_client_types = new ArrayList<>();

    public CustomerManager() {
        // TODO: Add default client types
        // add_client_type("Overheid klant", 4);
        // add_client_type("Zakelijke klant", 2);
        // add_client_type("Particuliere klant", 0);
    }

    public static void add_client_type() {
        final String client_type_name = InputValidators.request_valid_input(
                "Vul een (valide) klanttype naam in (a-Z): ",
                String::trim,
                ValidationUtils::is_valid_full_name
        );

        final String discount = InputValidators.request_valid_input(
                "Vul in een (valide) procent korting voor dit klanttype (0-100): ",
                String::trim,
                input -> input.matches("^[0-9]{1,2}$")
        );

        for (final CustomerType each : loaded_client_types) {
            if (each.get_type_name().equals(client_type_name)) {
                System.out.println("Deze klanttype bestaat al.");
                return;
            }
        }

        loaded_client_types.add(new CustomerType(client_type_name.toLowerCase(), Integer.parseInt(discount)));
    }

    public static void delete_client_type()
    {
        while (true) {
            print_client_types();

            final String type_name = InputValidators.request_valid_input(
                    "Welk klanttype wilt u verwijderen? (a-Z): ",
                    str -> str,
                    ValidationUtils::is_valid_full_name
            );

            Optional<CustomerType> optionalClientType = loaded_client_types.stream()
                    .filter(client -> client.get_type_name().equalsIgnoreCase(type_name))
                    .findFirst();

            if (optionalClientType.isPresent()) {
                loaded_client_types.remove(optionalClientType.get());
                System.out.println("Klanttype " + type_name + " is verwijderd.");
                return;
            } else {
                System.out.println("Er is geen klanttype met de naam " + type_name + ".");
            }
        }
    }

    public static void edit_client_type() {
        while (true) {
            print_client_types();

            final String client_type_name = InputValidators.request_valid_input(
                    "Welk klanttype wilt u bewerken: ",
                    str -> str,
                    ValidationUtils::is_valid_full_name
            );

            Optional<CustomerType> optional_client_type = CustomerManager.loaded_client_types.stream()
                    .filter(client_type -> client_type.get_type_name().equalsIgnoreCase(client_type_name))
                    .findFirst();

            if (optional_client_type.isPresent()) {
                final String new_client_type_name = InputValidators.request_valid_input(
                        "Nieuwe klanttype naam: ",
                        str -> str,
                        ValidationUtils::is_valid_full_name);

                final int new_client_type_discount = InputValidators.request_valid_choice_in_range(
                        "Nieuwe klanttype korting (0-100): ",
                        Integer::parseInt,
                        0,
                        101); // TODO: find out why this doesnt work, floating-end-point precision maybe

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

    public static void view_client_type()
    {
        System.out.println(Arrays.toString(CustomerManager.loaded_client_types.stream().map(CustomerType::toString).toArray()));
    }
}

