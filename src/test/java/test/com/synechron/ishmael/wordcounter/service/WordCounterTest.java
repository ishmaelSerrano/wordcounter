package test.com.synechron.ishmael.wordcounter.service;

import com.synechron.ishmael.wordcounter.service.Translator;
import com.synechron.ishmael.wordcounter.service.WordCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WordCounterTest {
  @Mock
  private Translator translator;

  private WordCounter wordCounter;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    wordCounter = new WordCounter(translator);
  }

  @Test
  public void testWordCount() {
    // Mock translation results
    when(translator.translate("flower")).thenReturn("flower");
    when(translator.translate("flor")).thenReturn("flower");
    when(translator.translate("Blume")).thenReturn("flower");

    wordCounter.addWords("flower", "flor", "Blume");
    assertEquals(3, wordCounter.getCount("flower"));

    // Verify translation method calls
    verify(translator, times(1)).translate("flower");
    verify(translator, times(1)).translate("flor");
    verify(translator, times(1)).translate("Blume");

    // Reset mock for next test case
    reset(translator);

    // Mock translation results
    when(translator.translate("apple")).thenReturn("apple");
    when(translator.translate("pomme")).thenReturn("apple");
    when(translator.translate("apfel")).thenReturn("apple");

    wordCounter.addWords("apple", "pomme", "apfel");
    assertEquals(3, wordCounter.getCount("apple"));

    // Verify translation method calls
    verify(translator, times(1)).translate("apple");
    verify(translator, times(1)).translate("pomme");
    verify(translator, times(1)).translate("apfel");

    // Reset mock for next test case
    reset(translator);

    // Mock translation results
    when(translator.translate("cat")).thenReturn("cat");
    when(translator.translate("gato")).thenReturn("cat");
    when(translator.translate("katze")).thenReturn("cat");

    wordCounter.addWords("cat", "gato", "katze");
    assertEquals(3, wordCounter.getCount("cat"));

    // Verify translation method calls
    verify(translator, times(1)).translate("cat");
    verify(translator, times(1)).translate("gato");
    verify(translator, times(1)).translate("katze");
  }
}






