package managers;

import entities.klant.CustomerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;

class CustomerManagerTest {
    // Test om te kijken of we alle correcte klanttypes terug krijgen
    @Test
    void get_all_client_types_test_should_return_correct_list_of_types_when_called() {
        // Arrange
        ArrayList<CustomerType> client_types_list = new ArrayList<>();
        CustomerManager customerManager = new CustomerManager();

        // Act
        final ArrayList<CustomerType> result = customerManager.get_all_client_types();

        // Assert
        assertEquals(client_types_list, result);
    }

    // Test om te kijken of we alle correcte klanttypes terug krijgen
    @Test
    void test_get_all_client_types_should_return_correct_list_of_types_when_called() {
        // Arrange
        ArrayList<CustomerType> expected = new ArrayList<>();
        CustomerManager customerManager = new CustomerManager();

        // Act
        final ArrayList<CustomerType> result = customerManager.get_all_client_types();

        // Assert
        assertIterableEquals(expected, result);
    }

    // Define a custom subclass of CustomerManager for testing purposes
    static class TestCustomerManager extends CustomerManager {
        TestCustomerManager() {
            // Set the loaded_client_types field directly
            loaded_client_types = new ArrayList<>();
            loaded_client_types.add(new CustomerType("SomeClientType",20));
        }
    }
}