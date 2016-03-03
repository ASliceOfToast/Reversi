import java.util.ArrayList;
public class Reversi{



  public static void main(String[] args){
  int count = 1; //counts turns
  Player player1 = new Player(){
   public void setMove(ArrayList<int[]> screams){};
  };
  Player player2 = new Player(){
   public void setMove(ArrayList<int[]> screamssomemore){}
  };
  
   if(args.length >= 3){
      System.out.println("Format is: java Reversi Player 1 Player 2. Replace Player 1 and Player 2 with Human or RandomComputerPlayer.");
      System.exit(0);
   }//if too many arguments
   
   for(int i = 0;i<args.length;i++){
         switch(args[i].toLowerCase()){
            case "randomcomputerplayer": 
               if(i == 0){
                  player1 = new RandomComputerPlayer("X");
               }
     
               if(i == 1){
                  player2 = new RandomComputerPlayer("O");
               }
            break;
            case "human":
               if(i == 0){
                  player1 = new HumanPlayer("X");
               }
               if(i == 1){
                  player2 = new HumanPlayer("O");   
               }
            break;
            default: 
               System.out.println("Format is: java Reversi Player 1 Player 2. Replace Player 1 and Player 2 with Human or RandomComputerPlayer.");
               System.exit(0);    
            }//switch, assigns players, exits game if invalid args given
            
   }//for loop
   
   System.out.println("\nWelcome to Reversi!  Moves should be entered in \"[row] [column]\" format.\n");
     
     
   ReversiBoard itsaboard = new ReversiBoard();
   
   //below commented out until boolean wincondition actually exists
   while(!itsaboard.isGameOver(itsaboard.whereICanGo(player1.getPlayer()), itsaboard.whereICanGo(player2.getPlayer()))){
 
         itsaboard.printBoard(); 
         if(count%2 == 0){
            itsaboard.whereAmI(player2.getPlayer());
            if(itsaboard.whereICanGo(player2.getPlayer()).size() != 0){
               player2.setMove(itsaboard.whereICanGo(player2.getPlayer()));
            }//if, skips player turn if they don't have any possible moves
            else{
               if(player2 instanceof HumanPlayer){
                  System.out.println("No possible moves!");
               }//if human player, displays message for them if they had no possible moves
            }
         }//if
         else{
            itsaboard.whereAmI(player1.getPlayer());
            if(itsaboard.whereICanGo(player1.getPlayer()).size() != 0){
               player1.setMove(itsaboard.whereICanGo(player1.getPlayer()));
            }//if, sets player move if they have possible moves
            else{
               if(player1 instanceof HumanPlayer){
                  System.out.println("No possible moves!");
               }//if human player, displays message for them if they had no possible moves
            }//else
         }//tests to see which player's turn it is. X goes on odd numbered turns, O on even
         count++;
   }//while, runs while game end conditions not met
   
   
   
   itsaboard.displayScore();
  }
}
