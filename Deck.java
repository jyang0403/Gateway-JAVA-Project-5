import java.util.Random;
/** 
 *  Project 5A: Deck.java | Gateway Computing JAVA
 *  =====================================================================
 *  This program initializes a full deck of 52 cards for the user, and
 *  includes two methods to shuffle and reorder the deck.
 *
 *  @author: Jiashu Yang
 *  @JHED: jyang166
 *  @date: 04/5/22
 *
 */
 
public class Deck {
   
   final int numCardsDeck = 52;
   final int numCardsSuit = 13;
   private Card[] cards = new Card[numCardsDeck];
   
   // initializes the Deck object with the 52 original cards in a deck.
   Deck() {
      buildDeck(cards);
   }
   
   /** creates each of the 52 unique cards in array cards in order
    *  based on suit and rank.
    *  
    *  @param newDeck the Card array to be constructed
    */
   public void buildDeck(Card[] newDeck) {
      int index = 0;
      for (int startSuit = 1; startSuit < 5; startSuit++) {
         for (int startRank = 1; startRank < 14; startRank++) {
            Card card = new Card(startRank, startSuit);
            newDeck[index] = card;
            index++;
         }
      }      
   }
   
   /** overrides toString() to print all 52 cards in the deck.
    *
    *  @return "" empty string
    */
   @Override
   public String toString() {
      for (int i = 0; i < numCardsDeck - 1; i++) {
         System.out.println(cards[i]);
      }
      System.out.print(cards[51]);
      return "";
   }
   
   /** shuffles the deck randomly by swapping the indices
    *  of two cards in array cards.
    */
   public void shuffle() {
      Random rand = new Random();
      for (int i = 0; i < 104; i++) {
         int index1 = rand.nextInt(numCardsDeck);
         int index2 = rand.nextInt(numCardsDeck);
         swap(index1, index2);
      }
   }
   
   /** helper method that swaps the indices of two cards 
    *  in array cards
    */
   private void swap(int index1, int index2) { 
      Card temp = new Card(0, 0);
      temp = cards[index1];
      cards[index1] = cards[index2];
      cards[index2] = temp;
   }
   
   /** sorts the array cards in order of rank in each suit, then 
    * in order of each rank, each of which is also in order relative 
    * to the others.
    */
   public void sort() {
      // using algorithm provided
      for (int j = 0; j < 52; j++) {
         Card c = cards[j];
         int i = j - 1;
         while (i >= 0 && cards[i].compareTo(c) > 0) {
            cards[i + 1] = cards[i];
            i--;
         }
         cards[i + 1] = c;
      }
   }
}