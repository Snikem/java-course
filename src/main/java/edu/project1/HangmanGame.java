package edu.project1;

import java.util.Locale;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HangmanGame {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static Scanner SCANNER = new Scanner(System.in);
    private String path;
    private GuessingWord guessingWord;
    private int health;

    public void turnOnGame(String path) {
        this.path = path;
        greeting();
    }

    private void greeting() {
        LOGGER.info(
            "if you want to run the game, type \"y\". There is also a command to exit the game at any time - \"exit\"");
        String input = controlInput();
        if (input.equals("y")) {
            startGame();
        }
        if (input.equals("n")) {
            closeGame();
        } else {
            LOGGER.info("Your conclusion is not clear. Try again.");
            greeting();
        }
    }

    private void startGame() {
        guessingWord = new GuessingWord(new Dictionary().getRandomWordFromFile(path));
        health = guessingWord.getWord().length();
        LOGGER.info("Game start");
        printTheGiessingWord();
        LOGGER.info("you got " + health + " attempts");
        runGame();
    }

    private boolean isCorrectInput(String input) {
        if (input.length() == 1 && Character.isAlphabetic(input.charAt(0))) {
            return true;
        }
        return false;
    }

    private String controlInput() {
        String input = SCANNER.nextLine();
        if (input.equals("exit")) {
            closeGame();
        }
        return input;
    }

    private void printTheGiessingWord() {
        LOGGER.info("The word: " + guessingWord.getGuessingWordToUser());
    }

    private void runGame() {
        LOGGER.info("enter your one letter without spaces");
        String input = controlInput();
        if (!isCorrectInput(input)) {
            LOGGER.info("Incorrect entry. Try again");
            runGame();
        }
        input = input.toLowerCase(Locale.ROOT);
        Character letter = input.charAt(0);
        if (guessingWord.letterIsInTheWord(letter)) {
            LOGGER.info("HIT!");
            guessingWord.addGuessedLetter(letter);
            printTheGiessingWord();
            if (guessingWord.countNotGuessingLetters() < 1) {
                winGame();
            }
            runGame();
        } else {
            health--;
            printHealth();
            if (health < 1) {
                gameLose();
            }
            printTheGiessingWord();
            runGame();
        }

    }

    private void printHealth() {
        LOGGER.info("Missed, mistake " + (guessingWord.getWord().length() - health) + " out of "
            + guessingWord.getWord().length() + ".");
    }

    private void gameLose() {
        LOGGER.info("You lose....");
        closeGame();

    }

    private void winGame() {
        LOGGER.info("You won!!!!!");
        closeGame();
    }

    private void closeGame() {
        System.exit(0);
    }
}
