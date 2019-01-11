package ss.week7.threads;

public class TestConsole extends Thread{
  
  public TestConsole(String name) {
    super("Thread " + name);
  }
  
  public void run() {
    sum();
  }
  
  private void sum() {
    int one = Console.readInt(this.getName() + ": Get number 1?");
    int two = Console.readInt(this.getName() + ": Get number 2?");
    int sum = one + two;
    Console.println(this.getName() + ": " + one + "+" + two + "=" + sum);
  }
  
  public static void main(String[] args) {
    if (args.length==2) {
      TestConsole one = new TestConsole(args[0]);
      TestConsole two = new TestConsole(args[1]);
      one.start();
      two.start();
    } else { 
      Console.println("error");
    } 
  }

}
