package managers;

import entities.bootconfig.BoatConfig;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BoatManagerTest {

    @Test
    void testPrintLoadedConfigs_ShouldPrintLoadedConfigs_WhenCalled() {
    }

    @Test
    void testAddBoatConfig_ShouldAddBoatConfig_WhenCalled() {
    }

    @Test
    void testChangeBoatConfig_ShouldChangeBoatConfig_WhenCalled() {
    }

    @Test
    void testRemoveBoatConfig_ShouldRemoveBoatConfig_WhenCalled() {
    }

    // Test om te kijken of de boot configuratie goed wordt meegekregen
    @Test
    void testContainsBoatConfig_ShouldReturnTrueIfBoatConfigExists_WhenCalled() {
        // Arrange
        BoatConfig config = new BoatConfig("Speedboat", "Speedboat");
        BoatManager.loaded_boat_configurations.put("Speedboat", config);

        // Act
        boolean result1 = BoatManager.contains_boat_config("Speedboat");
        boolean result2 = BoatManager.contains_boat_config("Niet bestaande configuratie");

        // Assert
        assertTrue(result1);
        assertFalse(result2);
    }

    // Test om te kijken of alle boot configuraties worden neergezet
    @Test
    void testGetAllBoatConfigs_ShouldReturnAllBoatConfigs_WhenCalled() {
        // Arrange
        BoatManager.loaded_boat_configurations = new HashMap<>();
        BoatConfig speedboat = new BoatConfig("Speedboat", "Speedboat");
        BoatConfig yacht = new BoatConfig("Yacht", "Yacht");
        BoatManager.loaded_boat_configurations.put("Speedboat", speedboat);
        BoatManager.loaded_boat_configurations.put("Yacht", yacht);

        // Act
        Map<String, BoatConfig> result = BoatManager.get_all_boat_configs();

        Map<String, BoatConfig> expected = new HashMap<>();
        expected.put("Speedboat", speedboat);
        expected.put("Yacht", yacht);

        // Assert
        assertEquals(expected,result);


    }

    // Test om te kijken of de config die we willen opvragen goed wordt opgevraagd
    @Test
    void testGetConfig_ShouldReturnNullIfBoatConfigNotFound_WhenCalled() {
        // Arrange
        BoatManager boatmanager = new BoatManager();

        // Act
        BoatConfig result = boatmanager.get_config("non existent");

        // Assert
        assertEquals(null, result);
    }
}