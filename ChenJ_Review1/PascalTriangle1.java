// Author: Jenny Chen
// Filename: PascalTriangle1
// Date created: September 13, 2018
// Description: Prints a pascal triangle with a user selected number of rows.

import java.util.*;

public class PascalTriangle1 {
  public static void main (String[] args) {
    // declare variables
    String space = " ";
    int levelCount = 1;
    int numberOfLevels;
    ArrayList<Integer> pastLevel = new ArrayList<>();
    ArrayList<Integer> currentLevel = new ArrayList<>();

    // get input from user
    Scanner scan = new Scanner(System.in);
    System.out.print("Number of rows: ");
    numberOfLevels = scan.nextInt();

    for (; levelCount <= numberOfLevels; levelCount++) {
      // print the very first level
      if (levelCount == 1) {
        System.out.println(1);
        pastLevel.add(1);
        continue;
      } // end if

      // get values for row and add to arraylist
      for (int i = 1; i <= levelCount; i++) {
        // add 1 if first or last term in the row
        if ((i == 1) || (i == levelCount)) {
          currentLevel.add(1);
        } else {
          currentLevel.add(pastLevel.get(i-2) + pastLevel.get(i-1));
        } // end if
      } // end for loop

      // print the row
      System.out.print(currentLevel.get(0));
      // format with spaces
      for (int i = 1; i < currentLevel.size(); i++) {
        if (currentLevel.get(i) < 10) {
          System.out.print("    ");
        } else if (currentLevel.get(i) >= 10 && currentLevel.get(i) < 100) {
          System.out.print("   ");
        } else if (currentLevel.get(i) >= 100 && currentLevel.get(i) < 1000) {
          System.out.print("  ");
        } else {
          System.out.print(" ");
        } // end if
        System.out.print(currentLevel.get(i));
      } // end if
      System.out.println();

      // move current level to past
      pastLevel.clear();
      pastLevel.addAll(currentLevel);
      currentLevel.clear();
    }
  }
}
