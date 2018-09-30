// author: Jenny Chen
// date created: October , 2018
// description:

import java.util.*;

public class MockingSpongeBob {
  // public variables
  public static Scanner scan = new Scanner(System.in);
  public static ArrayList<String> newSentences = new ArrayList<>();

  public static void changeSentence() {
    boolean upper = false;
    String newSentence = "";
    String sentence = scan.nextLine();
    for (int j = 0; j < sentence.length(); j++) {
      if ((sentence.charAt(j) >= 'a' && sentence.charAt(j) < 'z') || (sentence.charAt(j) >= 'A' && sentence.charAt(j) <= 'Z')) {
        if (upper) {
          newSentence = newSentence + Character.toUpperCase(sentence.charAt(j));
          upper = false;
        } else {
          newSentence = newSentence + Character.toLowerCase(sentence.charAt(j));
          upper = true;
        } // end if
      } else {
        newSentence = newSentence + sentence.charAt(j);
      } // end if
    } // end for
    newSentences.add(newSentence);
  } // end changeSentence()

  public static void printSentences() {
    for (int j = 0; j < newSentences.size(); j++) {
      System.out.println(newSentences.get(j));
    } // end for
  } // end printSentences()

  public static void main (String [] args) {
    int numSentences = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < numSentences; i++) {
      changeSentence();
    } // end for loop
    printSentences();
  } // end main()

}
