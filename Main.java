/**
 * The Main for Baguenaudier Puzzle
 *
 * @author Blake Byerly
 */

/*
The Big-O classification for this algorithm:
O(n)

The function doubles the amount of moves when reaching an even number of rings, and then doubles before adding a one when reaching an odd number of rings.
*/

package edu.elon.algorithms;
import java.util.Arrays;

public class Main {

    static int [] state;
    static int counter;

    public static void flip(int x) { // switch rings from on and off
        if (state[x] == 0) {
            state[x] = 1;
        }
        else {
            state[x] = 0;
        }
    }

    public static void recursiveSolve(int x) {
        if (x == 1) {  // if only one ring
            flip(0);
            System.out.print(x + ":");
            printRings();
            System.out.println();
            counter++;
        }
        else if (x == 2) {  // if only 2 rings
            flip(0);
            System.out.print(x + ":");
            printRings();
            System.out.println();
            counter++;
            flip(1);
            System.out.print(x + ":");
            printRings();
            System.out.println();
            counter++;
        }
        else { // if more than 2 rings
            recursiveSolve(x-1);
            recursiveSolve(x - 2);
            flip(x-1);
            System.out.print(x + ":");
            printRings();
            System.out.println();
            counter++;
            recursiveSolve(x - 2);

        }
    }

    public static void printRings(){ // show the state of the rings//array
        for (int i = state.length-1; i >= 0; i--) {
            System.out.print(state[i]);
        }
    }

    public static void main(String[] args) {

        int n = 4;
        state = new int[n];
        for (int i = 0; i < n; i++) {
            state[i] = 1;
        }
	    recursiveSolve(n);
        System.out.print("Number of flips: " + counter);
    }
}
