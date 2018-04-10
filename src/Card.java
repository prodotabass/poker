

public class Card {

    public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
    public enum Suit {HEARTS, SPADES, DIAMONDS, CLUBS};

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Card) {
            Card c = (Card) obj;
            return c.getSuit().equals(this.getSuit()) && c.getRank().equals(this.getRank());
        }
        else {return false;}
    }
}
