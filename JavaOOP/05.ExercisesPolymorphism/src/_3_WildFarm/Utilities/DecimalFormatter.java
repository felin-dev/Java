package _3_WildFarm.Utilities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DecimalFormatter {

    private static DecimalFormat formatter;

    static {
        setFormat('.', "##.##");
    }

    public static void setFormat (char separator, String wantedFormat) {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setDecimalSeparator(separator);
        formatter = new DecimalFormat(wantedFormat, symbols);
    }

    public static String format(double decimalNumber) {
        return formatter.format(decimalNumber);
    }
}
