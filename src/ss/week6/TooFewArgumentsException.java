package ss.week6;

public class TooFewArgumentsException extends ss.week6.WrongArgumentException {
  public TooFewArgumentsException() {
    super();
}
@Override
public String getMessage() {
    return "error: too few command line arguments";
}
}
