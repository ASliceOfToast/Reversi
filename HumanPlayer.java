import java.util.*;

public class HumanPlayer extends Player{
Scanner input = new Scanner(System.in);

public void setMove(){
   System.out.println("Enter your move, " + getPlayer() + " player: ");
   String fightme;
   fightme = input.nextLine().replaceAll(" ",""); //kill all white space
     //not accounting for errors in player input yet =__=
   try{
      position[0] = Character.getNumericValue(fightme.charAt(0));
      position [1] = Character.getNumericValue(fightme.charAt(1));   
   }
   catch(NumberFormatException curveball){
      //meh
   }
}


}