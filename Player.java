public abstract class Player{

private String player;
public int[] position = new int[2];

public String getPlayer(){
   return player;
}
public void setPlayer(String player){
   player = this.player;
}

public abstract void setMove(int[][] possiblemoves);

public int[] getMove(){
   return position;
}

}