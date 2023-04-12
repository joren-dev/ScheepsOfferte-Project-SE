package entities.klant;

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

    // Test om te kijken of de name methode van de Customer klasse de naam goed instelt, en daarna kijken of hij hem goed aanpast.
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

    // Test om te kijken of het bedrijf wat wij invoeren in klant ook een correcte get output terug geeft.
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

    // Test om te kijken of de Company die we eerst hebben erin gezet goed wordt aangepast en doorgezet.
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

    // Test om te kijken of het adress wat wij als klant meegeven goed wordt verwerkt.
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

    // Test om te kijken of de klant die we eerst van klant hebben goed wordt veranderd.
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

    // Test om te kijken of de email die we krijgen van de klant goed wordt afgelezen
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

    // Test om te kijken of we de verandering van een email goed aanpassen
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

    // Test om te kijken of we de telefoonnummer die we krijgen van de klant goed meenemen.
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

    // Test om te kijken of we de telefoonnummer die we veranderd hebben goed wordt aangepast
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

    // Test om te kijken of klanttype goed wordt meegekregen
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

    // Test om te kijken of de klanttype die we hebben aangepast goed wordt meegenomen
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

    // Test om te kijken of de korting die we hebben ingevuld goed erin wordt gezet
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
