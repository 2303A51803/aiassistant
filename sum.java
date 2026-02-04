//generate java code to caluculate the sum of a digits without using function and with using function
import java.util.Scanner;

public class sum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to calculate its sum: ");
        int number = scanner.nextInt();

        // Calculate sum without using function
        int sumWithoutFunction = 0;
        int temp = number;
        while (temp > 0) {
            sumWithoutFunction += temp % 10;
            temp /= 10;
        }
        System.out.println("Sum of digits without using function: " + sumWithoutFunction);

        // Calculate sum using function
        int sumWithFunction = calculateSum(number);
        System.out.println("Sum of digits using function: " + sumWithFunction);

        scanner.close();
    }

    // Method to calculate sum using function
    public static int calculateSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}