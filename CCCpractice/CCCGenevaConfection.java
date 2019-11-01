import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int tests = scan.nextInt();
    ArrayList<Integer> cars = new ArrayList<>();
    ArrayList<Integer> spare = new ArrayList<>();

    for (int t = 0; t < tests; t++) {
      int n = scan.nextInt();
      int smallest = 1;

      for (int i = 0; i < n; i++) {
        cars.add(scan.nextInt());
      }

      int cIndex = cars.size()-1;
      int sIndex = spare.size()-1;
      int count = 0;

      while (cars.size() != 0 || (spare.size() != 0 && spare.get(sIndex) == smallest)) {

        if (cars.size() != 0 && (cars.get(cIndex) == smallest)) {
          cars.remove(cIndex);
          smallest = smallest + 1;
        } else if (spare.size() != 0 && spare.get(sIndex) == smallest) {
          spare.remove(sIndex);
          smallest = smallest + 1;
        } else {
          spare.add(cars.get(cIndex));
          cars.remove(cIndex);
        }
        cIndex = cars.size()-1;
        sIndex = spare.size()-1;
      }
      if (cars.size() == 0 && spare.size() == 0) {
        System.out.println("Y");
      } else {
        System.out.println("N");
        cars.clear();
        spare.clear();
      }
    }

  }
}
