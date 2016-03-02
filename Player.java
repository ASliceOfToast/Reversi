import java.util.ArrayList;

public abstract class Player{

private int score;
private String player;
public int[] position = new int[2];

public String getPlayer(){
   return player;
}
public void setPlayer(String player){
   player = this.player;
}

public abstract void setMove(ArrayList<int[]> possiblemoves);

public int[] getMove(){
   return position;
}

public void setScore(int score){
   score = this.score;
}

public int getScore(){
   return score;
}

}