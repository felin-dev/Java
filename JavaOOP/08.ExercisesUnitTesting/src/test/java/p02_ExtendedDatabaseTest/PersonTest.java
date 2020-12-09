package p02_ExtendedDatabaseTest;

import org.junit.jupiter.api.Test;
import p02_ExtendedDatabase.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void testPersonParams() {
        Person person = new Person(43, "Ray");
        assertEquals(43, person.getId());
        assertEquals("Ray", person.getUsername());
    }
}
