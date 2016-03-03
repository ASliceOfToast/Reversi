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
  int[] AHAHA = new int[2];
   if(args.length >= 3){
      System.out.println("Format is: java Reversi Player 1 Player 2. Replace Player 1 and Player 2 with Human or RandomComputerPlayer.");
      System.exit(0);
   }
   
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
            }//switch
            
   }//for loop
   
   System.out.println("\nWelcome to Reversi!  Moves should be entered in \"[row] [column]\" format.\n");
  
   
   /** THE TESTING AREA 
   
   player1 = new RandomComputerPlayer("X");
   ReversiBoard itsaboard = new ReversiBoard();
   itsaboard.whereAmI(player1.getPlayer());
   
   itsaboard.printBoard();
    
   for(int i = 0; i<itsaboard.whereICanGo(player1.getPlayer()).size();i++){
   AHAHA  = itsaboard.whereICanGo(player1.getPlayer()).get(i);
   System.out.print((AHAHA[0]+1) + ", ");
   System.out.println((AHAHA[1]+1));
   }
   
   player1.setMove(itsaboard.whereICanGo(player1.getPlayer()));
   System.out.println(player1.getMove()[0] + ", " +player1.getMove()[1]);*/
   
     
   
   //below commented out until boolean wincondition actually exists
   /*while(!wincondition){
         itsaboard.printBoard(); 
         if((count%2 == 0){
            itsaboard.whereAmI(player2.getPlayer());
            player2.setMove(itsaboard.whereICanGo(player2.getPlayer()));
         }
         else{
            itsaboard.whereAmI(player1.getPlayer());
            player1.setMove(itsaboard.whereICanGo(player1.getPlayer()));
         }
         count++;
   }
   
   some method that counts the amount of 'O's and 'X's on the board to determine winner
   
   */
   
   System.out.println("GG NUBS -insertplayer- WINS");
  }
}
