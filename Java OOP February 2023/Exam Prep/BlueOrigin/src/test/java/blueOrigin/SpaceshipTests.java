package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {

//    @Before
//    public void setUp() {
//        spaceship = new Spaceship("SoftuniPro", 10);
//    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWithNegativeNumber() {
        new Spaceship("Softuni Pro", -5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWithNull() {
        new Spaceship(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWithWhitespace() {
        new Spaceship("        ", 5);
    }

    @Test
    public void testCreateSpaceshipSuccessfully() {
        Spaceship spaceship = new Spaceship("SoftuniPro", 5);
        Assert.assertEquals("SoftuniPro", spaceship.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithoutCapacity() {
        Spaceship spaceship =new Spaceship("SoftuniPro", 1);
        Astronaut astronaut = new Astronaut("Mike", 22.2);
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCapacity());

        Astronaut astronaut1 = new Astronaut("Tom", 22.3);
        spaceship.add(astronaut1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithDuplicate() {
        Spaceship spaceship = new Spaceship("SoftuniPro", 2);
        Astronaut astronaut = new Astronaut("Mike", 22.2);
        spaceship.add(astronaut);

        Astronaut astronaut1 = new Astronaut("Mike", 22.3);
        spaceship.add(astronaut1);
    }

    @Test
    public void testAddSuccessfully() {
        Spaceship spaceship = new Spaceship("SoftuniPro", 10);
        Astronaut astronaut = new Astronaut("Mike", 22.2);
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());

        Astronaut astronaut1 = new Astronaut("Tom", 22.3);
        spaceship.add(astronaut1);
        Assert.assertEquals(2, spaceship.getCount());

        Astronaut astronaut3 = new Astronaut("Max", 35.2);
        spaceship.add(astronaut3);
        Assert.assertEquals(3, spaceship.getCount());
    }

    @Test
    public void testRemoveSuccessfully() {
        Spaceship spaceship = new Spaceship("SoftuniPro", 1);
        Astronaut astronaut = new Astronaut("Mike", 22.2);
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());

        spaceship.remove("Mike");
        Assert.assertEquals(0, spaceship.getCount());

    }





}
