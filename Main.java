public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Create and display a student1 object
        student1 s1 = new student1("Alice", 20, "A");
        s1.displayInfo();

        // Create a calculator instance
        Calculator calc = new Calculator();

        // Perform some calculations
        int sum = calc.add(10, 5);
        int difference = calc.subtract(10, 5);
        int product = calc.multiply(10, 5);
        double quotient = calc.divide(10, 5);

        // Display results
        System.out.println("10 + 5 = " + sum);
        System.out.println("10 - 5 = " + difference);
        System.out.println("10 * 5 = " + product);
        System.out.println("10 / 5 = " + quotient);
    }
}

// Calculator class with basic operations
class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return (double) a / b;
    }
}
