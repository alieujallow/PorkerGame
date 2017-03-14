/**
 * This is a class that modules a Porker Card
 * It has two instance variables and two
 * accessor methods
 * @author Alieu Jallow
 * */
public class Card
{
  /**
   * instance variables
   * */
  private String rank;        //strores the rank of a card
  private int comp;           // stores a value of the rank of a card
  private String suit;         // stores the suit of a card
  
  /**
   *  A constructor that creates a card object
   * @param s the suit of the card
   * @param r the rank of the card
   * */
  public Card(String r, String s,int c)
  {
    rank=r;
    suit=s;
    comp=c;
  }
  
  /**
   * A method that gets the rank of the card
   * @return the rank of the card 
   * */
  public String getRank()
  {
    return rank;
  }
  
  /**
   * A method that gets the comp of the card
   * @return the comp of the card 
   * */
  public int getComp()
  {
    return comp;
  }
  
  /**
   * A method that gets the suit of the card
   * @return the suit of the card 
   * */
  public String getSuit()
  {
    return suit;
  }
}