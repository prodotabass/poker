

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

    public static Suit stringToSuit(String suit) {
        Suit result;
        switch (suit.toLowerCase()) {
            case "h": result = Suit.HEARTS; break;
            case "s": result = Suit.SPADES; break;
            case "d": result = Suit.DIAMONDS; break;
            case "c": result = Suit.CLUBS; break;
            default: result = null;
        }
        return result;
    }

    public static Rank stringToRank(String rank) {
        Rank result;
        switch (rank.toLowerCase()) {
            case "2": result = Rank.TWO; break;
            case "3": result = Rank.THREE; break;
            case "4": result = Rank.FOUR; break;
            case "5": result = Rank.FIVE; break;
            case "6": result = Rank.SIX; break;
            case "7": result = Rank.SEVEN; break;
            case "8": result = Rank.EIGHT; break;
            case "9": result = Rank.NINE; break;
            case "10": result = Rank.TEN; break;
            case "j": result = Rank.JACK; break;
            case "q": result = Rank.QUEEN; break;
            case "k": result = Rank.KING; break;
            case "a": result = Rank.ACE; break;
            default: result = null;
        }
        return result;
    }
}
//2H, 10S