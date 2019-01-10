package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements VoteView, Observer{
  
  // class instances
  private VoteMachine votemachine;
  
  // Constructor
  public VoteTUIView (VoteMachine votemachine) {
    this.votemachine = votemachine;
  }
  
  
  // Commands
  @Override
  public void update(Observable o, Object arg) {
    if (arg.equals("vote")) {
      System.out.print("A vote was added \n");
    }
    if (arg.equals("party")) {
      System.out.print("A party was added \n");
    }
  }

  @Override
  public void start() {
    boolean running = true;
    Scanner in = null;
    while (running) {
      System.out.print("What is your command?");
      in = new Scanner(System.in);
      String answer = in.hasNextLine() ? in.nextLine() : null;
      String[] words = answer.split(" ");
      if (words.length == 2 && words[0].equals("VOTE")) {
        this.votemachine.vote(words[1]);
        //System.out.println("Successfully voted");
      } else if (words.length == 3 && words[0].equals("ADD") && words[1].equals("PARTY")) {
        this.votemachine.addParty(words[2]);
        //System.out.println("Successfully added party");
      } else if (words.length == 1 && words[0].equals("VOTES")) {
        System.out.println(this.votemachine.getVotes());
      } else if (words.length == 1 && words[0].equals("PARTIES")) {
        System.out.println(this.votemachine.getParties());
      } else if (words.length == 1 && words[0].equals("HELP")) {
        this.showError("HELP!"); 
      } else if (words.length == 1 && words[0].equals("EXIT")) {
        running = false;
      } else {
          System.out.println("Unknown command");
      }
    }
    in.close();
  }
 
  @Override
  public void showVotes(Map<String, Integer> votes) {
    System.out.println(votes);    
  }

  @Override
  public void showParties(List<String> parties) {
    System.out.println(parties);
    
  }

  @Override
  public void showError(String message) {
    System.out.println(message);
    
  }
  

}
