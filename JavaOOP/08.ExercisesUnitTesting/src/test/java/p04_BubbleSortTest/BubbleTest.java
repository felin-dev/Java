package p04_BubbleSortTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] unsorted = new int[]{3, 1, 9, 4, 13};
        int[] sorted = new int[]{1, 3, 4, 9, 13};
        Bubble.sort(unsorted);

        for (int i = 0; i < sorted.length; i++) {
            assertEquals(sorted[i], unsorted[i]);
        }
    }
}
