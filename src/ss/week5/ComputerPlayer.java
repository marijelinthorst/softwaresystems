package ss.week5;

import ss.week4.tictactoe.*;


public class ComputerPlayer extends ss.week4.tictactoe.Player{
  
  private Strategy strategy;
  
  public ComputerPlayer (Mark mark, Strategy strategy) {
    super(strategy.getName() + " - " + mark.name(), mark);
    this.strategy = strategy;
  }

  public ComputerPlayer(Mark mark) {
    super("Naive - " + mark.name(), mark);
    this.strategy= new NaiveStrategy();
  }

  @Override
  public int determineMove(Board board) {
    return strategy.determineMove(board, this.getMark());
  }

}
