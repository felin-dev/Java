package FinalExam04apr2020;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int barcodes = Integer.parseInt(sc.nextLine());
        String regex = "^@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < barcodes; i++) {
            String barcode = sc.nextLine();
            Matcher matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                printBarcodeGroup(matcher);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }

    private static void printBarcodeGroup(Matcher matcher) {
        StringBuilder group = new StringBuilder();
        String getGroup = matcher.group("barcode");
        for (int i = 0; i < getGroup.length(); i++) {
            if (Character.isDigit(getGroup.charAt(i))) {
                group.append(getGroup.charAt(i));
            }
        }

        String groupType = group.toString();
        if (groupType.equals("")) {
            groupType = "00";
        }

        System.out.println("Product group: " + groupType);
    }
}