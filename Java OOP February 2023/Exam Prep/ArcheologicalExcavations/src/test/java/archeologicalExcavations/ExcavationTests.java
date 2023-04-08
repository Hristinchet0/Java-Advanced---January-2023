package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowWhenIsNull() {
        Excavation excavation = new Excavation(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowWhenIsEmpty() {
        Excavation excavation = new Excavation("    ", 10);
    }

    @Test
    public void testSetNameSuccessfully() {
        Excavation excavation = new Excavation("valid", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWhenIsNegativeNumber() {
        Excavation excavation = new Excavation("valid", -10);
    }

    @Test
    public void testSetCapacitySuccessfully() {
        Excavation excavation = new Excavation("valid", 10);
    }

    @Test
    public void testGetName() {
        Excavation excavation = new Excavation("valid", 10);
        Assert.assertEquals("valid", excavation.getName());
    }

    @Test
    public void testGetCapacity() {
        Excavation excavation = new Excavation("valid", 10);
        Assert.assertEquals(10, excavation.getCapacity());
    }

    @Test
    public void testGetCount() {
        Excavation excavation = new Excavation("valid", 10);

        Assert.assertEquals(0, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistWithFullCapacity() {
        Excavation excavation = new Excavation("valid", 2);
        Archaeologist archaeologist = new Archaeologist("Ivan", 150);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 120);
        Archaeologist archaeologist2 = new Archaeologist("Gosho", 110);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test
    public void testAddArchaeologistWithIncreasesCount() {
        Excavation excavation = new Excavation("valid", 5);
        Archaeologist archaeologist = new Archaeologist("Ivan", 150);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 120);
        Archaeologist archaeologist2 = new Archaeologist("Gosho", 110);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        Assert.assertEquals(3, excavation.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistWithSameName() {
        Excavation excavation = new Excavation("valid", 5);
        Archaeologist archaeologist = new Archaeologist("Ivan",100);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testRemoveArchaeologistReturnFalseForMissingName() {
        Excavation excavation = new Excavation("valid", 5);
        Archaeologist archaeologist = new Archaeologist("Ivan",100);
        excavation.addArchaeologist(archaeologist);
        boolean result = excavation.removeArchaeologist("Gosho");
        Assert.assertFalse(result);
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void testRemoveArchaeologistDecreasesCount() {
        Excavation excavation = new Excavation("valid", 5);
        Archaeologist archaeologist = new Archaeologist("Ivan", 150);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 120);
        Archaeologist archaeologist2 = new Archaeologist("Gosho", 110);
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        boolean result = excavation.removeArchaeologist(archaeologist1.getName());

        Assert.assertTrue(result);
        Assert.assertEquals(2, excavation.getCount());
    }




}
