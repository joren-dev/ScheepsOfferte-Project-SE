package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean is_valid_name(final String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean is_valid_address(final String address) {
        final String regex = "^[a-zA-Z]+\\s\\d+[a-zA-Z]*\\s*,\\s*\\d{4}[a-zA-Z]{2},\\s*[a-zA-Z ]+$";
        return address.matches(regex);
    }

    public static boolean is_valid_offerte_number(final String invoiceNumber)
    {
        final String regex = "^\\d*$";
        return invoiceNumber.matches(regex);
    }

    public static boolean is_valid_email(final String email) {
        if (email == null || email.isEmpty())
            return false;

        // Regex pattern to check if email address is valid
        final String pattern = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$";

        final Pattern regex = Pattern.compile(pattern);
        final Matcher matcher = regex.matcher(email);

        return matcher.matches();
    }

    public static boolean is_valid_phone_number(final String phone_number) {
        if (phone_number == null || phone_number.isEmpty())
            return false;

        // Remove any non-digit characters from the phone number
        final String digits_only = phone_number.replaceAll("\\D", "");

        if (digits_only.length() < 11 && digits_only.length() > 7)
            return true;

        return false;
    }

    public static boolean is_valid_full_name(final String client_type_name) {
        final String regex = "^[a-zA-Z][a-zA-Z ]*$";
        return client_type_name.matches(regex);
    }
}
