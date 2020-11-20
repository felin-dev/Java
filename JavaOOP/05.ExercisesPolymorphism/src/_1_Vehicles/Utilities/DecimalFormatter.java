package _1_Vehicles.Utilities;

import java.text.DecimalFormat;

public class DecimalFormatter {

    public static String format(double decimalNumber, String wantedFormat) {
        DecimalFormat formatter = new DecimalFormat(wantedFormat);
        return formatter.format(decimalNumber);
    }
}
