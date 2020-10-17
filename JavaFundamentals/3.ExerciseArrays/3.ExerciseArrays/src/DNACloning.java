import java.util.Arrays;
import java.util.Scanner;

public class DNACloning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dnaLength = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        int[] bestDnaSample = new int[dnaLength];
        int sampleNumber = 0;
        int bestDnaSequence = 0;
        int counter = 0;
        int bestSum = 0;
        int bestIndex = dnaLength;

        while (!input.equals("Clone them!")) {

            int[] currentDnaSample = Arrays
                    .stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            counter++;
            int currentBestSequence = 0;
            int currentDnaSequence = 0;
            int currentSum = 0;
            int currentBestIndex = dnaLength;
            int currentIndex = dnaLength;
            boolean bestSequence = false;
            for (int i = 0; i < dnaLength - 1; i++) {
                if (currentDnaSample[i] == currentDnaSample[i + 1] && currentDnaSample[i] != 0){
                    currentDnaSequence++;
                    currentIndex = i;
                } else {
                    currentDnaSequence = 1;
                }

                if (currentIndex < currentBestIndex) {
                    currentBestIndex = currentIndex;
                }

                if (currentDnaSequence > currentBestSequence) {
                    currentBestSequence = currentDnaSequence;
                }

                currentSum += currentDnaSample[i];
            }

            currentSum += currentDnaSample[dnaLength - 1];

            if (currentDnaSequence == bestDnaSequence && bestIndex == currentBestIndex && currentSum > bestSum) {
                bestSequence = true;
            }

            if (currentSum > bestSum && currentBestIndex == bestIndex) {
                bestDnaSequence = currentDnaSequence;
                bestSequence = true;
            }

            if (currentBestIndex < bestIndex) {
                bestIndex = currentBestIndex;
                bestDnaSequence = currentDnaSequence;
                bestSequence = true;
            }

            if (bestSequence) {
                bestDnaSample = currentDnaSample.clone();
                sampleNumber = counter;
                bestSum = currentSum;
            }

            input = sc.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.\n", sampleNumber, bestSum);
        for (int dna : bestDnaSample) {
            System.out.print(dna + " ");
        }
    }
}
