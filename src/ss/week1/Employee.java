package ss.week1;

public class Employee {
	private int hours; // hours worked in the week
	private double rate; // hourly pay rate (dollars)
	
	// constructor
	public Employee (int hours, int rate) {
		this.hours = hours;
		this.rate = rate;
	}
	// Queries
	public double pay () {
		double pay;
		if (hours <=40)
			pay = hours*rate;
		else 
			pay = 40*rate + (hours-40)*1.5*rate;
		return pay;
	}

}
