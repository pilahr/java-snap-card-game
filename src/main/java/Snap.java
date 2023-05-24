import java.util.Scanner;

public class Snap extends CardGame {
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("Welcome to the Snap Card Game! ");
        System.out.println("Please select a valid option: ");
        System.out.println("1: Play | 2: Exit");

        String option = scanner.nextLine();

        if (option.equals("1")) {
            System.out.println("Please enter Player1 name: ");
            String playerOneName = scanner.nextLine();
            // create a player

            System.out.println("Please enter Player2 name: ");
            String playerTwoName = scanner.nextLine();
            //create a player

            System.out.println("Game starts...");
            System.out.println("Getting a deck...");
            //playgame


        } else if (option.equals("2")) {
            System.out.println("QUIT GAME"); // wait to create quit game method
        } else {
            menu();
        }
    }

}
