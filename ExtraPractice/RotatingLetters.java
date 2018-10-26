import java.util.*;

public class RotatingLetters {
  public static void main (String [] args) {
    // declare variables
    char[] notChangingLetters = {'I', 'O', 'S', 'H', 'Z', 'X', 'N'};
    boolean validWord = true;
    boolean match = false;

    // get input from user
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();

    // iterate through user input
    mainloop:
      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        match = false;
        for (int j = 0; j < notChangingLetters.length; j++) {
          if (c == notChangingLetters[j]) {
            match = true;
            continue;
          } // end if
          if (j == (notChangingLetters.length-1) && match == false) {
            validWord = false;
            break mainloop;
          } // end if
        } // end for
      } // end for

    // print results
    if (validWord) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    } // end if
  }
}
