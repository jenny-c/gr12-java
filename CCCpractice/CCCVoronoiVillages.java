import java.util.*;

public class CCCVoronoiVillages {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    int numberOfVillages = scan.nextInt();
    double smallestVillage = 0.0;

    // get input
    ArrayList<Integer> villages = new ArrayList<>();
    ArrayList<Double> villageSizes = new ArrayList<>();
    for (int i = 0; i < numberOfVillages; i++) {
      villages.add(scan.nextInt());
    } // end of for loop
    Collections.sort(villages);

    // get village sizes
    for (int i = 1; i < (villages.size() - 1); i++) {
      double size = ((villages.get(i) - villages.get(i-1)) / 2.0) + ((villages.get(i+1) - villages.get(i)) / 2.0);
      villageSizes.add(size);
    } // end of for loop

    for (int i = 0; i < villageSizes.size(); i++) {
      if ((i == 0) || (villageSizes.get(i) < smallestVillage)) {
        smallestVillage = villageSizes.get(i);
      }
    } // end of for loop

    System.out.printf("%.1f", smallestVillage);
  }
}
