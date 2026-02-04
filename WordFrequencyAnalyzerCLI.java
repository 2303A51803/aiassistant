import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Word Frequency Analyzer - Command Line Version
 * This program reads a text file and counts the frequency of each word.
 * 
 * Usage: java WordFrequencyAnalyzerCLI <file_path> [top_n]
 * Example: java WordFrequencyAnalyzerCLI sample_log.txt 15
 */
public class WordFrequencyAnalyzerCLI {
    
    /**
     * Main entry point - accepts command line arguments
     */
    public static void main(String[] args) {
        String filePath;
        int topN = 10;
        
        // Parse command line arguments
        if (args.length > 0) {
            filePath = args[0];
        } else {
            filePath = "sample_log.txt"; // Default file
        }
        
        if (args.length > 1) {
            try {
                topN = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Using default value of 10.");
            }
        }
        
        // Perform the analysis
        analyzeLogFile(filePath, topN);
    }
    
    /**
     * Reads a text file and returns its contents as a string.
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
     */
    public static List<String> extractWords(String text) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text.toLowerCase());
        
        while (matcher.find()) {
            words.add(matcher.group());
        }
        
        return words;
    }
    
    /**
     * Counts the frequency of each word using a HashMap.
     */
    public static Map<String, Integer> countWordFrequency(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        return wordCount;
    }
    
    /**
     * Gets top N words sorted by frequency (descending order).
     */
    public static List<Map.Entry<String, Integer>> getTopWords(
            Map<String, Integer> wordCount, int topN) {
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int size = Math.min(topN, entries.size());
        return entries.subList(0, size);
    }
    
    /**
     * Displays the word frequency results in a formatted table.
     */
    public static void displayResults(Map<String, Integer> wordCount, int topN) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Total unique words: " + wordCount.size());
        System.out.println("=".repeat(50) + "\n");
        
        System.out.println("Top " + topN + " most frequent words:");
        System.out.println("-".repeat(50));
        System.out.printf("%-20s %-10s%n", "Word", "Frequency");
        System.out.println("-".repeat(50));
        
        List<Map.Entry<String, Integer>> topWords = getTopWords(wordCount, topN);
        for (Map.Entry<String, Integer> entry : topWords) {
            System.out.printf("%-20s %-10d%n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("-".repeat(50) + "\n");
    }
    
    /**
     * Main orchestration function for word frequency analysis.
     */
    public static void analyzeLogFile(String filePath, int topN) {
        System.out.println("Analyzing file: " + filePath);
        
        String text = readTextFile(filePath);
        if (text == null) {
            return;
        }
        
        List<String> words = extractWords(text);
        System.out.println("Total words found: " + words.size());
        
        Map<String, Integer> wordCount = countWordFrequency(words);
        displayResults(wordCount, topN);
    }
}
