package hotelReservation;

public enum Season {
    AUTUMN("Autumn", 1),
    SPRING("Spring", 2),
    WINTER("Winter", 3),
    SUMMER("Summer", 4);
    private String name;
    private int multiplyCoefficient;

    Season(String name, int multiplyCoefficient) {
        this.name = name;
        this.multiplyCoefficient = multiplyCoefficient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMultiplyCoefficient() {
        return multiplyCoefficient;
    }

    public void setMultiplyCoefficient(int multiplyCoefficient) {
        this.multiplyCoefficient = multiplyCoefficient;
    }
}
