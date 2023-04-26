package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] DATA = {"A", "B", "C", "D", "E"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParameter() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNextAndMove() {
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());

    }

//    @Test
//    public void testMove() {
//        Assert.assertTrue(listIterator.move());
//        Assert.assertTrue(listIterator.move());
//        Assert.assertTrue(listIterator.move());
//        Assert.assertTrue(listIterator.move());
//        Assert.assertFalse(listIterator.move());
//    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator1 = new ListIterator();
        listIterator1.print();
    }

    @Test
    public void testPrintCorrectly() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), DATA[index]);
            index++;
            listIterator.move();
        }
    }

}