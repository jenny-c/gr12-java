// Author: Jenny Chen
// Filename: AlphabeticallySpeaking
// Date created: September 13, 2018
// Description: Reorders a sentence given by a user.

import java.util.*;

public class AlphabeticallySpeaking {
  public static void main (String [] args) {
    // declare variables
    boolean partB = false;
    int punctuationCount = 0;
    ArrayList<Character> newSentence = new ArrayList<>();
    ArrayList<Character> punctuation = new ArrayList<>();
    ArrayList<Integer> indexesOfPunctuation = new ArrayList<>();

    // get user input
    Scanner scan = new Scanner(System.in);
    System.out.print("Sentence: ");
    String sentence = scan.nextLine();
    System.out.print("Part B (Y or N): ");
    String partSelection = scan.nextLine();
    partB = (partSelection.equalsIgnoreCase("yes") || partSelection.equalsIgnoreCase("y"));
    System.out.println();

    // iterate through each character in sentence
    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);

      // store characters in an array
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        newSentence.add(c);
      } else {
        punctuation.add(c);
        indexesOfPunctuation.add(i);
      } // end if
    } // end for

    // sort character array
    Collections.sort(newSentence);

    // print results; if part b is true, print punctuation too
    System.out.println(sentence);
    if (!partB) {
      for (int i = 0; i < newSentence.size(); i++) {
        System.out.print(newSentence.get(i));
      }
    } else {
      for (int i = 0; i < sentence.length(); i++) {
        if (indexesOfPunctuation.contains(i)) {
          System.out.print(punctuation.get(punctuationCount));
          punctuationCount++;
        } else {
          System.out.print(newSentence.get(i-punctuationCount));
        } // end if
      } // end for
    } // end if
  }
}
