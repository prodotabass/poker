import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Checker {

    public static String checkHand(String[] stringCards) {
        return "";
    }
    
private static boolean checkFlush(List<Card> cards) {
        Card.Suit suit = cards.get(0).getSuit();
        for (Card c : cards) {
            if (!c.getSuit().equals(suit))
                return false;
        }
        return true;
    }

    private static boolean checkStraight(List<Card> cards) {
        List<Card.Rank> ranks = cardsToRanks(cards);
        int lowest = ranks.get(0).ordinal();

        for(int i = 1; i < ranks.size(); ++i) {
            if(lowest + 1 != ranks.get(i).ordinal()) {
                return false;
            }

            lowest++;
        }

        return true;
    }
    
    private static Card.Rank getHighest(List<Card> cards) {
        List<Card.Rank> ranks = cardsToRanks(cards);
       return ranks.get(ranks.size() - 1);
    }

    private static List<Card.Rank> cardsToRanks(List<Card> cards) {
        List<Card.Rank> ranks = new ArrayList<>();
        for (Card card:cards) {
            ranks.add(card.getRank());
        }
        Collections.sort(ranks);
        return ranks;
    }

    private static Card stringToCard(String card) {
        String[] words = card.split(" ");
        if (words.length < 3 || !words[1].equals("of"))
            throw new IllegalArgumentException();
        Card.Rank rank = Card.Rank.valueOf(words[0].toUpperCase());
        Card.Suit suit = Card.Suit.valueOf(words[2].toUpperCase());
        return new Card(rank, suit);
    }

    private static class Combination {
        private Card.Rank rank;
        private int count;

        private Combination(Card.Rank rank, int count) {
            this.rank = rank;
            this.count = count;
        }

        public Card.Rank getRank() {
            return rank;
        }

        public int getCount() {
            return count;
        }
    }
}
