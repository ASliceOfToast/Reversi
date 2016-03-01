public abstract class Player{

    String whoAmI;

    public abstract int[] showMeYourMoves(int x, int y);

}

class HumanPlayer extends Player{

    public int[] showMeYourMoves(int x, int y){
      System.out.print("Enter your move, " + this.whoAmI + "player: ");
      int[] returnThis = new int[2];
      returnThis[0] = x;
      returnThis[1] = y;
      return returnThis;
    }

}

abstract class ComputerPlayer extends Player{



}

class RandomComputerPlayer extends ComputerPlayer{

    public int[] showMeYourMoves(int x, int y){

    }

}

class IntelligentComputerPlayer extends ComputerPlayer{

    public int[] showMeYourMoves(int x, int y){

    }

}
