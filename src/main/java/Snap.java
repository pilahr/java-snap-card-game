import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    private Scanner scanner = new Scanner(System.in);
    public int cardIndex = 0;


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

            playGame(playerOne, playerTwo);


        } else if (option.equals("2")) {
            quitGame();
        } else {
            menu();
        }
    }

    public void playGame(Player playerOne, Player playerTwo) {
        shuffleDeck();
        cardIndex = 0;
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //// task to display card of each player


                if (cardIndex < getDeck().size()) {


                    if (cardIndex % 2 == 0) {
                        snapRun(timer, playerOne, playerOne, playerTwo);
                    } else {
                        snapRun(timer, playerTwo, playerOne, playerTwo);
                    }


                    cardIndex++;
                    System.out.println(cardIndex);// to be removed

                    if (cardIndex == getDeck().size()) {
                        System.out.println("No snap in this game!\n");
                        timer.cancel();
                        replay(playerOne, playerTwo);
                    }
                } else {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 2000);
    }

    public void snapRun(Timer gameTimer, Player currentPlayer, Player playerOne, Player playerTwo) {


        //// if symbols are equal --> win
        //// if type snap ---> that player win --- 2sec to type

        //Showing each player's card --- Ex PlayerA 2 of Heart, PlayerB 5 of Diamond and so onn..
        System.out.println("\n Player: " + currentPlayer.getName());
        System.out.println(dealCard(cardIndex));

        if (cardIndex > 0 && dealCard(cardIndex-1).getSymbol()
                .equals(dealCard(cardIndex).getSymbol())) {

            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    //if has keyboard input --> keep that input in a variable
                    //if no input (blank "") --> "" in a variable
                    //if "snap" in lowercase ---> print win +name /else --> lose + name
                    // replay?

                    String inputFromKeyboard = "";
                    if (scanner.hasNextLine()) {
                        inputFromKeyboard = scanner.nextLine();
                    } else {
                        inputFromKeyboard = "";
                    }

                    if (inputFromKeyboard.toLowerCase().equals("snap")) {
                        System.out.println("Congrats!! You Win!!, Player: "+ currentPlayer.getName());
                        System.out.println("Press Enter to continue..");

                        String enter = scanner.nextLine();
                        if (enter.equals("")) {
                            timer.cancel();
                            gameTimer.cancel();
                            replay(playerOne, playerTwo);
                        } else {
                            System.out.println("Press Enter to continue..");
                        }
                    }
                }
            };
            timer.scheduleAtFixedRate(timerTask, 0, 2000);
        }
    }



    public void replay(Player playerOne, Player playerTwo) {
        System.out.println("Would you like to play again ? ");
        System.out.println("y/n ?");
        String reply = scanner.nextLine();

        if (reply.toLowerCase().equals("n")) {
            menu();
        } else if (reply.toLowerCase().equals("y")) {
            playGame(playerOne, playerTwo);
        } else {
            System.out.println("Please select a valid option!");
            replay(playerOne, playerTwo);
        }
    }

    public void quitGame() {
        cardIndex = 52;
        System.out.println("Quitting Game..");
    }
}
