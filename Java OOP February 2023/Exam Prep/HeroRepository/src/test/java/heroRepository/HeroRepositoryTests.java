package heroRepository;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HeroRepositoryTests {

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowWhenHeroIsNull() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowWhenHeroIsDuplicated() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Hrisi", 5);
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test
    public void testCreateSuccessfully() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertEquals(0, heroRepository.getCount());
        Hero hero = new Hero("Hrisi", 5);
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowWhenIsNull() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Hrisi", 5);
        heroRepository.create(hero);
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowWhenIsEmpty() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Hrisi", 5);
        heroRepository.create(hero);
        heroRepository.remove("     ");
    }

    @Test
    public void testRemovedSuccessfully() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Hrisi", 5);
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
        heroRepository.remove("Hrisi");
        Assert.assertEquals(0, heroRepository.getCount());

        Hero removedHero = heroRepository.getHero("Hrisi");
        Assert.assertNull(removedHero);
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Hrisi", 5);
        heroRepository.create(hero);
        Hero hero1 = new Hero("Pesho", 10);
        heroRepository.create(hero1);
        Hero hero2 = new Hero("Gosho", 15);
        heroRepository.create(hero2);

        Assert.assertEquals(3, heroRepository.getHeroes().size());

        Hero highestHeroLvl = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals("Gosho", highestHeroLvl.getName());
        Assert.assertEquals(15, highestHeroLvl.getLevel());

    }

}
