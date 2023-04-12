package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParseValidators {

    public static Double parse_price(String input) {
        try {
            Double price = Double.parseDouble(input);
            if (price < 0) {
                throw new IllegalArgumentException("Price must be a positive number.");
            }
            BigDecimal bdPrice = BigDecimal.valueOf(price);
            if (bdPrice.scale() > 2) {
                throw new IllegalArgumentException("Price can have at most 2 decimal places.");
            }
            return bdPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price format: " + input);
        }
    }
}
