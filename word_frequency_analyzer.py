"""
Word Frequency Analyzer
This script reads a text file and counts the frequency of each word.
"""

import re
from collections import Counter
from pathlib import Path


def read_text_file(file_path):
    """
    Reads a text file and returns its contents as a string.
    
    Args:
        file_path (str): Path to the text file
        
    Returns:
        str: Contents of the file
    """
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            content = file.read()
        return content
    except FileNotFoundError:
        print(f"Error: File '{file_path}' not found.")
        return None
    except Exception as e:
        print(f"Error reading file: {e}")
        return None


def extract_words(text):
    """
    Extracts words from text, converting to lowercase and removing punctuation.
    
    Args:
        text (str): Input text string
        
    Returns:
        list: List of extracted words
    """
    # Use regex to find all words (alphanumeric sequences)
    # \w+ matches one or more word characters (letters, digits, underscore)
    # This ignores punctuation and splits on whitespace
    words = re.findall(r'\b\w+\b', text.lower())
    return words


def count_word_frequency(words):
    """
    Counts the frequency of each word using Counter from collections module.
    
    Args:
        words (list): List of words
        
    Returns:
        Counter: Dictionary-like object with word frequencies
    """
    # Counter automatically counts occurrences of each word
    word_count = Counter(words)
    return word_count


def display_results(word_count, top_n=10):
    """
    Displays the word frequency results in a formatted way.
    
    Args:
        word_count (Counter): Word frequency counter object
        top_n (int): Number of top words to display (default: 10)
    """
    print(f"\n{'='*50}")
    print(f"Total unique words: {len(word_count)}")
    print(f"{'='*50}\n")
    
    print(f"Top {top_n} most frequent words:")
    print(f"{'-'*50}")
    print(f"{'Word':<20} {'Frequency':<10}")
    print(f"{'-'*50}")
    
    # most_common() returns a list of tuples (word, count) sorted by frequency
    for word, count in word_count.most_common(top_n):
        print(f"{word:<20} {count:<10}")
    
    print(f"{'-'*50}\n")


def analyze_log_file(file_path, top_n=10):
    """
    Main function that orchestrates the word frequency analysis.
    
    Args:
        file_path (str): Path to the text/log file
        top_n (int): Number of top words to display
    """
    print(f"Analyzing file: {file_path}")
    
    # Step 1: Read the file
    text = read_text_file(file_path)
    if text is None:
        return
    
    # Step 2: Extract words from the text
    words = extract_words(text)
    print(f"Total words found: {len(words)}")
    
    # Step 3: Count word frequency
    word_count = count_word_frequency(words)
    
    # Step 4: Display results
    display_results(word_count, top_n)
    
    return word_count


def main():
    """
    Main entry point of the program.
    """
    # Example usage
    file_path = input("Enter the path to the text file (or press Enter for 'sample_log.txt'): ").strip()
    
    if not file_path:
        file_path = "sample_log.txt"
    
    top_n = input("Enter number of top words to display (default 10): ").strip()
    top_n = int(top_n) if top_n.isdigit() else 10
    
    # Perform the analysis
    analyze_log_file(file_path, top_n)


if __name__ == "__main__":
    main()
