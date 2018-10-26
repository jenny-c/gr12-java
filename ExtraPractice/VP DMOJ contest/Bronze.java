import java.util.*;

public class Bronze {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int uglyCount = 0;
    int numSold = scan.nextInt();
    ArrayList<Integer> heights = new ArrayList<>();

    for (int i = 0; i < numSold; i++) {
      heights.add(scan.nextInt());
    }

    if (heights.get(0) < 42 && heights.get(1) < 42) {
      uglyCount++;
    }

    for (int i = 1; i < heights.size()-1; i++) {
      if (heights.get(i-1) < 42 && heights.get(i) < 42 && heights.get(i+1) < 42) {
        uglyCount++;
      }
    }

    System.out.print(uglyCount);

  }
}
