package ss.week3.bill;

public class SysoutPrinter implements Printer{
	
	public SysoutPrinter() {
	}
	
	@Override
	public void printLine (String text, double price) {
		System.out.println(format(text, price));
	}
	
	public static void main (String[] args) {
		Printer p = new SysoutPrinter();
		p.printLine("Text1", 1.0);
		p.printLine("Other_text", -12.1212);
		p.printLine("Something", .2);
	}

}
