/**
 * This is a class that has all the methods required to test the 5-Card Poker Hands
 * Which are FLUSH, STRAIGHT, STARIGHT-FLUSH, FOUR-OF-A-KIND, THREE-OF-A-KIND,
 * PAIR, TWO-PAIR, and FULL-HOUSE
 * @author Alieu Jallow
 * */
public class Poker
{
  /**
   * instance variables
   * */
  final int ZERO=0;
  /**
   * This is a method that checks if a 5-Card Poker Hand is a straight
   * @return true if the hand is Straight; false otherwise
   * */
  public boolean testStraight(Card[] array)
  {
    for (int i=0;i<array.length-1;i++)
    {
      int difference= array[i+1].getComp() - array[i].getComp();
      if(difference!=1)
      {
        return false;
      }
    }
    return true;
  }
  
  /**
   * This is a method that checks if a 5-Card Poker Hand is a Flush
   * @return true if the hand is Flush; false otherwise
   * */
  public boolean testFlush(Card[] array)
  {
    for(int i=0; i<array.length-1;i++)
    {
      String temp=array[i].getSuit();
      if(!temp.equalsIgnoreCase(array[i+1].getSuit()))
      {
        return false;
      }
    }
    return true;
  }
  
  /**
   * This is a method that checks if a 5-Card Poker Hand is a Straight-Flush
   * @return true if the hand is Straight-Flush; false otherwise
   * */
  public boolean testFlushStraight(Card[] array)
  {
    if( testStraight(array))
    {
      if(testFlush(array))
      {
        return true;
      }
    }
    return false;
  }
  
  /**
   * This is a method that checks if a 5-Card Poker Hand is a Four-of-a-Kind
   * @return true if the hand is a Four-of-a-Kind; false otherwise
   * */
  public boolean testFourOfAKind(Card[] array)
  {
    int equal=0;
    for(int i=0; i<array.length-1;i++)
    {
      int temp=array[i].getComp();
      if(temp==array[i+1].getComp())
      {
        equal++;
      }
      else
      {
        if(equal!=3)
        {
          equal=0;
        }
      }
    }
    if(equal==3)
    {
      return true;
    }
    return false;
  }
  
  /**
   * This is a method that checks if a 5-Card Poker Hand is a Three-of-a-Kind
   * @return true if the hand is aThree-of-a-Kind; false otherwise
   * */
  public boolean testThreeOfAKind(Card[] array)
  {
    if(testThree(array)==0)
    {
      return false;
    }
    return true;
  }
  
  public int testThree(Card[] array)
  {
    int equal=0;
    int num=0;
    for(int i=0; i<array.length-1;i++)
    {
      int temp=array[i].getComp();
      if(temp==array[i+1].getComp() && equal!=2)
      {
        equal++;
        num=temp;
      }
      else
      {
        if(equal!=2)
        {
          equal=0;
        }
      }
    }
    if(equal==2)
    {
      return num;
    }
    return 0;
  }
  
  /**
   * This is a method that checks if a 5-Card Poker Hand has a Pair
   * @return true if the hand has a Pair; false otherwise
   * */
  public boolean testPair(Card[] array)
  {
    if(pair(array)==0)
    {
      return false;
    }
    return true;
  }
  
  public int pair(Card[] array)
  {
    int[]similar=new int[4];
    int num =0;
    for(int i=0; i<array.length-1;i++)
    {
      int temp=array[i].getComp();
      if(temp==array[i+1].getComp())
      {
        similar[num]=temp;
        num++;
      }
    }
    if(num==1)
    {
      return similar[0];
    }
    else if(num==3)
    {
      if(similar[0]==similar[1] && similar[1]==similar[2])
      {
        return 0;
      }
      if(similar[0]==similar[1])
      {
        return similar[2];
      }
      else if(similar[1]==similar[2])
      {
        return similar[0];
      }
    }
    return 0;
  }
  
  /**
   * This is a method that checks if a 5-Card Poker Hand is a Full-House
   * @return true if the hand is a Full-House; false otherwise
   * */
  public boolean testFullHouse(Card[] array)
  {
    if(testThree(array)==0 || pair(array)==0)
    {
      return false;
    }
    if(pair(array)==testThree(array))
    {
      return false;
    }
    return true;
  }
  
  /**
   * This is a method that checks if a 5-Card Poker Hand has Two-Distinct-Pairs
   * @return true if the hand has Two-Distinct-Pairs; false otherwise
   * */
  public boolean testTwoPairs(Card[] array)
  {
    int count=0;
    for(int i=0; i<array.length-1;i++)
    {
      int temp=array[i].getComp();
      if(temp==array[i+1].getComp())
      {
        count++;
        i+=1;
      }
      if(count==2)
      {
        return true;
      }
    }
    return false;
  }
  
  /**
   * This is a method that sorts the elements of a given array    
   * in ascending order
   * */
  public void SortArray(Card[] array) 
  {
    int i, j, minIndex;
    Card tmp;
    int n = array.length;
    for (i = 0; i < n - 1; i++)
    {
      minIndex = i;
      for (j = i + 1; j < n; j++)
        if (array[j].getComp() <array[minIndex].getComp())
      {
        minIndex = j;
      }
      if (minIndex != i)
      {
        tmp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmp;
      }
    }
  }
}