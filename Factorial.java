import java.util.Scanner;

public class Factorial {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt();
        
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is: " + result);
        }
        
        scanner.close();
    }
    
    // Method to calculate factorial using iteration
    public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        
        return factorial;
    }
    
    // Alternative recursive method (commented out)
    /*
    public static long calculateFactorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorialRecursive(n - 1);
    }
    */
}
