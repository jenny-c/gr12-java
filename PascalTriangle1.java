import java.util.*;

public class PascalTriangle1 {
  public static void main (String[] args) {
    final String space = " ";
    int numberOfLevels;
    int levelCount = 1;
    ArrayList<Integer> pastLevel = new ArrayList<>();
    ArrayList<Integer> currentLevel = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    System.out.print("Number of rows: ");
    numberOfLevels = scan.nextInt();

    for (; levelCount <= numberOfLevels; levelCount++) {
      // print first level
      if (levelCount == 1) {
        System.out.println(1);
        pastLevel.add(1);
        continue;
      }

      // add in the row
      for (int i = 1; i <= levelCount; i++) {
        // add 1 if first or last term in the row
        if ((i == 1) || (i == levelCount)) {
          currentLevel.add(1);
        } else {
          currentLevel.add(pastLevel.get(i-2) + pastLevel.get(i-1));
        }
      }

      // print the row

      // formatting
      System.out.print(currentLevel.get(0));
      for (int i = 1; i < currentLevel.size(); i++) {
        if (currentLevel.get(i) < 10) {
          System.out.print("    ");
        } else if (currentLevel.get(i) >= 10 && currentLevel.get(i) < 100) {
          System.out.print("   ");
        } else {
          System.out.print("  ");
        }
        System.out.print(currentLevel.get(i));
      }
      System.out.println();
      pastLevel.clear();
      pastLevel.addAll(currentLevel);
      currentLevel.clear();
    }
  }
}
