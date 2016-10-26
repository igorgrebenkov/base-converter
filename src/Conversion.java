import static java.lang.Long.toBinaryString;
import static java.lang.Long.toHexString;
import static java.lang.Long.toOctalString;

/**
 * The class Conversion contains helper functions for converting numbers between bases.
 *
 * After a conversion, it updates the appropriate text fields.
 *
 * It contains only static methods.
 *
 * @author Igor Grebenkov
 */
public class Conversion {

    /**
     * Calls the appropriate methods to make the requested conversion.
     *
     * @param prefix the first character in the string; indicates the base of the input
     * @param inputString the input number, minus the prefix
     * @return
     */
    public static String convertNumber(char prefix, String inputString, OutputView outputView) {
        String result = "";

        switch (prefix) {
            case '%':
                // do binary conversions
                break;
            case '@':
                // do octal conversions
                break;
            case '#':
                result = convertDecimal(inputString, outputView);
                // do decimal conversions
                break;
            case '$':
                // do hex conversions
                break;
        }
        return result;
    }

    private static void convertDecimal(String inputString, OutputView outputView) {
        Long inputNum = Long.parseLong(inputString);

        outputView.setOutBinaryFieldText(toBinaryString(inputNum));

        outputView.setOutOctalFieldText(toOctalString(inputNum));

        outputView.setOutDecimalFieldText(inputString);

        outputView.setOutHexFieldText(toHexString(inputNum).toUpperCase());
    }

    private static void convertBinary(String inputString, OutputView outputView) {
        
    }

    public static String convertDecimalToBinary(String inputNum) {
        return "";
    }
}
