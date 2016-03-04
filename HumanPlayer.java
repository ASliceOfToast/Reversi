import java.util.*;

/**
* This class is a realization of the player class allowing for human input.
*/
public class HumanPlayer extends Player{
	Scanner input = new Scanner(System.in);
	public ArrayList<int[]> possiblecoordinates;
	public int[] holder = new int[2];
	boolean ispossible;

	/**
	* This constructor creates a player object
	*/
	public HumanPlayer(String player){
	   setPlayer(player);
	}
	/**
	* This method is an overloaded setMove that directly sets the player position.
	*
	*	@param	position	an int[] indicating a move.
	*/
	public void setMove(int[] position){}

	/**
	* This method sets a move according the possible moves given a player's positioning.
	*
	* @param	possiblecoordinates an ArrayList containing int[] representing possible placements of the player's pieces.
	*/
	public void setMove(ArrayList<int[]> possiblecoordinates){//will get possiblecoordinates from the whereCanIGo method in ReversiBoard
	   this.possiblecoordinates = possiblecoordinates;
	   System.out.println("Enter your move, " + getPlayer() + " player: ");
	   String fightme;
	   int[] AHAHA = new int[2];

	   fightme = input.nextLine().replaceAll(" ","");

	   try{
	      position[0] = Character.getNumericValue(fightme.charAt(0)) - 1;
	      position [1] = Character.getNumericValue(fightme.charAt(1)) - 1;
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
