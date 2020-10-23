import java.util.*;
import java.util.function.Function;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> pieces = new HashMap<>();
        for (int i = 0; i < numberOfPieces; i++) {
            String[] piecesInfo = sc.nextLine().split("\\|");
            String piece = piecesInfo[0];
            String composer = piecesInfo[1];
            String key = piecesInfo[2];
            if (!pieces.containsKey(piece)) {
                pieces.put(piece, new ArrayList<>());
                pieces.get(piece).add(0, composer);
                pieces.get(piece).add(1, key);
            }
        }

        String input = sc.nextLine();
        while (!"Stop".equals(input)) {
            String[] tasks = input.split("\\|");
            String command = tasks[0];
            switch (command) {
                case "Add":{
                    String piece = tasks[1];
                    String composer = tasks[2];
                    String key = tasks[3];

                    if (!pieces.containsKey(piece)) {
                        pieces.put(piece, new ArrayList<>());
                        pieces.get(piece).add(0, composer);
                        pieces.get(piece).add(1, key);
                        System.out.println(String.format("%s by %s in %s added to the collection!",
                                piece, composer, key));
                    } else {
                        System.out.println(String.format("%s is already in the collection!", piece));
                    }
                    break;}
                case "Remove":{
                    String piece = tasks[1];
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.println(String.format("Successfully removed %s!", piece));
                    } else {
                        System.out.println(String.format("Invalid operation! %s does not exist in the collection.", piece));
                    }
                    break;}
                case "ChangeKey":{
                    String piece = tasks[1];
                    String newKey = tasks[2];
                    if (pieces.containsKey(piece)) {
                        pieces.get(piece).set(1, newKey);
                        System.out.println(String.format("Changed the key of %s to %s!", piece, newKey));
                    } else {
                        System.out.println(String.format("Invalid operation! %s does not exist in the collection.", piece));
                    }
                    break;}
            }

            input = sc.nextLine();
        }

        pieces
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Function<Map.Entry<String, List<String>>, String>)
                        Map.Entry::getKey).thenComparing(pieceFirst -> pieceFirst.getValue().get(0)))
                .forEach(piece -> System.out.println(String.format("%s -> Composer: %s, Key: %s",
                        piece.getKey(), piece.getValue().get(0), piece.getValue().get(1))));
    }
}