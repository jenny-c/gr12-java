import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    boolean done = true;

    String[] first = new String[n];
    String[] second = new String[n];

    for (int i = 0; i < n; i++) {
      first[i] = scan.next();
    }
    for (int i = 0; i < n; i++) {
      second[i] = scan.next();
    }

    if (n%2 != 0) {
      System.out.println("bad");
    } else {

      outside:
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (second[j].equals(first[i])) {
            if (!(first[j].equals(second[i])) || first[i].equals(second[i])) {
              done = false;
              break outside;
            }
          }
        }
      }
      if (done) {
        System.out.println("good");
      } else {
        System.out.println("bad");
      }
    }
  }
}
