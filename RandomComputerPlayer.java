import java.util.ArrayList;

public class RandomComputerPlayer extends ComputerPlayer{
public int rnum;

public RandomComputerPlayer(String player){
   setPlayer(player);
}

public void setMove(ArrayList<int[]> possiblecoordinates){
   rnum = (int) Math.ceil(Math.random() * (possiblecoordinates.size() - 1));
   position = possiblecoordinates.get(rnum);
   //will choose a random option from the int array that contains all possible moves
//then set position
}

}