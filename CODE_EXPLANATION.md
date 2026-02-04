# Word Frequency Analyzer - Code Explanation

This Python script analyzes text files (like log files) to count word frequency. Below is a detailed explanation of how the code works.

## Overview
The script reads a text file, extracts all words, counts their frequency, and displays the most common words. This is useful for analyzing log files to identify common keywords, error messages, or patterns.

## Code Structure

### 1. Imports
```python
import re
from collections import Counter
from pathlib import Path
```
- **`re`**: Regular expression module for pattern matching (used to extract words)
- **`Counter`**: A specialized dictionary from collections module that counts occurrences automatically
- **`Path`**: For file path handling (optional, not actively used but good practice)

### 2. `read_text_file(file_path)` Function
**Purpose**: Reads the content of a text file from disk.

**How it works**:
- Opens the file in read mode with UTF-8 encoding (supports international characters)
- Uses a `with` statement to ensure the file is automatically closed after reading
- Includes error handling for missing files or other read errors
- Returns the file content as a string, or `None` if an error occurs

**Key Concept**: The `with` statement is a context manager that ensures proper resource cleanup even if an error occurs.

### 3. `extract_words(text)` Function
**Purpose**: Extracts individual words from text, removing punctuation and converting to lowercase.

**How it works**:
- Uses regular expression `r'\b\w+\b'` to find word boundaries
  - `\b`: Word boundary (ensures we match complete words)
  - `\w+`: One or more word characters (letters, numbers, underscore)
- Converts all text to lowercase using `.lower()` for case-insensitive counting
- Returns a list of all words found in the text

**Example**: "Hello, World!" becomes `['hello', 'world']`

### 4. `count_word_frequency(words)` Function
**Purpose**: Counts how many times each word appears in the list.

**How it works**:
- Uses Python's `Counter` class which is a specialized dictionary
- Automatically counts occurrences: `Counter(['a', 'b', 'a'])` → `{'a': 2, 'b': 1}`
- Returns a Counter object that behaves like a dictionary with additional useful methods

**Why Counter?**: It's optimized for counting and has convenient methods like `.most_common()` to get sorted results.

### 5. `display_results(word_count, top_n)` Function
**Purpose**: Formats and displays the word frequency results in a readable table.

**How it works**:
- Shows total unique words (different words found)
- Displays top N most frequent words in a formatted table
- Uses `.most_common(top_n)` method to get the most frequent words
- Formats output with column alignment for readability

**Output Format**:
```
Word                  Frequency
-----------------------------------
info                  15
error                 5
successful            4
```

### 6. `analyze_log_file(file_path, top_n)` Function
**Purpose**: Main orchestrator function that ties all the steps together.

**Execution Flow**:
1. Read the file → Get text content
2. Extract words → Get list of words
3. Count frequency → Get word frequency dictionary
4. Display results → Show formatted output

This is the main workflow function that calls all other functions in sequence.

### 7. `main()` Function
**Purpose**: Program entry point that handles user interaction.

**How it works**:
- Prompts user for file path (defaults to 'sample_log.txt' if empty)
- Asks for number of top words to display (defaults to 10)
- Calls `analyze_log_file()` with user inputs

### 8. `if __name__ == "__main__":` Block
**Purpose**: Ensures the script only runs when executed directly (not when imported as a module).

## How to Use

1. **Run the script**:
   ```bash
   python word_frequency_analyzer.py
   ```

2. **Enter file path** when prompted (or press Enter for default)

3. **View results**: The script displays the most frequent words in the file

## Example Output

For the sample log file, you might see:
- "info" appears most frequently (multiple INFO log entries)
- "error" appears several times (ERROR log entries)
- Common words like "user", "database", "successful" also appear frequently

This helps identify:
- Most common log levels (INFO, ERROR, WARNING)
- Frequently accessed resources or users
- Common error patterns

## Benefits

1. **Automated Analysis**: Quickly identify patterns in large log files
2. **Keyword Detection**: Find most common terms or issues
3. **Log Monitoring**: Understand what's happening most often in your system
4. **Case Insensitive**: Treats "Error" and "error" as the same word

## Extensions

You could extend this script to:
- Filter out common stop words (the, is, a, an, etc.)
- Group similar words (plurals, verb forms)
- Generate visual charts/graphs
- Export results to CSV or JSON
- Analyze multiple files at once
