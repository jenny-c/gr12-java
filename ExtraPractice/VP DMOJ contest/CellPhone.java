import java.util.*;

public class CellPhone {
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    int time = 0;

    char[] two = {'a', 'b', 'c'};
    char[] three = {'d', 'e', 'f'};
    char[] four = {'g', 'h', 'i'};
    char[] five = {'j', 'k', 'l'};
    char[] six = {'m', 'n', 'o'};
    char[] seven = {'p', 'q', 'r', 's'};
    char[] eight = {'t', 'u', 'v'};
    char[] nine = {'w', 'x', 'y', 'z'};

    char[][] phone = {two, three, four, five, six, seven, eight, nine};
    int lastIndex = -1;

    ArrayList<Integer> times = new ArrayList<>();


    String word = scan.nextLine();
    while (!word.equals("halt")) {
      char[] tempArray = word.toCharArray();

      for (int c = 0; c < tempArray.length; c++) {
        for (int i = 0; i < phone.length; i++)  {
          for (int j = 0; j < phone[i].length; j++) {
            if (tempArray[c] == phone[i][j]) {
              System.out.println("hi");
              if (i == lastIndex) {
                time = time + 2;
              }
              lastIndex = i;
              time = time + j;
            }
          }
        }
      }

      times.add(time);

      time = 0;
      word = scan.nextLine();
    }

    for (int i = 0; i < times.size(); i++) {
      System.out.println(times.get(i));
    }
  }
}
