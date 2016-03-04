import java.util.ArrayList;

/**
* This class represents attributes shared by all players
*/
public abstract class Player{

	private String player;
	public int[] position = new int[2];

	/**
	* This method returns a string representation of the player.
	*
	* @return			the string representation of the player
	*/
	public String getPlayer(){
	   return player;
	}

	/**
	* This method is an overloaded setMove that directly sets the player position.
	*
	*	@param	position	an int[] indicating a move.
	*/
	public abstract void setMove(int[] position);

	/**
	* This method sets the player as being the string taken in.
	*/
	public void setPlayer(String player){
	   this.player = player;
	}

	/**
	* This method would set a move for a player given an arraylist of int[]
	* indicating all the possible placements for a player.
	*
	* @param	possibleMoves	an ArrayList of int[] indicating possible placements
	*/
	public abstract void setMove(ArrayList<int[]> possiblemoves);

	/**
	* This method returns the currently selected move.
	*
	*	@return		an int[] representing the currently decided move.
	*/
	public int[] getMove(){
	   return position;
	}


}
