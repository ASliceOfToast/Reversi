<div align = "center">
# Reversi
<b>Nathan Su</b> | 811342394 | nws44361@uga.edu  
<b>Trinity Key</b> | 811890405 | trinity.key25@uga.edu
###Starting A Gayme
<b>1.</b> Open the command line or terminal and move to the directory containing all java and/or class files (use `cd pathname`).
<b>2.</b> In case there are no class files, run the following to compile the java files: `javac Player.java HumanPlayer.java ComputerPlayer.java RandomComputerPlayer.java Board.java ReversiBoard.java Reversi.java` .
<b>2.</b> Start a game by typing the command `java Reversi [Player 1] [Player 2]`, replacing [Player 1] and [Player 2] with the types of players you would like.  

<b>ie.</b> `java Reversi Human RandomComputerPlayer`    

There are two types of players: Human and RandomComputerPlayer.      
<b>Human:</b> Allows for user input to determine moves.  
<b>RandomComputerPlayer:</b> A simpleminded bot that makes random moves against its opponent in futile hopes of success.    

<b>Player 1 goes first and their pieces are denoted by X, while Player 2's are denoted by O.</b>

###The Rules of the Gayme
The players are pitted against each other in a death match taking place on an 8 by 8 grid, which is first populated with two X's and two O's in such a manner as the following:  
<pre>
    1 2 3 4 5 6 7 8  
1 . . . . . . . .
2 . . . . . . . .
3 . . . . _ . . .
4 . . . X O _ . .
5 . . _ O X . . .
6 . . . _ . . . .
7 . . . . . . . .
8 . . . . . . . .

Enter your move, X player:</pre>    

The dots denote empty spaces. Underscores denote spaces where the player, Player 1 (X) in this instance, may place a piece. Placing a piece in any one of these spots results in all of your enemy's hapless pieces that happen to be caught between two of yours to betray their former master and become one of your own.    

Suppose Player 1, in a display of ruthless brutality, puts their piece at coordinates (5,3), using the following command:  
`5 3`  (the format is [rows] [cols])  

The resulting board:  

<pre>
    1 2 3 4 5 6 7 8  
1 . . . . . . . .
2 . . . . . . . .
3 . . . _ X _ . .
4 . . . X X . . .
5 . . . O X _ . .
6 . . . . . . . .
7 . . . . . . . .
8 . . . . . . . .

Enter your move, O player:</pre>         
And thus it is Player 2's turn.  
And thus, the war wages on. Until...
###Win Conditions
The game ends when any of following things happens:  
<b>1.</b> The board is filled entirely with player pieces.  
<b>2.</b> Neither player can make a move.    

The player with the most pieces wins the game.
</align>
