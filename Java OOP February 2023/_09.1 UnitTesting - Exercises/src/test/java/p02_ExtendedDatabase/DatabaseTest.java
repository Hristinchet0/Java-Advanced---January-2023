package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final String[] DATA = {"Ani", "Bobi", "Ceco", "Didi", "Eli"};
    private Database database;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        Person[] people = new Person[5];

        for (int i = 0; i < DATA.length; i++) {
            people[i] = new Person(i + 1, DATA[i]);
        }
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWhenNoElementForDelete() throws OperationNotSupportedException {
        for (int i = 0; i < DATA.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenUsernameIsDuplicated() throws OperationNotSupportedException {
        database.add(new Person(6, "Ani"));
        database.findByUsername("Ani");
    }

    @Test
    public void testFindByUsernameShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person found = this.database.findByUsername("Eli");
//        boolean areEqual = found.getId() == 5 && found.getUsername().equals("E");
//        Assert.assertTrue(areEqual);
        Assert.assertEquals(found.getUsername(), 5, found.getId());
    }

    @Test
    public void testFindByUsernameShouldBeCaseSensitive() throws OperationNotSupportedException {
        database.add(new Person(44, "buba"));
        Person found = database.findByUsername("buba");
//        boolean areEqual = found.getId() == 44 && found.getUsername().equals("buba");
//        Assert.assertTrue(areEqual);
        Assert.assertEquals(found.getUsername(), "buba");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIDShouldThrowWhenNoUserWithThisID() throws OperationNotSupportedException {
        database.findById(69);
    }



}