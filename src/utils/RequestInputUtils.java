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

    public static <T, MIN extends Comparable<MIN>, MAX extends Comparable<MAX>> T request_valid_choice(
            String prompt, Function<String, T> parser, MIN min, MAX max) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                T value = parser.apply(input);
                if (value instanceof Comparable) {
                    Comparable<MIN> cmin = (MIN) min;
                    Comparable<MAX> cmax = (MAX) max;
                    if (cmin.compareTo((MIN) value) <= 0 && cmax.compareTo((MAX) value) >= 0) {
                        return value;
                    }
                }
                System.out.printf("Ongeldige invoer. Voer een getal tussen %s en %s in.\n", min, max);
            } catch (Exception e) {
                System.out.printf("Ongeldige invoer. Voer een getal tussen %s en %s in.\n", min, max);
            }
        }
    }

}
