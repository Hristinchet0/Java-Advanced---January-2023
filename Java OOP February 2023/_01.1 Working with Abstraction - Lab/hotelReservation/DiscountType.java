package hotelReservation;

public enum DiscountType {
    VIP("VIP", 20.0),
    SECONDVISIT("SecondVisit", 10.0),
    NONE("None", 0.0);
    private String name;
    private double percent;

    DiscountType(String name, double percent) {
        this.name = name;
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
