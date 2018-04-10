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
