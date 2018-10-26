// author: Jenny Chen
// date created: October , 2018
// description:

import java.util.*;

public class PithyPasstimes {
  // public variables
  public static Scanner scan = new Scanner(System.in);
  public static int numPasstimes = scan.nextInt();

  public static int countValidPasstimes() {
    int count = 0;
    for (int i = 0; i < numPasstimes; i++) {
      if ((scan.next()).length() <= 10) {
        count++;
      } // end if
    }
    return count;
  }

  public static void main (String [] args) {
    System.out.print(countValidPasstimes());
  }
}
