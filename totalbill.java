//generate code to calculate total bill EC + FC + CC + ED
import java.util.Scanner;
public class billing {  
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the type of consumer (Domestic/Commercial/Industrial): ");
        String consumerType = scanner.nextLine();
        
        System.out.print("Enter the energy consumption in kWh: ");
        double energyConsumption = scanner.nextDouble();
        
        double energyCharges = calculateEnergyCharges(consumerType, energyConsumption);
        double fixedCharges = calculateFixedCharges(consumerType);
        double customerCharges = calculateCustomerCharges(consumerType);
        double electricityDuty = calculateElectricityDuty(energyCharges);
        
        if (energyCharges == -1 || fixedCharges == -1 || customerCharges == -1) {
            System.out.println("Invalid consumer type.");
        } else {
            double totalBill = energyCharges + fixedCharges + customerCharges + electricityDuty;
            System.out.println("Energy Charges: $" + energyCharges);
            System.out.println("Fixed Charges: $" + fixedCharges);
            System.out.println("Customer Charges: $" + customerCharges);
            System.out.println("Electricity Duty: $" + electricityDuty);
            System.out.println("Total Bill: $" + totalBill);
        }
        
        scanner.close();
    }
    
    // Method to calculate energy charges based on consumer type and consumption
    public static double calculateEnergyCharges(String consumerType, double consumption) {
        double rate;
        if (consumerType.equalsIgnoreCase("Domestic")) {
            rate = 1.5; // Example rate for domestic consumers
        } else if (consumerType.equalsIgnoreCase("Commercial")) {
            rate = 2.0; // Example rate for commercial consumers
        } else if (consumerType.equalsIgnoreCase("Industrial")) {
            rate = 3.0; // Example rate for industrial consumers
        } else {
            return -1; // Invalid consumer type
        }        return consumption * rate;
    }
    
    // Method to calculate fixed charges based on consumer type
    public static double calculateFixedCharges(String consumerType) {
        if (consumerType.equalsIgnoreCase("Domestic")) {
            return 50.0; // Example fixed charge for domestic consumers
        } else if (consumerType.equalsIgnoreCase("Commercial")) {
            return 100.0; // Example fixed charge for commercial consumers
        } else if (consumerType.equalsIgnoreCase("Industrial")) {
            return 200.0; // Example
