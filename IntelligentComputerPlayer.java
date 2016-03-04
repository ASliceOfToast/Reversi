import java.util.*;

public class IntelligentComputerPlayer extends ComputerPlayer{

   public IntelligentComputerPlayer(String player){
      setPlayer(player);
   }
   
   public void setMove(int[] position){
      this.position[0] = position[0];
      this.position[1] = position[1];
   }

   public void setMove(ArrayList<int[]> possiblemoves){
   
   }
}