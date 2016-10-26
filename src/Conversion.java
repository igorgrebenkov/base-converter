/**
 * The class Conversion contains helper functions for converting numbers between bases.
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
     * @param inputNum the input number, minus the prefix
     * @return
     */
    public static String convertNumber(String prefix, String inputNum) {
        String result = "";

        switch (prefix) {
            case "%":
                // do binary conversions
                break;
            case "@":
                // do octal conversions
                break;
            case "#":
                // do decimal conversions
                break;
            case "$":
                // do hex conversions
                break;
        }
        return result;
    }
}
