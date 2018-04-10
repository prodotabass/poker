import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Checker {

    public static String checkHand(String[] stringCards) {
        if(stringCards.length != 5)
            throw new IllegalArgumentException();
        List<Card> cards = new ArrayList();
        for (String c: stringCards) {
            cards.add(stringToCard(c));
        }

        for(int i = 0; i < cards.size() - 1; i++) {
            for(int j = i + 1; j < cards.size(); j++) {
                if((cards.get(i)).equals(cards.get(j))) {
                    throw new IllegalArgumentException();
                }
            }
        }
        
        boolean flush = checkFlush(cards);
        boolean straight = checkStraight(cards);
        String checkFullHouse = checkFullHouse(cards);
        Combination comb = checkCombination(cards);
        Card.Rank highest = getHighest(cards);
        if(flush && straight)
            if(highest.equals(Card.Rank.ACE))
                return "ROYAL FLUSH";
            else
                return highest.toString() + "-HIGH STRAIGHT FLUSH";
        if(comb.getCount() == 4)
            return "FOUR OF " + comb.getRank().toString() + "S";
        if(checkFullHouse != null)
            return checkFullHouse;
        if(flush)
            return highest.toString() + "-HIGH FLUSH";
        if(straight)
            return highest.toString() + "-HIGH STRAIGHT";
        if(comb.getCount() == 3)
            return "THREE OF " + comb.getRank().toString() + "S";
        if(comb.getCount() == 22)
            return comb.getRank().toString() + "-HIGH TWO PAIRS";
        if(comb.getCount() == 2)
            return "PAIR OF " + comb.getRank().toString() + "S";
        return "NOTHING, HIGHEST CARD - " + highest.toString();
    }
    
        private static String checkFullHouse(List<Card> cards) {
        Checker.Combination comb = checkCombination(cards);
        if(comb.getCount() != 3)
            return null;
        Checker.Combination comb1 = checkTwoPairs(cardsToRanks(cards), comb.getRank());
        return comb1.getCount() != 22? null : comb.getRank().toString() + "S FULL OF " + comb1.getRank().toString() + "S";

    }
    
    private static Checker.Combination checkCombination(List<Card> cards) {
        List<Card.Rank> ranks = cardsToRanks(cards);
        int count = 0;
        int currCount = 0;
        Card.Rank rank = ranks.get(0);
        Card.Rank currRank = ranks.get(0);
        for (Card.Rank r : ranks) {
            if(r.equals(currRank)) {
                ++currCount;
            } else {
                currRank = r;
                currCount = 1;
            }

            if(currCount > count) {
                count = currCount;
                rank = currRank;
            }
        }

        if(count != 2)
            return new Checker.Combination(rank, count);
        Checker.Combination comb = checkTwoPairs(ranks, rank);
        if(comb.getCount() == 22)
            return new Checker.Combination(comb.getRank().ordinal() > rank.ordinal()?comb.getRank():rank, 22);
        return comb;
    }

    private static Checker.Combination checkTwoPairs(List<Card.Rank> ranks, Card.Rank rank) {
        int newCount = 0;
        int currCount = 0;
        Card.Rank newRank = ranks.get(0);
        Card.Rank currRank = ranks.get(0);

        for (Card.Rank r : ranks) {
            if(r.equals(currRank)) {
                ++currCount;
            } else {
                currRank = r;
                currCount = 1;
            }

            if(currCount > newCount && !currRank.equals(rank)) {
                newCount = currCount;
                newRank = currRank;
            }
        }

        if(newCount == 2)
            return new Checker.Combination(newRank, 22);
        return new Checker.Combination(rank, 2);
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
       List<Card.Rank> ranks = new ArrayList();

        for (Card c : cards) {
            ranks.add(c.getRank());
        }
        Collections.sort(ranks);
        return ranks;
    }

    private static Card stringToCard(String card) {
        String[] words = card.split(" ");
        if(words.length != 3 || !words[1].equals("of")
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
            return this.rank;
        }

        public int getCount() {
            return this.count;
        }
    }
}
