package entities.klant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    // Hier
    @Test
    void testGetName() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        String result = customer.get_name();

        // Assert
        assertEquals("Rico", result);
    }

    @Test
    void testSetName() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        customer.set_name("Karel");

        // Assert
        assertEquals("Karel", customer.get_name());

    }

    @Test
    void testGetCompany() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        String result = customer.get_company();

        // Assert
        assertEquals("Google", result);
    }

    @Test
    void testSetCompany() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        customer.set_company("Apple");

        // Assert
        assertEquals("Apple", customer.get_company());
    }

    @Test
    void testGetAddress() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        String result = customer.get_address();

        // Assert
        assertEquals("Den Haag", result);
    }

    @Test
    void testSetAddress() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        customer.set_address("New York");

        // Assert
        assertEquals("New York", customer.get_address());

    }

    @Test
    void testGetEmail() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        String result = customer.get_email();

        // Assert
        assertEquals("Rico@outlook.com", result);
    }

    @Test
    void testSetEmail() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        customer.set_email("Rico@apple.com");

        // Assert
        assertEquals("Rico@apple.com", customer.get_email());
    }

    @Test
    void testGetPhoneNumber() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        String result = customer.get_phone_number();

        // Assert
        assertEquals("0612121212", result);
    }

    @Test
    void testSetPhoneNumber() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        customer.set_phone_number("0676543210");

        // Assert
        assertEquals("0676543210", customer.get_phone_number());
    }

    @Test
    void testGetClientType() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);

        // Act
        CustomerType result = customer.get_client_type();

        // Assert
        assertEquals(customerType, result);
    }

    @Test
    void testSetClientType() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);
        Customer customer = new Customer("Rico", "Google", "Den Haag", "Rico@outlook.com", "0612121212", customerType);
        CustomerType newType = new CustomerType("Digital Marketing", 15);

        // Act
        customer.set_client_type(newType);

        // Assert
        assertEquals(newType, customer.get_client_type());
    }

    @Test
    void testGetClientDiscount() {
        // Arrange
        CustomerType customerType = new CustomerType("CEO", 60);

        // Act
        int result = customerType.get_discount();

        // Assert
        assertEquals(60, result);
    }
}
