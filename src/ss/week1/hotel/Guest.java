package ss.week1.hotel;

public class Guest {
	/**
	 * @author marije.linthorst
	 * Hotel guest with a name and possibly a hotel room.
	 */
	public String name;
	public Room room;

	//constructor
	/**
	 * Creates a Guest with the given name and without Room.
	 */
	public Guest(String name) {
		this.name = name;
		room = null;
	}
	// Queries
	/**
	 * Returns the name of this Guest.
	 */
	public String getName() {
	return name;
	}
	
	/**
	 * Returns the Room that is rented by this Guest.
	 */
	public Room getRoom() {
	return room;
	}
	
	public String toString() {
		return "Guest=" + name;
	}
	// Commands+queries
	/**
	 * Rents a Room to this Guest.
	 */
	public boolean checkin(Room room) {
		if (room.getGuest() == null) {
				room.setGuest(this);
				this.room = room;
				return true;
		}
		else
				return false;
	}
	/**
	 * Sets the Room of this Guest to null.
	 */
	public boolean checkout() {
		if (this.getRoom()==null)
			return false;
		else {
			room.setGuest(null);
			this.room = null;
			return true;
		}
	}
}
