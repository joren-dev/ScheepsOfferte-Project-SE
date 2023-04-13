package entities.klant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    // Test om te kijken of de naam goed returned wanner hij wordt aangevraagd
    @Test
    void test_get_type_name_should_return_type_name_when_called() {
        // Arrange
        final CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        final String result = customerType.get_type_name();

        // Assert
        assertEquals("CEO", result);
    }

    // Test om te kijken of de naam goed geset wordt
    @Test
    void test_set_type_name_should_set_type_name_when_called() {
        // Arrange
        final CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        customerType.set_type_name("Sales");

        // Assert
        assertEquals("Sales", customerType.get_type_name());
    }

    // Test om te kijken of de korting goed wordt aangevraagd
    @Test
    void test_get_discount_should_return_discount_when_called() {
        // Arrange
        final CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        final int result = customerType.get_discount();

        // Arrange
        assertEquals(60, result);
    }

    // Test om te kijken of de korting goed wordt gezet
    @Test
    void test_set_discount_should_set_discount_when_called() {
        // Arrange
        final CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        customerType.set_discount(20);

        // Assert
        assertEquals(20, customerType.get_discount());
    }

    // Test om te kijken de klanten informatie goed omgezet wordt naar een String output
    @Test
    void test_to_string_should_convert_customer_type_to_string_when_called() {
        // Arrange
        final CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        final String result = customerType.toString();

        // Assert
        assertEquals("Huidige waardes: naam=CEO korting=60", result);
    }
}
