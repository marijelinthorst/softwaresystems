package ss.week4.hotel;

public class PricedSafe extends ss.week2.hotel.Safe implements ss.week3.bill.Bill.Item{
	
	private double price;
	
	// Constructor
	public PricedSafe (double price) {
		this.price=price;
	}
	
	// Query
	public String toString() {
		return Double.toString(price);
	}

	@Override
	public double getAmount() {
		return price;
	}

}
