package p03_IteratorTest;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Test
    public void testListIteratorConstructorWithNullElementsThrowsEx(){
        assertThrows(OperationNotSupportedException.class, () -> listIterator = new ListIterator(null));
    }

    @Test
    public void testListIteratorPrintStringMethodThrowsExWithoutElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        assertThrows(IllegalStateException.class, () -> listIterator.print());
    }

    @Test
    public void testListIteratorPrintStringCorrectString() throws OperationNotSupportedException {
        listIterator = new ListIterator("It's working");
        assertEquals("It's working", listIterator.print());
    }

    @Test
    public void testListIteratorHasNextAndMoveReturnTrue() throws OperationNotSupportedException {
        listIterator = new ListIterator("It's working", "sure!");
        assertTrue(listIterator.hasNext());
        assertTrue(listIterator.move());
    }

    @Test
    public void testListIteratorHasNextAndMoveReturnFalse() throws OperationNotSupportedException {
        listIterator = new ListIterator("It's not working");
        assertFalse(listIterator.hasNext());
        assertFalse(listIterator.move());
    }
}
