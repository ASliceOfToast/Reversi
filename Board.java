public interface Board{

public void printBoard();

}

class ReversiBoard implements Board{
    int[][] hereIAm;
    String[][] that=new String [8][8];

    public void ReversiBoard(){
        for (int i = 0; i <8; i++){
  			 	for(int j = 0;j<8;++j){
  		    	  that[i][j]=".";
  			 	}//for
  	  	}//For
        that[4][4]="X";
        that[5][5]="X";
        that[5][4]="O";
        that[4][5]="O";
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

    public int[][] whereICanGo(String whoAmI){
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

    }

}//ReversiBoard
