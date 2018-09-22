import java.util.*;

public class CCCRoboThieves {
  static ArrayList<char[]> grid = new ArrayList<>();
  static ArrayList<Integer> emptyCellRows = new ArrayList<>();
  static ArrayList<Integer> emptyCellColumns = new ArrayList<>();
  static ArrayList<Integer> stepsNeeded = new ArrayList<>();
  static int stepCount = 0;
  static int tempStepCount = 0;
  static int startRow = 0;
  static int startCol = 0;

  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    // 0 is left, 1 is up, 2 is right, 3 is down
    int direction = 0;

    int numberOfRows = scan.nextInt();
    int numberOfColumns = scan.nextInt();
    scan.nextLine();

    for (int i = 0; i < numberOfRows; i++) {
      grid.add((scan.nextLine()).toCharArray());
    }
    // System.out.println("done scanning");


    // System.out.println((grid.get(1))[2]);

    // find position of empty cells
    for (int i = 0; i < numberOfRows; i++) {
      for (int x = 0; x < numberOfColumns; x++) {
        System.out.println("starting search");
        if ((grid.get(i))[x] == '.') {
          stepsNeeded.add(0);
          emptyCellRows.add(i);
          emptyCellColumns.add(x);
          continue;
          // System.out.println("empty cell at: " + i + ", " + x);
        } else if ((grid.get(i))[x] == 'C') {
          // System.out.println("camera stuff");
          (grid.get(i))[x] = 'W';
          direction = 0;
          switch ((grid.get(i))[x-1]) {
            case '.':
              switch (direction) {
                case 0:
                  (grid.get(i))[x-1] = 'W';
                  break;
                case 1:
                  (grid.get(i-1))[x] = 'W';
                  break;
                case 2:
                  (grid.get(i))[x+1] = 'W';
                  break;
                case 3:
                  (grid.get(i+1))[x] = 'W';
                  break;
              }
              break;
            case 'L':
            case 'R':
            case 'U':
            case 'D':
              int count = 1;
              switch (direction) {
                case 0:
                  while (true) {
                    if ((grid.get(i))[x-1-count] == 'L' || (grid.get(i))[x-1-count] == 'R' || (grid.get(i))[x-1-count] == 'U' || (grid.get(i))[x-1-count] == 'D') {
                      count++;
                    } else {
                      (grid.get(i))[x-1-count] = 'W';
                      break;
                    }
                  }
                  break;
                case 1:
                  while (true) {
                    if ((grid.get(i-1-count))[x] == 'L' || (grid.get(i-1-count))[x] == 'R' || (grid.get(i-1-count))[x] == 'U' || (grid.get(i-1-count))[x] == 'D') {
                      count++;
                    } else {
                      (grid.get(i-1-count))[x] = 'W';
                      break;
                    }
                  }
                  break;
                case 2:
                  while (true) {
                    if ((grid.get(i))[x+1+count] == 'L' || (grid.get(i))[x+1+count] == 'R' || (grid.get(i))[x+1+count] == 'U' || (grid.get(i))[x+1+count] == 'D') {
                      count++;
                    } else {
                      (grid.get(i))[x+1+count] = 'W';
                      break;
                    }
                  }
                  break;
                case 3:
                  while (true) {
                    if ((grid.get(i+1+count))[x] == 'L' || (grid.get(i+1+count))[x] == 'R' || (grid.get(i+1+count))[x] == 'U' || (grid.get(i+1+count))[x] == 'D') {
                      count++;
                    } else {
                      (grid.get(i+1+count))[x] = 'W';
                      break;
                    }
                  }
              }
              break;
          }
          direction++;
          switch ((grid.get(i-1))[x]) {
            case '.':
              switch (direction) {
                case 0:
                  (grid.get(i))[x-1] = 'W';
                  break;
                case 1:
                  (grid.get(i-1))[x] = 'W';
                  break;
                case 2:
                  (grid.get(i))[x+1] = 'W';
                  break;
                case 3:
                  (grid.get(i+1))[x] = 'W';
                  break;
              }
              break;
            case 'L':
            case 'R':
            case 'U':
            case 'D':
              int count = 1;
              switch (direction) {
                case 0:
                  while (true) {
                    if ((grid.get(i))[x-1-count] == 'L' || (grid.get(i))[x-1-count] == 'R' || (grid.get(i))[x-1-count] == 'U' || (grid.get(i))[x-1-count] == 'D') {
                      count++;
                    } else {
                      (grid.get(i))[x-1-count] = 'W';
                      break;
                    }
                  }
                  break;
                case 1:
                  while (true) {
                    if ((grid.get(i-1-count))[x] == 'L' || (grid.get(i-1-count))[x] == 'R' || (grid.get(i-1-count))[x] == 'U' || (grid.get(i-1-count))[x] == 'D') {
                      count++;
                    } else {
                      (grid.get(i-1-count))[x] = 'W';
                      break;
                    }
                  }
                  break;
                case 2:
                  while (true) {
                    if ((grid.get(i))[x+1+count] == 'L' || (grid.get(i))[x+1+count] == 'R' || (grid.get(i))[x+1+count] == 'U' || (grid.get(i))[x+1+count] == 'D') {
                      count++;
                    } else {
                      (grid.get(i))[x+1+count] = 'W';
                      break;
                    }
                  }
                  break;
                case 3:
                  while (true) {
                    if ((grid.get(i+1+count))[x] == 'L' || (grid.get(i+1+count))[x] == 'R' || (grid.get(i+1+count))[x] == 'U' || (grid.get(i+1+count))[x] == 'D') {
                      count++;
                    } else {
                      (grid.get(i+1+count))[x] = 'W';
                      break;
                    }
                  }
                  break;
              }
              break;
          }
          direction++;
          switch ((grid.get(i))[x+1]) {
            case '.':
              switch (direction) {
                case 0:
                  (grid.get(i))[x-1] = 'W';
                  break;
                case 1:
                  (grid.get(i-1))[x] = 'W';
                  break;
                case 2:
                  (grid.get(i))[x+1] = 'W';
                  break;
                case 3:
                  (grid.get(i+1))[x] = 'W';
                  break;
              }
              break;
            case 'L':
            case 'R':
            case 'U':
            case 'D':
              int count = 1;
              switch (direction) {
                case 0:
                  while (true) {
                    if ((grid.get(i))[x-1-count] == 'L' || (grid.get(i))[x-1-count] == 'R' || (grid.get(i))[x-1-count] == 'U' || (grid.get(i))[x-1-count] == 'D') {
                      count++;
                    } else {
                      (grid.get(i))[x-1-count] = 'W';
                      break;
                    }
                  }
                  break;
                case 1:
                  while (true) {
                    if ((grid.get(i-1-count))[x] == 'L' || (grid.get(i-1-count))[x] == 'R' || (grid.get(i-1-count))[x] == 'U' || (grid.get(i-1-count))[x] == 'D') {
                      count++;
                    } else {
                      (grid.get(i-1-count))[x] = 'W';
                      break;
                    }
                  }
                  break;
                case 2:
                  while (true) {
                    if ((grid.get(i))[x+1+count] == 'L' || (grid.get(i))[x+1+count] == 'R' || (grid.get(i))[x+1+count] == 'U' || (grid.get(i))[x+1+count] == 'D') {
                      count++;
                    } else {
                      (grid.get(i))[x+1+count] = 'W';
                      break;
                    }
                  }
                  break;
                case 3:
                  while (true) {
                    if ((grid.get(i+1+count))[x] == 'L' || (grid.get(i+1+count))[x] == 'R' || (grid.get(i+1+count))[x] == 'U' || (grid.get(i+1+count))[x] == 'D') {
                      count++;
                    } else {
                      (grid.get(i+1+count))[x] = 'W';
                      break;
                    }
                  }
                  break;
              }
              break;
          }
          direction++;
          switch ((grid.get(i+1))[x]) {
            case '.':
              switch (direction) {
                case 0:
                  (grid.get(i))[x-1] = 'W';
                  break;
                case 1:
                  (grid.get(i-1))[x] = 'W';
                  break;
                case 2:
                  (grid.get(i))[x+1] = 'W';
                  break;
                case 3:
                  (grid.get(i+1))[x] = 'W';
                  break;
              }
              break;
            case 'L':
            case 'R':
            case 'U':
            case 'D':
              int count = 1;
              switch (direction) {
                case 0:
                  while (true) {
                    if ((grid.get(i))[x-1-count] == 'L' || (grid.get(i))[x-1-count] == 'R' || (grid.get(i))[x-1-count] == 'U' || (grid.get(i))[x-1-count] == 'D') {
                      count++;
                    } else {
                      (grid.get(i))[x-1-count] = 'W';
                      break;
                    }
                  }
                  break;
                case 1:
                  while (true) {
                    if ((grid.get(i-1-count))[x] == 'L' || (grid.get(i-1-count))[x] == 'R' || (grid.get(i-1-count))[x] == 'U' || (grid.get(i-1-count))[x] == 'D') {
                      count++;
                    } else {
                      (grid.get(i-1-count))[x] = 'W';
                      break;
                    }
                  }
                  break;
                case 2:
                  while (true) {
                    if ((grid.get(i))[x+1+count] == 'L' || (grid.get(i))[x+1+count] == 'R' || (grid.get(i))[x+1+count] == 'U' || (grid.get(i))[x+1+count] == 'D') {
                      count++;
                    } else {
                      (grid.get(i))[x+1+count] = 'W';
                      break;
                    }
                  }
                  break;
                case 3:
                  while (true) {
                    if ((grid.get(i+1+count))[x] == 'L' || (grid.get(i+1+count))[x] == 'R' || (grid.get(i+1+count))[x] == 'U' || (grid.get(i+1+count))[x] == 'D') {
                      count++;
                    } else {
                      (grid.get(i+1+count))[x] = 'W';
                      break;
                    }
                  }
                  break;
              }
              break;
          }
        } else if ((grid.get(i))[x] == 'S') {
          startRow = i;
          startCol = x;
        }
      }
    }

    // mark the ones that are impossible to reach
    for (int i = 0; i < emptyCellRows.size(); i++) {
      if (grid.get(i)[i] == 'W') {
        stepsNeeded.add(i, -1);
      }
    }

    while (true) {
      stepCount++;
      tempStepCount = stepCount;
      move(startRow, startCol);
      break;
    }


    // System.out.println("done search");
    //for (int y = 0; y < numberOfRows; y++) {
      //System.out.println(grid.get(y));
    //}

    // figure out paths and count steps
  }

  public static void move (int startRow, int startCol) {

  }
}
