package ArticlesPartTwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfArticles = Integer.parseInt(sc.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < numberOfArticles; i++) {
            String[] tokens = sc.nextLine().split(",\\s+");
            String title = tokens[0];
            String content = tokens[1];
            String author = tokens[2];
            Article article = new Article(title, content, author);
            articles.add(article);
        }

        String sortBy = sc.nextLine();
        sortTheArticles(sortBy, articles);
    }

    private static void sortTheArticles(String sortBy, List<Article> articles) {
        switch (sortBy) {
            case "title": {
                articles
                        .stream()
                        .sorted(Comparator.comparing(Article::getTitle))
                        .forEach(article -> System.out.printf("%s - %s: %s%n",
                                article.getTitle(), article.getContent(), article.getAuthor()));
                break;
            }
            case "content": {
                articles
                        .stream()
                        .sorted(Comparator.comparing(Article::getContent))
                        .forEach(article -> System.out.printf("%s - %s: %s%n",
                                article.getTitle(), article.getContent(), article.getAuthor()));
                break;
            }
            case "author": {
                articles
                        .stream()
                        .sorted(Comparator.comparing(Article::getAuthor))
                        .forEach(article -> System.out.printf("%s - %s: %s%n",
                                article.getTitle(), article.getContent(), article.getAuthor()));
                break;
            }
        }
    }
}
