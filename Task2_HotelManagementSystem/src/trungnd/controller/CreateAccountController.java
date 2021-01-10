package trungnd.controller;

import java.util.List;
import java.util.Scanner;

import trungnd.dao.AccountDAO;
import trungnd.dto.AccountDTO;
import trungnd.utils.MyUtils;

public class CreateAccountController {
	MyUtils utl = new MyUtils();
	Scanner sc = new Scanner(System.in);
	
	public void createNewAccount() {   
        try {
        	boolean check = true;
        	AccountDAO dao = new AccountDAO();
        	String username = null;
        	String password = null;
        	String name = null;
        	int age = 0;
        	String phone = null;
        	String address = null;
        	int roleID = 0;
        	String accID = null;
        	
        	//username + password + check exist account
        	do {
        		check = true;
        		System.out.print("Username: ");
                username = utl.checkInputUsername();                  
    			if (!dao.checkUsernameExist(username)) {
    			    System.err.println("Username exist.");
    			    check = false;
    			}   			
			} while (!check);   
        	
			System.out.print("Password: ");
            password = utl.checkInputPassword();  	
        	
        	//fullname
        	do {
        		check = true;
        		System.out.print("Fullname: ");
        		name = utl.checkInputString();
    			if (name.length() > 50) {
    				System.err.println("Fullname out of range!");
    				check = false;
    			} else if (name.length() == 0) {
    				System.err.println("Fullname not empty!");
    				check = false;
    			}
			} while (!check);
        	
        	//age
			System.out.print("Age: ");
			age = utl.checkInputIntLimit(18, 200);
			
			//phone
			do {
				String phonePattern = "\\d{10}"; 
				System.out.print("Phone: ");
				phone = sc.nextLine();
				check = phone.matches(phonePattern);
				if (!check) {
					System.err.println("Invalid phone!");
				}
			} while (!check);
			
			//address
			do {
				check = true;
				System.out.println("Address: ");
				address = utl.checkInputString();
				if (address.length() > 200) {
    				System.err.println("Address out of range!");
    				check = false;
    			} else if (address.length() == 0) {
    				System.err.println("Address not empty!");
    				check = false;
    			} else if (address.length() <= 5) {
    				System.err.println("Address more than 5 letters!");
    				check = false;
    			}
			} while (!check);
        	
			//roleID
			do {
				int chooseRole = roleMenu();
				switch (chooseRole) {
				case 1:
					roleID = 1;
					break;
				case 2:
					roleID = 2;
					break;
				}
			} while (!check);
			
			//accID
			List<AccountDTO> listAccount = dao.checkAllAccIDByRole(roleID);
			switch (roleID) {
			case 1:
				accID = "CT_" + (listAccount.size() + 1);
				break;
			case 2:
				accID = "CL_" + (listAccount.size() + 1);
				break;
			}
			
			//create account
			AccountDTO dto = new AccountDTO(accID, username, name, roleID, age, phone, address);
			dto.setPassword(password);
		
			if (dao.createAccount(dto)) {
				System.out.println("\nSuccessful!!!");
			} else {
				System.out.println("\nUnsuccessful!!!");
			}
			
		} catch (Exception e) {
			System.err.println("Something wrong in CreateAccountController : " + e.getMessage());
		}

    }
	
	public int roleMenu() {
		System.out.println("--@@--Role Menu--@@--");
		System.out.println("1. Customer.");
		System.out.println("2. Clerk.");
		int choice = utl.checkInputIntLimit(1, 2);
		return choice;
	}
}
