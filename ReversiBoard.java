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

    public void whereICanGo(String whoAmI){
        String whoTheyAre;
        if(whoAmI.equals("X")){
            whoTheyAre = "Y";
        }else{
            whoTheyAre = "X";
        }

        for(int[] location: hereIAm){

            int x = location[0];
            int y = location[1];



        }

    }//I JUST SET THIS TO VOID SO IT'D COMPILE FOR TEST, it was int[][]

}//ReversiBoard
