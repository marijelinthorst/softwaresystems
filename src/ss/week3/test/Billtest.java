package ss.week3.test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.*;

public class Billtest {
	
	
	public class Item implements Bill.Item{
		private String text;
		private double amount;
		
		public Item (String text, double amount) {
			this.text=text;
			this.amount=amount;
		}
		
		@Override
		public String toString() {
			return text;
		}
		
		public double getAmount() {
			return amount;
		}
	}
	
	private Bill testbill;
	private Item Text1;
	private Item Other_text;
	private Item Something;
	
	@BeforeEach
	void setUp(){
		testbill = new Bill();
		Text1 = new Item ("Text11", 1.0);
		Other_text = new Item ("Other_text1", -12.1212);
		Something = new Item ("Something1", .1);
	}
	
	@Test
	void testInitial() {
		assertEquals(testbill.getSum(),0, 0.1);
		//test initial
	}
	
	@Test
	void testaddItem() {
		testbill.addItem(Text1);
		testbill.addItem(Text1);
		testbill.addItem(Something);
		testbill.addItem(Other_text);
		assertEquals(testbill.getSum(),-10.0212, 0.1);
		testbill.close();
	}
	
	@Test
	void testclose() {
		testbill.close();
		assertEquals(testbill.getSum(), 0, 0.1);
	}

}
