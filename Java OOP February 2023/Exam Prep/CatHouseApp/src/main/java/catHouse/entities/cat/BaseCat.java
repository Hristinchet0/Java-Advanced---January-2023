package catHouse.entities.cat;

import catHouse.common.ExceptionMessages;

public abstract class BaseCat implements Cat {
    private String name;
    private String breed;
    private int kilograms;
    private double price;


    public BaseCat(String name, String breed,int kilograms, double price) {
        this.setName(name);
        this.setBreed(breed);
        this.setPrice(price);
        this.setKilograms(kilograms);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            String exceptionMsg = String.format(ExceptionMessages.CAT_NAME_NULL_OR_EMPTY);
            throw new NullPointerException(exceptionMsg);
        }
        this.name = name;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }


    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            String exceptionMsg = String.format(ExceptionMessages.CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
            throw new NullPointerException(exceptionMsg);
        }
        this.breed = breed;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            String exceptionMsg = String.format(ExceptionMessages.CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
            throw new NullPointerException(exceptionMsg);
        }
        this.price = price;
    }

    @Override
    abstract public void eating();
}
