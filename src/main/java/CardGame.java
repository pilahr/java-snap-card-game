import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    private static ArrayList<Card> deckOfCards = new ArrayList<>();

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

                deckOfCards.add(new Card(CardSuit.values()[i].getCardSuitUnicode(), symbol, j));
            }
        }
    }

    public ArrayList<Card> getDeck(){
        System.out.println(deckOfCards);
        return deckOfCards;
    }
    public Card dealCard() {
        Card topCard = deckOfCards.get(0);
        deckOfCards.remove(0);
        System.out.println(topCard);
        return topCard;
    }

    public ArrayList<Card> sortDeckingNumberOrder() {
        Collections.sort(deckOfCards, Comparator.comparingInt(Card::getValue));
        System.out.println(deckOfCards);
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(deckOfCards, Comparator.comparing(Card::getSuit));
        System.out.println(deckOfCards);
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        System.out.println(deckOfCards);
        return deckOfCards;
    }
}
