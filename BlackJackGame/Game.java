import java.util.*;

public class Game{
  // variables
  private Dealer dealer;
  private Deck deck;
  private Player[] players;
  private Scanner scan = new Scanner(System.in);
  private int numPlayers;
  private int roundCount;
  private boolean gameOver;

  // constructor
  public Game() {
    // initialize variables
    gameOver = false;
    roundCount = 1;
    deck = new Deck();

    // create, print, and shuffle deck
    setUpDeck();

    // create player(s)
    initializePlayers();

    // create dealer
    dealer = new Dealer();

    // play game; start rounds
    while (!gameOver) {
      // introduce round
      System.out.println("\n---------------------------");
      System.out.println("ROUND " + roundCount + ":\n");

      // deal starting cards to players and dealer
      dealStartingCards();

      // get wagers for each player
      getPlayerWagers();

      // display hands
      displayStartingHands();

      // go through each player and process their choice
      playPlayers();

      // dealer plays
      playDealer();

      // find winners (whoever is above dealer and not bust), or whoever is above dealer
      displayRoundResults();

      // ask player if play another round
      System.out.print("Do you want to play another round? [Y/N] ");
      boolean validAnswer = false;
      while (!validAnswer) {
        scan.nextLine();
        String answer = (scan.nextLine()).toLowerCase();
        if (answer.equals("y") || answer.equals("yes")) {
          roundCount++;
          validAnswer = true;
          // reset deck, hands, ifBust if starting a new round
          resetGame();
        } else if (answer.equals("n") || answer.equals("no")) {
          System.out.println("Thanks for playing!");
          validAnswer = true;
          gameOver = true;
        } else {
          System.out.print("Please enter a valid answer: [Y/N] ");
        } // end if
      } // end while (!validAnswer)
    } // end while (!gameOver)
  } // end Game()

  // methods

  // method to deal starting cards to player and dealer
  private void dealStartingCards() {
    // everyone gets two cards at the beginning
    for (int i = 0; i < numPlayers; i++) {
      Player currentPlayer = players[i];

      currentPlayer.getHand().add(deck.dealCard());
      currentPlayer.getHand().add(deck.dealCard());
    } // end for

    dealer.getHand().add(deck.dealCard());
    dealer.getHand().add(deck.dealCard());
  } // end dealCards()

  // method to display hand of given participant
  private void displayHand(Participant p) {
    System.out.print(p.getName() + "'s hand: ");
    System.out.print(p.handToString() + "[total: " + p.getHandValue() + "]");
  } // end displayHand()

  // method to display player's money
  private void displayMoney(Player p) {
    System.out.println(p.getName() + ": $" + p.getMoney());
  }

  // method to display the results of that round
  private void displayRoundResults() {
    // display results for this round
    System.out.println();
    System.out.println("---------------------------");
    System.out.println("ROUND " + roundCount + " RESULTS: ");
    System.out.println();

    // display dealer's end hand
    System.out.println("Hands: ");
    displayHand(dealer);
    System.out.println();

    // display end hands of players and whether or not they won
    for (int i = 0; i < numPlayers; i++) {
      displayHand(players[i]);
      if (players[i].ifBust() == true) {
        System.out.println(" Bust!");
        players[i].setMoney(players[i].getMoney() - players[i].getWager());
      } else if ((dealer.ifBust() == true) || (players[i].getHandValue() > dealer.getHandValue())) {
        System.out.println(" Winner!");
        players[i].setMoney(players[i].getMoney() + players[i].getWager());
      } else if (players[i].getHandValue() == dealer.getHandValue()) {
        System.out.println(" Tied with dealer!");
      } else {
        System.out.println(" Lost!");
        players[i].setMoney(players[i].getMoney() - players[i].getWager());
      } // end if
    } // end

    // display how much money each player has left
    for (int i = 0; i < numPlayers; i++) {
      displayMoney(players[i]);
    } // end for
    System.out.println("\n");
  }

