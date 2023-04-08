package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ComputerManagerTests {
    @Test
    public void testCreateComputerManagerAndAddSuccessfullyComputer() {
        Computer computer = new Computer("Dell", "Latitude", 1500);
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = Exception.class)
    public void testGetComputerShouldThrowBecauseUnmodifiableList() {
        Computer computer = new Computer("Dell", "Latitude", 1500);
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(computer);
        computerManager.getComputers().add(computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowIfComputerExist() {
        Computer computer = new Computer("Dell", "Latitude", 1500);
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }

    @Test
    public void testRemoveComputer() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Dell", "Latitude", 1500);
        computerManager.addComputer(computer);
        Computer computer2 = new Computer("Dell", "Latitude2", 1800);
        computerManager.addComputer(computer2);
        Assert.assertEquals(2, computerManager.getCount());

        computerManager.removeComputer("Dell", "Latitude");
        Assert.assertEquals(1, computerManager.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWhenNoExistingComputer() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Dell", "Latitude", 1500);
        computerManager.addComputer(computer);

        computerManager.getComputer("invalid", "invalid1");
    }

    @Test
    public void testGetComputersByManufacturer() {
        ComputerManager computerManager = new ComputerManager();
        List<Computer> computers = List.of(
                new Computer("Dell2", "Latitude3", 2000),
                new Computer("Dell1", "Latitude2", 1800),
                new Computer("Dell", "Latitude", 1500));

        computers.forEach(c -> computerManager.addComputer(c));

        List<Computer> expected = computers.stream()
                .filter(c -> c.getManufacturer().equals("Dell"))
                .collect(Collectors.toList());

        List<Computer> actual = computerManager.getComputersByManufacturer("Dell");
        assertEquals(expected, actual);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnEmptyList() {
        ComputerManager computerManager = new ComputerManager();
        List<Computer> actual = computerManager.getComputersByManufacturer("Invalid");
        assertEquals(0, actual.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowExBecauseManufacturerIsNull() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputer(null, "Invalid");
    }
}