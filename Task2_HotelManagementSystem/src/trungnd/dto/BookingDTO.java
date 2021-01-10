package trungnd.dto;

public class BookingDTO {
	private String bookingID;
	private String bookingName;
	private String startTimeBook;
	private String endTimeBook;
	private String accID;
	private String roomID;
	private boolean bookingStatus;
	
	public BookingDTO() {
		super();
	}
	
	
	public BookingDTO(String bookingID, String bookingName, String startTimeBook, String endTimeBook, String accID,
			String roomID, boolean bookingStatus) {
		super();
		this.bookingID = bookingID;
		this.bookingName = bookingName;
		this.startTimeBook = startTimeBook;
		this.endTimeBook = endTimeBook;
		this.accID = accID;
		this.roomID = roomID;
		this.bookingStatus = bookingStatus;
	}


	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public String getBookingName() {
		return bookingName;
	}
	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}
	public String getStartTimeBook() {
		return startTimeBook;
	}
	public void setStartTimeBook(String startTimeBook) {
		this.startTimeBook = startTimeBook;
	}
	public String getEndTimeBook() {
		return endTimeBook;
	}
	public void setEndTimeBook(String endTimeBook) {
		this.endTimeBook = endTimeBook;
	}
	public boolean isBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	public String getAccID() {
		return accID;
	}


	public void setAccID(String accID) {
		this.accID = accID;
	}


	public String getRoomID() {
		return roomID;
	}


	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	
	
	
	
}
