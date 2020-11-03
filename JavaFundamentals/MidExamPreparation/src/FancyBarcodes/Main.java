package FancyBarcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int barcodes = Integer.parseInt(sc.nextLine());
        while (barcodes > 0) {
            String barcodeString = sc.nextLine();
            String[] barcodeArray = barcodeString.split("");
            List<String> barcode = new ArrayList<>();
            boolean barcodeStarted = false;
            boolean barcodeEnded = false;
            boolean barcodeEndHasStarted = false;
            boolean valid = false;
            for (int i = 2; i < barcodeArray.length; i++) {
                if (barcodeArray[0].equals("@") && barcodeArray[1].equals("#")) {
                    String currentDigit = barcodeArray[i];
                    char currentChar = barcodeString.charAt(i);
                    if (!isNotValidSymbol(currentChar) && !barcodeEnded) {
                        barcode.add(barcode.size(), currentDigit);
                        barcodeStarted = true;
                    }
                    if (barcodeStarted && isNotValidSymbol(currentChar)) {
                        barcodeEnded = true;
                    }
                    if (barcodeEnded && currentChar == '@') {
                        barcodeEndHasStarted = true;
                        currentChar = barcodeString.charAt(i+1);
                    }
                    if (barcodeEndHasStarted && currentChar != '#') {
                        valid = false;
                    } else if (barcodeEnded && currentChar == '#'){
                        valid = true;
                    }
                }
            }
            String barcodeRaw = String.join("", barcode);
            if (barcodeRaw.length() < 6 || isNotCapitalLatter(barcodeRaw.charAt(0)) ||
                    isNotCapitalLatter(barcodeRaw.charAt(barcodeRaw.length() - 1))) {
                valid = false;
            }

            if (valid) {
                String barcodeRawString = String.join("", barcode);
                String[] barcodeRawSplit = barcodeRawString.split("");
                getProductGroup(barcodeRawSplit);
            } else {
                System.out.println("Invalid barcode");
            }

            barcodes--;
        }
    }

    private static void getProductGroup(String[] barcode) {
        String barcodeString = String.join("", barcode);
        List<String> sum = new ArrayList<>();
        for (int i = 0; i < barcodeString.length(); i++) {
            char currentChar = barcodeString.charAt(i);
            if (currentChar >= 48 && currentChar <= 57) {
                String[] digits = barcodeString.split("");
                sum.add(digits[i]);
            }
        }

        System.out.print("Product group: ");
        if (sum.isEmpty()) {
            System.out.print("00");
        } else {
            for (String character : sum) {
                System.out.print(character);
            }
        }
        System.out.println();
    }

    private static boolean isNotCapitalLatter(char digit) {
        boolean capital = false;
        if (digit >= 65 && digit <= 90) {
            capital = true;
        }
        return !capital;
    }

    private static boolean isNotValidSymbol(char currentChar) {
        return currentChar < 48 || currentChar > 57 && currentChar < 65 ||
                currentChar > 90 && currentChar < 97 || currentChar > 122;
    }
}
