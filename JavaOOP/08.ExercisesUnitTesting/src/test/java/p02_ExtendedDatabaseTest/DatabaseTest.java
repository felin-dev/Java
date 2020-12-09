package p02_ExtendedDatabaseTest;

import org.junit.jupiter.api.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

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
                database = new Database(getPeople(17)));
    }

    @Test
    public void testDatabaseAddMethodNullThrowsEx() throws OperationNotSupportedException {
        database = new Database(getPeople(2));
        assertThrows(OperationNotSupportedException.class, () -> database.add(null));
    }

    @Test
    public void testDatabaseAddMethodAddsElement() throws OperationNotSupportedException {
        database = new Database(getPeople(2));
        database.add(new Person(3, "Ray"));
        assertEquals(3, database.getElements()[2].getId());
    }

    @Test
    public void testDatabaseRemoveMethodRemovesTheLastElement() throws OperationNotSupportedException {
        database = new Database(getPeople(2));
        database.remove();
        assertEquals(1, database.getElements().length);
        assertEquals(1, database.getElements()[0].getId());
    }

    @Test
    public void testDatabaseRemoveMethodThrowsExWithNoElements() throws OperationNotSupportedException {
        database = new Database(getPeople(1));
        database.remove();
        assertThrows(OperationNotSupportedException.class, () -> database.remove());
    }

    @Test
    public void testDatabaseFindByUsernameForNullThrowsEx() throws OperationNotSupportedException {
        database = new Database(new Person(2, null), new Person(1, "John"));
        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername(null));
    }

    @Test
    public void testDatabaseFindByUsernameForNotExistingPersonThrowsEx() throws OperationNotSupportedException {
        database = new Database(new Person(2, "John"), new Person(1, "Rambo"));
        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername("InvalidOne"));
    }

    @Test
    public void testDatabaseFindByUsernameReturnsTheRightPerson() throws OperationNotSupportedException {
        database = new Database(getPeople(3));
        assertEquals(3, database.findByUsername("Test_Person_3").getId());
    }

    @Test
    public void testDatabaseFindByIdForNullThrowsEx() throws OperationNotSupportedException {
        database = new Database(new Person(2, null), new Person(1, "John"));
        assertThrows(OperationNotSupportedException.class, () -> database.findByUsername(null));
    }

    @Test
    public void testDatabaseFindByIdForNotExistingPersonThrowsEx() throws OperationNotSupportedException {
        database = new Database(new Person(2, "John"), new Person(1, "Rambo"));
        assertThrows(OperationNotSupportedException.class, () -> database.findById(3));
    }

    @Test
    public void testDatabaseFindByIdReturnsTheRightPerson() throws OperationNotSupportedException {
        database = new Database(getPeople(3));
        assertEquals("Test_Person_3", database.findById(3).getUsername());
    }

    private Person[] getPeople(int count) {
        Person[] people = new Person[count];
        for (int i = 0; i < count; i++) {
            people[i] = (new Person(i + 1, "Test_Person_" + (i + 1)));
        }

        return people;
    }
}
