package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Processes a sentence to find the longest words
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructor initializes the sentence to be processed
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence
     * @return List of longest words in order of appearance
     */
    public List<String> findLongestWords() {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>();
        }

        // Split the sentence into words, handling multiple spaces
        String[] words = sentence.trim().split("\\s+");
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;

        // First pass: find the maximum word length
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        // Second pass: collect all words of maximum length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
} 