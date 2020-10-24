package PasswordResset;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> text = new ArrayList<>(Arrays.asList(sc.nextLine().split("")));
        String replace = sc.nextLine();
        String replaceWith = sc.nextLine();
        Collections.replaceAll(text, replace, replaceWith);
        System.out.println(text);
    }
}
