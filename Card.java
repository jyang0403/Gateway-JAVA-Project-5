/** 
 *  Project 5A: Card.java | Gateway Computing JAVA
 *  =====================================================================
 *  This program contains a new object, Card, each of which resembles
 *  a card in a 52-card deck, able to contain and print information 
 *  about its suit and rank. There are also other methods, that can
 *  compare the suits of two cards, determine if the cards are 
 *  equal, and so on. 
 *
 *  @author: Jiashu Yang
 *  @JHED: jyang166
 *  @date: 04/5/22
 *
 */
 
class Card {

   /* storing all possible suits and ranks, including "0" as a case where
    * given suit or rank is outside the bounds
    */
   private final String[] suits = {"0", "Clubs", "Diamonds", 
                                     "Hearts", "Spades"};
   private final String[] ranks = {"0", "Ace", "2", "3", "4", 
      "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
   private int rank = -1;
   private int suit = -1;
   
   /** allows for a card to be initialized with an existing rank and suit, 
    *  and sets these as zero if they are outside the allotted range for 
    *  possible ranks and suits
    */
   Card(int initRank, int initSuit) {
      suit = initSuit;
      rank = initRank;
      if (suit > 4 || suit < 1) {
         suit = 0;
      }
      if (rank > 13 || rank < 1) {
         rank = 0;
      }
   }
   
   /** reports a Card's suit.
    *  @return the Card's suit
    */
   public int getSuit() {
      return suit;
   }
   
   /** reports a Card's rank
    *  @return the Card's rank
    */
   public int getRank() {
      return rank;
   }
   
   /** overrides toString() in order to return a custom string 
    *  representation of a Card's rank and suit
    *
    *  @return Card string containing rank and suit
    */
   @Override
   public String toString() {
      return ranks[this.getRank()] + " of " + suits[this.getSuit()];
   }
   
   /** overrides equals() to compare two cards' ranks and suits
    *  to determine if they are equal
    *
    *  @return true if cards are equal, false otherwise
    */
   @Override
   public boolean equals(Object other) {
      if (other instanceof Card) {
         Card temp = (Card) other;
         if (temp.getRank() == this.getRank() && 
            temp.getSuit() == this.getSuit()) {
            return true;
         }
      }
      return false;
   }
   
   
   /** 
    * Compare this Card with another specified Card for order. 
    * @param otherCard the other Card object to be compared. 
    * @return a negative integer, zero, or a positive integer as 
    * this object is less than, equal to, or greater than the otherCard
    * depending on suit, then rank. 
    */ 
   public int compareTo(Card otherCard) { 
      if (otherCard.suit < this.suit) {
         return 1;
      }
      else if (otherCard.suit > this.suit) {
         return -1;
      }
      else if (otherCard.suit == this.suit) {
         if (otherCard.rank < this.rank) {
            return 1;
         }
         else if (otherCard.suit > this.suit) {
            return -1;
         }
      }
      return 0;
   }
}