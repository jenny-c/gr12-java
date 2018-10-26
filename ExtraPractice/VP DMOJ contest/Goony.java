import java.util.*;

public class Goony {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int firstSum = 0;
    int secondSum = 0;
    int thirdSum = 0;
    int temp;

    String[] tempString = (scan.nextLine()).split("-");

    temp = Integer.parseInt(tempString[0]);
    while (temp>0) {
      firstSum = firstSum + temp%10;
      temp = temp/10;
    }
    temp = Integer.parseInt(tempString[1]);
    while (temp>0) {
      secondSum = secondSum + temp%10;
      temp = temp/10;
    }
    temp = Integer.parseInt(tempString[2]);;
    while (temp>0) {
      thirdSum = thirdSum + temp%10;
      temp = temp/10;
    }

    if (firstSum == secondSum && secondSum == thirdSum) {
      System.out.print("Goony!");
    } else {
      System.out.print("Pick up the phone!");
    }
  }
}
