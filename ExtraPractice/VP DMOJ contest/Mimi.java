import java.util.*;

public class Mimi {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int a = scan.nextInt();
    int R = scan.nextInt();

    int answer = R/a;

    if (answer < N) {
      System.out.println(answer);
    } else {
      System.out.println(N);
    }
  }
}
