package trungnd.controller;

import java.util.ArrayList;
import java.util.List;

import trungnd.dao.RoomDAO;
import trungnd.dto.RoomDTO;
import trungnd.utils.MyUtils;

public class SearchRoomController {
	MyUtils utl = new MyUtils();
	
	public void searchRoom() {
		RoomDAO dao = new RoomDAO();
		List<RoomDTO> listRoom = new ArrayList<>();
		
		System.out.print("Input room's name that you want to search: ");
		String roomName = utl.checkInputString();
		try {
			listRoom = dao.searchRoom(roomName);
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
		} catch (Exception e) {
			System.err.println("Something wrong in SearchRoomController: " + e.getMessage());
		}
	}
}
