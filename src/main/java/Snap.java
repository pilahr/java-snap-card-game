import org.w3c.dom.ls.LSOutput;

import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {


    private Scanner scanner = new Scanner(System.in);
    public int cardIndex = 0;


//    public Card card1;
//    public Card card2;

    public void menu() {
        System.out.println("Welcome to the Snap Card Game! ");
        System.out.println("Please select a valid option: ");
        System.out.println("1: Play | 2: Exit");

        String option = scanner.nextLine();

        if (option.equals("1")) {
            System.out.println("Please enter Player1 name: ");
            String playerOneName = scanner.nextLine();
            Player playerOne = new Player(playerOneName);
            System.out.println("Player 1: " + playerOne.getName());


            System.out.println("\nPlease enter Player2 name: ");
            String playerTwoName = scanner.nextLine();
            Player playerTwo = new Player(playerTwoName);
            System.out.println("Player 2: " + playerTwo.getName());

            System.out.println("\nGame starts...");
            System.out.println("Getting a deck...");

            System.out.println("\nPress Enter to deal a card");

            playGame(playerOne, playerTwo);


        } else if (option.equals("2")) {
            System.out.println("Quitting Game..");
        } else {
            menu();
        }
    }

    public void playGame(Player playerOne, Player playerTwo) {
        shuffleDeck();
        cardIndex = 0;
        Card card1 = new Card(null,null,0);
        Card card2 = new Card(null,null,0);

        while (cardIndex <= 52) {


            String input = scanner.nextLine().toLowerCase();
            if (cardIndex % 2 == 0) {
                if (input.equals("")) {
                    card1 = dealCard(cardIndex);
                    System.out.println("\n Player: " + playerOne.getName());
                    System.out.println(card1);
                }
            } else {

                if (input.equals("")) {
                    card2 = dealCard(cardIndex);
                    System.out.println("\n Player: " + playerTwo.getName());
                    System.out.println(card2);
                }
            }

            System.out.println("Inside the while loop " + card1.getSymbol());/// don't forget to delete
            System.out.println("Inside the while loop " + card2.getSymbol());/// don't forget to delete


//            Timer timer = new Timer();
//            TimerTask task = new TimerTask() {
//                @Override
//                public void run() {
//
//                }
//            }
            if ((card1.getSymbol()).equals(card2.getSymbol()) && input.equals("snap")) {
                System.out.println("\n** SNAP!! You Win! **\n");
                replay(playerOne, playerTwo);
            }
            if ((card1.getSymbol()) != (card1.getSymbol()) | input.equals("snap")) {
                System.out.println("\n** It's not a snap, you loose! **\n");
                replay(playerOne, playerTwo);
            }
//            Timer timer = new Timer();
//            Card finalCard = card1;
//            Card finalCard1 = card2;
//            TimerTask timerTask = new TimerTask() {
//
//                @Override
//                public void run() {
//
//                    if ((finalCard.getSymbol()) != (finalCard1.getSymbol()) && input.equals("snap")) {
//                        System.out.println("\nIt's not a snap, you loose!\n");
//                        timer.cancel();
//                        replay(playerOne, playerTwo);
//                    }
//                    else if ((finalCard.getSymbol()).equals(finalCard1.getSymbol()) && input.equals("snap")) {
//                        System.out.println("\n** SNAP!! You Win! **\n");
//                        timer.cancel();
//
//                    }
////                    else if ((finalCard.getSymbol()).equals(finalCard1.getSymbol())) {
////                        System.out.println("Time's up");
////                        timer.cancel();
////                    }
//                }
//            };
//            timer.scheduleAtFixedRate(timerTask, 0, 2000);



//
//            System.out.println("Card Index = " + cardIndex); /// don't forget to delete
//            System.out.println(getDeck());/// don't forget to delete
            cardIndex++;
            if (0 == getDeck().size()) {
                System.out.println("\n* No snap in this game! *\n");
                replay(playerOne, playerTwo);
            }


        }



    }


//    public void snapRun() {
//        Card previousCard = dealCard(cardIndex - 1);
//        Card currentCard = dealCard(cardIndex);
//        String snapInput = scanner.nextLine();
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                if (previousCard.getSymbol().equals(currentCard.getSymbol()) && snapInput.equals("snap")) {
//                    timer.cancel();
//                    System.out.println("SNAP!! You Win! Player: " );
//                } else {
//                    System.out.println("It's not a snap, you loose!");
//                    replay();
//                }
//            }
//        };
//        timer.scheduleAtFixedRate(timerTask, 0, 2000);
//    }


//        if (dealCard(cardIndex - 1).getSymbol().equals(dealCard(cardIndex).getSymbol())) {
//
//            String input = scanner.nextLine().toLowerCase();
//
//            if (input.equals("snap")) {
//                System.out.println(dealCard(cardIndex - 1));
//                System.out.println(dealCard(cardIndex));
//                System.out.println("SNAP!! You Win!!, Player: " + currentPlayer.getName());
//                System.out.println("Press Enter to continue..");
//            } else {
//                replay(playerOne, playerTwo);
//            }
//        }
//    }


//            Timer timer = new Timer();
//            TimerTask timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    String input = scanner.nextLine().toLowerCase();
//
//                    if (input.equals("snap")) {
//                        System.out.println(dealCard(cardIndex-1));
//                        System.out.println(dealCard(cardIndex));
//                        System.out.println("SNAP!! You Win!!, Player: " + currentPlayer.getName());
//                        System.out.println("Press Enter to continue..");
//                    } else {
//                        replay(playerOne, playerTwo);
//                    }
//                }
//            };
//            timer.scheduleAtFixedRate(timerTask, 0, 2000);

//    }


    public void replay(Player playerOne, Player playerTwo) {
        System.out.println("Would you like to play again ? ");
        System.out.println("Y/n ?");

        String reply = scanner.nextLine().toLowerCase();

        if (reply.equals("n")) {
            menu();
        } else if (reply.equals("y")) {
            CardGame newDeck = new CardGame();
            newDeck.shuffleDeck();
            System.out.println("Press Enter to continue..");
            playGame(playerOne, playerTwo);
        } else {
            System.out.println("Please select a valid option!");
            replay(playerOne, playerTwo);
        }
    }

}
