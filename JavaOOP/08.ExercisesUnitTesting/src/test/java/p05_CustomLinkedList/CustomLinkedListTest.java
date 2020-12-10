package p05_CustomLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {

    private final CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();

    @Test
    public void testNodeListGetCountWorksCorrectly() {
        fillNodeList();
        assertEquals(3, customLinkedList.getCount());
    }

    @Test
    public void testNodeListThrowsExWhenTryingToGetNegativeIndex() {
        fillNodeList();
        assertThrows(IllegalArgumentException.class, () -> customLinkedList.get(-1));
    }

    @Test
    public void testNodeListThrowsExWhenTryingToGetBiggerIndexThanLength() {
        fillNodeList();
        assertThrows(IllegalArgumentException.class, () -> customLinkedList.get(3));
    }

    @Test
    public void testNodeListThrowsExWhenTryingToSetNegativeIndex() {
        fillNodeList();
        assertThrows(IllegalArgumentException.class, () -> customLinkedList.set(-1, 0));
    }

    @Test
    public void testNodeListThrowsExWhenTryingToSetBiggerIndexThanLength() {
        fillNodeList();
        assertThrows(IllegalArgumentException.class, () -> customLinkedList.set(3, 4));
    }

    @Test
    public void testNodeListSetsTheRightElementAtIndex() {
        fillNodeList();
        customLinkedList.set(2, 4);
        assertEquals(4, customLinkedList.get(2));
    }

    @Test
    public void testNodeListAddsFirstNodeCorrectly() {
        customLinkedList.add(1);
        assertEquals(1, customLinkedList.get(0));
    }

    @Test
    public void testNodeListAddsMoreThanOneNodeCorrectly() {
        fillNodeList();
        assertEquals(3, customLinkedList.get(2));
    }

    @Test
    public void testNodeListRemoveNodeByItemCorrectly() {
        fillNodeList();
        assertEquals(2, customLinkedList.remove(3));
    }

    @Test
    public void testNodeListRemoveUnexistingNodeByItemReturnsMinusOne() {
        fillNodeList();
        assertEquals(-1, customLinkedList.remove(5));
    }

    @Test
    public void testNodeListRemoveNodeByIndexCorrectly() {
        fillNodeList();
        assertEquals(3, customLinkedList.removeAt(2));
    }

    @Test
    public void testNodeListRemoveNodesByIndexCorrectlyWithMoreThanOneElementInList() {
        customLinkedList.add(1);
        customLinkedList.add(2);
        assertEquals(1, customLinkedList.removeAt(0));
        assertEquals(2, customLinkedList.removeAt(0));
    }

    @Test
    public void testNodeListRemoveUnexistingNodeByIndexThrowsExWithAtBiggerIndex() {
        fillNodeList();
        assertThrows(IllegalArgumentException.class, () -> customLinkedList.removeAt(5));
    }

    @Test
    public void testNodeListRemoveUnexistingNodeByIndexThrowsExWithIndexUnderZero() {
        fillNodeList();
        assertThrows(IllegalArgumentException.class, () -> customLinkedList.removeAt(-5));
    }

    @Test
    public void testNodeListReturnsTheRightIndexOfItem() {
        fillNodeList();
        assertEquals(1, customLinkedList.indexOf(2));
    }

    @Test
    public void testNodeListReturnMinusOneWhenTryingToGetIndexOfUnexistingItemWithBiggerIndex() {
        fillNodeList();
        assertEquals(-1, customLinkedList.indexOf(5));
    }

    @Test
    public void testNodeListReturnMinusOneWhenTryingToGetIndexOfUnexistingItemWithIndexUnderZero() {
        fillNodeList();
        assertEquals(-1, customLinkedList.indexOf(-5));
    }

    @Test
    public void testNodeListContainsExistingItem() {
        fillNodeList();
        assertTrue(customLinkedList.contains(2));
    }

    @Test
    public void testNodeListDosNotContainItem() {
        fillNodeList();
        assertFalse(customLinkedList.contains(24));
    }

    private void fillNodeList() {
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
    }
}
