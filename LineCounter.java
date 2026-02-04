// Generate a code function to count lines in a text file.Example:File contains 3 lines Output: 3
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LineCounter     {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\n" + //
                        "itin\\OneDrive\\Desktop\\sample\\sample.txt";        // Replace with your file path
        try {
            int lineCount = countLinesInFile(filePath);
            System.out.println("Number of lines in the file: " + lineCount);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static int countLinesInFile(String filePath) throws IOException {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        }
        return lineCount;
    }
}

