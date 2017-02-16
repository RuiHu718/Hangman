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

        String currentForm = initCurrentForm();
        String pickedLetter;
        int count = 8;
        
        while (true) {
            pickedLetter = getUserInput();
            println ("Your guess: " + pickedLetter);

            if (targetWord.indexOf(pickedLetter.charAt(0)) == -1) {
                println("There are no " + pickedLetter + " in the word.");
                println("The word now looks like this: " + currentForm);
                count--;
                if (count == 0) {
                    println("You are completely hung.");
                    println("The word was: " + targetWord);
                    break;
                } else {
                    println("You have " + count + " guesses left.");
                }
            } else {
                
                //currentForm = updateTarget(currentForm, pickedLetter);
            }

            
        }


        
        // for (int j = 8; j > 0; j--) { // player has eight chances

        //     println("You have " + j + " guesses left.");

        //     String pickedLetter = readLine();
        //     pickedLetter = pickedLetter.toUpperCase();
        //     // there is a problem here, what if use type in two chars more than once?
        //     if (pickedLetter.length() > 1) {
        //         println("Illegal input, input should be a single letter so try again");
        //         pickedLetter = readLine();
        //         pickedLetter = pickedLetter.toUpperCase();
        //     }
        //     println("Your guess: " + pickedLetter);

        //     // Checks whether the picked letter is part of target word
        //     // Note that pickedletter is string type so have to convert to char first
        //     if (targetWord.indexOf(pickedLetter.charAt(0)) == -1) {
        //         println("There are no " + pickedLetter + " in the word.");
        //         println("The word now looks like this: " + currentForm);
        //     } else {
                
        //         //currentForm = updateTarget(currentForm, pickedLetter);
        //     }
        // }
    }


    // gets user input of a single letter
    // check for input errors
    private String getUserInput() {
        String letter = readLine();
        if (letter.length() > 1) {
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

}
