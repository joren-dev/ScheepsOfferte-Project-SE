package managers;

import entities.bootconfig.BoatConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;


class BoatManagerTest {
    // Test om te kijken of de boot configuratie goed wordt meegekregen
    @Test
    void test_contains_boat_config_should_return_true_if_boat_config_exists_when_called() {
        // Arrange
        BoatConfig config = new BoatConfig("Speedboat", "Speedboat");
        BoatManager.loaded_boat_configurations.put("Speedboat", config);

        // Act
        final boolean result1 = BoatManager.contains_boat_config("Speedboat");
        final boolean result2 = BoatManager.contains_boat_config("Niet bestaande configuratie");

        // Assert
        assertTrue(result1);
        assertFalse(result2);
    }

    // Test om te kijken of alle boot configuraties worden neergezet
    @Test
    void test_get_all_boat_configs_should_return_all_boat_configs_when_called() {
        // Arrange
        BoatManager.loaded_boat_configurations = new HashMap<>();
        BoatConfig speedboat = new BoatConfig("Speedboat", "Speedboat");
        BoatConfig yacht = new BoatConfig("Yacht", "Yacht");
        BoatManager.loaded_boat_configurations.put("Speedboat", speedboat);
        BoatManager.loaded_boat_configurations.put("Yacht", yacht);

        // Act
        final Map<String, BoatConfig> result = BoatManager.get_all_boat_configs();

        final Map<String, BoatConfig> expected = new HashMap<>();
        expected.put("Speedboat", speedboat);
        expected.put("Yacht", yacht);

        // Assert
        assertEquals(expected,result);


    }

    // Test om te kijken of de config die we willen opvragen goed wordt opgevraagd
    @Test
    void test_get_config_should_return_null_if_boat_config_not_found_when_called() {
        // Arrange
        final BoatManager boatmanager = new BoatManager();

        // Act
        final BoatConfig result = boatmanager.get_config("non existent");

        // Assert
        assertEquals(null, result);
    }
}