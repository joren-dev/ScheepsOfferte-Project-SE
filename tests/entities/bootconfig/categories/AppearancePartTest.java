package entities.bootconfig.categories;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppearancePartTest {
        // Test om te controleren of de get_price methode de juiste String retourneert
        @Test
        void test_getPrice_returnsCorrectString() {
            // Arrange
            AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);

            // Act
            String result = appearancePart.get_price();

            // Assert
            assertEquals("20.0", result);
        }

        // Test om te controleren of de values die we krijgen geldig zijn en correct worden geretourneerd
        @Test
        void test_getValues_returnsValidAndCorrectList() {
            // Arrange
            AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);

            // Act
            ArrayList<String> result = appearancePart.get_values();

            // Assert
            assertEquals(List.of("Biologische verf"), result);
        }

        @Test
        void test_getOptionAmount() {
        }

        @Test
        void test_remove() {
        }

        // Test om te controleren of de optie goed wordt opgeslagen
        @Test
        void test_contains_returnsCorrectContaining() {
            // Arrange
            AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);

            // Act
            boolean first = appearancePart.contains("Uiterlijk");
            boolean second = appearancePart.contains("Motor");

            // Assert
            assertTrue(first);
            assertFalse(second);
        }

        @Test
        void test_add() {
        }

        // Test om te controleren of de appearance list correct wordt geretourneerd
        @Test
        void test_isEmpty_returnsCorrectValue() {
            // Arrange
            AppearancePart appearancePart1 = new AppearancePart(List.of("Biologische verf"), 20.0);
            AppearancePart appearancePart2 = new AppearancePart(List.of(), 0.0);

            // Act
            boolean result1 = appearancePart1.isEmpty();
            boolean result2 = appearancePart2.isEmpty();

            // Assert
            assertFalse(result1);
            assertTrue(result2);
        }

        @Test
        void test_toString() {
        }
    }