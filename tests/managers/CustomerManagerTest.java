package managers;

import entities.klant.CustomerType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerManagerTest {

    @Test
    void add_client_type_test_ShouldAddClientTypeToManager_WhenCalled() {
    }

    @Test
    void delete_client_type_test_ShouldDeleteClientTypeFromManager_WhenCalled() {
    }

    @Test
    void edit_client_type_test_ShouldEditClientTypeInManager_WhenCalled() {
    }

    // Test om te kijken of we alle correcte klanttypes terug krijgen
    @Test
    void get_all_client_types_test_ShouldReturnCorrectListOfTypes_WhenCalled() {
        // Arrange
        ArrayList<CustomerType> client_types_list = new ArrayList<>();
        CustomerManager customerManager = new CustomerManager();

        // Act
        ArrayList<CustomerType> result = customerManager.get_all_client_types();

        // Assert
        assertEquals(client_types_list, result);
    }

    // Test om te kijken of we alle correcte klanttypes terug krijgen
    @Test
    void testGetAllClientTypes_ShouldReturnCorrectListOfTypes_WhenCalled() {
        // Arrange
        ArrayList<CustomerType> expected = new ArrayList<>();
        CustomerManager customerManager = new CustomerManager();

        // Act
        ArrayList<CustomerType> result = customerManager.get_all_client_types();

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

    @Test
    void print_client_types_test_ShouldPrintClientTypes_WhenCalled() {
    }

    @Test
    public void testGetClientType_ShouldReturnCorrectTypeName_WhenGivenValidInput() {
    }
}