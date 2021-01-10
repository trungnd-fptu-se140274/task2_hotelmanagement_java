package trungnd.dto;

public class RoomDTO {
	private String roomID;
	private String roomName;
	private double roomPrice;
	private boolean status;
	
	public RoomDTO() {
		super();
	}
	
	public RoomDTO(String roomID, String roomName, double roomPrice, boolean status) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.status = status;
	}
	
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
