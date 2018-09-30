// author: Jenny Chen
// date: Sepember 26, 2018
// description: program to detect all numbers between a range which are prime and are read the same forwards as backwards.

import java.util.*;

public class SpecialNumbers {
  public static void main (String[] args) {
    // declare variables
    ArrayList<String> specialNumbers = new ArrayList<>();
    ArrayList<Integer> primeNumbers = new ArrayList<>();

    // get user input
    Scanner scan = new Scanner(System.in);
    int rangeStart = scan.nextInt();
    int rangeEnd = scan.nextInt();

    // iterate through range
    for (int i = rangeStart; i <= rangeEnd; i++) {
      // check if number is prime
      for (int j = 2; j <= i; j++) {
        if (((i % j) == 0) && (i != j)) {
          break;
        } // end if
        // if prime, add number to arraylist
        if (j == i) {
          primeNumbers.add(i);
        }
      } // end for
    } // end for

    // iterate through arraylist of prime numbers
    for (int i = 0; i < primeNumbers.size(); i++) {
      String tempStr = Integer.toString(primeNumbers.get(i));
      String reverse = "";
      // check if number is read same backwards and backwards
      for (int j = tempStr.length()-1; j >= 0; j--) {
        reverse = reverse + Character.toString(tempStr.charAt(j));
      } // end for
      // if number is same, add to arraylist of special numbers
      if (reverse.equals(tempStr)) {
        specialNumbers.add(tempStr);
      } // end if
    }

    // print results
    printResults(specialNumbers);
  } // end main()

  public static void printResults(ArrayList a) {
    // print number of special numbers
    System.out.println(a.size());
    for (int i = 0; i < a.size();i++) {
      // print each special number
      if (i == a.size() - 1) {
        System.out.print(a.get(i));
        break;
      }
      System.out.print(a.get(i) + ", ");
    }
  } // end printResults()

} // end SpecialNumbers
