/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 * first try
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class HangmanCanvas extends GraphicsProgram {

    // for testing purpose
    public void run() {
        HangmanCanvas canvas = new HangmanCanvas();
        add(canvas);
        canvas.reset();
        println(canvas.getElementCount());
    }



    
/** Resets the display so that only the scaffold appears */
	public void reset() {
            println("hello");
            beam = new GLine (50, 50, 100, 100);
            // beam = new GLine(getWidth()/2, getHeight()/2 - LEG_LENGTH - BODY_LENGTH - 2*HEAD_RADIUS - ROPE_LENGTH,
            //                        getWidth()/2 - BEAM_LENGTH, getHeight()/2 - LEG_LENGTH - BODY_LENGTH - 2*HEAD_RADIUS - ROPE_LENGTH);
            beam.setVisible(true);
            beam.setColor(Color.BLACK);
            add(beam);


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


/* Instance variables */
    private GLine beam;
    
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
