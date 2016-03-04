import java.util.ArrayList;

/**
* This class creates and instance of board
* along with the methods used to manipulate it.
*/
public class ReversiBoard implements Board{
    int[][] hereIAm;
    String[][] that=new String [8][8];
		boolean gameover = true;

		/**
		* This constructor for ReversiBoard creates a board
		* of size 8x8 and sets up the positions for X and O.
		* Empty spots are represented with "."
		*/
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

		/**
		* This method prints out the current board with
		* the X and Y placements as well as the row and
		* column numberings.
		*/
		public void printBoard(){
			System.out.println("  1 2 3 4 5 6 7 8  ");
				for (int i = 0; i <8; i++){
					System.out.print(i+1+" ");
					for(int j = 0;j<8;++j){
  		    	  System.out.print(that[i][j]+ " ");
  			 	}//for
  			 	System.out.println();
  	  	}//For
    }//printBoard

		/**
		* This method takes in a string indicating whose
		* turn it is (X or Y) and finds all locations of
		* the player on the board.
		*
		* @param	whoAmI	a string indicating whose locations are being found
		* @return					an array holding arrays of ints representing the location of player
		*/
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

		/**
		* Returns an array of arrays with sizes of 2 representing
		* locations the player may place a piece.
		*
		* @param	whoAmI	a string representing the player
		* @return					an ArrayList of arrays with sizes of 2 representing possible placements
		*/
    public ArrayList<int[]> whereICanGo(String whoAmI){
        String theyAre;
				ArrayList<int[]> canGoHere = new ArrayList<int[]>();
        if(whoAmI.equals("X")){
            theyAre = "O";
        }else{
            theyAre = "X";
        }



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

				return canGoHere;
    }//whereICanGo

		/**
		* Returns true if the board has no available spaces left or if
		* if either of the two players can no longer make a move.
		*
		* @param	player1moves	an ArrayList of arrays representing locations of possible moves for player1
		* @param	player2moves	an ArrayList of arrays representing locations of possible moves for player2
		* @return								true or false depending on whether the game is over
		*/
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

	 /**
	 * The method does not return anything, but displaces who
	 * won the game depending on who has the greater score.
	 */
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

