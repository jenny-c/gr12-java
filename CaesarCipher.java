import java.util.*;

public class CaesarCipher {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Sentence to decipher: ");
    String sentence = scan.nextLine();

    System.out.print("First word: ");
    String firstWord = scan.nextLine();

    ArrayList<Integer> decipheredSentence = new ArrayList<>();

    // create alphabet
    ArrayList<Character> alphabet = new ArrayList<>();
    for (char c = 'A'; c <= 'Z'; c++) {
      alphabet.add(c);
    }

    // find shift value
    int shift = alphabet.indexOf(firstWord.charAt(0)) - alphabet.indexOf(sentence.charAt(0));
    if (shift < 0) {
      shift = 26 + (shift);
    }
    
    // create new sentence with integer value
    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);

      // figure out a way to handle punctuation
      if (c == ' ') {
        decipheredSentence.add(-1);
        continue;
      } else if (c == '\'') {
        decipheredSentence.add(-2);
        continue;
      } else if (c == '.') {
        decipheredSentence.add(-3);
        continue;
      }

      int newNumber = alphabet.indexOf(c) + shift;

      if (newNumber > 25) {
        newNumber = newNumber - 26;
      }

      decipheredSentence.add(newNumber);
    } // end for loop

    // use integer values to print deciphered sentence
    for (int i = 0; i < decipheredSentence.size(); i++) {
      if (decipheredSentence.get(i) == -1) {
        System.out.print(" ");
        continue;
      } else if (decipheredSentence.get(i) == -2) {
        System.out.print("\'");
        continue;
      } else if (decipheredSentence.get(i) == -3) {
        System.out.print(".");
        continue;
      }
      System.out.print(alphabet.get(decipheredSentence.get(i)));
    }
  }
}
