import java.util.*;
import java.lang.*;

public class CCCLazyFox {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int maxTreats = 0;
    int treats = 0;

    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();

    for (int n = 0; n < N; n++) {
      x.add(scan.nextInt());
      y.add(scan.nextInt());
    }

    for (int n = 0; n < N; n++) {
      treats = 0;
      int prevDist = sqrt(x.get(n)*x.get(n) + y.get(n)*y.get(n));
      treats = treats + 1;
    }

  }

  public 
}
