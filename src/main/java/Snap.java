import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    private Scanner scanner = new Scanner(System.in);
    public int cardIndex = 0;

    public void menu() {
        System.out.println("\n\n== Welcome to the Snap Card Game! == \n");

        System.out.println("\t ___________________");
        System.out.println("\t|                   |");
        System.out.println("\t|\t1: Play         |");
        System.out.println("\t|\t2: Exit         |");
        System.out.println("\t|\t3: Instruction  |");
        System.out.println("\t|                   |");
        System.out.println("\t -------------------");
        System.out.print("Please select a valid option: ");

        String option = scanner.nextLine().toLowerCase();

        if (option.equals("1")) {
            System.out.print("Please enter Player1 name: ");
            String playerOneName = scanner.nextLine();
            Player playerOne = new Player(playerOneName);
            System.out.println("Player 1: " + playerOne.getName());


            System.out.print("\nPlease enter Player2 name: ");
            String playerTwoName = scanner.nextLine();
            Player playerTwo = new Player(playerTwoName);
            System.out.println("Player 2: " + playerTwo.getName());

            System.out.println("\nGame starts...");
            System.out.println("Getting a deck...");

            System.out.println("\nPress Enter to deal a card");

            playGame(playerOne, playerTwo);


        } else if (option.equals("2")) {
            System.out.println("Quitting Game..");
        } else if (option.equals("3")) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Snap Card game is for two players. Players enter their names.");
            System.out.println("Each of the players takes turn to deal a card from a deck by pressing Enter.");
            System.out.println("Keep an eyes on the symbols of the cards.");
            System.out.println("If the symbol of a card you drew matches with the previous one from another player.");
            System.out.println("It's a Snap!! ");
            System.out.println("The player who types 'snap' first (within 2 seconds) win the game.");
            System.out.println("-----------------------------------------------------------------------------------------\n");
            System.out.println("Are you ready to play??");
            System.out.println("Y/n ?");
            String select = scanner.nextLine().toLowerCase();
            if (select.equals("y")) {
                menu();
            }
            if (select.equals("n")) {
                System.out.println("Quitting Game...");
            }
        } else {
            menu();
        }
    }

    public void playGame(Player playerOne, Player playerTwo) {
        CardGame snapGameCard = new CardGame("Snap");
        snapGameCard.shuffleDeck();

        cardIndex = 0;
        Card card1 = new Card(null, null, 0);
        Card card2 = new Card(null, null, 0);

        while (cardIndex <= 52) {
            String input = scanner.nextLine().toLowerCase();

            if (cardIndex % 2 == 0) {
                if (input.equals("")) {
                    card1 = dealCard();
                    System.out.println("\n Player: " + playerOne.getName());
                    System.out.println(card1);
                }
            } else {

                if (input.equals("")) {
                    card2 = dealCard();
                    System.out.println("\n Player: " + playerTwo.getName());
                    System.out.println(card2);
                }
            }

            Timer timer = new Timer();
            Card finalCard = card1;
            Card finalCard1 = card2;
            boolean snapped = finalCard.getSymbol().equals(finalCard1.getSymbol());

            if (snapped && input.equals("snap")) {
                System.out.println("\n** SNAP!! You Win! **\n");
                System.out.println();
            }

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    while (snapped && input.equals("")) {
                        timer.cancel();
                        System.out.println("\n** Time's up, there was a snap **\n");
                        System.out.println("------------------");
                        System.out.println(finalCard);
                        System.out.println(finalCard1);
                        System.out.println("------------------");
                        System.out.println("Press Enter to continue..");
                        break;
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 2000, 2000);

            while (!snapped && input.equals("snap")) {
                System.out.println("\n** It's not a snap, you lose! **\n");
                timer.cancel();
                replay(playerOne, playerTwo);
            }

            cardIndex++;
            if (0 == getDeck().size()) {
                System.out.println("\n* No snap in this game! *\n");
                replay(playerOne, playerTwo);
            }
        }
    }

    public void replay(Player playerOne, Player playerTwo) {
        System.out.println("Would you like to play again ? ");
        System.out.println("Y/n ?");

        String reply = scanner.nextLine().toLowerCase();

        if (reply.equals("n")) {
            menu();
        } else if (reply.equals("y")) {
            System.out.println("Press Enter to continue..");
            CardGame newCard = new CardGame("Snap");
            newCard.shuffleDeck();
            playGame(playerOne, playerTwo);
        } else {
            System.out.println("Please select a valid option!");
            CardGame newCard = new CardGame("Snap");
            newCard.shuffleDeck();
            replay(playerOne, playerTwo);
        }
    }
}
