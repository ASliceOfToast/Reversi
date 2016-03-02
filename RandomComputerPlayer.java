public class RandomComputerPlayer extends ComputerPlayer{
int rnum;

public void setMove(int[][] possiblecoordinates){
   rnum = (int) Math.ceil(Math.random() * (possiblecoordinates.length - 1));
   position[0] = possiblecoordinates[rnum][0]; 
   position[1] = possiblecoordinates[rnum][1];
   //will choose a random option from the int array that contains all possible moves
//then set position
}

}