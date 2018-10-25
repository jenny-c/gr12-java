import java.util.*;

public abstract class Participant {
  // variables
  protected ArrayList<Integer> hand;
  protected String name;
  protected int handValue;
  private boolean bust;

  // constructors
  public Participant() {
    hand = new ArrayList<>();
    handValue = 0;
    bust = false;
  } // end Player(String, double)

  // methods

  // returns String value of participant's hand
  public String handToString() {
    String temp = "";
    for (int i = 0; i < hand.size(); i++) {
      temp = temp + Deck.cardToString(hand.get(i)) + " ";
    } // end for
    return temp;
  } // end handToString()

  // returns the participant's name
  public String getName() {
    return name;
  } // end getName ()

  // returns the participant's hand
  public ArrayList<Integer> getHand() {
    return hand;
  } // end getHand()

  // changes boolean value of
  public void setBust(boolean bust) {
    this.bust = bust;
  } // end setLost()

  // returns whether or not participant has busted
  public boolean ifBust() {
    return bust;
  } // end ifLost()

  // returns total hand value of participant
  public int getHandValue() {
    handValue = handToValue(this.getHand());
    return handValue;
  } // end getHandValue()

  // calculates and returns the value of given hand
  public static int handToValue(ArrayList<Integer> hand) {
    int tempHandValue = 0;
    for (int i = 0; i < hand.size(); i++) {
      // if card is Ace and hand value will exceed 21, make Ace's value 1
      if ((hand.get(i) % 13 == 1) && (tempHandValue + 11) > 21) {
        tempHandValue = tempHandValue - 10;
      } // end if
      tempHandValue = tempHandValue + Deck.cardToValue(hand.get(i));
    } // end for
    return tempHandValue;
  } // end getHandValue

} // end Player
