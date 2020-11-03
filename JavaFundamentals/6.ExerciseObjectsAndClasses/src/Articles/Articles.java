package Articles;

import java.util.Scanner;

public class Articles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] articleData = sc.nextLine().split(",\\s+");
        String initialTitle = articleData[0];
        String initialContent = articleData[1];
        String initialAuthor = articleData[2];

        Article article = new Article(initialTitle, initialContent, initialAuthor);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(": ");
            String command = tokens[0];
            String data = tokens[1];
            switch (command) {
                case "Edit":
                    article.edit(data);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(data);
                    break;
                case "Rename":
                    article.rename(data);
                    break;
            }
        }

        System.out.println(article);
    }
}