	 /**
	 * This method takes in an array representing the coordinates the Player
	 * wishes to place a piece as well as a string representing the player.
	 * Using this information, the method determines which tiles to flip and does so.
	 * It also makes the intended placement.
	 *
	 * @param	placeHere	an array representing the coordinates of the intended placement
	 * @param	whoAmI		a string representing the which player is calling the method
	 */
		public void flipThatShit(int[] placeHere, String whoAmI){

			int x = placeHere[0];
			int y = placeHere[1];
			String theyAre;
			if(whoAmI.equals("X")){
					theyAre = "O";
			}else{
					theyAre = "X";
			}

			that[x][y]=whoAmI;//Places the move.

			//I'm not really all too sure how to go about this, I'm thinking an 8 directional flip check, let's see how that goes...

			if(x>1){//Moving up
				if(that[x-1][y].equals(theyAre)){//check for them
					int step = 2;
					int counter = 1;
					while(x-step>=0){
						if(that[x-step][y].equals(whoAmI)){//found myself
							for(int i=counter;i>0;i--){//replace tiles
								that[x-i][y]=whoAmI;
							}
							break;
						}//found a dot
						step++;
						counter++;
					}//while loop
				}//check for myself
			}//moving up

			if(x<6){//Moving down
				if(that[x+1][y].equals(theyAre)){//check for them
					int step = 2;
					int counter = 1;
					while(x+step<=7){
						if(that[x+step][y].equals(whoAmI)){//found myself
							for(int i = counter; i>0;i--){//replace tiles
								that[x+i][y]=whoAmI;
							}
							break;
						}//found myself
						step++;
						counter++;
					}//while loop
				}//check for them
			}//moving down

			if(y>1){//moving left
				if(that[x][y-1].equals(theyAre)){//right check
					int step = 2;
					int counter = 1;
					while(y-step>=0){
						if(that[x][y-step].equals(whoAmI)){//found myself
							for(int i=counter;i>0;i--){//replace tiles
								that[x][y-i]=whoAmI;
							}
							break;
						}//found myself
						step++;
						counter++;
					}//while loop
				}//right check
			}//moving left

			if(y<6){ //moving right
				if(that[x][y+1].equals(theyAre)){//check for them
					int step = 2;
					int counter = 1;
					while(y+step<=7){
						if(that[x][y+step].equals(whoAmI)){//myself
							for(int i = counter; i>0;i--){
								that[x][y+i]=whoAmI;
							}
							break;
						}//found myself
						step++;
						counter++;
					}//while loop
				}//check
			}//moving right and up

			if(x<6&&y>1){//moving down and left
				if(that[x+1][y-1].equals(theyAre)){//check for them
					int step = 2;
					int counter = 1;
					while(x+step<=7&&y-step>=0){
						if(that[x+step][y-step].equals(whoAmI)){//found myself
							for(int i = counter; i>0; i--){
								that[x+i][y-i]=whoAmI;
							}
							break;
						}//found a dot
						step++;
						counter++;
					}//while loop
				}//check for them
			}//moving down and left

			if(x>1&&y>1){//moving up and left
				if(that[x-1][y-1].equals(theyAre)){//check for them
					int step = 2;
					int counter = 1;
					while(x-step>=0&&y-step>=0){
						if(that[x-step][y-step].equals(whoAmI)){//found myself
							for(int i =counter;i>0;i--){
								that[x-i][y-i]=whoAmI;
							}
							break;
						}//found myself
						step++;
						counter++;
					}//while loop
				}//check for them
			}//moving right and up

			if(x>1&&y<6){//moving up and right
				if(that[x-1][y+1].equals(theyAre)){//check for them
					int step = 2;
					int counter = 1;
					while(x-step>=0&&y+step<=7){
						if(that[x-step][y+step].equals(whoAmI)){//myself
							for(int i = counter; i>0;i--){
								that[x-i][y+i]=whoAmI;
							}
							break;
						}//found myself
						step++;
						counter++;
					}//while loop
				}//check
			}//moving right and up

			if(x<6&&y<6){//moving down and right
				if(that[x+1][y+1].equals(theyAre)){//check for them
					int step = 2;
					int counter=1;
					while(x+step<=7&&y+step<=7){
						if(that[x+step][y+step].equals(whoAmI)){//found myself
							for(int i=counter;i>0;i--){
								that[x+i][y+i]=whoAmI;
							}
							break;
						}//myself
						step++;
						counter++;
					}//while loop
				}//check for them
			}//moving right and down

		}//flip that shit

