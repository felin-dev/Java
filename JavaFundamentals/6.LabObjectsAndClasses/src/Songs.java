import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int songsCount = Integer.parseInt(sc.nextLine());
        List<Song> songList = new ArrayList<>();
        for (int i = 0; i < songsCount; i++) {
            String[] input = sc.nextLine().split("_");
            String typeList = input[0];
            String name = input[1];
            String time = input[2];

            Song song = new Song(typeList, name, time);

            songList.add(song);
        }

        String requestedType = sc.nextLine();

        for (Song song : songList) {
            if (requestedType.equals(song.getTypeList())) {
                System.out.println(song.getName());
            }

            if (requestedType.equals("all")) {
                System.out.println(song.getName());
            }
        }
    }
}
