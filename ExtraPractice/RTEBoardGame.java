// author: Jenny Chen
// date created: October , 2018
// description:

import java.util.*;

public class RTEBoardGame {
  // public variables
  public static Scanner scan = new Scanner(System.in);
  public static String sentence;
  public static int totalLs = 0;
  public static int consecutiveLs = 0;

  public static void getInput () {
    sentence = scan.nextLine();
  } // getInput

  public static void countLs() {
    int tempConsecCount = 0;
    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) == 'L') {
        totalLs = totalLs + 1;
        tempConsecCount = tempConsecCount + 1;
        if (tempConsecCount > consecutiveLs) {
          consecutiveLs = tempConsecCount;
        } // end if
        continue;
      } else if (sentence.charAt(i) == ' ') {
        continue;
      }
      tempConsecCount = 0;
    } // end for
  } // end countLs()

  public static void printResults() {
    System.out.print(totalLs + " " + consecutiveLs);
  } // end printResults()

  public static void main (String [] args) {
    getInput();
    countLs();
    printResults();
  } // end main()
}
