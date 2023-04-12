package managers;

import entities.bootconfig.BoatConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatManagerTest {

    @Test
    void testPrintLoadedConfigs() {
    }

    @Test
    void testAddBoatConfig() {
    }

    @Test
    void testChangeBoatConfig() {
    }

    @Test
    void testRemoveBoatConfig() {
    }

    @Test
    void testContainsBoatConfig() {
    }

    @Test
    void testGetAllBoatConfigs() {
        BoatManager boatManager = new BoatManager();


    }

    // Test om te kijken of de config die we willen opvragen goed wordt opgevraagd
    @Test
    void testGetConfig() {
        // Arrange
        BoatManager boatmanager = new BoatManager();

        // Act
        BoatConfig result = boatmanager.get_config("non existent");

        // Assert
        assertEquals(null, result);
    }
}