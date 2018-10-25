import java.util.*;

public class Player extends Participant {
  // variables
  protected double money;
  private double wager;
  private boolean won;

  // constructors
  public Player(String name, double money) {
    this.name = name;
    this.money = money;
    wager = 0;
  } // end Player(String, double)

  // methods

  // returns String value of Player
  public String toString() {
    return ("My name is " + this.name + ". I have $" + String.format("%.2f", this.money));
  } // end toString()

  // sets player's value of money
  public void setMoney(double m) {
    money = m;
  } // end setMoney(double)

  // returns player's amount of money
  public double getMoney() {
    return money;
  } // end getMoney()

  // sets player's wager
  public void setWager(Double w) {
    wager = w;
  } // end setWager(double)

  // returns player's wager
  public double getWager() {
    return wager;
  } // end getWager()

} // end Player
