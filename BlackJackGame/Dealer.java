import java.util.*;

public class Dealer extends Participant {
  // constructorsi
  public Dealer() {
    this.name = dealerName;
  } // end Dealer()

  // methods

  // returns String value of dealer
  public String toString() {
    return ("I am the dealer.");
  } // end toString(Player)

  // returns String value of dealer's hand (with ?)
  public String startHandToString() {
    return "" + Deck.cardToString(hand.get(0)) + "  ?";
  } // end startHandToString

  // return whether or not dealer will hit
  public boolean ifDealerHit() {
    return handValue < 17;
  } // end ifDealerHit()

} // end Dealer
