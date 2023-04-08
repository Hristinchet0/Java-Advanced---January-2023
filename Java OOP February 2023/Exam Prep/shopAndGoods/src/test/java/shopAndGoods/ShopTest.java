package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() {
        this.shop= new Shop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldThrowBecauseUnmodifiableCollection() {
        shop.getShelves().clear();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowForInvalidShelve() throws OperationNotSupportedException {
        shop.addGoods("invalid", null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsShouldThrowForExistingGood() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_test");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test
    public void testAddGoodsSuccessfully() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_test");
        String expected = "Goods: test_test is placed successfully!";
        String actual = shop.addGoods("Shelves1", goods);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowForInvalidShelve() {
        shop.removeGoods("invalid_test", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldFailForDifferentGoodOnTheSameShelve() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_test");
        Goods goods1 = new Goods("test_good_2", "test_test_2");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods1);
    }

    @Test
    public void testRemoveSuccessfully() throws OperationNotSupportedException {
        Goods goods = new Goods("Test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        String expected = "Goods: test_code is removed successfully!";
        String actual = shop.removeGoods("Shelves1", goods);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveGoodsShouldSetTheShelveValueToNull() throws OperationNotSupportedException {
        Goods goods = new Goods("Test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);

        Goods emptySlot = shop.getShelves().get("Shelves1");
        Assert.assertNull(emptySlot);
    }



}