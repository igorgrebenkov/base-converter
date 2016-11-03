import java.math.BigInteger;

import static java.lang.Long.toBinaryString;
import static java.lang.Long.toHexString;
import static java.lang.Long.toOctalString;

/**
 * The class Conversion contains helper functions for converting numbers between bases.
 * <p>
 * After a conversion, it updates the appropriate text fields.
 * <p>
 * It contains only static methods.
 *
 * @author Igor Grebenkov
 */
public class Conversion {

    /**
     * Calls the appropriate methods to make the requested conversion.
     *
     * @param prefix      the first character in the string; indicates the base of the input
     * @param inputString the input number, minus the prefix
     */
    public static void convertNumber(char prefix, String inputString, Model model) throws NumberFormatException {
        inputString = inputString.replaceAll("\\s",""); // ignore spaces
        switch (prefix) {
            case '%':
                convertBinary(inputString, model);
                break;
            case '@':
                convertOctal(inputString, model);
                break;
            case '#':
                convertDecimal(inputString, model);
                break;
            case '$':
                convertHex(inputString, model);
                break;
        }
    }

    private static void convertBinary(String inputString, Model model) throws NumberFormatException {
        Long inputNum = Long.parseLong(inputString, 2);

        model.setOutBinary(formatBinaryString(inputString));
        model.setOutOctal(formatOctalString(toOctalString(inputNum)));
        model.setOutDecimal(formatDecimalString(inputNum.toString()));
        model.setOutHex(formatHexString(toHexString(inputNum).toUpperCase()));
    }

    private static void convertOctal(String inputString, Model model) throws NumberFormatException {
        Long inputNum = Long.parseLong(inputString, 8);

        model.setOutBinary(formatBinaryString(toBinaryString(inputNum)));
        model.setOutOctal(formatOctalString(inputString));
        model.setOutDecimal(formatDecimalString(inputNum.toString()));
        model.setOutHex(formatHexString(toHexString(inputNum).toUpperCase()));
    }

    private static void convertDecimal(String inputString, Model model) throws NumberFormatException {
        Long inputNum = Long.parseLong(inputString, 10);

        model.setOutBinary(formatBinaryString(toBinaryString(inputNum)));
        model.setOutOctal(formatOctalString(toOctalString(inputNum)));
        model.setOutDecimal(formatDecimalString(inputNum.toString()));
        model.setOutHex(formatHexString(toHexString(inputNum).toUpperCase()));
    }

    private static void convertHex(String inputString, Model model) throws NumberFormatException {
        Long inputNum = Long.parseLong(inputString, 16);

        model.setOutBinary(formatBinaryString(toBinaryString(inputNum)));
        model.setOutOctal(formatOctalString(toOctalString(inputNum)));
        model.setOutDecimal(formatDecimalString(inputNum.toString()));
        model.setOutHex(formatHexString(toHexString(inputNum).toUpperCase()));
    }

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
