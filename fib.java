
//genearte fib of n without function
import java.util.Scanner;   
public class fib {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to calculate its Fibonacci: ");
        int number = scanner.nextInt();
        
        if (number < 0) {
            System.out.println("Fibonacci is not defined for negative numbers.");
        } else {
            int a = 0, b = 1;
            System.out.print("Fibonacci series up to " + number + " terms: ");
            for (int i = 0; i < number; i++) {
                System.out.print(a + " ");
                int next = a + b;
                a = b;
                b = next;
            }
        }
        
        scanner.close();
    }
}7