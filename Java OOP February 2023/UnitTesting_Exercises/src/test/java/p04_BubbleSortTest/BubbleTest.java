package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] numbers = {3, 44, 38, 5, 47, 15};
        Bubble.sort(numbers);
        int[] expectedSortedArray = {3, 5, 15, 38, 44, 47};

        Assert.assertEquals(numbers.length, expectedSortedArray.length);
        Assert.assertArrayEquals(numbers, expectedSortedArray);
    }

}