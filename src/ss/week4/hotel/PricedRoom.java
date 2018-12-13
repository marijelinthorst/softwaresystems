package ss.week4.hotel;

public class PricedRoom extends ss.week2.hotel.Room implements ss.week3.bill.Bill.Item {
	
	private double roomprice;
	// no = room number
	
	// Constructor
	public PricedRoom (int no, double roomprice, double safeprice) {
		super(no, new PricedSafe(safeprice));
		this.roomprice=roomprice;		
	}
	
	//Query
	@Override
	public String toString() {
		return super.toString() + ". Price per night:" + 
				Double.toString(roomprice);
	}

	@Override
	public double getAmount() {
		return roomprice;
	}

}
