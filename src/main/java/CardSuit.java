public enum CardSuit {
    HEART("\u2665"), CLUB("\u2663"), DIAMOND("\u2666"), SPADE("\u2660");

    protected final String cardSuitUnicode;

    CardSuit(String cardSuitUnicode) {
        this.cardSuitUnicode = cardSuitUnicode;
    }
}
