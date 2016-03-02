import java.util.*;

public class HumanPlayer extends Player{
Scanner input = new Scanner(System.in);
public int[][] possiblecoordinates;
boolean ispossible;

public void setMove(int[][] possiblecoordinates){//will get possiblecoordinates from the whereCanIGo method in ReversiBoard
   possiblecoordinates = this.possiblecoordinates;
   System.out.println("Enter your move, " + getPlayer() + " player: ");
   String fightme;
   fightme = input.nextLine().replaceAll(" ",""); //kill all white space
     //not accounting for syntax errors in player input yet =__=
   try{
      position[0] = Character.getNumericValue(fightme.charAt(0));
      position [1] = Character.getNumericValue(fightme.charAt(1));   
   }
   catch(NumberFormatException curveball){
      //meh
   }
   
   for(int i = 0; i < possiblecoordinates.length;i++){
         if(possiblecoordinates[i][0] == position[0] && possiblecoordinates[i][1] == position[1]){
            ispossible = true;
         }
   }//for loop checks to see if the coordinates the user entered are valid moves/coordinates
   
   
   if(!ispossible){
      System.out.print("Invalid move.");
      setMove(possiblecoordinates);
   }//if the coordinates were invalid it runs the method again
}

}