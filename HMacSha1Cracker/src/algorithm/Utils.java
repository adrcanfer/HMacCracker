package algorithm;

import java.math.BigInteger;
import java.util.Formatter;

public class Utils {
    public static String hexToString(byte[] bytes) {
        @SuppressWarnings("resource")
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static String stringToHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes()));
    }
}
