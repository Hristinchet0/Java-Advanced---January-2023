package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {5, 8, 20, 67, 98};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    //Text Constructor
    //1. Create correct Object

    @Test
    public void testConstructorHasToCreateValidObject() {
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(databaseElements.length, NUMBERS.length);

        for (int i = 0; i < databaseElements.length; i++) {
            Assert.assertEquals(NUMBERS[i], databaseElements[i]);
        }
    }

    //2.If elements are > 16
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThenSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    //3.If elements are < 1
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThenOneElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    //Test add method
    //1.If element is null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    //2.If element is not null
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(5);
        Assert.assertEquals(database.getElements().length, database.getElements().length + 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(5));
    }

    //Test remove method
    //1.If there is no element in array
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWhenNoElementForDelete() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
    //2.If correct delete element
    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] elementsInDatabase = database.getElements();
        Assert.assertEquals(elementsInDatabase.length, NUMBERS.length - 1);
        Assert.assertEquals(elementsInDatabase[elementsInDatabase.length - 1], Integer.valueOf(67));
    }

    //

}