import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame() {
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

    public ArrayList<Card> sortDeckingNumberOrder(){
        Collections.sort(deckOfCards, (a,b) -> a.getValue()-b.getValue());
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(deckOfCards, (a,b) -> a.getSymbol()-b.getSymbol());
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
