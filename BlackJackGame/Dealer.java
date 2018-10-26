import java.util.*;

public class Dealer extends Participant {
  // instance variables
  private int maxHandValue;

  // constructorsi
  public Dealer() {
    this.name = "dealer";
    maxHandValue = 17;
  } // end Dealer()

  // methods

  // returns String value of dealer
  public String toString() {
    return ("I am the dealer.");
  } // end toString(Player)

  // returns String value of dealer's hand (with ?)
  public String handToString(boolean startingHand) {
    if (startingHand) {
      return "" + Deck.cardToString(hand.get(0)) + "  ?";
    } // end if
    return this.handToString();
  } // end startHandToString

  // return whether or not dealer will hit
  public boolean ifDealerHit() {
    return handValue < maxHandValue;
  } // end ifDealerHit()

} // end Dealer