  // method to display starting hands of dealer and players
  private void displayStartingHands() {
    // display dealer's hands
    System.out.println();
    System.out.print("Dealer's hand: ");
    System.out.println(dealer.startHandToString());

    for (int i = 0; i < numPlayers; i++) {
      // display each person's hands
      displayHand(players[i]);
      System.out.println();
    } // end for

    System.out.println();
  } // end displayStartingHands()

  // method to print and shuffle deck
  private void setUpDeck() {
    // set up deck
    System.out.println(deck); // print unshuffled
    deck.shuffle();
    System.out.println(deck); // print shuffled
    System.out.println();
  } // end setUpDeck()

  // method to get user input and initialize players accordingly
  private void initializePlayers() {
    System.out.print("How many players are there? ");
    numPlayers = scan.nextInt();
    scan.nextLine();
    players = new Player[numPlayers];
    System.out.println();

    for (int i = 0; i < numPlayers; i++) {
      System.out.println("For player " + (i+1) + ": ");
      System.out.print("  What is their name? ");
      String name = scan.nextLine();

      System.out.print("  How much money do they have? ");
      double money = scan.nextDouble();
      scan.nextLine();

      Player tempPlayer = new Player(name, money);
      players[i] = tempPlayer;
    } // end for
  }

  // method to get user input (each player's wagers)
  private void getPlayerWagers() {
    for (int i = 0; i < numPlayers; i++) {
      boolean validWager = false;
      System.out.print(players[i].getName() + "'s wager: ");
      double wager = scan.nextDouble();

      // error message -> find more errors and fill in
      while (!validWager) {
        if (wager <= players[i].getMoney()) {
          players[i].setWager(wager);
          validWager = true;
        } else {
          System.out.print("Please enter a valid wager: ");
          wager = scan.nextDouble();
        }
      }
      scan.nextLine();
    } // end for()
  }

  // method to iterate through player and let them play their turn
  private void playPlayers() {
    for (int i = 0; i < numPlayers; i++) {
      // display each person's hands
      displayHand(players[i]);
      System.out.println();

      // get and process player's choice
      int choice = 0;
      if (players[i].getHandValue() < 21) {
        while (choice != 2) {
          System.out.print("Hit or stand? [1 or 2] ");
          choice = scan.nextInt();
          if (choice == 1) {
            players[i].getHand().add(deck.dealCard());
            displayHand(players[i]);
            System.out.println();
            if (players[i].getHandValue() >= 21) {
              if (players[i].getHandValue() > 21) {
                System.out.println("Bust!");
                players[i].setBust(true);
              } // end if
              break;
            }
          } else if (choice != 2) {
            System.out.println("Please enter a valid choice.");
          } // end if
        } // end while
      } else { // player starts with 21, a blackjack
        System.out.println(players[i].getName() + " has Blackjack!");
      } // end if

      System.out.println();
    } // end for
  } // end playersTurns()

  // method for the dealer to play their turn
  private void playDealer() {
    boolean turnOver = false;
    if (dealer.getHandValue() == 21) {
      System.out.println("Dealer has Blackjack!");
      return;
    } // end if

    while (!turnOver) {
      displayHand(dealer);
      if (dealer.ifDealerHit()) {
        System.out.println(" Dealer hit!");
        dealer.getHand().add(deck.dealCard());
        if (dealer.getHandValue() > 21) {
          displayHand(dealer);
          System.out.print(" Dealer bust!");
          dealer.setBust(true);
          turnOver = true;
        } // end if
        System.out.println();
      } else {
        System.out.println(" Dealer stands");
        turnOver = true;
      } // end if
    } // end while
  } // end playDealer()

  // method to reset stats from last round
  private void resetGame() {
    deck.reset();
    deck.shuffle();
    dealer.getHand().clear();
    dealer.setBust(false);
    for (int i = 0; i < numPlayers; i++) {
      players[i].getHand().clear();
      players[i].setBust(false);
    } // end if
  } // end resetCards()
} // end Game
