public class Main {

    public static void main(String[] args) {
        System.out.println("heart \u2665");
        System.out.println("diamond \u2666");
        System.out.println("club \u2663");
        System.out.println("spade \u2660");

        CardGame card = new CardGame();
        System.out.println(card.deckOfCards.toString());


    }
}
