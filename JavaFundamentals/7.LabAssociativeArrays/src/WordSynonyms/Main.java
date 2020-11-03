package WordSynonyms;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pairsCount = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> synonyms = new LinkedHashMap<>();
        for (int i = 0; i < pairsCount; i++) {
            String key = sc.nextLine();
            String synonym = sc.nextLine();

            if (synonyms.containsKey(key)) {
                List<String> stringList = synonyms.get(key);
                stringList.add(synonym);
                synonyms.put(key, stringList);
            } else {
                List<String> synonymsList = new ArrayList<>();
                synonymsList.add(synonym);
                synonyms.put(key, synonymsList);
            }
        }

        for (Map.Entry<String, List<String>> entry : synonyms.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(),
                    entry.getValue()
                            .toString()
                            .replaceAll("[]\\[]", ""));
        }
    }
}