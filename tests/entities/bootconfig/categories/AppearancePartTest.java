package entities.bootconfig.categories;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AppearancePartTest {
        // Test om te controleren of de get_price methode de juiste String retourneert
        @Test
        void test_get_price_returns_correct_str() {
            // Arrange
            AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);

            // Act
            final String result = appearancePart.get_price();

            // Assert
            assertEquals("20.0", result);
        }

        // Test om te controleren of de values die we krijgen geldig zijn en correct worden geretourneerd
        @Test
        void test_getValues_returns_valid_and_correct_list() {
            // Arrange
            AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);

            // Act
            final ArrayList<String> result = appearancePart.get_values();

            // Assert
            assertEquals(List.of("Biologische verf"), result);
        }

        // Test om te controleren of de optie goed wordt opgeslagen
        @Test
        void test_contains_returns_correct_containing() {
            // Arrange
            AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);

            // Act
            final boolean first = appearancePart.contains("Uiterlijk");
            final boolean second = appearancePart.contains("Motor");

            // Assert
            assertTrue(first);
            assertFalse(second);
        }

        // Test om te controleren of de appearance list correct wordt geretourneerd
        @Test
        void test_is_empty_returns_correct_value() {
            // Arrange
            AppearancePart appearancePart1 = new AppearancePart(List.of("Biologische verf"), 20.0);
            AppearancePart appearancePart2 = new AppearancePart(List.of(), 0.0);

            // Act
            final boolean result1 = appearancePart1.isEmpty();
            final boolean result2 = appearancePart2.isEmpty();

            // Assert
            assertFalse(result1);
            assertTrue(result2);
        }
    }