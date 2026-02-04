//check the string whether it start with capital letter or not and end with period or not
import java.util.Scanner;

public class checkthestring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        boolean startsWithCapital = Character.isUpperCase(input.charAt(0));
        boolean endsWithPeriod = input.endsWith(".");
        
        System.out.println("Starts with capital letter: " + startsWithCapital);
        System.out.println("Ends with period: " + endsWithPeriod);
        
        scanner.close();
    }
}