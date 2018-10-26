// Author: Jenny Chen
// Filename: LuckyNumber
// Date created: September 20, 2018
// Description: Finds the number with the lar

import java.util.*;

public class LuckyNumber {
  public static void main (String [] args) {
    // declare variables
    int newNumber = 0;
    int numberOfDigits;
    String stringCurrentNumber;
    ArrayList<String> results = new ArrayList<>();

    // get user input
    Scanner scan = new Scanner(System.in);
    int numOfLines = scan.nextInt();
    scan.nextLine();

    // 
    for (int i = 0; i < numOfLines; i++) {
      stringCurrentNumber = scan.nextLine();
      // add digits together
      while (stringCurrentNumber.length() > 1) {
        newNumber = 0;
        for (int j = 0; j < stringCurrentNumber.length(); j++) {
          newNumber = newNumber + Character.getNumericValue(stringCurrentNumber.charAt(j));
        } // end for
        stringCurrentNumber = Integer.toString(newNumber);
      } // end while
      results.add(stringCurrentNumber);
    } // end for

    // print results
    for (int i = 0; i < results.size(); i++) {
      System.out.println(results.get(i));
    } // end for
  }
}
