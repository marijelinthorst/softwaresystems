package ss.week4.hotel;

import ss.week2.hotel.*;
import ss.week3.bill.*;

public class Hotel {
	private String hotelname;
	private Room room1;
	private Room room2;
	private Password checkinpassword;
	private Guest hotelguest;
	
	// constructor
	public Hotel (String MyHotel, double roomprice, double safeprice) {
		this.room1= new Room (1);
		this.room2= new PricedRoom (2,roomprice, safeprice);
		hotelname = MyHotel;
		checkinpassword = new Password ();
	}
	
	//commands
	public Room checkIn(String password, String nameguest) { 
		if (
				checkinpassword.testWord(password)==true 
				&& nameguest != null 
				&& getFreeRoom()!=null 
				&& !(this.room1.getGuest()!=null && this.room1.getGuest().getName().equals(nameguest)) 
				&& !(this.room2.getGuest()!=null && this.room2.getGuest().getName().equals(nameguest))
			) {
			hotelguest = new Guest(nameguest);
			Room roomhotelguest = getFreeRoom();
			roomhotelguest.setGuest(hotelguest);
			return roomhotelguest;
		}
		else 
			return null;
		
	}
	public void checkOut(String nameguest) {
		if (this.getRoom(nameguest)!=null) {
				this.getRoom(nameguest).getSafe().deactivate();
				this.getRoom(nameguest).setGuest(null);
		}
	}
	
	public Bill getBill(String nameguest, int nights) {
		if (!(this.getRoom(nameguest)==null && this.getRoom(nameguest) instanceof PricedRoom)) {
			Bill roombill = new Bill();
			for(int i=0; i<nights; i=i+1) {
				roombill.addItem((PricedRoom)this.getRoom(nameguest));
			}
			roombill.close();
			if (((PricedRoom)this.getRoom(nameguest)).getSafe() instanceof PricedSafe) {
				for(int i=0; i<nights; i=i+1) {
					roombill.addItem((PricedSafe)this.getRoom(nameguest).getSafe());
				}
			}
			return roombill;
		} else return null;
	}
	
	
	// queries
	public Room getFreeRoom() {
		if (room1.getGuest()==null)
			return room1;
		else if (room2.getGuest()==null)
			return room2;
		else return null;
	}
	public Room getRoom(String nameguest) {
		if (room1.getGuest()!=null && room1.getGuest().getName()==nameguest)
			return room1;
		else if (room2.getGuest()!=null && room2.getGuest().getName()==nameguest)
			return room2;
		else return null;
	}
	public Password getPassword () {
		return checkinpassword;
	}
	@Override
	public String toString() {
		String b;
		String c;
		
		if (room1.getSafe().isActive()) {
			b = "activated";
		}
		else { b = "deactivated";
		}
		
		if (room2.getSafe().isActive()) {
			c = "activated";
		}
		else { c = "deactivated";
		}
		
		String a = "Status safe room 1: " + b + "Status safe room 2: " + c;
		
		if (room1.getGuest()==null && room2.getGuest()==null) {
			return "The Hotel has two rooms: room 1 and room 2 are both emty." + a;
		}
		else if (room1.getGuest()!=null && room2.getGuest()==null) {
			return "The Hotel has two rooms: room 1 has a guest (guest name:" + room1.getGuest().getName() 
					+ "), room 2 is emty." + a;
		}
		else if (room1.getGuest()==null && room2.getGuest()!=null) {
			return "The Hotel has two rooms: room 1 is emty, room 2 has a guest (guest name:" 
					+ room2.getGuest().getName() + ")." + a;
		}
		else { return "The Hotel has two rooms: both room 1 and room 2 have a guest. Guest name room 1: " 
					+ room1.getGuest().getName() + ", guest name room 2: " + room2.getGuest().getName() + "." + a;
		}
	}
	public String getHotelName() {
		return hotelname;
	}
	
}
