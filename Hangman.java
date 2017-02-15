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
        
    }


    // sets up the game by getting a random word
    private void setupGame() {
        String targetWord = chooseRandomWord();
        println(targetWord);

    }


    // chooses random word as target
    // uses simple hangmanLexicon stud for now
    private String chooseRandomWord() {
        String word = hangmanLex.getWord(2);
        return word;
    }



    //Private instance variables

    // object to get random word
    private HangmanLexicon hangmanLex;

}
