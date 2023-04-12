package entities.klant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTypeTest {

    // Test om te kijken of het type naam van de klanttype goed in de klanttype wordt gezet
    @Test
    void testGetTypeName() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        String result = customerType.get_type_name();

        // Assert
        assertEquals("CEO", result);
    }

    // Test om te kijken of de aanpassing van de klanttype naam goed wordt aangepast
    @Test
    void testSetTypeName() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        customerType.set_type_name("Sales");

        // Assert
        assertEquals("Sales", customerType.get_type_name());
    }

    // Test om te kijken of de korting die we hebben ingevuld goed wordt meegekregen
    @Test
    void testGetDiscount() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        int result = customerType.get_discount();

        // Arrange
        assertEquals(60, result);
    }

    // Test om te kijken of de korting die we aanpassen goed wordt aangepast
    @Test
    void testSetDiscount() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        customerType.set_discount(20);

        // Assert
        assertEquals(20, customerType.get_discount());
    }

    // Test om te kijken of de aanpassing van klanttype naar string-type goed wordt omgezet.
    @Test
    void testToString() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        String result = customerType.toString();

        // Assert
        assertEquals("Huidige waardes: naam=CEO korting=60", result);
    }
}