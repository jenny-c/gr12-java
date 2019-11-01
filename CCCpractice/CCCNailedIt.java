import java.io.*;
import java.util.*;
import java.lang.*;

public class CCCNailedIt {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int numBoards = scan.nextInt();
    // ArrayList<Integer> boards = new ArrayList<>();
    int[] boards = new int[numBoards];
    ArrayList<Integer> previousHeights = new ArrayList<>();

    for (int i = 0; i < numBoards; i++) {
      // boards.add(scan.nextInt());
      boards[i] = scan.nextInt();
    }

    int height;
    int length;
    int maxLength = 0;
    int numHeights = 0;

    for (int i = 0; i < numBoards; i++) {
      for (int j = i+1; j < numBoards; j++) {
        if (i == j) continue;

        height = boards[i] + boards[j];
        if (previousHeights.contains(height)) continue;
        previousHeights.add(height);
        length = 1;

        for (int x = 0; x < numBoards; x++) {
          if (x == i || x == j) continue;
          for (int y = x+1; y < numBoards; y++) {
            if (y == i || y == j) continue;
            if (boards[x] + boards[y] == height) {
              length = length + 1;
            }
          }
        }
        if (length > maxLength) {
          maxLength = length;
          numHeights = 1;
        } else if (length == maxLength) {
          numHeights = numHeights + 1;
        }
      }
    }

    System.out.print(maxLength + " " + numHeights);
  }
}
