// Author: Jenny Chen
// Filename: Divisors
// Date created: September 13, 2018
// Description: Finds the number with the largest number of divisors within a range (inclusive) and then prints the number of divisors.

import java.util.*;

public class Divisors {
  public static void main (String[] args) {
    // declare variables
    int currentNumber = 0;
    int factorCount = 0;
    int highestNumFactors = 0;
    ArrayList<Integer> numbers = new ArrayList<>();

    // get input from user
    Scanner scan = new Scanner(System.in);
    System.out.print("Lower limit: ");
    int lowerLimit = scan.nextInt();
    System.out.print("Upper limit: ");
    int upperLimit = scan.nextInt();

    // iterate through each number within range
    for (int i = lowerLimit; i <= upperLimit; i++) {
      currentNumber = i;
      // find number of divisors for each number
      for (int j = 2; j < i/2;) {
        if (currentNumber % j == 0) {
          factorCount++;
          currentNumber = currentNumber / j;
          continue;
        } // end if
        j++;
      } // end for

      // clear past answers if new record; add to array if not
      if (factorCount > highestNumFactors) {
        numbers.clear();
        numbers.add(i);
        highestNumFactors = factorCount;
      } else if (factorCount == highestNumFactors) {
        numbers.add(i);
        highestNumFactors = factorCount;
      }// end if
      factorCount = 0;
    } // end for

    // print results
    System.out.println();
    System.out.print("Numbers with the highest number of divisors: ");
    for (int i = 0; i < numbers.size(); i++) {
      System.out.print(numbers.get(i) + " ");
    }
    System.out.println();
    System.out.println("Number of divisors: " + highestNumFactors);
  }
}
