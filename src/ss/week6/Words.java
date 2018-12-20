package ss.week6;

import java.util.Scanner;

public class Words {
  
  private static String word;
  private static Scanner in = new Scanner (System.in);//.useDelimiter(" ");
  private static boolean end = false;
  
  public static void main(String[] args) {
    System.out.println("Please enter a sentence");
 
    while (!end) {
      word = in.next();
      System.out.println(word);
      
      if (word.equals("end")) {
        end= true;
      }
    }
  }

}
