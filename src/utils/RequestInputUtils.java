package utils;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class RequestInputUtils {
    public static <T> T request_data(final String prompt, final Function<String, T> parser, final Predicate<T> validator) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(prompt);
            final String input = scanner.nextLine();

            try {
                T value = parser.apply(input);

                if (validator.test(value))
                    return value;

                System.out.println("Ongeldige invoer. Probeer opnieuw.");

            } catch (final Exception e) {
                System.out.println("Ongeldige invoer. Probeer opnieuw.");
            }
        }
    }

}
