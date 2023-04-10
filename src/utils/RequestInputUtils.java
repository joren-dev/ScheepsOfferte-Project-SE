package utils;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class RequestInputUtils {
    public static <T> T request_data(String prompt, Function<String, T> parser, Predicate<T> validator) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                T value = parser.apply(input);
                if (validator.test(value)) {
                    return value;
                }
                System.out.println("Ongeldige invoer. Probeer opnieuw.");
            } catch (Exception e) {
                System.out.println("Ongeldige invoer. Probeer opnieuw.");
            }
        }
    }

}
