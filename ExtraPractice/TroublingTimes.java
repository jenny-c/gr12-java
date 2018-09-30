import java.util.*;

public class TroublingTimes {
  // instance variables
  public static ArrayList<Integer> intervals = new ArrayList<>();
  public static int dest = 0;
  public static boolean reachable = false;

  public static void getUserInput() {
    Scanner scan = new Scanner(System.in);
    int count = scan.nextInt();
    dest = scan.nextInt();
    if (dest < 0) {
      dest = dest * -1;
    } // end if
    for (int i = 0; i < count;i++) {
      intervals.add(scan.nextInt());
    } // end for
    scan.close();
  } // end getUserInput()

  public static boolean isPossibleInterval(int interval) {
    return (dest % interval == 0);
  }

  public static void printResults(int n) {
    if (reachable) {
      System.out.println(n);
    } else {
      System.out.println("This is not the best time for a trip.");
    }
  }

  public static void main (String [] args) {
    getUserInput();
    if (dest == 0) {
      System.out.println(0);
    } else {
      int minJumps = -1;
      for (int i = 0; i < intervals.size(); i++) {
        if (isPossibleInterval(intervals.get(i))) {
          if ((dest / intervals.get(i)) < minJumps || minJumps == -1) {
            minJumps = dest / intervals.get(i);
          } // end if
        } // end if
      } // end for
      reachable = !(minJumps == -1);
      printResults(minJumps);
    } // end if
  } // end main()

}
