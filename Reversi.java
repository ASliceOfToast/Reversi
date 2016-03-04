import java.util.ArrayList;
public class Reversi{



  public static void main(String[] args){
  int count = 1; //counts turns
  boolean gameover=false;//determines if game end conditions met
  Player player1 = new Player(){
   public void setMove(ArrayList<int[]> screams){};
   public void setMove(int[] position){};
  };
  Player player2 = new Player(){
   public void setMove(ArrayList<int[]> screamssomemore){}
   public void setMove(int[] position){};
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
            case "intelligentcomputerplayer":
               if(i == 0){
                  player1 = new IntelligentComputerPlayer("X");
               }
               if(i == 1){
                  player2 = new IntelligentComputerPlayer("O");
               }
            break;
						case "reallyintelligentcomputerplayer":
							if(i==0){
								System.out.println("  1 2 3 4 5 6 7 8  ");
									for (int q = 0; q <8; q++){
										System.out.print(q+1+" ");
										for(int j = 0;j<8;++j){
					  		    	  System.out.print("X ");
					  			 	}//for
					  			 	System.out.println();
					  	  	}//For
									System.out.println("Player 1: 64 points		Player 2: 0 points\nPlayer 1 Wins!!\nHoly shit you suck, get rekt m8");
							}
							if(i==1){
								System.out.println("  1 2 3 4 5 6 7 8  ");
									for (int q = 0; q <8; q++){
										System.out.print(q+1+" ");
										for(int j = 0;j<8;++j){
					  		    	  System.out.print("O ");
					  			 	}//for
					  			 	System.out.println();
					  	  	}//For
									System.out.println("Player 1: 0 points		Player 2: 64 points\nPlayer 1 Wins!!\nHoly shit you suck, get rekt m8");
							}
						System.exit(0);
						break;
            default:
               System.out.println("Format is: java Reversi Player 1 Player 2. Replace Player 1 and Player 2 with Human or RandomComputerPlayer.");
               System.exit(0);
            }//switch, assigns players, exits game if invalid args given

   }//for loop

   System.out.println("\nWelcome to Reversi!  Moves should be entered in \"[row] [column]\" format.\n");


   ReversiBoard itsaboard = new ReversiBoard();
   itsaboard.whereAmI(player1.getPlayer());
   itsaboard.whereAmI(player2.getPlayer());



   while(!gameover){


         if(count%2 == 0){
            itsaboard.whereAmI(player2.getPlayer());
               if(player2 instanceof HumanPlayer){
                  itsaboard.printBored(itsaboard.whereICanGo(player2.getPlayer()));
               }//if, prints board for player
               else if(player2 instanceof ComputerPlayer){
                  itsaboard.printBoard();
                  System.out.println();
               }//else if, prints board for computerplayer (doesn't display _)
               if(itsaboard.whereICanGo(player2.getPlayer()).size() != 0){
                  if(player2 instanceof IntelligentComputerPlayer){
                     player2.setMove(itsaboard.theVeryBest(player2.getPlayer()));
                  }
                  else{
                     player2.setMove(itsaboard.whereICanGo(player2.getPlayer()));
                  }

                  itsaboard.flipThatShit(player2.getMove(),player2.getPlayer());
               }//if, skips player turn if they don't have any possible moves
               else{
                  if(player2 instanceof HumanPlayer){
                     System.out.println("No possible moves!");
                  }//if human player, displays message for them if they had no possible moves

            }//else, if there were no possible moves
            if(player2 instanceof ComputerPlayer){
               try {
                  Thread.sleep(1000);
               }//put that thread to sleep man
               catch (InterruptedException ie) {
                  ie.printStackTrace();
               }
               itsaboard.printBoard();
               System.out.println();
               System.out.println("Player 2 moved!");
            }

         }//if, tests what player's turn it is
         else{
            itsaboard.whereAmI(player1.getPlayer());
               if(player1 instanceof HumanPlayer){
                  itsaboard.printBored(itsaboard.whereICanGo(player1.getPlayer()));
               }
               else if(player1 instanceof ComputerPlayer){
                  itsaboard.printBoard();
                  System.out.println();
               }//else if, prints board for computerplayer (doesn't display _)
               if(itsaboard.whereICanGo(player1.getPlayer()).size() != 0){
                  if(player1 instanceof IntelligentComputerPlayer){
                     player1.setMove(itsaboard.theVeryBest(player1.getPlayer()));
                  }
                  else{
                     player1.setMove(itsaboard.whereICanGo(player1.getPlayer()));
                  }
                  itsaboard.flipThatShit(player1.getMove(),player1.getPlayer());
               }//if, sets player move if they have possible moves
               else{
                  if(player1 instanceof HumanPlayer){
                     System.out.println("No possible moves!");
                  }//if human player, displays message for them if they had no possible moves
               }//else, if there were no possible moves
            if(player1 instanceof ComputerPlayer){
               try {
                  Thread.sleep(1000);
               }//put that thread to sleep man
               catch (InterruptedException ie) {
                  ie.printStackTrace();
               }
               itsaboard.printBoard();
               System.out.println();
               System.out.println("Player 1 moved!");
            }
         }//tests to see which player's turn it is. X goes on odd numbered turns, O on even
         count++;
      gameover = itsaboard.isGameOver(itsaboard.whereICanGo(player1.getPlayer()), itsaboard.whereICanGo(player2.getPlayer()));

   }//while, runs while game end conditions not met



   itsaboard.displayScore();
  }
}
