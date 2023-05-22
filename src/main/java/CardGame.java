import java.lang.reflect.Array;
import java.util.ArrayList;

public class CardGame {

    ArrayList<Card> deckOfCards = new ArrayList<>();

    public void initialiseCardGame() {
        for (int i = 0; i < CardSuit.values().length; i++) {
            for (int j = 2; j < 15; j++) {
                String symbol = "";
                if (j == 11) {
                    symbol = "J";
                } else if (j == 12) {
                    symbol = "Q";
                } else if (j == 13) {
                    symbol = "K";
                } else if (j == 14) {
                    symbol = "A";
                } else {
                    symbol = Integer.toString(j);
                }
                deckOfCards.add(new Card(CardSuit.values()[i].toString(), symbol, j));
            }
        }
    }

    public Card dealCard() {
        Card topCard = deckOfCards.get(0);
        deckOfCards.remove(0);
        return topCard;
    }

    public static void main(String[] args) {

    }



}
