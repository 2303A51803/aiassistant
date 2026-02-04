//generate te java code to count the number of vowels in a given string and take input from user for ex ample input "hello world" output should be 3 and hello should return 2
import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        int count = countVowels(input);
        System.out.println("Number of vowels in the string: " + count);
        
        scanner.close();
    }
    
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        
        return count;
    }
}