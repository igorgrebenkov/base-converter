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
                convertBinary(inputString, outputView);
                break;
            case '@':
                convertOctal(inputString, outputView);
                break;
            case '#':
                convertDecimal(inputString, outputView);
                break;
            case '$':
                convertHex(inputString, outputView);
                break;
        }
        return result;
    }

    private static void convertBinary(String inputString, OutputView outputView) {
        Long inputNum = Long.parseLong(inputString, 2);

        outputView.setOutBinaryFieldText(inputString);
        outputView.setOutOctalFieldText(toOctalString(inputNum));
        outputView.setOutDecimalFieldText(inputNum.toString());
        outputView.setOutHexFieldText(toHexString(inputNum).toUpperCase());
    }

    private static void convertOctal(String inputString, OutputView outputView) {
        Long inputNum = Long.parseLong(inputString, 8);

        outputView.setOutBinaryFieldText(toBinaryString(inputNum));
        outputView.setOutOctalFieldText(inputString);
        outputView.setOutDecimalFieldText(inputNum.toString());
        outputView.setOutHexFieldText(toHexString(inputNum).toUpperCase());
    }

    private static void convertDecimal(String inputString, OutputView outputView) {
        Long inputNum = Long.parseLong(inputString, 10);

        outputView.setOutBinaryFieldText(toBinaryString(inputNum));
        outputView.setOutOctalFieldText(toOctalString(inputNum));
        outputView.setOutDecimalFieldText(inputNum.toString());
        outputView.setOutHexFieldText(toHexString(inputNum).toUpperCase());
    }

    private static void convertHex(String inputString, OutputView outputView) {
        Long inputNum = Long.parseLong(inputString, 16);

        outputView.setOutBinaryFieldText(toBinaryString(inputNum));
        outputView.setOutOctalFieldText(toOctalString(inputNum));
        outputView.setOutDecimalFieldText(inputNum.toString());
        outputView.setOutHexFieldText(toHexString(inputNum).toUpperCase());
    }
}
