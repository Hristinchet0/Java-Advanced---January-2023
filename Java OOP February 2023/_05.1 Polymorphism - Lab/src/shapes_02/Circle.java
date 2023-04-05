package shapes_02;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.radius * 2 * Math.PI);
    }

    @Override
    protected void calculateArea() {
        setArea(Math.pow(this.radius, 2) * Math.PI);
    }
}
