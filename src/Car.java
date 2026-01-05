public class Car extends Vehicle implements Servicable {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2025);
        return basePrice * 0.05 + age * 20;
    }

    @Override
    public void performService() {
        System.out.println("Car " + model + " is undergoing standard maintenance.");
    }

    @Override
    public int getServiceIntervalKm() {
        return 15000;
    }

    @Override
    public String toString() {
        return super.toString() + ", doors=" + numberOfDoors;
    }
}
