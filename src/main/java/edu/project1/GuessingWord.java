package edu.project1;

import java.util.HashSet;

public class GuessingWord {
    String word;
    HashSet<Character> guessedLetters;
    HashSet<Character> notGuessedLetters;

    public HashSet<Character> convertStringWordToSet(String word) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        return set;
    }

    public String getWord() {
        return word;
    }

    public GuessingWord(String word) {
        this.word = word;
        this.notGuessedLetters = convertStringWordToSet(word);
        this.guessedLetters = new HashSet<Character>();
    }

    public int countNotGuessingLetters() {
        return notGuessedLetters.size();
    }

    public void addGuessedLetter(Character letter) {
        guessedLetters.add(letter);
        notGuessedLetters.remove(letter);
    }

    public String getGuessingWordToUser() {
        String result = this.word;
        for (Character let : this.notGuessedLetters) {
            result = result.replace(let, '*');
        }
        return result;
    }

    boolean letterIsInTheWord(Character letter) {
        if (this.notGuessedLetters.contains(letter)) {
            return true;
        }
        return false;

    }

}
