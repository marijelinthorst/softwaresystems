package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class NaiveStrategy implements Strategy {

  @Override
  public String getName() {
    return "Naive";
  }

  @Override
  public int determineMove(Board b, Mark m) {
    int[] possiblemoves = new int [9];
    for ( int i =0;i<9;i++) {
      if (b.isEmptyField(i)==true) {
        possiblemoves[i]=i;
      } else {
        possiblemoves[i]=-1;
      }
    }
    int randomChoice = (int) Math.floor(Math.random() * 9);
    while (possiblemoves[randomChoice] == -1) {
      randomChoice = (int) Math.floor(Math.random() * 9);
  }
    return randomChoice;
  }
}
