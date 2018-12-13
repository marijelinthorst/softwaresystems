package ss.week3.bill;

public interface Printer {
	
	
	
	default public String format(String text, double price) {
		return String.format("%1$-20s %2$10.2f \n", text, price);
	}
	public void printLine (String text, double price);

}
