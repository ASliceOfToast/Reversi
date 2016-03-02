import java.util.ArrayList;

public class ReversiBoard implements Board{
    int[][] hereIAm;
    String[][] that=new String [8][8];

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

        for(int[] location : hereIAm){//Iterating through all the locations of the player

            int x = location[0];
            int y = location[1];

						//Time to do the really fucking long check
						//Starting with special cases
						//Holy fuck this shit is long
						//I'm just gonna put a shit load of comments here so I can find it more easily..................................................................................................................best solution.
						//Thank God for folding.

						if(x==0&&y==0){//Top left Corner

							if(that[1][0].equals(theyAre)){//It's going down
								for(int i = 2; i<that.length;i++){//Don't go too far down
									if(that[i][0].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=0;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//Don't go too far down
							}//...I'm yelling timber

							if(that[0][1].equals(theyAre)){//Going right
								for(int i = 2; i<that[0].length;i++){//Don't go too far
									if(that[0][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=0;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//But not too far
							}//To the right

							if(that[1][1].equals(theyAre)){//going diagonally down and right
								for(int i = 2; i<that[0].length;i++){//Don't go too far
									if(that[i][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
										break;
									}//found a dot
								}//Don't go too far
							}//towards the bottom right

						}//if Top left

						if(x==0&&y==7){//Top right corner

							if(that[1][7].equals(theyAre)){//It's going down
								for(int i = 2; i<that.length;i++){//Don't go too far down
									if(that[i][7].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=7;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//Don't go too far down
							}//...I'm yelling timber

							if(that[0][6].equals(theyAre)){//Going left
								for(int i = that[0].length - 2; i>0;i--){//Don't go too far
									if(that[0][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=0;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);break;
									}//Found a dot
								}//But not too far
							}//To the right

							if(that[1][6].equals(theyAre)){//going diagonally down and left
								for(int i = that[0].length - 2; i>0;i--){//Don't go too far
									if(that[that[0].length-i][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=that[0].length-i;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
										break;
									}//found a dot
								}//Don't go too far
							}//towards the bottom left

						}//if Top right

						if(x==7&&y==0){//Bottom left corner

							if(that[6][0].equals(theyAre)){//I'm coming up
								for(int i = that[0].length - 2; i>0;i--){//But not too far up
									if(that[i][0].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=0;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//but not too far up
							}//...so you better get the party started

							if(that[7][1].equals(theyAre)){//Going right
								for(int i = 2; i<that[0].length;i++){//Don't go too far
									if(that[7][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=7;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//But not too far
							}//To the right

							if(that[6][1].equals(theyAre)){//going diagonally up and right
								for(int i = that[0].length - 2; i>0;i--){//Don't go too far
									if(that[i][that[0].length-i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=that[0].length-i;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
										break;
									}//found a dot
								}//Don't go too far
							}//up and right

						}//bottom left

						if(x==7&&y==0){//Bottom right corner

							if(that[6][7].equals(theyAre)){//I'm coming up
								for(int i = that[0].length - 2; i>0;i--){//But not too far up
									if(that[i][7].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=7;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//but not too far up
							}//...so you better get the party started

							if(that[7][6].equals(theyAre)){//To the left
								for(int i = that[0].length - 2; i>0;i--){//Don't go too far
									if(that[7][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=7;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//But not too far
							}//... Irreplaceable - Beyonce

							if(that[6][6].equals(theyAre)){//going diagonally up and left
								for(int i = that[0].length - 2; i>0;i--){//Don't go too far
									if(that[i][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
										break;
									}//found a dot
								}//Don't go too far
							}//up and left

						}//bottom right

						if(x==0&&y!=0&&y!=7){//Top edge

							if(y>1){//moving left
								if(that[0][y-1].equals(theyAre)){//left check
									int step = 2;
									while(y-step>=0){
										if(that[0][y-step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=0;
											possibleCoordinates[1]=y-step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//left check
							}//moving left

							if(y<6){//moving right
								if(that[0][y+1].equals(theyAre)){//right check
									int step = 2;
									while(y+step<=7){
										if(that[0][y+step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=0;
											possibleCoordinates[1]=y+step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//right check
							}//moving right

							if(that[1][y].equals(theyAre)){//moving down
								for(int i = 2; i<that.length;i++){//Don't go too far down
									if(that[i][y].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=y;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//Don't go too far down
							}//moving down

							if(y>1){//moving left and down
								if(that[x+1][y-1].equals(theyAre)){//check for them
									int step = 2;
									while(y-step>=0){
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
							}//moving left

							if(y<6){//moving right and down
								if(that[x+1][y+1].equals(theyAre)){//check for them
									int step = 2;
									while(y+step<=7){
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

						}//Top edge

						if(x==7&&y!=0&&y!=7){//Bottom edge

							if(y>1){//moving left
								if(that[7][y-1].equals(theyAre)){//left check
									int step = 2;
									while(y-step>=0){
										if(that[7][y-step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=7;
											possibleCoordinates[1]=y-step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//left check
							}//moving left

							if(y<6){//moving right
								if(that[7][y+1].equals(theyAre)){//right check
									int step = 2;
									while(y+step<=7){
										if(that[7][y+step].equals(".")){//found a dot
											int[] possibleCoordinates = new int[2];
											possibleCoordinates[0]=7;
											possibleCoordinates[1]=y+step;
											canGoHere.add(possibleCoordinates);
											break;
										}//found a dot
										step++;
									}//while loop
								}//right check
							}//moving right

							if(that[6][y].equals(theyAre)){//moving up
								for(int i = 2; x-i>=0;i++){//Don't go too far up
									if(that[x-i][y].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=x-i;
										possibleCoordinates[1]=y;
										canGoHere.add(possibleCoordinates);
										break;
									}//Found a dot
								}//Don't go too far up
							}//moving up

							if(y>1){//moving left and up
								if(that[x-1][y-1].equals(theyAre)){//check for them
									int step = 2;
									while(y-step>=0){
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
							}//moving left and up

							if(y<6){//moving right and up
								if(that[x-1][y+1].equals(theyAre)){//check for them
									int step = 2;
									while(y+step<=7){
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

						}//Bottom edge

						if(y==0&&x!=0&&x!=7){//Left edge

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

							if(x>1){//moving right and up
								if(that[x-1][y+1].equals(theyAre)){//check for them
									int step = 2;
									while(x-step>=0){
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

							if(x<6){//moving right and down
								if(that[x+1][y+1].equals(theyAre)){//check for them
									int step = 2;
									while(x+step<=7){
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

						}//Left edge

						if(y==7&&x!=0&&x!=7){//Right edge

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

							if(x>1){//moving left and up
								if(that[x-1][y-1].equals(theyAre)){//check for them
									int step = 2;
									while(x-step>=0){
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

							if(x<6){//moving left and down
								if(that[x+1][y-1].equals(theyAre)){//check for them
									int step = 2;
									while(x+step<=7){
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
							}//moving right and down

						}//Right edge

						if(x!=0&&x!=7&&y!=0&&y!=7){//General condition

							//And so begins the last portion of this gargantuan method.............................................................................................................................

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
							}//moving right and down

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

}//ReversiBoard
