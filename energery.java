//clauculate energy consumption for •	Use conditional statements based on:Domestic Commercial Industrial consumers
import java.util.Scanner;

public class energery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the type of consumer (Domestic/Commercial/Industrial): ");
        String consumerType = scanner.nextLine();
        
        System.out.print("Enter the energy consumption in kWh: ");
        double energyConsumption = scanner.nextDouble();
        
        double cost = 0;
        
        if (consumerType.equalsIgnoreCase("Domestic")) {
            cost = energyConsumption * 1.5; // Example rate for domestic consumers
        } else if (consumerType.equalsIgnoreCase("Commercial")) {
            cost = energyConsumption * 2.0; // Example rate for commercial consumers
        } else if (consumerType.equalsIgnoreCase("Industrial")) {
            cost = energyConsumption * 3.0; // Example rate for industrial consumers
        } else {
            System.out.println("Invalid consumer type.");
            return;
        }
        
        System.out.println("Energy consumption cost: $" + cost);
        
        scanner.close();
    }
}