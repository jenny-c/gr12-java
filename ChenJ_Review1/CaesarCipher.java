// Author: Jenny Chen
// Filename: CaesarCipher
// Date created: September 13, 2018
// Description: Deciphers a sentence encrypted with Caesar's Cipher.

import java.util.*;

public class CaesarCipher {
  public static void main (String[] args) {
    // declare variables
    int punctuationCount = 0;
    ArrayList<Character> alphabet = new ArrayList<>();
      for (char c = 'A'; c <= 'Z'; c++) {
        alphabet.add(c);
      }
    ArrayList<Integer> decipheredSentence = new ArrayList<>();
    ArrayList<Character> punctuation = new ArrayList<>();

    // get input from user
    Scanner scan = new Scanner(System.in);
    System.out.print("Sentence to decipher: ");
    String sentence = scan.nextLine();
    System.out.print("First word: ");
    String firstWord = scan.nextLine();

    // find shift value
    int shift = alphabet.indexOf(firstWord.charAt(0)) - alphabet.indexOf(sentence.charAt(0));
    if (shift < 0) {
      shift = 26 + (shift);
    }

    // create new sentence with integer values
    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);

      // handle punctuation
      if (!(alphabet.contains(c))) {
        decipheredSentence.add(-1);
        punctuation.add(c);
        continue;
      }

      // shift character to new character
      int newNumber = alphabet.indexOf(c) + shift;

      if (newNumber > 25) {
        newNumber = newNumber - 26;
      }

      decipheredSentence.add(newNumber);
    } // end for loop

    // use integer values to print deciphered sentence
    for (int i = 0; i < decipheredSentence.size(); i++) {
      if (decipheredSentence.get(i) == -1) {
        System.out.print(punctuation.get(punctuationCount));
        punctuationCount++;
        continue;
      }
      System.out.print(alphabet.get(decipheredSentence.get(i)));
    } // end for loop
  }
}
