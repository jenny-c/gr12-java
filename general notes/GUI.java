// GUI

import java.awt.*; // abstract window toolkit
import javac.swing.*;

public class TestFrame {
  public static void main (String[] args) {
    MyFrame frame = new MyFrame("Test frame");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}

public class MyFrame extends JFrame {
  private JButton b;
  private Container c;

  public MyFrame(String title) {
    super(title);
    c = getContentPane();
    c.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 30));
    // FlowLayout, BorderLayout, GridLayout, CardLayout
    b = new JButton("AAAAAA");
    this.add(b);
    this.setSize(400, 500); // make setSize last line in constructor
  }
}

/*
BorderLayout

container.setLayout(new BorderLayout(5, 10));
  sets spaces between each thing (horizontal gap: 5, vertical gap: 10)

BorderLayout.EAST;
BorderLayout.SOUTH;
etc.
*/

/*
GridLayout

container.setLayout(new GridLayout(3, 4, 5, 5));
  sets: number of rows, number of columns, horizontal gap, vertical gap

*/

/*
CardLayout

- use different panels

*/

// review how to perform action s

/*
BoxLayout

*/


extends JFrame implements ActionListener

.addActionListener(this);
.getSource();
