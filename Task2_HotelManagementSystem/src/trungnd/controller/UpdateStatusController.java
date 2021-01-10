package trungnd.controller;

import java.util.ArrayList;
import java.util.List;

import trungnd.dao.RoomDAO;
import trungnd.dto.RoomDTO;
import trungnd.utils.MyUtils;

public class UpdateStatusController {
	MyUtils utl = new MyUtils();
	
	public void updateStatusRoom() {
		RoomDAO dao = new RoomDAO();
		List<RoomDTO> listRoomAll = new ArrayList<>();
		try {
			listRoomAll = dao.getAllRooms();
		} catch (Exception e) {
			System.err.println("Something wrong in UpdateStatusController : " + e.getMessage());
		}
		if (listRoomAll != null) {
			System.out.println("No\tRoomID\tRoom Name\tPrice\tStatus");
			for (int i = 0; i < listRoomAll.size(); i++) {
				System.out.print((i + 1) + "\t" 
							+ listRoomAll.get(i).getRoomID() + "\t" 
							+ listRoomAll.get(i).getRoomName() + "\t" 
							+ listRoomAll.get(i).getRoomPrice()  + "\t");
				if (listRoomAll.get(i).isStatus()) {
					System.out.print("Open\t\n");
				} else {
					System.out.print("Closed\t\n");
				}
			}
		}
		System.out.print("Choose number to set status: ");
		int choice = utl.checkInputIntLimit(1, listRoomAll.size());
		
		System.out.println("You choose " + choice +  " " + listRoomAll.get(choice - 1).getRoomID().toString() + ".\nNow choose role to set up user's role!\nYour role's chosen: ");
		int choiceStatus = statusMenu();
		String roomID = listRoomAll.get(choice - 1).getRoomID().toString();
		String name = listRoomAll.get(choice - 1).getRoomName().toString();
		double price = listRoomAll.get(choice - 1).getRoomPrice();
		boolean status = listRoomAll.get(choice - 1).isStatus();
		switch(choiceStatus) {
			case 1:			
				status = true;
				break;
			case 2:
				status = false;
				break;
		}
		
		try {
			if (dao.updateStatus(roomID, name, price, status)) {
				System.out.println("Successful");
			}
		} catch (Exception e) {
			System.out.println("Unsuccessful");
			System.err.println("Something wrong in UpdateStatusController : " + e.getMessage());
		}
		
	}
	
	public int statusMenu() {
		System.out.println("--@@--Status Room Menu--@@--");
		System.out.println("1. Open.");
		System.out.println("2. Closed.");
		int choice = utl.checkInputIntLimit(1, 2);
		return choice;
	}
}
