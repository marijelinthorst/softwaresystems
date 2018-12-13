package ss.week3.bill;

public class StringPrinter implements Printer{
	
	private String HALLO = "start bill\n";
	
	public StringPrinter() {
	}
	
	public String getString() {
		System.out.println(HALLO);
		return HALLO;
	}
	
	@Override
	public void printLine (String text, double price) {
		this.HALLO= this.HALLO + format(text,price);
	}
	
	//public static void main (String[] args) {
		//String
	//	Printer p = new StringPrinter();
	//	p.printLine("Text1", 1.0);
	//	p.printLine("Other_text", -12.1212);
	//	p.printLine("Something", .2);
		//p.getString();
	//}

}