		/**
		* Takes in a string representing which player is calling the method and
		* uses the information to determine which of all the possible moves yields
		* the most flipped tiles.
		*
		* @param	whoAmI	a string representing which player is calling the method
		*/
		public int[] theVeryBest(String whoAmI){//find move that flips most tiles

			ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
			possibleMoves = whereICanGo(whoAmI);
			int[] bestMove = new int[2];
			int numFlipped = 0;
			String theyAre;
			if(whoAmI.equals("X")){
					theyAre = "O";
			}else{
					theyAre = "X";
			}

			for(int[] move:possibleMoves){
					int x = move[0];
					int y = move[1];

					//I think I'll re implement something like the 8 directional check for the flip function.
					if(x>1){//Moving up
						if(that[x-1][y].equals(theyAre)){//check for them
							int step = 2;
							int counter = 1;
							while(x-step>=0){
								if(that[x-step][y].equals(whoAmI)){//found myself
									for(int i=counter;i>0;i--){//replace tiles
										if(counter>numFlipped){//Comparing to currently best move
											counter=numFlipped;
											bestMove[0]=x;
											bestMove[1]=y;
										}
									}
									break;
								}//found a dot
								step++;
								counter++;
							}//while loop
						}//check for myself
					}//moving up

					if(x<6){//Moving down
						if(that[x+1][y].equals(theyAre)){//check for them
							int step = 2;
							int counter = 1;
							while(x+step<=7){
								if(that[x+step][y].equals(whoAmI)){//found myself
									for(int i = counter; i>0;i--){//replace tiles
										if(counter>numFlipped){//Comparing to currently best move
											counter=numFlipped;
											bestMove[0]=x;
											bestMove[1]=y;
										}
									}
									break;
								}//found myself
								step++;
								counter++;
							}//while loop
						}//check for them
					}//moving down

					if(y>1){//moving left
						if(that[x][y-1].equals(theyAre)){//right check
							int step = 2;
							int counter = 1;
							while(y-step>=0){
								if(that[x][y-step].equals(whoAmI)){//found myself
									for(int i=counter;i>0;i--){//replace tiles
										if(counter>numFlipped){//Comparing to currently best move
											counter=numFlipped;
											bestMove[0]=x;
											bestMove[1]=y;
										}
									}
									break;
								}//found myself
								step++;
								counter++;
							}//while loop
						}//right check
					}//moving left

					if(y<6){//moving right
						if(that[x][y+1].equals(theyAre)){//right check
							int step = 2;
							int counter = 1;
							while(y+step<=7){
								if(that[x][y+step].equals(whoAmI)){//found myself
									for(int i = counter; i>0;i++){//Replacetiles
										if(counter>numFlipped){//Comparing to currently best move
											counter=numFlipped;
											bestMove[0]=x;
											bestMove[1]=y;
										}
									}
									break;
								}//found myself
								step++;
								counter++;
							}//while loop
						}//right check
					}//moving right

					if(x<6&&y>1){//moving down and left
						if(that[x+1][y-1].equals(theyAre)){//check for them
							int step = 2;
							int counter = 1;
							while(x+step<=7&&y-step>=0){
								if(that[x+step][y-step].equals(whoAmI)){//found myself
									for(int i = counter; i>0; i--){
										if(counter>numFlipped){//Comparing to currently best move
											counter=numFlipped;
											bestMove[0]=x;
											bestMove[1]=y;
										}
									}
									break;
								}//found a dot
								step++;
								counter++;
							}//while loop
						}//check for them
					}//moving down and left

					if(x>1&&y>1){//moving up and left
						if(that[x-1][y-1].equals(theyAre)){//check for them
							int step = 2;
							int counter = 1;
							while(x-step>=0&&y-step>=0){
								if(that[x-step][y-step].equals(whoAmI)){//found myself
									for(int i =counter;i>0;i--){
										if(counter>numFlipped){//Comparing to currently best move
											counter=numFlipped;
											bestMove[0]=x;
											bestMove[1]=y;
										}
									}
									break;
								}//found myself
								step++;
								counter++;
							}//while loop
						}//check for them
					}//moving right and up

					if(x>1&&y<6){//moving up and right
						if(that[x-1][y+1].equals(theyAre)){//check for them
							int step = 2;
							int counter = 1;
							while(x-step>=0&&y+step<=7){
								if(that[x-step][y+step].equals(whoAmI)){//myself
									for(int i = counter; i>0;i--){
										if(counter>numFlipped){//Comparing to currently best move
											counter=numFlipped;
											bestMove[0]=x;
											bestMove[1]=y;
										}
									}
									break;
								}//found myself
								step++;
								counter++;
							}//while loop
						}//check
					}//moving right and up

					if(x<6&&y<6){//moving down and right
						if(that[x+1][y+1].equals(theyAre)){//check for them
							int step = 2;
							int counter=1;
							while(x+step<=7&&y+step<=7){
								if(that[x+step][y+step].equals(whoAmI)){//found myself
									for(int i=counter;i>0;i--){
										that[x+i][y+i]=whoAmI;
									}
									break;
								}//myself
								step++;
								counter++;
							}//while loop
						}//check for them
					}//moving right and down

			}

			return bestMove;
		}//like no one ever was

		public void printBored(ArrayList<int[]> placesICanGo){
			String[][] copy = new String[8][8];
			for(int i = 0;i<8;i++){
				for(int j= 0; j<8;j++){
					copy[i][j]=that[i][j];
				}
			}

			for(int i = 0;i<placesICanGo.size();i++){
				int x = placesICanGo.get(i)[0];
				int y = placesICanGo.get(i)[1];
				copy[x][y]="_";
			}

			System.out.println("  1 2 3 4 5 6 7 8  ");
				for (int i = 0; i <8; i++){
					System.out.print(i+1+" ");
					for(int j = 0;j<8;++j){
  		    	  System.out.print(copy[i][j]+ " ");
  			 	}//for
  			 	System.out.println();
  	  	}//For
    }//printBoard

}//ReversiBoard
