package entities.bootconfig.categories;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppearancePartTest {

    @Test
    void testGetPrice() {
        // Arrange
        AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);

        // Act
        String result = appearancePart.get_price(); // TODO: Waarom levert dit een string op??

        // Assert
        assertEquals("20.0", result);
    }

    @Test
    void testGetValues() {
        // Arrange
        AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);

        // Act
        ArrayList<String> result = appearancePart.get_values();

        // Assert
        assertEquals(List.of("Biologische verf"), result);
    }

    @Test
    void testGetOptionAmount() {
    }

    @Test
    void testRemove() {
    }

    // TODO: Waarom is de contains methode zo geschreven?
//    @Test
//    void testContains() {
//        // Arrange
//        AppearancePart appearancePart = new AppearancePart(List.of("Biologische verf"), 20.0);
//
//        // Act
//        boolean first = appearancePart.contains("Biologische verf");
//        boolean second = appearancePart.contains("LED verlichting");
//
//        // Assert
//        assertTrue(first);
//        assertFalse(second);
//    }

    @Test
    void testAdd() {
    }

    @Test
    void testIsEmpty() {
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
    void testToString() {
    }
}