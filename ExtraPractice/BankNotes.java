// author: Jenny Chen
// date created: September 29, 2018
// description:

import java.util.*;

public class BankNotes {
  // public variables
  public static Scanner scan = new Scanner(System.in);
  public static int numDenom;
  public static ArrayList<Integer> denominations = new ArrayList<>();
  public static ArrayList<Integer> numBankNotes = new ArrayList<>();
  public static int sumToPay;
  public static int noteCount = 0;

  public static void getUserInput() {
    numDenom = scan.nextInt();
    for (int i = 0; i < numDenom; i++) {
      denominations.add(scan.nextInt());
    } // end for
    for (int i = 0; i < numDenom; i++) {
      numBankNotes.add(scan.nextInt());
    } // end for
    sumToPay = scan.nextInt();
  } // end getUserInput()

  public static void main (String [] args) {
    getUserInput();
    
  }
}
