/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 * first try
 */

import acm.graphics.*;


public class HangmanCanvas extends GCanvas {


/** Resets the display so that only the scaffold appears */
	public void reset() {

            //need to commit
            beam = new GLine (getWidth()/2, 10, getWidth()/2 - BEAM_LENGTH, 10); // num 10 is arbitrary here, will adjust later
            add(beam);
            scaffold = new GLine(getWidth()/2 - BEAM_LENGTH, 10, getWidth()/2 - BEAM_LENGTH, 10 + SCAFFOLD_HEIGHT);
            add(scaffold);
            rope = new GLine(getWidth()/2, 10, getWidth()/2, 10 + ROPE_LENGTH);
            add(rope);

            drawHead();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
	}


/**
 * The following methods draw hangman body parts
 */
    private void drawHead() {
        head = new GOval(getWidth()/2 - HEAD_RADIUS, 10 + ROPE_LENGTH, HEAD_RADIUS*2, HEAD_RADIUS*2);
        add(head);
        

    }
        
    

/* Instance variables */
        private GLine beam;
        private GLine scaffold;
        private GLine rope;
        private GOval head;

    
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
