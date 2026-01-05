import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetApp {

    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nFleet Management System");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total yearly insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> printAllVehicles();
                case 2 -> addNewCar();
                case 3 -> addNewBus();
                case 4 -> showTotalInsurance();
                case 5 -> showOlderThanNYears();
                case 6 -> performServiceForAll();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
            return;
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void addNewCar() {
        System.out.print("Model: ");
        String model = scanner.next();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Base price: ");
        double price = scanner.nextDouble();
        System.out.print("Number of doors: ");
        int doors = scanner.nextInt();

        vehicles.add(new Car(model, year, price, doors));
    }

    private void addNewBus() {
        System.out.print("Model: ");
        String model = scanner.next();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Base price: ");
        double price = scanner.nextDouble();
        System.out.print("Passenger capacity: ");
        int capacity = scanner.nextInt();

        vehicles.add(new Bus(model, year, price, capacity));
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total yearly insurance fees: " + total);
    }

    private void showOlderThanNYears() {
        System.out.print("Current year: ");
        int currentYear = scanner.nextInt();
        System.out.print("N years: ");
        int n = scanner.nextInt();

        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
            }
        }
    }

    private void performServiceForAll() {
        for (Vehicle v : vehicles) {
            if (v instanceof Servicable) {
                Servicable s = (Servicable) v;
                s.performService(); // polymorphic call
            }
        }
    }

    public static void main(String[] args) {
        new FleetApp().run();
    }
}
