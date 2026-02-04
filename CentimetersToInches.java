//generate python code to converte centimeters to inches  for example 10 cm = 3.93 inches
import java.util.Scanner;   

public class CentimetersToInches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length in centimeters: ");
        double cm = scanner.nextDouble();
        double inches = cm / 2.54;
        System.out.println(cm + " cm = " + inches + " inches");
        scanner.close();
    }
}