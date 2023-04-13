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
        final ArrayList<CustomerType> client_types_list = new ArrayList<>();
        final CustomerManager customerManager = new CustomerManager();

        // Act
        final ArrayList<CustomerType> result = customerManager.get_all_client_types();

        // Assert
        assertEquals(client_types_list, result);
    }

    // Test om te kijken of we alle correcte klanttypes terug krijgen
    @Test
    void test_get_all_client_types_should_return_correct_list_of_types_when_called() {
        // Arrange
        final ArrayList<CustomerType> expected = new ArrayList<>();
        final CustomerManager customerManager = new CustomerManager();

        // Act
        final ArrayList<CustomerType> result = customerManager.get_all_client_types();

        // Assert
        assertIterableEquals(expected, result);
    }
}