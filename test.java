import java.util.*;

public class test {
  public static void main (String[] args) {
    System.out.println("hello world");
    ArrayList<Integer> l=new ArrayList<>();
        l.add(10);
        l.add(11);
        l.add(12);
        l.add(13);
        l.add(14);
        l.forEach((a)->System.out.println(a));
  }
}
