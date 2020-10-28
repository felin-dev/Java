import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_BeeDescription {
    private static int flowersCount;
    private static boolean bonus;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] beePosition = new int[2];
        Character[][] field = fillMatrix(reader, n);
        getBeePosition(beePosition, field);
        bonus = false;

        boolean outOfField = false;
        String command = reader.readLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up": {
                    //row - 1
                    int[] oldPosition = beePosition;
                    int[] newPosition = new int[2];
                    newPosition[0] = beePosition[0] - 1;
                    newPosition[1] = beePosition[1];
                    if (isValidIndex(newPosition[0], field)) {
                        move(oldPosition, newPosition, field);
                    } else {
                        field[oldPosition[0]][oldPosition[1]] = '.';
                        outOfField = true;
                    }
                    if (bonus) {
                        oldPosition[0] = newPosition[0];
                        newPosition[0] = newPosition[0] - 1;
                        field[oldPosition[0]][oldPosition[1]] = '.';
                        if (isValidIndex(newPosition[0], field)) {
                            move(oldPosition, newPosition, field);
                        } else {
                            outOfField = true;
                        }
                        bonus = false;
                    }
                    beePosition = newPosition;
                    break;
                }
                case "down": {
                    //row + 1
                    int[] oldPosition = beePosition;
                    int[] newPosition = new int[2];
                    newPosition[0] = beePosition[0] + 1;
                    newPosition[1] = beePosition[1];
                    field[oldPosition[0]][oldPosition[1]] = '.';
                    if (isValidIndex(newPosition[0], field)) {
                        move(oldPosition, newPosition, field);
                    } else {
                        outOfField = true;
                    }
                    if (bonus) {
                        oldPosition[0] = newPosition[0];
                        newPosition[0] = newPosition[0] + 1;
                        field[oldPosition[0]][oldPosition[1]] = '.';
                        if (isValidIndex(newPosition[0], field)) {
                            move(oldPosition, newPosition, field);
                        } else {
                            outOfField = true;
                        }
                        bonus = false;
                    }
                    beePosition = newPosition;
                    break;
                }
                case "left": {
                    //col - 1
                    int[] oldPosition = beePosition;
                    int[] newPosition = new int[2];
                    newPosition[0] = beePosition[0];
                    newPosition[1] = beePosition[1] - 1;
                    field[oldPosition[0]][oldPosition[1]] = '.';
                    if (isValidIndex(newPosition[1], field)) {
                        move(oldPosition, newPosition, field);
                    } else {
                        outOfField = true;
                    }
                    if (bonus) {
                        oldPosition[1] = newPosition[1];
                        newPosition[1] = newPosition[1] - 1;
                        field[oldPosition[0]][oldPosition[1]] = '.';
                        if (isValidIndex(newPosition[0], field)) {
                            move(oldPosition, newPosition, field);
                        } else {
                            outOfField = true;
                        }
                        bonus = false;
                    }
                    beePosition = newPosition;
                    break;
                }
                case "right": {
                    //col + 1
                    int[] oldPosition = beePosition;
                    int[] newPosition = new int[2];
                    newPosition[0] = beePosition[0];
                    newPosition[1] = beePosition[1] + 1;
                    field[oldPosition[0]][oldPosition[1]] = '.';
                    if (isValidIndex(newPosition[1], field)) {
                        move(oldPosition, newPosition, field);
                    } else {
                        outOfField = true;
                    }
                    if (bonus) {
                        oldPosition[1] = newPosition[1];
                        newPosition[1] = newPosition[1] + 1;
                        field[oldPosition[0]][oldPosition[1]] = '.';
                        if (isValidIndex(newPosition[0], field)) {
                            move(oldPosition, newPosition, field);
                        } else {
                            outOfField = true;
                        }
                        bonus = false;
                    }
                    beePosition = newPosition;
                    break;
                }
            }

            command = reader.readLine();
            if (outOfField) {
                command = "End";
            }
        }
        if (outOfField) {
            System.out.println("The bee got lost!");
        }
        if (flowersCount >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowersCount);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 - flowersCount));
        }

        printMatrix(field);
    }

    private static void move(int[] oldPosition, int[] newPosition, Character[][] field) {
        int oldPositionRow = oldPosition[0];
        int oldPositionCol = oldPosition[1];
        int newPositionRow = newPosition[0];
        int newPositionCol = newPosition[1];
        field[oldPositionRow][oldPositionCol] = '.';
        if (field[newPositionRow][newPositionCol] == 'f') {
            flowersCount++;
        } else if (field[newPositionRow][newPositionCol] == 'O') {
            bonus = true;
        }
        field[newPositionRow][newPositionCol] = 'B';
    }

    private static boolean isValidIndex(int index, Character[][] field) {
        return index >= 0 && index < field.length;
    }

    private static void getBeePosition(int[] beePosition, Character[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                Character currentChar = field[row][col];
                if (currentChar == 'B') {
                    beePosition[0] = row;
                    beePosition[1] = col;
                    return;
                }
            }
        }
    }

    private static Character[][] fillMatrix(BufferedReader reader, int n) throws IOException {
        Character[][] field = new Character[n][n];
        for (int row = 0; row < n; row++) {
            Character[] line = reader.readLine().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            field[row] = line;
        }
        return field;
    }

    private static void printMatrix(Character[][] field) {
        StringBuilder output = new StringBuilder();
        for (Character[] row : field) {
            for (Character col : row) {
                output.append(col);
            }

            output.append(System.lineSeparator());
        }

        System.out.println(output.toString().trim());
    }
}
