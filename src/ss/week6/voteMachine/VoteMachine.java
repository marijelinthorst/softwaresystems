package ss.week6.voteMachine;

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
    // TODO Auto-generated method stub
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

}
