import java.util.ArrayList;

/**
*	This class is a realization of ComputerPlayer where the computer randomly selects a move.
*/
public class RandomComputerPlayer extends ComputerPlayer{
	public int rnum;

	/**
	* This method is an overloaded setMove that directly sets the player position.
	*
	*	@param	position	an int[] indicating a move.
	*/
	public void setMove(int[] position){}

		/**
		* The constructor creates a player object for computer.
		*/
	public RandomComputerPlayer(String player){
	   setPlayer(player);
	}
	/**
	* This method randomly selects a possible move
	*
	* @param possiblecoordinates	an ArrayList of int[] indicating possible moves for the given player.
	*/
	public void setMove(ArrayList<int[]> possiblecoordinates){
	   rnum = (int) Math.ceil(Math.random() * (possiblecoordinates.size() - 1));
	   position = possiblecoordinates.get(rnum);
	   //will choose a random option from the int array that contains all possible moves
	//then set position
	}

}
