// author: Jenny Chen
// date created: October 29, 2018
// description:

import java.util.*;

public class GuessSequence {
  // public variables
  public static Scanner scan = new Scanner(System.in);
  public static boolean done = false;

  public static boolean isDone() {
    if (((scan.nextLine()).equals("YES")) && ((scan.nextLine()).equals("DONE"))) {
      return true;
    } // end if
    return false;
  } // end getInput()

  public static int guess() {
    return (int)(Math.random() * 3 + 1);
  }

  public static void main (String [] args) {
    while (!done) {
      System.out.println(guess());
      done = isDone();
    }
  }
}
