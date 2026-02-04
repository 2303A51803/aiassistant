import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Word Frequency Analyzer
 * This program reads a text file and counts the frequency of each word.
 */
public class WordFrequencyAnalyzer {
    
    /**
     * Main entry point of the program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the path to the text file (or press Enter for 'sample_log.txt'): ");
        String filePath = scanner.nextLine().trim();
        
        if (filePath.isEmpty()) {
            filePath = "sample_log.txt";
        }
        
        System.out.print("Enter number of top words to display (default 10): ");
        String topNInput = scanner.nextLine().trim();
        int topN = 10;
        
        if (!topNInput.isEmpty()) {
            try {
                topN = Integer.parseInt(topNInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default value of 10.");
            }
        }
        
        scanner.close();
        
        // Perform the analysis
        analyzeLogFile(filePath, topN);
    }
    
    /**
     * Reads a text file and returns its contents as a string.
     * 
     * @param filePath Path to the text file
     * @return Contents of the file, or null if an error occurs
     */
    public static String readTextFile(String filePath) {
        try {
            StringBuilder content = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            
            reader.close();
            return content.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + filePath + "' not found.");
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Extracts words from text, converting to lowercase and removing punctuation.
     * Uses regex to find word boundaries.
     * 
     * @param text Input text string
     * @return List of extracted words
     */
    public static List<String> extractWords(String text) {
        List<String> words = new ArrayList<>();
        
        // Regex pattern to match word boundaries: \b\w+\b
        // \b = word boundary, \w+ = one or more word characters
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text.toLowerCase());
        
        while (matcher.find()) {
            words.add(matcher.group());
        }
        
        return words;
    }
    
    /**
     * Counts the frequency of each word using a HashMap.
     * 
     * @param words List of words to count
     * @return HashMap with word frequencies
     */
    public static Map<String, Integer> countWordFrequency(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Count occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        return wordCount;
    }
    
    /**
     * Sorts the word frequency map by value (frequency) in descending order
     * and returns the top N entries.
     * 
     * @param wordCount Map of word frequencies
     * @param topN Number of top words to return
     * @return List of Map.Entry sorted by frequency (descending)
     */
    public static List<Map.Entry<String, Integer>> getTopWords(
            Map<String, Integer> wordCount, int topN) {
        
        // Convert map entries to list
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        
        // Sort by value (frequency) in descending order
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Return top N entries
        int size = Math.min(topN, entries.size());
        return entries.subList(0, size);
    }
    
    /**
     * Displays the word frequency results in a formatted way.
     * 
     * @param wordCount Map of word frequencies
     * @param topN Number of top words to display
     */
    public static void displayResults(Map<String, Integer> wordCount, int topN) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Total unique words: " + wordCount.size());
        System.out.println("=".repeat(50) + "\n");
        
        System.out.println("Top " + topN + " most frequent words:");
        System.out.println("-".repeat(50));
        System.out.printf("%-20s %-10s%n", "Word", "Frequency");
        System.out.println("-".repeat(50));
        
        // Get and display top N words
        List<Map.Entry<String, Integer>> topWords = getTopWords(wordCount, topN);
        for (Map.Entry<String, Integer> entry : topWords) {
            System.out.printf("%-20s %-10d%n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("-".repeat(50) + "\n");
    }
    
    /**
     * Main function that orchestrates the word frequency analysis.
     * 
     * @param filePath Path to the text/log file
     * @param topN Number of top words to display
     */
    public static void analyzeLogFile(String filePath, int topN) {
        System.out.println("Analyzing file: " + filePath);
        
        // Step 1: Read the file
        String text = readTextFile(filePath);
        if (text == null) {
            return;
        }
        
        // Step 2: Extract words from the text
        List<String> words = extractWords(text);
        System.out.println("Total words found: " + words.size());
        
        // Step 3: Count word frequency
        Map<String, Integer> wordCount = countWordFrequency(words);
        
        // Step 4: Display results
        displayResults(wordCount, topN);
    }
}
