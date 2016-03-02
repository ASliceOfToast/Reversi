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
        for (int i = 0; i <8; i++){
  			 	for(int j = 0;j<8;++j){
  		    	  System.out.print(that[i][j]);
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
            theyAre = "Y";
        }else{
            theyAre = "X";
        }

        for(int[] location : hereIAm){//Iterating through all the locations of the player

            int x = location[0];
            int y = location[1];

						//Time to do the really fucking long check
						//Starting with special cases

						if(x==0&&y==0){//Top left

							if(that[1][0].equals(theyAre)){//It's going down
								for(int i = 2; i<that.length;i++){//Don't go too far down
									if(that[i][0].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=0;
										canGoHere.add(possibleCoordinates);
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
									}//found a dot
								}//Don't go too far
							}//towards the bottom right

						}//if Top left

						if(x==0&&y==7){//Top right

							if(that[1][7].equals(theyAre)){//It's going down
								for(int i = 2; i<that.length;i++){//Don't go too far down
									if(that[i][7].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=i;
										possibleCoordinates[1]=7;
										canGoHere.add(possibleCoordinates);
									}//Found a dot
								}//Don't go too far down
							}//...I'm yelling timber

							if(that[0][6].equals(theyAre)){//Going left
								for(int i = that[0].length - 2; i>0;i++){//Don't go too far
									if(that[0][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=0;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
									}//Found a dot
								}//But not too far
							}//To the right

							if(that[1][6].equals(theyAre)){//going diagonally down and left
								for(int i = that[0].length - 2; i>0;i++){//Don't go too far
									if(that[that[0].length-i][i].equals(".")){//found a dot
										int[] possibleCoordinates = new int[2];
										possibleCoordinates[0]=that[0].length-i;
										possibleCoordinates[1]=i;
										canGoHere.add(possibleCoordinates);
									}//found a dot
								}//Don't go too far
							}//towards the bottom left

						}//if Top right



        }//Iterating through all the locations of player
				return canGoHere;
    }//whereICanGo

}//ReversiBoard
