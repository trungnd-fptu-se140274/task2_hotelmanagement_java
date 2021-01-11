package trungnd.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import trungnd.dao.AccountDAO;
import trungnd.dao.BookingDAO;
import trungnd.dao.RoomDAO;
import trungnd.dto.BookingDTO;
import trungnd.dto.RoomDTO;
import trungnd.utils.MyUtils;

public class BookingRoomsController {
	MyUtils utl = new MyUtils();
	RoomDAO dao = new RoomDAO();
	BookingDAO dao_Booking = new BookingDAO();
	AccountDAO dao_Account = new AccountDAO();
	
	List<RoomDTO> listRoom = null;
	
	public List<RoomDTO> printRooms(List<RoomDTO> listRoom) {
		if (listRoom != null) {
			System.out.println("No\tRoomID\tRoomName\tPrice\tStatus");
			for (int i = 0; i < listRoom.size(); i++) {
				System.out.print((i + 1) + "\t" 
							+ listRoom.get(i).getRoomID() + "\t" 
							+ listRoom.get(i).getRoomName() + "\t\t" 
							+ listRoom.get(i).getRoomPrice()  + "\t");
				if (listRoom.get(i).isStatus()) {
					System.out.print("Open\t\n");
				} else {
					System.out.print("Closed\t\n");
				}
			}
		}
		return listRoom;
	}
	
	public String makeDate(Calendar c) {
		String inputDateString;
		boolean check;
		do {
			check = true;
			inputDateString = utl.checkInputString();
				if (!inputDateString.matches("(0?[1-9]|[12][0-9]|3[01])(/|-)(0?[1-9]|1[012])(/|-)(20\\d\\d)")) {
					System.out.println("Please enter again!");
					check = false;
				}
			} while (check == false);
		if (inputDateString.charAt(1) == '-' || inputDateString.charAt(1) == '/') { // 1/11/2021
				inputDateString = "0" + inputDateString; 
			}
		if (inputDateString.charAt(4) == '-' || inputDateString.charAt(4) == '/') { // 11/1/2021
				String str1 = inputDateString.substring(0, 3).trim().toString();
				String str2 = inputDateString.substring(3, 9).trim().toString();
				inputDateString = str1 + "0" + str2;
			}
		int day = Integer.parseInt(inputDateString.substring(0, 2).trim().toString());
		int month = Integer.parseInt(inputDateString.substring(3, 5).trim().toString());
		int year = Integer.parseInt(inputDateString.substring(6, 10).trim().toString());
		inputDateString = year + "-" + month + "-" + day;
		int hour = 13;
		int minute = 00;
		int second = 00;

		return inputDateString + " " + hour + ":" + minute + ":" + second;
    	}
	
	public void bookRoom(int chooseRoom, String username) {
		String roomID = listRoom.get(chooseRoom).getRoomID().toString();
		String bookingID = "BK_" + listRoom.size();
		String bookingName = "HD_" + listRoom.size();
		Calendar calendar = Calendar.getInstance();
		String startDate;
		String endDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean check = true;
		do {		
			check = true;
			System.out.print("Enter start time: ");
			startDate = makeDate(calendar);
			System.out.print("Enter end time: ");
			endDate = makeDate(calendar);
			Date date1;
			Date date2;
			try {
				date1 = (Date) sdf.parse(startDate);
				date2 = (Date) sdf.parse(endDate);
				if (date1.after(date2)) {
					check = false;
					System.out.println("Input date again! Start Date > EndDate!");
				}
			} catch (ParseException e) {
				System.err.println("Something wrong in BookingRoomController-bookRoom: " + e.getMessage());
			}						
		} while (!check);
		String accID = null;
		try {
			accID = dao_Account.getAccID(username);
		} catch (Exception e) {
			System.err.println("Something wrong in BookingRoomController-getAccID(): " + e.getMessage());
		}
		try {
			dao.updateStatus1(roomID, false);
		} catch (Exception e1) {
			System.err.println("Something wrong in BookingRoomController-updateStatus1(): " + e1.getMessage());
		}
		BookingDTO dto_Booking = new BookingDTO(bookingID, bookingName, startDate, endDate, accID, roomID, true);
		try {
			dao_Booking.bookRoom(dto_Booking);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Something wrong in BookingRoomController-createBookingRoom: " + e.getMessage());
		}
	}
	
	public void bookingRoom(String username) {
		System.out.println("ALL ROOMS: ");
		int chooseRoomToBook = 0;
		try {
			listRoom = dao.getAllRooms();
			listRoom = printRooms(listRoom);	
		} catch (Exception e) {
			System.err.println("Something wrong in BookingRoomsController-printRooms(): " + e.getMessage());
		}
		boolean check;
		do {
			check = false;
			System.out.println("Choose Room with number: ");
			chooseRoomToBook = utl.checkInputIntLimit(1, listRoom.size());
			if (listRoom.get(chooseRoomToBook - 1).isStatus()) {
				check = true;			
				System.out.println("Completed!");
				bookRoom(chooseRoomToBook - 1, username);
			} else {
				System.err.print("Room is in service! Please choose another room!\t\n");
				check = false;
			}
		} while (!check);
	}
}
