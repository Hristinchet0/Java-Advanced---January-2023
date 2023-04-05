package shapes_02;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected void setPerimeter(Double parameter) {
        this.perimeter = parameter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();
}
