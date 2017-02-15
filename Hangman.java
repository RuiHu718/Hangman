/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    public void run() {
	
        setupGame();
        playGame();
        
    }


    // sets up the game by getting a random word
    private void setupGame() {
        targetWord = chooseRandomWord();
        println(targetWord);

    }


    //
    private void playGame() {
        int wordLen = targetWord.length();

        // sets up the initial representation of the unguessed string
        String currentForm = "";
        for (int i = 0; i < wordLen; i++) {
            currentForm = currentForm.concat("-");
        }

        println(currentForm);
    }


    // chooses random word as target
    // uses simple hangmanLexicon stud for now
    private String chooseRandomWord() {
        int i = rgen.nextInt(0, hangmanLex.getWordCount()-1); // is this correct on the edge?
        return  hangmanLex.getWord(i);
    }



    // object to get random word
    private HangmanLexicon hangmanLex = new HangmanLexicon();

    // to get random word
    private RandomGenerator rgen = RandomGenerator.getInstance();

    // random word choosen to be the game target
    private String targetWord;

}
