import java.awt.*;
import java.util.*;

/* A lion class that extends from the Critter Superclass. It should change the color of the lion every 3 moves and
 * lion will be represented as an L.
 * @author Alan To
 *
 */
public class Lion extends Critter {
   private int count;
   private int r;
   private Random rand;
   
   /* Constructor that will just set count to 2*/
   public Lion() {
      this.count = 2; //started at 2 because once we increment it, count will be 3 allowing us go into the if statement allowing it to be Random in the beginning
      this.rand = new Random();
   }
   
   /* Method should randomly pick either red, blue or green every 3 moves for lion
    * @return Random Color for the lion for whatever number the random object gives us from 0-2 every 3 steps
    */  
   public Color getColor() {
      count++; //this increment will make count be 3 allowing for every lion in the beginning to be random
      if (count%3 == 0) {
         r = rand.nextInt(3); //random # from 0-2
      }
      if (r == 0) {
         return Color.BLUE;
      }
      else if (r == 1) {
         return Color.RED; 
      }
      else {
         return Color.GREEN;
      }
   }
   
   /* toString method that should will only display the letter "L"
    * @return L the value for Lion
    */
   public String toString() {
      return "L";
   }
   
   /* Method should mainly tell how the Lion is going to move around
    * @param info CritterInfo should get the commands in CritterInfo to see how the Lion is supposed to move
    * @return Correct Lion Actions allowing it to control how it moves depending on their position
    */
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      }
      else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
         return Action.LEFT;
      }
      else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      }
      else {
         return Action.HOP;
      }
   }
}
      