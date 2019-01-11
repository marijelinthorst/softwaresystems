package ss.week7.threads;

public class TestSyncConsole extends Thread{
  
  public TestSyncConsole(String name) {
    super("Thread " + name);
  }
  
  public void run() {
    sum();
  }
  
  private synchronized void sum() {
    int one = SyncConsole.readInt(this.getName() + ": Get number 1?");
    int two = SyncConsole.readInt(this.getName() + ": Get number 2?");
    int sum = one + two;
    SyncConsole.println(this.getName() + ": " + one + "+" + two + "=" + sum);
  }
  
  public static void main(String[] args) {
    if (args.length==2) {
      TestSyncConsole one = new TestSyncConsole(args[0]);
      TestSyncConsole two = new TestSyncConsole(args[1]);
      one.start();
      two.start();
    } else { 
      SyncConsole.println("error");
    } 
  }

}
