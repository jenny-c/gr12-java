import java.util.*;

public class Odometers {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    String firstReading = scan.nextLine();
    int intReading = Integer.parseInt(firstReading);
    ArrayList<Integer> arrayReading = new ArrayList<>();
    char firstDigit = (scan.nextLine()).charAt(0);
    char secondDigit = (scan.nextLine()).charAt(0);
    int firstDigitCount = 0;
    int secondDigitCount = 0;
    int count = 0;

    ArrayList<Integer> possibilities = new ArrayList<>();

    for (int i = 0; i < firstReading.length(); i++) {
      if (firstReading.charAt(i) == firstDigit) {
        firstDigitCount++;
      }
    } // end for

    // System.out.print(firstDigitCount);

    while (secondDigitCount != firstDigitCount) {
      secondDigitCount = 0;
      intReading++;
      firstReading = Integer.toString(intReading);
      for (int i = 0; i < firstReading.length(); i++) {
        if (firstReading.charAt(i) == secondDigit) {
          secondDigitCount++;
        }
      }
      // System.out.println(secondDigitCount)
      count++;
    } // end while

    System.out.println(intReading);
    System.out.println(count);
  }
}
