import java.util.*;

public class Game {
  // static variables
  private static int maxPlayers = 6;
  private static int minCardsPerPlayer = 6;
  private static String line = "---------------------------";

  // instance variables
  private Dealer dealer;
  private Deck deck;
  private ArrayList<Player> players;
  private Scanner scan = new Scanner(System.in);
  private int roundCount;
  private int minNumCards;
  private boolean gameOver;

  // constructor
  public Game() {
    // initialize variables
    gameOver = false;
    roundCount = 1;
    deck = new Deck();
    players = new ArrayList<>();

    // create, print, and shuffle deck
    setUpDeck();

    // create player(s)
    initializePlayers();

    // create dealer
    dealer = new Dealer();

    // play game; start rounds
    while (!gameOver) {
      // introduce round
      System.out.println("\n" + line);
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

      // exit if table is empty
      if (players.size() == 0) {
        System.out.println("Everyone is out of money. Thanks for playing!");
        gameOver = true;
        break;
      } // end if

      // ask player if play another round
      System.out.print("Do you want to play another round? [Y/N] ");
      boolean validAnswer = false;
      while (!validAnswer) {
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
    for (int i = 0; i < players.size(); i++) {
      players.get(i).getHand().add(deck.dealCard());
      players.get(i).getHand().add(deck.dealCard());
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
  } // end displayMoney()

  // method to display the results of that round
  private void displayRoundResults() {
    System.out.println("\n" + line);
    System.out.println("ROUND " + roundCount + " RESULTS: \n");

    // display dealer's end hand
    System.out.println("Hands: ");
    displayHand(dealer);
    System.out.println();

    // display end hands of players and whether or not they won
    for (int i = 0; i < players.size(); i++) {
      displayHand(players.get(i));
      if (players.get(i).ifBust() == true) {
        System.out.println(" Bust!");
        players.get(i).setMoney(players.get(i).getMoney() - players.get(i).getWager());
      } else if ((dealer.ifBust() == true) || (players.get(i).getHandValue() > dealer.getHandValue())) {
        System.out.println(" Winner!");
        players.get(i).setMoney(players.get(i).getMoney() + players.get(i).getWager());
      } else if (players.get(i).getHandValue() == dealer.getHandValue()) {
        System.out.println(" Tied with dealer!");
      } else {
        System.out.println(" Lost!");
        players.get(i).setMoney(players.get(i).getMoney() - players.get(i).getWager());
      } // end if
    } // end
    System.out.println();

    // display how much money each player has left
    for (int i = 0; i < players.size(); i++) {
      displayMoney(players.get(i));
      // remove player if they no longer have money
      if (players.get(i).getMoney() == 0) {
        System.out.println(players.get(i).getName() + " is out of money and is out of the game!");
        players.remove(i);
        --i;
      } // end if
    } // end for

    System.out.println("\n");
  } // end displayRoundResults()

  // method to display starting hands of dealer and players
  private void displayStartingHands() {
    // display dealer's hands with a hidden card 
    System.out.println();
    System.out.print("Dealer's hand: ");
    System.out.println(dealer.handToString(true));

    for (int i = 0; i < players.size(); i++) {
      // display each player's's hands
      displayHand(players.get(i));
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
    String temp;
    String name;
    int numPlayers = 0;
    double money = 0;
    boolean validAnswer = false;

    // get number of players
    System.out.print("How many players are there? [MAX: 6] ");
    while (!validAnswer) {
      temp = scan.nextLine();
      try {
        numPlayers = Integer.parseInt(temp);
        if (numPlayers > 6) {
          throw new IllegalArgumentException("Sorry, that's too many players. Pick a number smaller than or equal to 6: ");
        } // end if
      } catch (NumberFormatException e) {
        System.out.print("Please enter a valid number of players: ");
        continue;
      } catch (IllegalArgumentException e) {
        System.out.print(e.getMessage());
        continue;
      } // end try
      validAnswer = true;
    } // end while

    // set number of cards at which to reset at
    minNumCards = numPlayers * minCardsPerPlayer;

    System.out.println();

    for (int i = 0; i < numPlayers; i++) {
      System.out.println("For player " + (i+1) + ": ");
      System.out.print("  What is their name? ");
      name = scan.nextLine();

      validAnswer = false;
      System.out.print("  How much money do they have? ");
      while (!validAnswer) {
        temp = scan.nextLine();
        try {
          money = Double.parseDouble(temp);
          if (money <= 0) {
            throw new IllegalArgumentException("  Money cannot be 0 or lower: ");
          } // end if
        } catch (NumberFormatException e) {
          System.out.print("  Please enter a valid amount of money: ");
          continue;
        } catch (IllegalArgumentException e) {
          System.out.print(e.getMessage());
          continue;
        } // end try
        validAnswer = true;
      } // end while

      Player tempPlayer = new Player(name, money);
      players.add(tempPlayer);
    } // end for
  } // end initializePlayers()

  // method to get user input (each player's wagers)
  private void getPlayerWagers() {
    for (int i = 0; i < players.size(); i++) {
      String temp;
      double wager = 0;
      boolean validWager = false;

      // get valid user input
      while (!validWager) {
        System.out.print(players.get(i).getName() + "'s wager [$" + players.get(i).getMoney() + "]: ");
        temp = scan.nextLine();
        try {
          wager = Double.parseDouble(temp);
          if (wager <= 0) {
            throw new IllegalArgumentException("Wager cannot be 0 or less than 0.");
          } else if (wager > players.get(i).getMoney()) {
            throw new IllegalArgumentException("You don't have enough money for that.");
          } // if
        } catch (NumberFormatException e) {
          System.out.println("Please enter a valid amount to wager.");
          continue;
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
          continue;
        } // end try
        validWager = true;
      } // end while
      players.get(i).setWager(wager);
    } // end for
  } // end getPlayerWagers()

  // method to iterate through player and let them play their turn
  private void playPlayers() {
    for (int i = 0; i < players.size(); i++) {
      // display each person's hands
      displayHand(players.get(i));
      System.out.println();

      // get and process player's choice
      String temp = "";
      int choice = 0;
      boolean validChoice = false;
      if (players.get(i).getHandValue() < 21) {
        while (choice != 2) {
          while (!validChoice) {
            System.out.print("Hit or stand? [1 or 2] ");
            temp = scan.nextLine();
            try {
              choice = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
              System.out.println("Please enter a valid choice.");
              continue;
            } // end try
            validChoice = true;
          } // end while
          if (choice == 1) {
            players.get(i).getHand().add(deck.dealCard());
            displayHand(players.get(i));
            System.out.println();
            // auto stand if player is at or above 21
            if (players.get(i).getHandValue() >= 21) {
              if (players.get(i).getHandValue() > 21) {
                System.out.println("Bust!");
                players.get(i).setBust(true);
              } // end if
              break;
            }
          } else if (choice != 2) {
            System.out.println("Please enter a valid choice.");
          } // end if
          validChoice = false;
        } // end while
      } else { // player starts with 21, a blackjack
        System.out.println(players.get(i).getName() + " has Blackjack!");
      } // end if

      System.out.println();
    } // end for
  } // end playersTurns()

  // method for the dealer to play their turn
  private void playDealer() {
    boolean allPlayerBust = true;
    // boolean losing = true;
    boolean turnOver = false;

    // handle blackjack case
    if (dealer.getHandValue() == 21) {
      System.out.println("Dealer has Blackjack!");
      return;
    } // end if

    // check if all players bust: dealer won't hit if they are
    for (int i = 0; i < players.size(); i++) {
      if (!players.get(i).ifBust()) {
        allPlayerBust = false;
        // losing = false;
        break;
      } // end if
    } // end for
    if (allPlayerBust) {
      System.out.println("All players have busted.");
      return;
    } // end if

    // play dealer's turn
    while (!turnOver) {
      displayHand(dealer);
      // if (losing && !allPlayerBust) {
      //   for (int i = 0; i < players.size(); i++) {
      //     if (dealer.getHandValue() >= players.get(i).getHandValue() && !players.get(i).ifBust()) {
      //       losing = false;
      //       break;
      //     } // end if
      //   } // end for
      // } // end if
      if (dealer.ifDealerHit()) {
        System.out.println(" Dealer hit!");
        dealer.getHand().add(deck.dealCard());
        if (dealer.getHandValue() > 21) {
          displayHand(dealer);
          System.out.println(" Dealer bust!");
          dealer.setBust(true);
          turnOver = true;
        } // end if
      } else {
        System.out.println(" Dealer stands");
        turnOver = true;
      } // end if
    } // end while
  } // end playDealer()

  // method to reset stats from last round
  private void resetGame() {
    // reset deck
    if (deck.getNumCardsLeft() <= minNumCards) {
      deck.shuffle();
      deck.reset();
    } // end if
    System.out.println(deck);
    // reset hands
    dealer.getHand().clear();
    dealer.setBust(false);
    for (int i = 0; i < players.size(); i++) {
      players.get(i).getHand().clear();
      players.get(i).setBust(false);
    } // end if
  } // end resetCards()

} // end Game
