package ss.week5;

import ss.week4.tictactoe.*;
/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
  public static Player s0;
  public static Player s1;
    public static void main(String[] args) {
      
      if (args[0].equals("-N")){
        s0 = new ComputerPlayer (Mark.XX);
      } else if(args[0].equals("-S")){
        s0 = new ComputerPlayer (Mark.XX, new SmartStrategy());
      } else {
        s0 = new HumanPlayer (args[0], Mark.XX);
      }
      
      if (args[1].equals("-N")) {
        s1 = new ComputerPlayer (Mark.OO);
      } else if(args[1].equals("-S")){
        s1 = new ComputerPlayer (Mark.OO, new SmartStrategy());
      } else {
        s1 = new HumanPlayer (args[1], Mark.OO);
      }
      Game game = new Game(s0, s1);
      game.start();   
    }
}

