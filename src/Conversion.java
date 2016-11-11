import static java.lang.Long.toBinaryString;
import static java.lang.Long.toHexString;
import static java.lang.Long.toOctalString;

/**
 * <p>The class <b>Conversion</b> contains helper functions for converting numbers between bases.</p>
 * <p>
 * <p>After a conversion, it updates the appropriate text fields.</p>
 * <p>
 * <p>t contains only static methods.</p>
 *
 * @author Igor Grebenkov
 */
public class Conversion {
    private final static int BASE_TWO = 2;
    private final static int BASE_EIGHT = 8;
    private final static int BASE_TEN = 10;
    private final static int BASE_SIXTEEN = 16;

    /**
     * Calls the appropriate methods to make the requested conversion.
     *
     * @param prefix      the first character in the string; indicates the base of the input
     * @param inputString the input number, minus the prefix
     */
    public static void convertNumber(char prefix, String inputString, Model model) throws NumberFormatException {
        inputString = inputString.replaceAll("\\s", ""); // ignore spaces
        switch (prefix) {
            case '%':
                convertNumber(inputString, model, BASE_TWO);
                break;
            case '@':
                convertNumber(inputString, model, BASE_EIGHT);
                break;
            case '#':
                convertNumber(inputString, model, BASE_TEN);
                break;
            case '$':
                convertNumber(inputString, model, BASE_SIXTEEN);
                break;
        }
    }

    /**
     * Private helper function that converts a number and uses it to update the model.
     *
     * @param inputString the input string (number to convert)
     * @param model       the model
     * @param base        the base we are converting to
     */
    private static void convertNumber(String inputString, Model model, int base) {
        Long inputNum = Long.parseLong(inputString, base);

        model.setOutBinary(formatBinaryString(toBinaryString(inputNum)));
        model.setOutOctal(formatOctalString(toOctalString(inputNum)));
        model.setOutDecimal(formatDecimalString(inputNum.toString()));
        model.setOutHex(formatHexString(toHexString(inputNum).toUpperCase()));
    }

    /**
     * Formats a binary string by padding with 0s and
     * adding spaces to form groups of 4.
     *
     * @param binary the binary string to format
     * @return the formatted string
     */
    private static String formatBinaryString(String binary) {
        // Pad with zeros if necessary
        if (binary.length() > 3) {
            switch (binary.length() % 4) {
                case 1:
                    binary = "000" + binary;
                    break;
                case 2:
                    binary = "00" + binary;
                    break;
                case 3:
                    binary = "0" + binary;
                    break;
            }
        }
        String result = "";
        // Add spaces to group into fours
        for (int i = 0; i < binary.length(); ++i) {
            char c = binary.charAt(i);
            if (i % 4 == 0 && i != 0) {
                result += " ";
            }
            result += c;
        }
        return result;
    }

    /**
     * Formats an octal string by padding with 0s and
     * adding spaces to form groups of 3.
     *
     * @param octal the octal string to format
     * @return the formatted string
     */
    private static String formatOctalString(String octal) {
        // Pad with zeros if necessary
        if (octal.length() > 3) {
            switch (octal.length() % 3) {
                case 1:
                    octal = "00" + octal;
                    break;
                case 2:
                    octal = "0" + octal;
                    break;
            }
        }
        String result = "";
        // Add spaces to group into threes
        for (int i = 0; i < octal.length(); ++i) {
            char c = octal.charAt(i);
            if (i % 3 == 0 && i != 0) {
                result += " ";
            }
            result += c;
        }
        return result;
    }

    /**
     * Formats a decimal string with the common convention.
     * e.g., 23000000 becomes 23 000 000
     *
     * @param decimal the decimal string to format
     * @return the formatted string
     */
    private static String formatDecimalString(String decimal) {
        if (decimal.length() > 3) {
            String firstDigit = "";
            String remainder = "";
            switch (decimal.length() % 3) {
                case 1:
                    firstDigit = decimal.substring(0, 1) + " ";
                    remainder = decimal.substring(1);
                    break;
                case 2:
                    firstDigit = decimal.substring(0, 2) + " ";
                    remainder = decimal.substring(2);
                    break;
                case 0:
                    firstDigit = decimal.substring(0, 3) + " ";
                    remainder = decimal.substring(3);
                    break;

            }
            String remainderSpaced = "";

            // Add spaces to rest of string to group into threes
            for (int i = 0; i < remainder.length(); ++i) {
                char c = remainder.charAt(i);
                if (i != 0 && i % 3 == 0) {
                    remainderSpaced += " ";
                }
                remainderSpaced += c;
            }
            return firstDigit + remainderSpaced;
        }
        return decimal;
    }

    /**
     * Formats a hex string by padding with 0s and
     * adding spaces to form groups of 2.
     *
     * @param hex the hex string to format
     * @return the formatted string
     */
    private static String formatHexString(String hex) {
        // Pad with zeros if necessary
        if (hex.length() > 2 && hex.length() % 2 == 1) {
            hex = "0" + hex;
        }
        String result = "";
        // Add spaces to group into twos
        for (int i = 0; i < hex.length(); ++i) {
            char c = hex.charAt(i);
            if (i % 2 == 0 && i != 0) {
                result += " ";
            }
            result += c;
        }
        return result;
    }
}
