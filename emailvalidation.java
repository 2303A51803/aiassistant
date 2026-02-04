//email validation using zero shot with using function calling
import java.util.Scanner;
public class emailvalidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an email address: ");
        String email = scanner.nextLine();
        
        boolean isValid = validateEmail(email);
        
        if (isValid) {
            System.out.println("The email address is valid.");
        } else {
            System.out.println("The email address is invalid.");
        }
        
        scanner.close();
    }
    
    // Method to validate email address
    public static boolean validateEmail(String email) {
        // Basic email validation pattern
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailPattern);
    }
}