package ss.week6;

public class ArgumentLengthsDifferException extends ss.week6.WrongArgumentException {
  int s1;
  int s2;
  
  public ArgumentLengthsDifferException(int s1, int s2) {
      super();
      this.s1 = s1;
      this.s2 = s2;
  }
  @Override
  public String getMessage() {
      return "error: length of command line arguments " 
              + "differ (" + s1 + ", " + s2 + ")";
  }
}
