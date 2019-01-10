package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
  // class instances
  private int size;
  private Map<String, Integer> votes = new HashMap <String, Integer>();
  
  //constructor
  public VoteList() {
    size=0;
  }
  
  // commands
  public void addVote(String party) {
    if (votes.containsKey(party)) {
      votes.replace(party, votes.get(party), votes.get(party) + 1);
    } else {
      this.votes.put(party, 1);
    }
    size++;
    setChanged();
    notifyObservers("vote");
  }
  
  
  //queries
  public int getSize () {
    return size;
  }
  
  public Map<String, Integer> getVotes(){
    return votes;
  }

}
