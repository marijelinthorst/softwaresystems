package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class SmartStrategy implements Strategy{

  @Override
  public String getName() {
    return "Smart";
  }

  @Override
  public int determineMove(Board b, Mark m) {
    
    if (b.isEmptyField(4)) {
     return 4;
    }
    
    
    for (int i= 0; i < b.DIM * b.DIM ; i++){
      Board copy = b.deepCopy();
      if (copy.getField(i)== Mark.EMPTY) {
        copy.setField(i, m);
        if (copy.hasWinner()){
          return i;
        }
      }
    }
    
    for (int i= 0; i < b.DIM * b.DIM ; i++){
      Board copy = b.deepCopy();
      Mark other = Mark.EMPTY;
      if (m == Mark.OO) {
        other = Mark.XX;
      } else {
        other = Mark.OO;
      }
      if (copy.getField(i)== Mark.EMPTY) {
        copy.setField(i, other);
        if (copy.hasWinner()){
          return i;
        }
      }
    }
    
    int randomChoice = (int) Math.floor(Math.random() * 9);
    while (b.getField(randomChoice) != Mark.EMPTY) {
      randomChoice = (int) Math.floor(Math.random() * 9);
    } 
    return randomChoice;
  }
}
