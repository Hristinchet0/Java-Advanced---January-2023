package P03SpeedRacing;

public class Car {
    //полета -> характеристики
    private String model;
    private double fuelAmount;
    private double consumptionFuelPerKM;
    private int distanceTraveled;

    //методи -> действия
    //констриктор -> метод чрез който ние създаваме обекти от класа
    public Car(String model, double fuelAmount, double consumptionFuelPerKM) {
         //нов празен обект
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumptionFuelPerKM = consumptionFuelPerKM;
        this.distanceTraveled = 0;
    }

    //методи -> действия
    public boolean drive(int kmDrive) {
        //1. нужно количество за да преминем kmDrive
        double needFuel = kmDrive * this.consumptionFuelPerKM;
        if(needFuel <= this.fuelAmount) {
            //можем да изминем разтоянието
            this.fuelAmount -= needFuel;
            this.distanceTraveled += kmDrive;
            return true;
        }
        return false;
    }


    //Пренаписваме toString във формата в който искаме да ни върне
    @Override
    public String toString() {
        //дава обекта под формата на текст
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }

}
