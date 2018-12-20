package ss.week6;

import java.util.Scanner;

public class Hello {
  
  private static String name;
  private static Scanner in;
  private static boolean end = false;
  
  public static void main(String[] args) {
    System.out.println("What's your name?");
    in = new Scanner (System.in);
    while (!end) {
      name = in.nextLine();
      if (!name.isEmpty()) {
      System.out.println("Hello " + name);
      System.out.println("What's your name?");
      } else {
        end = true;
      }
    }
    
  }

}
