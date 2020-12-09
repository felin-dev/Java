package p01_Database;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DatabaseTest {

    private Database database;

    @Test
    public void testDatabaseConstructorThrowsExceptionWithLessThanOneParameter() {
        assertThrows(OperationNotSupportedException.class, () -> database = new Database());
    }

    @Test
    public void testDatabaseConstructorThrowsExceptionWithMoreThanSixteenParameters() {
        assertThrows(OperationNotSupportedException.class, () ->
                database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17));
    }

    @Test
    public void testDatabaseAddMethodNullThrowsEx() throws OperationNotSupportedException {
        database = new Database(1, 2);
        assertThrows(OperationNotSupportedException.class, () ->database.add(null));
    }

    @Test
    public void testDatabaseAddMethodAddsElement() throws OperationNotSupportedException {
        database = new Database(1, 2);
        database.add(3);
        assertEquals(3, database.getElements()[2]);
    }

    @Test
    public void testDatabaseRemoveMethodRemovesTheLastElement() throws OperationNotSupportedException {
        database = new Database(1, 2);
        database.remove();
        assertEquals(1, database.getElements().length);
        assertEquals(1, database.getElements()[0]);
    }

    @Test
    public void testDatabaseRemoveMethodThrowsExWithNoElements() throws OperationNotSupportedException {
        database = new Database(1);
        database.remove();
        assertThrows(OperationNotSupportedException.class, () -> database.remove());
    }
}
