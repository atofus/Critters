import java.awt.*;

/* A Giant class that extends from the Critter super class. It should give the color gray and 
 * the value should be alternating from fie to fie to foe and to fum every 6 steps. It should then reset
 * to fee after fum. 
 * @author Alan To
 */
public class Giant extends Critter {
   private int count; 
   
   /* Constructor that sets count to start at 0 */
   public Giant() {
      this.count = 1;
   }

   public Color getColor() {
      return Color.GRAY;
   }
   /* The method that will show the value/String of Giant and 
    * @return "fee" for first 6 counts/steps, "fie" for next 6 counts/steps, "foe" for next 6 counts/steps, and "fum" for the next 6 count/steps
    */
   public String toString() { 
      if (count <= 6 ) {
         return "fee";
      }
      else if (count <= 12) {
         return "fie";
      }
      else if (count <= 18) {
         return "foe";
      }
      else {
         return "fum";
      }
   }
   
   /** Counter method should keep track of count and make sure it's no more than 24. It should reset count to 0 once it hits 24. Otherwise, we'll keep incrementing count.*/
   public void Counter() {
      if (count == 24) {
         count=1; //should reset when we hit 24 
      }
      else {
         count++; //we'll keep incrementing count until we hit 24
      }
   }
   /* Method should mainly tell how the Giant is going to move around. It should also check for count to see how many times the giant moves to make sure we could reset the String value of giant back to fee
    * @param info CritterInfo should get the commands in CritterInfo to see how Giant is supposed to move
    * @return Correct Giants Action and controlling how it moves based on their position
    */
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         Counter(); //will check for how many times the Giant moves
         return Action.INFECT;
      }
      else if (info.getFront() == Neighbor.EMPTY) {
         Counter();
         return Action.HOP;
      }
      else {
         Counter();
         return Action.RIGHT;
      }
    }
}