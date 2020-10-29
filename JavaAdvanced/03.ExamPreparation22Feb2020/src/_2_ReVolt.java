import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_ReVolt {
    private static boolean playerWon;
    private static boolean bonusHit;
    private static boolean trapHit;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int matrixDimensions = Integer.parseInt(reader.readLine());
        int count = Integer.parseInt(reader.readLine());

        Character[][] matrix = new Character[matrixDimensions][matrixDimensions];
        fillMatrix(reader, matrixDimensions, matrixDimensions, matrix);

        int[] oldCarPosition = new int[2];
        getCarPosition(oldCarPosition, matrix);
        playerWon = false;
        bonusHit = false;
        trapHit = false;

        while (count-- > 0) {
            String command = reader.readLine();
            switch (command) {
                case "up": {
                    //row - 1
                    int[] newCarPosition = new int[2];
                    newCarPosition[0] = oldCarPosition[0] - 1;
                    newCarPosition[1] = oldCarPosition[1];

                    move(oldCarPosition, getValidIndex(newCarPosition, matrix) , matrix);

                    if (bonusHit) {
                        newCarPosition[0] = newCarPosition[0] - 1;
                        move(oldCarPosition, getValidIndex(newCarPosition, matrix) , matrix);
                        bonusHit = false;
                    }

                    if (trapHit) {
                        newCarPosition[0] = oldCarPosition[0];
                        trapHit = false;
                    }

                    oldCarPosition[0] = newCarPosition[0];
                    oldCarPosition[1] = newCarPosition[1];
                    break;
                }
                case "down": {
                    //row + 1
                    int[] newCarPosition = new int[2];
                    newCarPosition[0] = oldCarPosition[0] + 1;
                    newCarPosition[1] = oldCarPosition[1];

                    move(oldCarPosition, getValidIndex(newCarPosition, matrix) , matrix);

                    if (bonusHit) {
                        newCarPosition[0] = newCarPosition[0] + 1;
                        move(oldCarPosition, getValidIndex(newCarPosition, matrix) , matrix);
                        bonusHit = false;
                    }

                    if (trapHit) {
                        newCarPosition[0] = oldCarPosition[0];
                        trapHit = false;
                    }

                    oldCarPosition[0] = newCarPosition[0];
                    oldCarPosition[1] = newCarPosition[1];
                    break;
                }
                case "left": {
                    //col - 1
                    int[] newCarPosition = new int[2];
                    newCarPosition[0] = oldCarPosition[0];
                    newCarPosition[1] = oldCarPosition[1] - 1;

                    move(oldCarPosition, getValidIndex(newCarPosition, matrix) , matrix);

                    if (bonusHit) {
                        newCarPosition[1] = newCarPosition[1] - 1;
                        move(oldCarPosition, getValidIndex(newCarPosition, matrix) , matrix);
                        bonusHit = false;
                    }

                    if (trapHit) {
                        newCarPosition[1] = oldCarPosition[1];
                        trapHit = false;
                    }

                    oldCarPosition[0] = newCarPosition[0];
                    oldCarPosition[1] = newCarPosition[1];
                    break;
                }
                case "right": {
                    //col + 1
                    int[] newCarPosition = new int[2];
                    newCarPosition[0] = oldCarPosition[0];
                    newCarPosition[1] = oldCarPosition[1] + 1;

                    move(oldCarPosition, getValidIndex(newCarPosition, matrix) , matrix);

                    if (bonusHit) {
                        newCarPosition[1] = newCarPosition[1] + 1;
                        move(oldCarPosition, getValidIndex(newCarPosition, matrix) , matrix);
                        bonusHit = false;
                    }

                    if (trapHit) {
                        newCarPosition[1] = oldCarPosition[1];
                        trapHit = false;
                    }

                    oldCarPosition[0] = newCarPosition[0];
                    oldCarPosition[1] = newCarPosition[1];
                    break;
                }
            }

            if (playerWon) {
                break;
            }
        }

        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void move(int[] oldCarPosition, int[] newCarPosition, Character[][] matrix) {
        if (matrix[newCarPosition[0]][newCarPosition[1]] == '-') {
            matrix[oldCarPosition[0]][oldCarPosition[1]] = '-';
            matrix[newCarPosition[0]][newCarPosition[1]] = 'f';
        } else if (matrix[newCarPosition[0]][newCarPosition[1]] == 'T') {
            trapHit = true;
        } else if (matrix[newCarPosition[0]][newCarPosition[1]] == 'B') {
            matrix[oldCarPosition[0]][oldCarPosition[1]] = '-';
            matrix[newCarPosition[0]][newCarPosition[1]] = 'B';
            bonusHit = true;
        } else if (matrix[newCarPosition[0]][newCarPosition[1]] == 'F') {
            matrix[oldCarPosition[0]][oldCarPosition[1]] = '-';
            matrix[newCarPosition[0]][newCarPosition[1]] = 'f';
            playerWon = true;
        }
    }

    private static int[] getValidIndex(int[] newCarPosition, Character[][] matrix) {
        if (newCarPosition[0] >= 0 && newCarPosition[1] >= 0 && newCarPosition[0] < matrix.length && newCarPosition[1] < matrix.length) {
            return newCarPosition;
        } else if (newCarPosition[0] < 0) {
            newCarPosition[0] = matrix.length - 1;
        } else if (newCarPosition[1] < 0) {
            newCarPosition[1] = matrix.length - 1;
        } else if (newCarPosition[0] > matrix.length - 1) {
            newCarPosition[0] = 0;
        } else if (newCarPosition[1] > matrix.length - 1) {
            newCarPosition[1] = 0;
        }

        return newCarPosition;
    }

    private static void getCarPosition(int[] oldCarPosition, Character[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char element = matrix[row][col];
                if (element == 'f') {
                    oldCarPosition[0] = row;
                    oldCarPosition[1] = col;
                }
            }
        }
    }

    private static void printMatrix(Character[][] matrix) {
        StringBuilder output = new StringBuilder();
        for (Character[] row : matrix) {
            for (Character element : row) {
                output.append(element);
            }
            output.append(System.lineSeparator());
        }

        System.out.println(output.toString().trim());
    }

    private static void fillMatrix(BufferedReader reader, int rowSize, int colSize, Character[][] matrix) throws IOException {
        for (int row = 0; row < rowSize; row++) {
            Character[] line = reader.readLine().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            for (int col = 0; col < colSize; col++) {
                matrix[row] = line;
            }
        }
    }
}
