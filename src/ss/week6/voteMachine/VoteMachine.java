package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

import ss.week6.voteMachine.gui.*;

//import ss.week6.voteMachine.gui.*;

public class VoteMachine{
  // instances
  private PartyList partylist;
  private VoteList votelist;
  
  // main
  public static void main(String[] args) {
    VoteMachine votemachine = new VoteMachine();
    votemachine.start();
    
  }
  
  // constructor
  public VoteMachine() {
    partylist = new PartyList();
    votelist = new VoteList();
  }
  
  // commands
  private void start() {
    VoteView view = new VoteGUIView(this);
    partylist.addObserver(view);
    votelist.addObserver(view);
    view.start();
  }
  
  public void addParty(String party) {
    partylist.addParty(party);
  }
  
  public void vote (String party) {
    if (partylist.hasParty(party)) {
      votelist.addVote(party);
    }
  }
  
  // queries
  public List<String> getParties() {
    return partylist.getParties();
    
  }

  public Map<String, Integer> getVotes() {
    return votelist.getVotes();
    
  }
  
  // queries

}
