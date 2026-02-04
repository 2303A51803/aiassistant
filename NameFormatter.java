//generate a java code that accept the full name as input as a single string and then format it to "Last Name, First Name Middle Name" forexample input "John Michael Doe" output "Doe, John Michael" and abhi ram pasham as input should return "Pasham, Abhi Ram"  
import java.util.Scanner;       

public class NameFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();
        
        String formattedName = formatName(fullName);
        System.out.println("Formatted name: " + formattedName);
        
        scanner.close();
    }
    
    public static String formatName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length < 2) {
            return fullName;
        }
        
        String lastName = parts[parts.length - 1];
        StringBuilder firstNameAndMiddleNames = new StringBuilder();
        
        for (int i = 0; i < parts.length - 1; i++) {
            firstNameAndMiddleNames.append(parts[i]).append(" ");
        }
        
        return lastName + ", " + firstNameAndMiddleNames.toString().trim();
    }
}