package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {
  // class instances
  private List<String> partylist = new ArrayList<>();
  private int size;
  
  // constructor
  public PartyList(){
    size=0;
  }
  
  // commands
  public void addParty (String party) {
    if(this.hasParty(party)==false) {
      size++;
      this.partylist.add(party);
      setChanged();
      notifyObservers("party");
    }
  }
  
  // queries
  public int getSize () {
    return size;
  }
  
  public List<String> getParties() {
    return partylist;
  }
  
  public boolean hasParty(String party) {
    return partylist.contains(party);
  }

}
