package trungnd.main;

import java.util.Scanner;

import trungnd.controller.BookingRoomsController;
import trungnd.utils.MyUtils;

public class CustomerForm {
	Scanner sc = new Scanner(System.in);
	MyUtils utl = new MyUtils();
	
	public int doMenu_Customer() {
		 System.out.println("\t\t\t@---++--- WELCOME CUSTOMER ---++---@");
		 System.out.println("\t\t\t\t1. Booking Rooms.");
		 System.out.println("\t\t\t\t2. Back.");
		 int choice = utl.checkInputIntLimit(1, 2);
		 return choice;
	}
	
	public void customerForm(String username) {
		int choiceCustomer;
		do {
			choiceCustomer = doMenu_Customer();
			System.out.println("\t\t\t\t@@--@@-- Hello, " + username + " --@@--@@");
			switch (choiceCustomer) {
            case 1:
                System.out.println("\t\t\t@---()--- Booking Rooms ---()---@");
                BookingRoomsController bookingRooms = new BookingRoomsController();
                bookingRooms.bookingRoom(username);
                break;
            case 2:
            	System.out.println("Sign out to Main Menu!");
        		break;
			}
		} while (choiceCustomer != 2);
	}
}
