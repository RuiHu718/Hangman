/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 * add this into git as well
 */

import acm.util.*;
import java.io.*;
import java.util.*;


public class HangmanLexicon {

    public HangmanLexicon() {

        rd = openFileReader();
        wordList = new ArrayList<String>();

        try {
            while(true) {
                String line = rd.readLine();
                if(line == null) break;
                wordList.add(line);
            }
            rd.close();
        } catch (IOException ex) {
            //println("An IO exception has occured.");
        }
        
    }





    
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
            return wordList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
            return wordList.get(index);
	}


    private BufferedReader openFileReader() {
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader("HangmanLexicon.txt"));
        } catch (IOException ex) {
            //println("Can't open that file.");
        }

        return reader;
    }


    /* Instance Variables */
    private BufferedReader rd;
    private ArrayList<String> wordList;
    
}
