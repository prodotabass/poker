import org.junit.Test;
 
 
 
 import static org.junit.Assert.*;
 
 public class Tests {
 
     @Test(expected= IllegalArgumentException.class)
     public void testInvalidCardNumber(){
         String[] cards = {
                 "Two of Spades",
                 "Three of Clubs",
                 "Four of Hearts",
                 "Five of Spades"};
         String result = Checker.checkHand(cards);
     }
 
     @Test(expected= IllegalArgumentException.class)
     public void testRepeatingCards(){
         String[] cards = {
                 "Two of Spades",
                 "Three of Clubs",
                 "Four of Hearts",
                 "Five of Spades",
                 "Five of Spades"};
         String result = Checker.checkHand(cards);
     }
 
     @Test(expected= IllegalArgumentException.class)
     public void testInvalidRank(){
         String[] cards = {
                 "Tw of Spades", //mistake here
                 "Three of Clubs",
                 "Four of Hearts",
                 "Five of Spades",
                 "Six of Spades"};
         String result = Checker.checkHand(cards);
     }
 
     @Test(expected= IllegalArgumentException.class)
     public void testInvalidSuit(){
         String[] cards = {
                 "Two of Spades",
                 "Three of Clubs",
                 "Four of Hearts",
                 "Five of Spaves", //mistake here
                 "Six of Spades"};
         String result = Checker.checkHand(cards);
     }
 
     @Test(expected= IllegalArgumentException.class)
     public void testMissingOf(){
         String[] cards = {
                 "Two of Spades",
                 "Three of Clubs",
                 "Four of Hearts",
                 "Five  Spades", //mistake here
                 "Six of Spades"};
       String result = Checker.checkHand(cards);
    }

@Test
    public void TestCardCreation() {
        Card.Rank rank = Card.Rank.NINE;
        Card.Suit suit = Card.Suit.DIAMONDS;
        Card card = new Card(rank,suit);
        assertEquals(card.getRank(),rank);
        assertEquals(card.getSuit(),suit);
    }

    @Test
    public void TestStraight() {
        String[] cards = {
                "Two of Spades",
                "Three of Clubs",
                "Four of Hearts",
                "Five of Spades",
                "Six of Diamonds"};
        assertEquals(Checker.checkHand(cards), "SIX-HIGH STRAIGHT");
    }

    @Test
    public void TestRoyalFlush() {
        String[] cards = {
                "King of Hearts",
                "Jack of Hearts",
                "Ace of Hearts",
                "Queen of Hearts",
                "Ten of Hearts"};
        assertEquals(Checker.checkHand(cards), "ROYAL FLUSH");
    }

    @Test
    public void TestStraightFlush() {
        String[] cards = {
                "King of Hearts",
                "Jack of Hearts",
                "Nine of Hearts",
                "Queen of Hearts",
                "Ten of Hearts"};
        assertEquals(Checker.checkHand(cards), "KING-HIGH STRAIGHT FLUSH");
    }

    @Test
    public void TestFour() {
        String[] cards = {
                "Ten of Diamonds",
                "Jack of Hearts",
                "Ten of Hearts",
                "Ten of Spades",
                "Ten of Clubs"};
        assertEquals(Checker.checkHand(cards), "FOUR OF TENS");
    }
  
  @Test
    public void TestFullHouse() {
        String[] cards = {
                "Jack of Diamonds",
                "Jack of Hearts",
                "Ten of Hearts",
                "Ten of Spades",
                "Ten of Clubs"};
        assertEquals(Checker.checkHand(cards),"TENS FULL OF JACKS");
    }

    @Test
    public void TestFlush() {
        String[] cards = {
                "Ten of Clubs",
                "Jack of Clubs",
                "Two of Clubs",
                "Queen of Clubs",
                "Four of Clubs"};
        assertEquals(Checker.checkHand(cards),"QUEEN-HIGH FLUSH");
    }

    @Test
    public void TestThree() {
        String[] cards = {
                "Ten of Clubs",
                "Queen of Diamonds",
                "Queen of Hearts",
                "Queen of Clubs",
                "Four of Clubs"};
        assertEquals(Checker.checkHand(cards),"THREE OF QUEENS");
    }

    @Test
    public void TestTwoPairs() {
        String[] cards = {
                "Ten of Clubs",
                "Two of Diamonds",
                "Queen of Hearts",
                "Queen of Clubs",
                "Two of Clubs"};
        assertEquals(Checker.checkHand(cards),"QUEEN-HIGH TWO PAIRS");
    }

    @Test
    public void TestPair() {
        String[] cards = {
                "Ten of Clubs",
                "Two of Diamonds",
                "Jack of Hearts",
                "Queen of Clubs",
                "Two of Clubs"};
        assertEquals(Checker.checkHand(cards),"PAIR OF TWOS");
    }

    @Test
    public void TestNoCombination() {
        String[] cards = {
                "Ten of Clubs",
                "Two of Diamonds",
                "Jack of Hearts",
                "Queen of Clubs",
                "Five of Clubs"};
        assertEquals(Checker.checkHand(cards),"NOTHING, HIGHEST CARD - QUEEN");
    }
}
