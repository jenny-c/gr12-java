import java.util.*;

public class CCCSunflowers {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    int position = 0;
    int count = 0;

    int numberOfLines = scan.nextInt();
    scan.nextLine();

    ArrayList<Integer> rows = new ArrayList<>();

    // figure out which position the data is in (four different possible positions)
    int firstPositionNumber = 0;
    int secondPositionNumber = 0;
    int thirdPositionNumber = 0;
    int fourthPositionNumber = 0;

    for (int x = 0; x < numberOfLines; x++) {
      for (int i = 0; i < numberOfLines; i++) {
        rows.add(scan.nextInt());
      }
      scan.nextLine();
    }

    firstPositionNumber = rows.get(0);
    secondPositionNumber = rows.get(numberOfLines-1);
    thirdPositionNumber = rows.get(numberOfLines*(numberOfLines-1));
    fourthPositionNumber = rows.get(numberOfLines*numberOfLines-1);

    // System.out.println(firstPositionNumber + " " + secondPositionNumber + " " + thirdPositionNumber + " " + fourthPositionNumber);

    if (firstPositionNumber < secondPositionNumber) {
      if (firstPositionNumber < thirdPositionNumber) {
        if (firstPositionNumber < fourthPositionNumber) {
          position = 1;
        } else {
          position = 4;
        } // end of if (firstPositionNumber < fourthPositionNumber)
      } else {
        if (thirdPositionNumber < fourthPositionNumber) {
          position = 3;
        } else {
          position = 4;
        }
      } // end of if (firstPositionNumber < thirdPositionNumber)
    } else {
      if (secondPositionNumber < thirdPositionNumber) {
        if (secondPositionNumber < fourthPositionNumber) {
          position = 2;
        } else {
          position = 4;
        }
      } else {
        if (thirdPositionNumber < fourthPositionNumber) {
          position = 3;
        } else {
          position = 4;
        }
      }
    } // end of if (firstPositionNumber < secondPositionNumber)

    // System.out.println(position);

    // rearrange numbers according to what starting position they're in
    switch (position) {
      case 1:
        for (int x = 0; x < numberOfLines; x++) {
          for (int i = 0; i < numberOfLines; i++) {
            System.out.print(rows.get(count) + " ");
            count++;
          }
          System.out.println();
        }
        break;

      case 2:
        for (int x = 0; x < numberOfLines; x++) {
          count = numberOfLines - (x+1);
          for (int i = 0; i < numberOfLines; i++) {
            System.out.print(rows.get(count) + " ");
            count += numberOfLines;
          }
          System.out.println();
        }
        break;

      case 3:
        for (int x = 0; x < numberOfLines; x++) {
          count = numberOfLines * (numberOfLines-1) + x;
          for (int i = 0; i < numberOfLines; i++) {
            System.out.print(rows.get(count) + " ");
            count -= numberOfLines;
          }
          System.out.println();
        }
        break;

      case 4:
        for (int x = 0; x < numberOfLines; x++) {
          count = numberOfLines * (numberOfLines - x) - 1;
          for (int i = 0; i < numberOfLines; i++) {
            System.out.print(rows.get(count) + " ");
            count -= 1;
          }
          System.out.println();
        }
        break;
    }
  }
}
