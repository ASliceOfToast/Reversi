import java.util.ArrayList;

public class ReversiBoard implements Board{
    int[][] hereIAm;
    String[][] that=new String [8][8];
		boolean gameover = true;

    public ReversiBoard(){
        for (int i = 0; i <8; i++){
  			 	for(int j = 0;j<8;++j){
  		    	  that[i][j]=".";
  			 	}//for
  	  	}//For
        that[3][3]="X";
        that[4][4]="X";
        that[4][3]="O";
        that[3][4]="O";
    }//Board

    public void printBoard(){
			System.out.println("   1 2 3 4 5 6 7 8  ");
				for (int i = 0; i <8; i++){
					System.out.print(" i+1");
					for(int j = 0;j<8;++j){
  		    	  System.out.print(that[i][j]+ " ");
  			 	}//for
  			 	System.out.println();
  	  	}//For
    }//printBoard

    public int[][] whereAmI(String whoAmI){

        int counter = 0;

        for (int i = 0; i <8; i++){
          for(int j = 0;j<8;++j){
              if(that[i][j].equals(whoAmI))
                  counter++;
          }//for
        }//For

        hereIAm = new int[counter][2];
        int counter2 = 0;

        for (int i = 0; i <8; i++){
  			 	for(int j = 0;j<8;++j){
  		    	  if(that[i][j].equals(whoAmI)){
                hereIAm[counter2][0] = i;
                hereIAm[counter2][1] = j;
                counter2++;
              }


  			 	}//for
  	  	}//For

        return hereIAm;

    }//whereIAm

    public ArrayList<int[]> whereICanGo(String whoAmI){
        String theyAre;
				ArrayList<int[]> canGoHere = new ArrayList<int[]>();
        if(whoAmI.equals("X")){
            theyAre = "O";
        }else{
            theyAre = "X";
        }

				for(String[] fuck:that){//Happy coincidence I swear
					for(String butt:fuck){//totally
						if(butt.equals("_")){
							butt=".";
						}//should replace
					}//all of the "_"
				}//with "."

        for(int[] location : hereIAm){//Iterating through all the locations of the player

            int x = location[0];
            int y = location[1];

						//Time to do the really fucking long check

						if(true){//General condition (There was a reason for this if statement earlier, but I changed it so now it's obsolete. I can't be bothered to remove it.)

							if(x>1){//Moving up
								if(that[x-1][y].equals(theyAre)){//check for them
									int step = 2;
									while(x-step>=0){
										if(that[x-step][y].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=x-step;
											possibleCoordinates[1]=y;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//check for them
							}//moving up

							if(x<6){//Moving down
								if(that[x+1][y].equals(theyAre)){//check for them
									int step = 2;
									while(x+step<=7){
										if(that[x+step][y].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=x+step;
											possibleCoordinates[1]=y;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//check for them
							}//moving down

							if(y>1){//moving left
								if(that[x][y-1].equals(theyAre)){//right check
									int step = 2;
									while(y-step>=0){
										if(that[x][y-step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=x;
											possibleCoordinates[1]=y-step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//right check
							}//moving left

							if(y<6){//moving right
								if(that[x][y+1].equals(theyAre)){//right check
									int step = 2;
									while(y+step<=7){
										if(that[x][y+step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=x;
											possibleCoordinates[1]=y+step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//right check
							}//moving right

							if(x<6&&y>1){//moving down and left
								if(that[x+1][y-1].equals(theyAre)){//check for them
									int step = 2;
									while(x+step<=7&&y-step>=0){
										if(that[x+step][y-step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=x+step;
											possibleCoordinates[1]=y-step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//check for them
							}//moving down and left

							if(x>1&&y>1){//moving up and left
								if(that[x-1][y-1].equals(theyAre)){//check for them
									int step = 2;
									while(x-step>=0&&y-step>=0){
										if(that[x-step][y-step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=x-step;
											possibleCoordinates[1]=y-step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//check for them
							}//moving right and up

							if(x>1&&y<6){//moving up and right
								if(that[x-1][y+1].equals(theyAre)){//check for them
									int step = 2;
									while(x-step>=0&&y+step<=7){
										if(that[x-step][y+step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=x-step;
											possibleCoordinates[1]=y+step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//check for them
							}//moving right and up

							if(x<6&&y<6){//moving down and right
								if(that[x+1][y+1].equals(theyAre)){//check for them
									int step = 2;
									while(x+step<=7&&y+step<=7){
										if(that[x+step][y+step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=x+step;
											possibleCoordinates[1]=y+step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//check for them
							}//moving right and down

						}//General condition

        }//Iterating through all the locations of player

				for(int[] possibleMove:canGoHere){
					int x = possibleMove[0];
					int y = possibleMove[1];
					that[x][y]="_";
				}

				return canGoHere;
    }//whereICanGo

		public boolean isGameOver(ArrayList<int[]> player1moves, ArrayList<int[]> player2moves){
      for (int i = 0; i <8; i++){
          for(int j = 0;j<8;++j){
              if(that[i][j].equals(".")){
               gameover = false;
              }//if, checks if board still has available spaces
          }//for
      }//For

      if(player1moves.size() != 0 && player2moves.size() != 0){
         gameover = false;
      }//if, checks if at least one player has possible moves

   return gameover;
   }//isGameOver

   public void displayScore(){
      int p1score=0;
      int p2score=0;
      String winner;

      for(int i = 0; i<8; i++){
         for(int j = 0; j<8; j++){
            if(that[i][j].equals("X")){
               p1score++;
            }//if
            else if(that[i][j].equals("O")){
               p2score++;
            }//else if
         }//for
      }//For

      System.out.println("\nPlayer 1: " + p1score + "points    Player 2: " + p2score + " points");
      if(p1score > p2score){
         winner = "Player 1 wins!! GG EZ";
      }//if player 1 higher score
      else if(p1score < p2score){
         winner = "Player 2 wins!! GG EZ";
      }//if player 2 higher score
      else{
         winner = "Neither of you fools win! AHAHAHA";
      }//if they tie

      System.out.println(winner);
   }//displayScore


		public void flipThatShit(){



		}//flip that shit

}//ReversiBoard
