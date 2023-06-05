package com.synechron.ishmael.wordcounter.service;


import java.util.HashMap;
import java.util.Map;

public class WordCounter {

  private Map<String, Integer> wordCounts;
  private Translator translator;

  public WordCounter(Translator translator) {
    wordCounts = new HashMap<>();
    this.translator = translator;
  }

  /**
   * Adds one or more words to the word counter.
   * @param words The words to add.
   */
  public void addWords(String... words) {
    for (String word : words) {
      String translatedWord = translator.translate(word);
      if (isValidWord(translatedWord)) {
        int count = wordCounts.getOrDefault(translatedWord, 0);
        wordCounts.put(translatedWord, count + 1);
      }
    }
  }

  /**
   * Returns the count of how many times a given word was added to the word counter.
   * @param word The word to get the count for.
   * @return The count of the word.
   */
  public int getCount(String word) {
    return wordCounts.getOrDefault(word, 0);
  }

  /**
   * Checks if a word is valid (contains only alphabetic characters).
   * @param word The word to check.
   * @return True if the word is valid, false otherwise.
   */
  private boolean isValidWord(String word) {
    return word.matches("[a-zA-Z]+");
  }
}
