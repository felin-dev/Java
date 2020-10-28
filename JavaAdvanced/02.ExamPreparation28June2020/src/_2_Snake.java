import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_Snake {
    private static int foodEaten = 0;
    private static boolean steppedOnBurrow = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int matrixDimensions = Integer.parseInt(reader.readLine());
        Character[][] matrix = new Character[matrixDimensions][matrixDimensions];
        fillMatrix(reader, matrix);
        int[] oldSnakePosition = new int[2];
        int[] firstBurrowPosition = new int[2];
        firstBurrowPosition[0] = -1;
        int[] secondBurrowPosition = new int[2];
        getFirstPositionsOfMatrixElements(oldSnakePosition, firstBurrowPosition, secondBurrowPosition, matrix);

        boolean outOfBounds = false;
        while (foodEaten < 10) {
            String command = reader.readLine();
            switch (command) {
                case "up": {
                    //row - 1
                    int[] newSnakePosition = new int[2];
                    newSnakePosition[0] = oldSnakePosition[0] - 1;
                    newSnakePosition[1] = oldSnakePosition[1];
                    if (indexIsValid(newSnakePosition[0], matrix.length)) {
                        move(oldSnakePosition, newSnakePosition, matrix);
                    } else {
                        matrix[oldSnakePosition[0]][oldSnakePosition[1]] = '.';
                        outOfBounds = true;
                    }

                    steppedOnBurrowCheck(matrix, firstBurrowPosition, secondBurrowPosition, newSnakePosition);

                    oldSnakePosition[0] = newSnakePosition[0];
                    oldSnakePosition[1] = newSnakePosition[1];
                    break;
                }
                case "down": {
                    //row + 1
                    int[] newSnakePosition = new int[2];
                    newSnakePosition[0] = oldSnakePosition[0] + 1;
                    newSnakePosition[1] = oldSnakePosition[1];
                    if (indexIsValid(newSnakePosition[0], matrix.length)) {
                        move(oldSnakePosition, newSnakePosition, matrix);
                    } else {
                        matrix[oldSnakePosition[0]][oldSnakePosition[1]] = '.';
                        outOfBounds = true;
                    }

                    steppedOnBurrowCheck(matrix, firstBurrowPosition, secondBurrowPosition, newSnakePosition);

                    oldSnakePosition[0] = newSnakePosition[0];
                    oldSnakePosition[1] = newSnakePosition[1];
                    break;
                }
                case "left": {
                    //col - 1
                    int[] newSnakePosition = new int[2];
                    newSnakePosition[0] = oldSnakePosition[0];
                    newSnakePosition[1] = oldSnakePosition[1] - 1;
                    if (indexIsValid(newSnakePosition[1], matrix.length)) {
                        move(oldSnakePosition, newSnakePosition, matrix);
                    } else {
                        matrix[oldSnakePosition[0]][oldSnakePosition[1]] = '.';
                        outOfBounds = true;
                    }

                    steppedOnBurrowCheck(matrix, firstBurrowPosition, secondBurrowPosition, newSnakePosition);

                    oldSnakePosition[0] = newSnakePosition[0];
                    oldSnakePosition[1] = newSnakePosition[1];
                    break;
                }
                case "right": {
                    //col + 1
                    int[] newSnakePosition = new int[2];
                    newSnakePosition[0] = oldSnakePosition[0];
                    newSnakePosition[1] = oldSnakePosition[1] + 1;
                    if (indexIsValid(newSnakePosition[1], matrix.length)) {
                        move(oldSnakePosition, newSnakePosition, matrix);
                    } else {
                        matrix[oldSnakePosition[0]][oldSnakePosition[1]] = '.';
                        outOfBounds = true;
                    }

                    steppedOnBurrowCheck(matrix, firstBurrowPosition, secondBurrowPosition, newSnakePosition);

                    oldSnakePosition[0] = newSnakePosition[0];
                    oldSnakePosition[1] = newSnakePosition[1];
                    break;
                }
            }

            if (outOfBounds) {
                System.out.println("Game over!");
                break;
            }
        }

        if (foodEaten == 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", foodEaten);

        printMatrix(matrix);
    }

    private static void steppedOnBurrowCheck(Character[][] matrix, int[] firstBurrowPosition, int[] secondBurrowPosition, int[] newSnakePosition) {
        if (steppedOnBurrow) {
            if (newSnakePosition[0] == firstBurrowPosition[0] &&
                    newSnakePosition[1] == firstBurrowPosition[1]) {
                newSnakePosition[0] = secondBurrowPosition[0];
                newSnakePosition[1] = secondBurrowPosition[1];
                matrix[newSnakePosition[0]][newSnakePosition[1]] = 'S';
            } else if (newSnakePosition[0] == secondBurrowPosition[0] &&
                    newSnakePosition[1] == secondBurrowPosition[1]) {
                newSnakePosition[0] = firstBurrowPosition[0];
                newSnakePosition[1] = firstBurrowPosition[1];
                matrix[newSnakePosition[0]][newSnakePosition[1]] = 'S';
            }
            steppedOnBurrow = false;
        }
    }

    private static void move(int[] oldSnakePosition, int[] newSnakePosition, Character[][] matrix) {
        if (matrix[newSnakePosition[0]][newSnakePosition[1]] == '-') {
            matrix[newSnakePosition[0]][newSnakePosition[1]] = 'S';
            matrix[oldSnakePosition[0]][oldSnakePosition[1]] = '.';
        } else if (matrix[newSnakePosition[0]][newSnakePosition[1]] == '*') {
            matrix[newSnakePosition[0]][newSnakePosition[1]] = 'S';
            matrix[oldSnakePosition[0]][oldSnakePosition[1]] = '.';
            foodEaten++;
        } else if (matrix[newSnakePosition[0]][newSnakePosition[1]] == 'B') {
            matrix[newSnakePosition[0]][newSnakePosition[1]] = '.';
            matrix[oldSnakePosition[0]][oldSnakePosition[1]] = '.';
            steppedOnBurrow = true;
        }
    }

    private static boolean indexIsValid(int index, int length) {
        return index >= 0 && index < length;
    }

    private static void getFirstPositionsOfMatrixElements(int[] oldSnakePosition, int[] firstBurrowPosition,
                                                          int[] secondBurrowPosition, Character[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 'S') {
                    oldSnakePosition[0] = row;
                    oldSnakePosition[1] = col;
                } else if (currentChar == 'B' && (firstBurrowPosition[0] == -1)) {
                    firstBurrowPosition[0] = row;
                    firstBurrowPosition[1] = col;
                } else if (currentChar == 'B') {
                    secondBurrowPosition[0] = row;
                    secondBurrowPosition[1] = col;
                }
            }
        }
    }

    private static void fillMatrix(BufferedReader reader, Character[][] matrix) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            Character[] line = reader.readLine().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            matrix[row] = line;
        }
    }

    private static void printMatrix(Character[][] matrix) {
        StringBuilder output = new StringBuilder();
        for (Character[] row : matrix) {
            for (Character symbol : row) {
                output.append(symbol);
            }
            output.append(System.lineSeparator());
        }

        System.out.println(output.toString().trim());
    }
}
