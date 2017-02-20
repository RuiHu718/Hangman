/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 * 
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
    }


    public void run() {
        canvas.reset();
        //need to commit
        setupGame();
        playGame();
    }


    // sets up the game by getting a random word
    private void setupGame() {
        targetWord = chooseRandomWord();
    }


    private void playGame() {
        println("Welcome to Hangman!");
        String currentForm = initCurrentForm();
        println ("The word now looks like this: " + currentForm);

        canvas.displayWord(currentForm);

        String pickedLetter;
        int count = 8;          // player has eight chances
        println("You have " + count + " guesses left." );
        
        // some methods work on string but not char and vice versa, be careful
        while (true) {
            pickedLetter = getUserInput();
            println ("Your guess: " + pickedLetter);

            // check whether the player picked a correct word
            if (targetWord.indexOf(pickedLetter.charAt(0)) == -1) {
                println("There are no " + pickedLetter + " in the word.");
                println("The word now looks like this: " + currentForm);
                canvas.noteIncorrectGuess(pickedLetter.charAt(0));
                count--;
                if (count == 0) {
                    println("You are completely hung.");
                    println("The word was: " + targetWord);
                    println("You lose.");
                    break;
                } else {
                    println("You have " + count + " guesses left.");
                }
            } else {
                // if a correct letter has been guessed before, simple ignore
                if (currentForm.indexOf(pickedLetter.charAt(0)) != -1) {
                    println("You have picked this letter before, pick a different one then.");
                    // continue;
                } else {
                    println("That guess is correct.");
                    currentForm = updateTarget(currentForm, targetWord, pickedLetter);
                    canvas.displayWord(currentForm);
                    if (currentForm.equals(targetWord)) {
                        println("You guessed the word: " + targetWord);
                        println("You win.");
                        break;
                    } else {
                        println("The word now looks like this: " + currentForm);
                        println("You have " + count + " guesses left.");
                    }
                }
            }
        }
    }


    /* update the string in progress accordingly, replace '-' with correct letters */
    private String updateTarget(String current, String target, String letter) {
        String result = "";

        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == '-') {
                if (letter.charAt(0) == target.charAt(i)) {
                    result = result + letter;
                } else {
                    result = result + "-";
                }
            } else {
                result = result + Character.toString(current.charAt(i));
            }
        }
        return result;
    }
    

    // gets user input of a single letter
    // check for input errors
    private String getUserInput() {
        String letter = readLine();

        // program will break if enter "enter" right away, how to catch this?
        if ((! Character.isLetter(letter.charAt(0))) || letter.length() > 1) {
            println("Illegal input, input should be a single letter so try again.");
            letter = readLine();
        }
        return letter.toUpperCase();
    }
    

    // sets up the initial representation of the unguessed string
    private String initCurrentForm() {
        int wordLen = targetWord.length();
        String s = "";

        for (int i = 0; i < wordLen; i++) {
            s = s.concat("-");
        }

        return s;
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
    // canvas to draw 
    private HangmanCanvas canvas;

}
