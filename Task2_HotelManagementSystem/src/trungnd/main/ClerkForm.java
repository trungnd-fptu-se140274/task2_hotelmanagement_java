package trungnd.main;

import java.util.Scanner;

import trungnd.controller.SearchRoomController;
import trungnd.controller.UpdateStatusController;
import trungnd.controller.ViewAllRoomsController;
import trungnd.utils.MyUtils;

public class ClerkForm {
	Scanner sc = new Scanner(System.in);
	MyUtils utl = new MyUtils();
	
	public int doMenu_Clerk() {
		 System.out.println("\t\t\t@---++--- WELCOME CLERK ---++---@");
		 System.out.println("\t\t\t\t1. View all of rooms.");
		 System.out.println("\t\t\t\t2. Search / Filter rooms.");
		 System.out.println("\t\t\t\t3. Update status of rooms.");
		 System.out.println("\t\t\t\t4. Back.");
		 int choice = utl.checkInputIntLimit(1, 4);
		 return choice;
	}
	
	public void clerkForm (String username) {
		int choiceClerk;
		do {
			choiceClerk = doMenu_Clerk();
			System.out.println("\t\t\t\t@@--@@--Welcome, HOTEL CLERK" + username + "--@@--@@");
			switch (choiceClerk) {
            case 1:
                System.out.println("\t\t\t@---()--- View all of rooms ---()---@");
                ViewAllRoomsController viewAll = new ViewAllRoomsController();
                viewAll.viewAllRooms();
                break;
            case 2:
            	System.out.println("\t\t\t@---()--- Search / Filter rooms ---()---@");
            	SearchRoomController searchRoom = new SearchRoomController();
            	searchRoom.searchRoom();
                break;
            case 3:
            	System.out.println("\t\t\t@---()--- Update status of rooms ---()---@");
            	UpdateStatusController updateStatus = new UpdateStatusController();
            	updateStatus.updateStatusRoom();
        		break;
            case 4:
            	System.out.println("Sign out to Main Menu!");
        		break;
			}
		} while (choiceClerk != 4);
	}
}
