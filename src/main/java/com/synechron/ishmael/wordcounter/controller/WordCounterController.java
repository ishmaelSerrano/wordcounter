package com.synechron.ishmael.wordcounter.controller;

import com.synechron.ishmael.wordcounter.service.Translator;
import com.synechron.ishmael.wordcounter.service.WordCounter;
import org.springframework.web.bind.annotation.*;



  @RestController
  @RequestMapping("/word-counter")
  public class WordCounterController {

    private final WordCounter wordCounter;
    Translator translator = new Translator();

    public WordCounterController() {
      this.wordCounter = new WordCounter(translator);
    }

    @PostMapping("/add-words")
    public void addWords(@RequestBody String[] words) {
      wordCounter.addWords(words);
    }

    @GetMapping("/count/{word}")
    public int getCount(@PathVariable String word) {
      return wordCounter.getCount(word);
    }
  }


