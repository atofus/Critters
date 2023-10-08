import java.awt.*;
import java.util.*;
/** Gator class that extends from superclass Critter. The color of the gator should start off 
 * and then be random every 5 steps. The gator value is displayed as :O. The class should also be able to 
 * dictate the Gator's movement. 
 * 
 * @author Alan To
 */
public class Gator extends Critter {
   private int moves;
   private int r;
   private Random rand; 
   
   
   /* Gator constructor that constructs the random object and sets moves to -1 so that it could start at 0 after increment*/
   public Gator() {
      this.moves = -1;
      this.rand = new Random();
   }
   
   
   /** Method will have every gator START off green then gators will start getting random colors every 5 moves
    * @return Whatever value the random object gives us from 0-2, it'll return and assign either blue, red or green to the gator. 
    */
   public Color getColor() {
      moves++;
      if (moves % 5 == 0 && moves != 0) {
         r = rand.nextInt(3);
      }
      if (r == 0||moves == 0){
         return Color.GREEN;
      }
      else if (r == 1) {
         return Color.RED;
      }
      else {
         return Color.BLUE;
      }
   }
   /* Method is going to show the Gator String value
    * @return :O the value for Gator
    */
   public String toString() {
      return ":O";
   }
   
   /* In the getMove method, it'll allow the gator to move. For this, the critter is going to attempt to ignore and stay away from everyone. This method will try to make this critter stay away 
    * from other critters as best as possible. It would not infect others, it's here for us to see how long it would survive without the ability to infect other critters. 
    * @param info CritterInfo should get the commands in CritterInfo to see how the Gator is supposed to move 
    * @return Correct Gator Actions allowing it to control how it moves depending on its position
    */ 
   public Action getMove(CritterInfo info) {
         if (info.getFront() == Neighbor.OTHER) {
            return Action.LEFT;
         }
         else if (info.getRight() == Neighbor.OTHER) {
            return Action.LEFT;
         }
         else if (info.getLeft() == Neighbor.OTHER) {
            return Action.RIGHT;
         }
         else if (info.getFront() == Neighbor.EMPTY || info.getBack() == Neighbor.OTHER) {
            return Action.HOP;
         }
         else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
         }
         else {
            return Action.RIGHT;
         }
       
   } 
}
