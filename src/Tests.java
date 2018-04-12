import org.junit.Test;



 import static org.junit.Assert.*;

 public class Tests {
  
        @Test(expected= IllegalArgumentException.class)
     public void testNeedlessSpace(){
         String[] cards = {
                 "2s",
                 "3c",
                 "4 h",
                 "5s",
                 "5c"};
         String result = Checker.checkHand(cards);
     }

     @Test(expected= IllegalArgumentException.class)
     public void testCardsOneLine(){
         String[] cards = {
                 "6s kc ah 3h 10s ",
                 " ",
                 " ",
                 " ",
                 " "};
         String result = Checker.checkHand(cards);
     }
     @Test(expected= IllegalArgumentException.class)
     public void testInvalidLanguage(){
         String[] cards = {
                 "2s",
                 "3c",
                 "4h",
                 "5s",
                 "5ч"};
         String result = Checker.checkHand(cards);
     }
 
     @Test(expected= IllegalArgumentException.class)
     public void testInvalidCardNumber(){
         String[] cards = {
                 "2s",
                 "3c",
                 "4h",
                 "5s"};
         String result = Checker.checkHand(cards);
     }
 
     @Test(expected= IllegalArgumentException.class)
     public void testRepeatingCards(){
         String[] cards = {
                 "2s",
                 "3c",
                 "4h",
                 "5s",
                 "5s"};
         String result = Checker.checkHand(cards);
     }
 
     @Test(expected= IllegalArgumentException.class)
     public void testInvalidRank(){
         String[] cards = {
                 "1S", //mistake here
                 "3c",
                 "4h",
                 "5s",
                 "6s"};
         String result = Checker.checkHand(cards);
     }
 
     @Test(expected= IllegalArgumentException.class)
     public void testInvalidSuit(){
         String[] cards = {
                 "2s",
                 "c",
                 "4h",
                 "5n", //mistake here
                 "6s"};
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
                "2S",
                "3C",
                "4H",
                "5S",
                "6D"};
        assertEquals(Checker.checkHand(cards), "SIX-HIGH STRAIGHT");
    }

   @Test
    public void TestRoyalFlush() {
        String[] cards = {
                "kh",
                "jh",
                "ah",
                "qh",
                "10h"};
        assertEquals(Checker.checkHand(cards), "ROYAL FLUSH");
    }

    @Test
    public void TestStraightFlush() {
        String[] cards = {
                "kh",
                "jh",
                "9h",
                "qh",
                "10h"};
        assertEquals(Checker.checkHand(cards), "KING-HIGH STRAIGHT FLUSH");
    }

    @Test
    public void TestFour() {
        String[] cards = {
                "10d",
                "jh",
                "10h",
                "10s",
                "10c"};
        assertEquals(Checker.checkHand(cards), "FOUR OF TENS");
    }
  
  @Test
    public void TestFullHouse() {
        String[] cards = {
                "jd",
                "jh",
                "10h",
                "10s",
                "10c"};
        assertEquals(Checker.checkHand(cards),"TENS FULL OF JACKS");
    }

    @Test
    public void TestFlush() {
        String[] cards = {
                "10c",
                "jc",
                "2c",
                "qc",
                "4c"};
        assertEquals(Checker.checkHand(cards),"QUEEN-HIGH FLUSH");
    }

    @Test
    public void TestThree() {
        String[] cards = {
                "10c",
                "qd",
                "qh",
                "qc",
                "4c"};
        assertEquals(Checker.checkHand(cards),"THREE OF QUEENS");
    }

    @Test
    public void TestTwoPairs() {
        String[] cards = {
                "10c",
                "2d",
                "qh",
                "qc",
                "2c"};
        assertEquals(Checker.checkHand(cards),"QUEEN-HIGH TWO PAIRS");
    }

    @Test
    public void TestPair() {
        String[] cards = {
                "10c",
                "2d",
                "jh",
                "qc",
                "2c"};
        assertEquals(Checker.checkHand(cards),"PAIR OF TWOS");
    }

    @Test
    public void TestNoCombination() {
        String[] cards = {
                "10c",
                "2d",
                "jh",
                "qc",
                "5c"};
        assertEquals(Checker.checkHand(cards),"NOTHING, HIGHEST CARD - QUEEN");
    }
}
