package trungnd.controller;


import java.util.List;

import trungnd.dao.RoomDAO;
import trungnd.dto.RoomDTO;

public class ViewAllRoomsController {
	public void viewAllRooms() {
		RoomDAO dao = new RoomDAO();
		try {
			List<RoomDTO> listRoom = dao.getAllRooms();
			if (listRoom != null) {
				System.out.println("No\tRoomID\tRoom Name\tPrice\tStatus");
				for (int i = 0; i < listRoom.size(); i++) {
					System.out.print((i + 1) + "\t" 
								+ listRoom.get(i).getRoomID() + "\t" 
								+ listRoom.get(i).getRoomName() + "\t" 
								+ listRoom.get(i).getRoomPrice()  + "\t");
					if (listRoom.get(i).isStatus()) {
						System.out.print("Open\t\n");
					} else {
						System.out.print("Closed\t\n");
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Something wrong in ViewAllRoomsController: " + e.getMessage());
		}
	}
}
