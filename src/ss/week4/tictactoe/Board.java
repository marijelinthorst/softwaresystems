package ss.week4.tictactoe;

/**
 * Board for the Tic Tac Toe game. Module 2 lab assignment.
 *
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Board {
    public static final int DIM = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
        " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";

    /**
     * The DIM by DIM fields of the Tic Tac Toe board. See NUMBERING for the
     * coding of the fields.
     */
    //@ private invariant fields.length == DIM*DIM;
    /*@ invariant (\forall int i; 0 <= i & i < DIM*DIM;
        getField(i) == Mark.EMPTY || getField(i) == Mark.XX || getField(i) == Mark.OO); */
    private Mark[] fields;

    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty board.
     */
    //@ ensures (\forall int i; 0 <= i & i < DIM * DIM; this.getField(i) == Mark.EMPTY);
    public Board() {
      fields = new Mark[9];
    	for (int i = 0; 0 <= i & i < DIM * DIM; i++) {
    	  fields[i] = Mark.EMPTY;
    	}
    }

    /**
     * Creates a deep copy of this field.
     */
    /*@ ensures \result != this;
        ensures (\forall int i; 0 <= i & i < DIM * DIM;
                                \result.getField(i) == this.getField(i));
      @*/
    public Board deepCopy() {
    	Board newBoard = new Board();
    	for (int i = 0; 0 <= i & i < DIM * DIM; i++) {
          newBoard.fields[i] = this.fields[i];
        }
        return newBoard;
    }

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @return the index belonging to the (row,col)-field
     */
    //@ requires 0 <= row & row < DIM;
    //@ requires 0 <= col & col < DIM;
    /*@pure*/
    public int index(int row, int col) {
        return (row*DIM + col);
    }

    /**
     * Returns true if ix is a valid index of a field on the board.
     * @return true if 0 <= index < DIM*DIM
     */
    //@ ensures \result == (0 <= index && index < DIM * DIM);
    /*@pure*/
    public boolean isField(int index) {
        return (0 <= index && index < DIM * DIM);
    }

    /**
     * Returns true of the (row,col) pair refers to a valid field on the board.
     *
     * @return true if 0 <= row < DIM && 0 <= col < DIM
     */
    //@ ensures \result == (0 <= row && row < DIM && 0 <= col && col < DIM);
    /*@pure*/
    public boolean isField(int row, int col) {
        return (0 <= row && row < DIM && 0 <= col && col < DIM);
    }
    
    /**
     * Returns the content of the field i.
     *
     * @param i
     *            the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    //@ requires this.isField(i);
    //@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
    /*@pure*/
    public Mark getField(int i) {
        return fields[i];
    }

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     *
     * @param row
     *            the row of the field
     * @param col
     *            the column of the field
     * @return the mark on the field
     */
    //@ requires this.isField(row,col);
    //@ ensures \result == Mark.EMPTY || \result == Mark.XX || \result == Mark.OO;
    /*@pure*/
    public Mark getField(int row, int col) {
    	// TODO: implement, see exercise P-4.18
        return getField(index(row,col));
    }

    /**
     * Returns true if the field i is empty.
     *
     * @param i
     *            the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    //@ requires this.isField(i);
    //@ ensures \result == (this.getField(i) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int i) {
        return (this.getField(i) == Mark.EMPTY);
    }

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     *
     * @param row
     *            the row of the field
     * @param col
     *            the column of the field
     * @return true if the field is empty
     */
    //@ requires this.isField(row,col);
    //@ ensures \result == (this.getField(row,col) == Mark.EMPTY);
    /*@pure*/
    public boolean isEmptyField(int row, int col) {
    	// TODO: implement, see exercise P-4.18
        return (this.getField(row,col) == Mark.EMPTY);
    }

    /**
     * Tests if the whole board is full.
     *
     * @return true if all fields are occupied
     */
    //@ ensures \result == (\forall int i; i <= 0 & i < DIM * DIM; this.getField(i) != Mark.EMPTY);
    /*@pure*/
    public boolean isFull() {
      int count = 0;
    	for (int i =0; i < DIM*DIM; i++) {
    	  if (fields[i] == Mark.EMPTY) {
    	    count++;
    	  }
    	}
        return count==0;
    }

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole board is full.
     *
     * @return true if the game is over
     */
    //@ ensures \result == this.isFull() || this.hasWinner();
    /*@pure*/
    public boolean gameOver() {
        return (this.isFull() || this.hasWinner());
    }

    /**
     * Checks whether there is a row which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a row controlled by m
     */
    /*@ pure */
    public boolean hasRow(Mark m) {
      boolean row = false;
      for (int i=0;i>=0 && i<=DIM*DIM;i=i+3) {
        if (fields[i]== m && fields[i+1] == m && fields[i+2]==m) {
          row = true;
        }
      }
      return row;
    }

    /**
     * Checks whether there is a column which is full and only contains the mark
     * m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a column controlled by m
     */
    /*@ pure */
    public boolean hasColumn(Mark m) {
      Boolean colomn = false;
      for (int i=0;i>=0 && i<=DIM*DIM;i++) {
        if (fields[i]== m && fields[i+3] == m && fields[i+6]==m) {
          colomn = true;
        }
      }
      return colomn;
    }

    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark m.
     *
     * @param m
     *            the mark of interest
     * @return true if there is a diagonal controlled by m
     */
    /*@ pure */
    public boolean hasDiagonal(Mark m) {
    	if (fields[0]==m && fields[4]==m && fields[8]==m) {
    	  return true;
    	} else if (fields[2]==m && fields[4]==m && fields[6]==m) {
    	  return true;
    	} else return false;
    }

    /**
     * Checks if the mark m has won. A mark wins if it controls at
     * least one row, column or diagonal.
     *
     * @param m
     *            the mark of interest
     * @return true if the mark has won
     */
    //@requires m == Mark.XX | m == Mark.OO;
    //@ ensures \result == this.hasRow(m) || this.hasColumn(m) | this.hasDiagonal(m);
    /*@ pure */
    public boolean isWinner(Mark m) {
        return this.hasRow(m) || this.hasColumn(m) | this.hasDiagonal(m);
    }

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     *
     * @return true if the student has a winner.
     */
    //@ ensures \result == isWinner(Mark.XX) | \result == isWinner(Mark.OO);
    /*@pure*/
    public boolean hasWinner() {
        return isWinner(Mark.XX) || isWinner(Mark.OO);
    }

    /**
     * Returns a String representation of this board. In addition to the current
     * situation, the String also shows the numbering of the fields.
     *
     * @return the game situation as String
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
                row = row + " " + getField(i, j).toString() + " ";
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    }

    /**
     * Empties all fields of this board (i.e., let them refer to the value
     * Mark.EMPTY).
     */
    /*@ ensures (\forall int i; 0 <= i & i < DIM * DIM;
                                this.getField(i) == Mark.EMPTY); @*/
    public void reset() {
    	for (int i=0;0 <= i & i < DIM * DIM; i++) {
    	  fields[i] = Mark.EMPTY;
    	}
    }

    /**
     * Sets the content of field i to the mark m.
     *
     * @param i
     *            the field number (see NUMBERING)
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(i);
    //@ ensures this.getField(i) == m;
    public void setField(int i, Mark m) {
    	fields[i]=m;
    }

    /**
     * Sets the content of the field represented by the (row,col) pair to the
     * mark m.
     *
     * @param row
     *            the field's row
     * @param col
     *            the field's column
     * @param m
     *            the mark to be placed
     */
    //@ requires this.isField(row,col);
    //@ ensures this.getField(row,col) == m;
    public void setField(int row, int col, Mark m) {
    	fields[index(row,col)]=m;
    }
}
