package magicGame;

import org.junit.Assert;
import org.junit.Test;

public class MagicianTests {

    @Test
    public void testCreateMagicianSuccessfullyWithValidName() {
        Magician magician = new Magician("Valid", 10);
        Assert.assertEquals("Valid", magician.getUsername());
        Assert.assertEquals(10, magician.getHealth());
    }

    @Test
    public void testCreateMagicianSuccessfullyWithValidHealth() {
        Magician magician = new Magician("Valid", 10);
        Assert.assertEquals(10, magician.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMagicianShouldThrowWhenHealthIsNegative() {
        Magician magician = new Magician("Valid", -10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateMagicianShouldThrowWhenNameIsNull() {
        Magician magician = new Magician(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateMagicianShouldThrowWhenNameIsWhitespace() {
        Magician magician = new Magician("      ", 10);
    }

    @Test
    public void testAddMagicSuccessfully() {
        Magic magic = new Magic("magic", 10);
        Magician magician = new Magician("Valid", 100);
        magician.addMagic(magic);
        Assert.assertEquals("magic", magician.getMagic(magic.getName()).getName());
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldThrowWhenMagicIsNull() {
        Magician magician = new Magician("Valid", 100);
        magician.addMagic(null);
    }

    @Test
    public void testRemoveMagicReturnTrueIfRemoved() {

        Magic magic = new Magic("magic", 100);
        Magician magician = new Magician("Valid", 100);
        magician.addMagic(magic);

        boolean actual = magician.removeMagic(magic);
        Assert.assertTrue(actual);
    }

    @Test
    public void testRemoveMagicReturnFalseIfNotRemoved() {

        Magic magic = new Magic("magic", 100);
        Magician magician = new Magician("Valid", 100);

        boolean actual = magician.removeMagic(magic);
        Assert.assertFalse(actual);
    }

    @Test(expected = Exception.class)
    public void testGetMagicsShouldReturnUnmodifiableCollection(){
        Magic magic = new Magic("magic", 100);
        Magician magician = new Magician("Valid", 100);
        magician.getMagics().add(magic);
    }

    @Test
    public void testGetMagicsShouldReturnCollection(){
        Magic magic = new Magic("magic", 100);
        Magician magician = new Magician("Valid", 100);
        magician.addMagic(magic);
        int actual = magician.getMagics().size();
        Assert.assertEquals(1,actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowWhenHealthIsLessThenZero() {
        Magician magician = new Magician("dead", 0);
        magician.takeDamage(10);
    }

    @Test
    public void testTakeDamageShouldDecreaseHealth() {
        Magician magician = new Magician("valid", 10);
        magician.takeDamage(5);
        int actualDamage = magician.getHealth();
        Assert.assertEquals(5, actualDamage);
    }

    @Test
    public void testTakeDamageShouldSetHealthToZero() {
        Magician magician = new Magician("valid", 10);
        magician.takeDamage(15);
        int actualDamage = magician.getHealth();
        Assert.assertEquals(0, actualDamage);
    }







}
