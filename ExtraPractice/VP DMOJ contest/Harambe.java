import java.util.*;

public class Harambe {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    String first = scan.nextLine();
    String second = scan.nextLine();
    int k = scan.nextInt();
    int count = 0;
    boolean done = false;

    char[] firstArray = first.toCharArray();
    char[] secondArray = second.toCharArray();

    for (int i = 0; i < firstArray.length; i++) {
      if (firstArray.length != secondArray.length) {
        System.out.println("No plagiarism");
        done = true;
        break;
      }
      if (firstArray[i] != secondArray[i]) {
        count = count + 1;
      }
      if ((firstArray[i] == ' ' && secondArray[i] != ' ') || (secondArray[i] == ' ' && firstArray[i] != ' ')) {
        System.out.println("No plagiarism");
        done = true;
        break;
      }
    }

    if (!done) {
      if (count < k) {
        System.out.println("Plagiarized");
      } else {
        System.out.println("No plagiarism");
      }
    }
  }

}
