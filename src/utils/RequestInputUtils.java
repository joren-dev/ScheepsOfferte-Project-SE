package utils;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class RequestInputUtils {
    public static <T> T request_raw_data(final String prompt, final Function<String, T> parser, final Predicate<T> validator) {
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

    public static <T extends Comparable<T>> T request_valid_choice(
            final String prompt, final Function<String, T> parser, final T min, final T max) {

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(prompt);
            final String input = scanner.nextLine();

            try {
                final T value = parser.apply(input);

                if (min.compareTo(value) <= 0 && max.compareTo(value) >= 0)
                    return value;

                System.out.printf("Ongeldige invoer. Voer een getal tussen %s en %s in.\n", min, max);
            } catch (final Exception e) {
                System.out.printf("Ongeldige invoer. Voer een getal tussen %s en %s in.\n", min, max);
            }
        }
    }
}
