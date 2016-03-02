import java.util.*;

public class HumanPlayer extends Player{
Scanner input = new Scanner(System.in);
public ArrayList<int[]> possiblecoordinates;
public int[] holder = new int[2];
boolean ispossible;

public HumanPlayer(String player){
   setPlayer(player);
}

public void setMove(ArrayList<int[]> possiblecoordinates){//will get possiblecoordinates from the whereCanIGo method in ReversiBoard
   possiblecoordinates = this.possiblecoordinates;
   System.out.println("Enter your move, " + getPlayer() + " player: ");
   String fightme;
   fightme = input.nextLine().replaceAll(" ",""); //kill all white space
     //not accounting for syntax errors in player input yet =__=
   try{
      position[1] = Character.getNumericValue(fightme.charAt(0)) - 1;
      position [0] = Character.getNumericValue(fightme.charAt(1)) - 1;   
   }
   catch(NumberFormatException curveball){
      System.out.println("Input format is: [rows] [cols]. [rows] and [cols] must be integers.");
      setMove(possiblecoordinates);
   }
   
   for(int i = 0; i < possiblecoordinates.size();i++){
         holder = possiblecoordinates.get(i);
         if(holder[0] == position[0] && holder[1] == position[1]){
            ispossible = true;
         }
   }//for loop checks to see if the coordinates the user entered are valid moves/coordinates
   
   
   if(!ispossible || position[0] < 0 || position[1] < 0 || position[0] > 7 || position[1] > 7){
      System.out.print("Invalid move.");
      setMove(possiblecoordinates);
   }//if the coordinates were invalid it runs the method again
}

}