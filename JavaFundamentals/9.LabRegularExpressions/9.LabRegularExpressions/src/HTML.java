import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        printTitle(title);
        String article = sc.nextLine();
        printArticle(article);

        String input = sc.nextLine();
        while (!"end of comments".equals(input)) {
            System.out.println("<div>");
            System.out.println("    " + input);
            System.out.println("</div>");

            input = sc.nextLine();
        }
    }

    private static void printArticle(String article) {
        System.out.println("<article>");
        System.out.println("    " + article);
        System.out.println("</article>");
    }

    private static void printTitle(String title) {
        System.out.println("<h1>");
        System.out.println("    " + title);
        System.out.println("</h1>");
    }
}
