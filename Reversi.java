public class Reversi{
int count = 1;


  public static void main(String[] args){
   
   if(args.length >= 3){
      System.out.println("Format is: java Reversi Player 1 Player 2. Replace Player 1 and Player 2 with Human or RandomComputerPlayer.");
      System.exit(0);
   }
   
   for(int i = 0;i<args.length;i++){
         switch(args[i].toLowerCase()){
            case "randomcomputerplayer": 
               if(i == 0){
                  RandomComputerPlayer player1 = new RandomComputerPlayer("X");
               }
     
               if(i == 1){
                  RandomComputerPlayer player2 = new RandomComputerPlayer("O");
               }
            break;
            case "human":
               if(i == 0){
                  HumanPlayer player1 = new HumanPlayer("X");
               }
               if(i == 1){
                  HumanPlayer player2 = new HumanPlayer("O");   
               }
            break;
            default: 
               System.out.println("Format is: java Reversi Player 1 Player 2. Replace Player 1 and Player 2 with Human or RandomComputerPlayer.");
               System.exit(0);    
            }//switch
            
   }//for loop
   
   System.out.println("\nWelcome to Reversi!  Moves should be entered in \"[row] [column]\" format.\n");
   
   
   ReversiBoard itsaboard = new ReversiBoard();
     
   
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
