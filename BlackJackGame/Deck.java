public class Deck {
  // variables
  private int[] cards;
  private int cardsLeft;
  private int numCards;

  // constructors
  public Deck() {
    numCards = 52;
    cards = new int[numCards];
    cardsLeft = numCards;
    for (int i = 0; i < numCards; i++) {
      cards[i] = i;
    } // end for
  } // end Deck()

  // methods

  // returns String value of individual card
  public static String cardToString(int numInList){
    char[] suits = {(char)'\u2660', (char)'\u2665', (char)'\u2666', (char)'\u2663'};
    String cardIs = "";
    int cardType = numInList % 13;
    char cardNum;

    //If card is A, K, J, or Q, sets it as such, otherwise card is equal to number%13
    if (cardType == 0) {
      cardNum = 'K';
    } else if (cardType == 1) {
      cardNum = 'A';
    } else if (cardType == 11) {
      cardNum = 'J';
    } else if (cardType == 12) {
      cardNum = 'Q';
    } else {
      cardNum = (char)(cardType+'0');
    } // end if

    if (cardType != 10) {
      cardIs = "" + cardNum + suits[(int)(numInList/13)];
    } else {
      cardIs = "10" + suits[(int)(numInList/13)];
    } // end if

    return cardIs;
  } // end cardToString(int)

  // returns value of card
  public static int cardToValue(int numOfList) {
    int cardValue;

    //If card is K,J,Q, returns value of 10
    if (numOfList % 13 == 0 || (numOfList % 13 >= 10 && numOfList % 13 <= 12)) {
      cardValue = 10;
    }
    //If ace, return value of 11 or 1 depending on the value of the hand
    else if (numOfList % 13 == 1) {
      cardValue = 11;
    }
    //All other cards values are their number%13
    else {
      cardValue = numOfList % 13;
    } // end if
    return cardValue;
  } // end cardToValue(int)

  // shuffles the deck by randomly switching cards
  public void shuffle() {
    int temp;
    for (int i = 0; i < numCards; i++) {
      int tempIndex = (int)(Math.random() * numCards);
      int tempValue = cards[i];
      cards[i] = cards[tempIndex];
      cards[tempIndex] = tempValue;
    } // end for
  } // end shuffle()

  // returns String value of the deck
  public String toString() {
    String temp = "";
    for (int i = 0; i < cardsLeft; i++) {
      temp = temp + (this.cardToString(cards[i])) + " ";
    } // end for
    return temp;
  } // end toString()

  public int getNumCardsLeft() {
    return cardsLeft;
  } // end getNumCardsLeft()

  // resets the cardsLeft count
  public void reset() {
    cardsLeft = numCards;
  } // end reset()

  // returns the last card in the deck
  public int dealCard() {
    return cards[--cardsLeft]; // returns last card in deck
  } // end dealCard()

} // end Deck
