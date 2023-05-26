import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CardGame {
    private String name;
    private static ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame(String name) {
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
        Card topCard = deckOfCards.get(cardIndex);
        deckOfCards.remove(cardIndex);
        return topCard;
    }

    public ArrayList<Card> sortDeckingNumberOrder() {
        return (ArrayList<Card>) deckOfCards.stream()
                .sorted((a,b) -> a.getValue()-b.getValue())
                .collect(Collectors.toList());
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        return (ArrayList<Card>) deckOfCards.stream()
                .sorted((a,b) -> a.getSuit().compareTo(b.getSuit()))
                .collect(Collectors.toList());
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
