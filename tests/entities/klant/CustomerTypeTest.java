package entities.klant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTypeTest {

    // Test om te kijken of het type naam van de klanttype goed in de klanttype wordt gezet
    @Test
    void testGetTypeName_ShouldReturnTypeName_WhenCalled() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        String result = customerType.get_type_name();

        // Assert
        assertEquals("CEO", result);
    }

    // Test om te kijken 9f de haaj goed gezet wordt
    @Test
    void testSetTypeName_ShouldSetTypeName_WhenCalled() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        customerType.set_type_name("Sales");

        // Assert
        assertEquals("Sales", customerType.get_type_name());
    }

    // Test om te kijken of de korting goed wordt meegekregen
    @Test
    void testGetDiscount_ShouldReturnDiscount_WhenCalled() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        int result = customerType.get_discount();

        // Arrange
        assertEquals(60, result);
    }

    // Test om te kijken of de korting wordt gezet
    @Test
    void testSetDiscount_ShouldSetDiscount_WhenCalled() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        customerType.set_discount(20);

        // Assert
        assertEquals(20, customerType.get_discount());
    }

    // Test om te kijken of de Klantenttype goed wordt gezet
    @Test
    void testToString_ShouldConvertCustomerTypeToString_WhenCalled() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        String result = customerType.toString();

        // Assert
        assertEquals("Huidige waardes: naam=CEO korting=60", result);
    }

}