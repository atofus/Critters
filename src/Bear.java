import java.awt.*; //import declartion is here because it allows access to the color class
/*
 * This is the bear class that extends from the Critter SuperClass. It should tell us the color of 
 * the bear and the bear will be represented with / and \
 * @author Alan To
 *
 */
public class Bear extends Critter {

   private boolean polar;
   private int moves; //to check the the amount of bear moves
   
   /** Constructor that constructs the polar field and give value to the field, moves
    * @param polar a boolean parameter that gives the field polar a value
    */
   public Bear(boolean polar) {
      this.polar = polar; //takes in the boolean parameter
      this.moves = 1;
   }
   /* Method should check to see what color the bear is. If polar is true it should make bear white and if it's false, it should make the bear black.
    * @return if polar is true, the bear should turn white
    * @return if polar is false, the bear should turn black
    */
   public Color getColor() {
      if (this.polar == true) {
         return Color.WHITE;
      }
      else {
         return Color.BLACK;
      }
   }
   /* Method should move back in forth between / and \
    * @return if number of moves is even it'll display /
    * @return if number of moves is odd it'll display \
    */
   
   public String toString() {
      moves++;
      if (moves % 2 == 0) {
         return "/";
      }
      else {
         return "\\";
      }
   }
   /* Method should tell how the bear is supposed to move
    * @param info CritterInfo should get the commands in CritterInfo to see how bear is supposed to move
    * @return Correct Bears Actions and controlling how it moves depending on their position
    *
    */
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      }
      else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      }
      else { //if what's in front is the same
         return Action.LEFT;
      }
   }
      
}

