"""Quick test script to demonstrate word frequency analysis"""
from word_frequency_analyzer import analyze_log_file

# Analyze the sample log file directly
if __name__ == "__main__":
    analyze_log_file("sample_log.txt", top_n=15)
