import java.util.*;

public class CCCRoboThieves {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    ArrayList<char[]> grid = new ArrayList<>();
    int startRow = 0;
    int startCol = 0;
    int stepCount = 0;

    int numberOfRows = scan.nextInt();
    int numberOfColumns = scan.nextInt();
    scan.nextLine();

    for (int i = 0; i < numberOfRows; i++) {
      grid.add((scan.nextLine()).toCharArray());
    }

    // System.out.println((grid.get(1))[2]);

    // find position of empty cells
    for (int i = 0; i < numberOfRows; i++) {
      
    }
  }
}
