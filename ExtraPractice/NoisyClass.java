import java.util.*;

public class NoisyClass {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    ArrayList<Integer> col1 = new ArrayList<>();
    ArrayList<Integer> col2 = new ArrayList<>();
    ArrayList<Integer> validNum = new ArrayList<>();

    int numStudents = scan.nextInt();
    int numConnections = scan.nextInt();

    // populate arrays
    for (int i = 0; i < numConnections; i++) {
      col1.add(scan.nextInt());
      col2.add(scan.nextInt());
    } // end for
    for (int i = 1; i <= numStudents; i++) {
      validNum.add(i);
    } // end for

    for (int i = 0; i < validNum.size(); i++) {

      for (int j = 0; j < col2.size(); j++) {
        if (col2.get(j) == validNum.get(i)) {
          break;
        } else if (j == col2.size()-1) {

          for (int t = 0; t < col1.size(); t++) {
            if (col1.get(t) == validNum.get(i)) {
              col1.remove(t);
              col2.remove(t);
              --t;
            } // end if
          } // end for
          validNum.remove(i);
          i = -1;

        } // end if
      } // end for

    } // end for


    if (col2.isEmpty()) {
      System.out.println("Y");
    } else {
      System.out.println("N");
    } // end if
  }
}
