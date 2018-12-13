package ss.week3.bill;

public class Bill {
	// Bill having multiple items. Lab assignment Module 2
	
	// Abstraction of the items on the bill.
	public static interface Item {
		// Abstraction of the items on the bill. Every item has an amount and description; the description is available with toString().
		
		// Returns the amount of this Item.
		public double getAmount();
	}
	
	private SysoutPrinter standardprint;
	private StringPrinter stringprint;
	private double totalsum;
	
	// Constructs a Bill sending the output to a given Printer
	public Bill() {	
		standardprint = new SysoutPrinter();
		stringprint = new StringPrinter();
		
	}
	
	// Methods
	// Adds an item to this Bill. The item is sent to the printer, and the amount is added to the sum of the Bill
	public void addItem (Bill.Item item){
		stringprint.printLine(item.toString(), item.getAmount());
		this.totalsum = this.totalsum + item.getAmount();
	}
	
	// Sends the sum total of the bill to the printer.
	public void close() {
		stringprint.printLine("Total sum", totalsum);
		stringprint.getString();
		totalsum=0;
	}
	
	// Returns the current sum total of the Bill.
	public double getSum() {
		return totalsum;
	}

}
