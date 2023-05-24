import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CardGame {
    private String name;
    private static ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame(String name, Scanner scanner) {
        this.name = name;

    }

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

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    public Card dealCard(int cardIndex) {
        Card topCard = deckOfCards.get(0);
        deckOfCards.remove(0);
        return topCard;
    }

    public ArrayList<Card> sortDeckingNumberOrder() {
        Collections.sort(deckOfCards, Comparator.comparingInt(Card::getValue));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(deckOfCards, Comparator.comparing(Card::getSuit));
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
