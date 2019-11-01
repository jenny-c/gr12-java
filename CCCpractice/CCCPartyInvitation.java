import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int rounds = scan.nextInt();
    ArrayList<Integer> invitees = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      invitees.add(i);
    }

    for (int j = 0; j < rounds; j++) {
      int r = scan.nextInt();
      int count = 1;
      int index = r;
      int mult = 2;
      while (index <= invitees.size()) {
        invitees.remove(index-1);
        index = (mult*r)-count;
        mult = mult + 1;
        count = count + 1;
      }
    }

    for (int i = 0; i < invitees.size(); i++) {
      System.out.println(invitees.get(i));
    }
  }
}
