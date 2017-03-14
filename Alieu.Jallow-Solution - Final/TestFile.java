import java.util.Scanner;
/**
 * This is a test Class
 * @author Alieu Jallow
 * */
public class TestFile
{
  public static void main(String[]args)
  {
    /**
     * instance varibales
     * */
    final int ONE=1;
    final int TWO=2;
    final int ZERO=0;
    final int FIVE=5;
    Poker game =new Poker();
    Card[]array=new Card[FIVE];
    String[] suits=new String[FIVE];
    String[] ranks=new String [FIVE];
    char[] comp=new char[FIVE];
    
    /**
     * printing instructions
     * */
    System.out.print("This is a program that helps you to determine whether a 5-Card Poker Hand is a FLUSH, STRAIGHT, STARIGHT-FLUSH,");
    System.out.println("FOUR-OF-A-KIND, THREE-OF-A-KIND, PAIR, TWO-PAIR, or a FULL-HOUSE");
    System.out.println("To start the program, enter 5 cards separated by a space in the console and hit Enter.");
    System.out.println();
    System.out.println("A card is represented by a number and a letter or two letters. Valid numbers range from 1 to 10 and the valid letters are:");
    System.out.println("S for Spade, D for DIAMOND, H for HEART C for CLUB, J for JACK, Q for QUEEN, and K for KING");
    System.out.println();
    System.out.println();
    System.out.println("For example, a Jack Club should be represented as JC,  ");
    System.out.println("5 Heart as 5H 7 Diamond as 7D, 8 Club as 8C, Jack Spade as JS, King Club as KQ etc.... ");
    System.out.println("NOTE: The vale of an Ace should be entered as 1 or 11 eg a club Ace should be entered as either 11C or 1C");
    System.out.println();
    System.out.println("Please Enter 5 valid Cards");
    
    /**
     * taking input from the user and storing it in an array
     * */
    Scanner input=new Scanner(System.in);
    String userInput=input.nextLine();
    String[] start=userInput.split(" ");
    
    /**
     * separating the numbers from the letters
     * */
    try
    {
      if(start.length==FIVE)
      {
        for(int i=ZERO; i<suits.length;i++)
        {
          String[] part =start[i].split("");
          if(part.length<4)
          {
            if(part.length==3 && Integer.parseInt(part[ZERO])==ONE)
            {
              if(Integer.parseInt(part[ONE])==ZERO)
              {
                ranks[i]="10";
                comp[i]= '0';
                suits[i]=part[TWO];
              }
              else if(Integer.parseInt(part[ONE])==ONE)
              {
                ranks[i]="11";
                comp[i]='W';
                suits[i]=part[TWO];
              }
            }
            else if(part.length==TWO)
            {
              ranks[i]=part[ZERO];
              comp[i]= ranks[i].charAt(ZERO);
              suits[i]=part[ONE];
            }
            
            if(suits[i]!=null && (suits[i].equalsIgnoreCase("D") || suits[i].equalsIgnoreCase("H") || suits[i].equalsIgnoreCase("S") || suits[i].equalsIgnoreCase("C")))
            {
              if(ranks[i]!=null)
              {
                if(ranks[i].equalsIgnoreCase("j"))
                {
                  comp[i]='X';
                }
                else if(ranks[i].equalsIgnoreCase("k"))
                {
                  comp[i]='Y';
                }
                else if(ranks[i].equalsIgnoreCase("Q"))
                {
                  comp[i]='Z';
                }
              }
              if((int)comp[i] < 48 || (int)comp[i] >90)
              {
                System.out.println("you have entered INVALID number");
                System.exit(ZERO);
              }
            }
            else
            {
              System.out.println("you have entered INVALID Card(s)");
              System.exit(ZERO);
            }
          }
          else
          {
            System.out.println("you have entered INVALID input");
            System.exit(ZERO);
          }
        } 
        
        /**
         * cerating instances of a card
         * */
        for(int i=ZERO; i<suits.length;i++)
        {
          array[i]=new Card(ranks[i],suits[i], (int) comp[i]);
        }
        
        /**
         * Sorting the elements of the array in ascending order
         * */
        game.SortArray(array);
        
        /**
         * Checking the status of a 5-Card Poker Hand
         * */
        if(game.testFlushStraight(array))
        {
          System.out.println("The cards are STRAIGHT-FLUSH");
        }
        else if (game.testFourOfAKind(array))
        {
          System.out.println("The cards are FOUR-OF-A-KIND");
        }
        else if(game.testFullHouse(array))
        {
          System.out.println("The cards are FULL-HOUSE");
        }
        else if(game.testFlush(array))
        {
          System.out.println("The cards are FLUSH");
        }
        else if(game.testStraight(array))
        {
          System.out.println("The cards are STRAIGHT");
        }
        else if(game.testThreeOfAKind(array))
        {
          System.out.println("The cards are THREE-OF-A-KIND");
        }
        else if(game.testTwoPairs(array))
        {
          System.out.println("The cards have TWO-PAIRS");
        }
        else if(game.testPair(array))
        {
          System.out.println("The cards have a PAIR");
        }
        else
        {
          System.out.println("Sorry, the 5-Card Poker hand you entered is not in the list");
        } 
      } 
      else
      {
        System.out.println("You have entered an INVALID number of Cards");
      }
    }
    catch(NumberFormatException e)
    {
      System.out.println("you have entered INVALID Card(s)");
      System.exit(ZERO);
    }
  }
}