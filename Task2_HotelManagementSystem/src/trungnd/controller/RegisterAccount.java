package trungnd.controller;

import java.util.List;
import java.util.Scanner;

import trungnd.dao.AccountDAO;
import trungnd.dto.AccountDTO;
import trungnd.utils.MyUtils;

public class RegisterAccount {
	MyUtils utl = new MyUtils();
	Scanner sc = new Scanner(System.in);
	
	public void registerAccount() {   
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
                username = utl.checkInputUsername();                  
    			if (!dao.checkUsernameExist(username)) {
    			    System.err.println("Username exist.");
    			    check = false;
    			}   			
			} while (!check);   
        	
            password = utl.checkInputPassword();  	
        	
        	//fullname
        	do {
        		check = true;
        		System.out.print("Enter Fullname: ");
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
			System.out.print("Enter Age: ");
			age = utl.checkInputIntLimit(18, 200);
			
			//phone
			do {
				String phonePattern = "\\d{10}"; 
				System.out.print("Enter Phone: ");
				phone = sc.nextLine();
				check = phone.matches(phonePattern);
				if (!check) {
					System.err.println("Invalid phone!");
				}
			} while (!check);
			
			//address
			do {
				check = true;
				System.out.println("Enter Address: ");
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
			roleID = 1;
			
			//accID
			List<AccountDTO> listAccount = dao.checkAllAccIDByRole(roleID);
			accID = "CT_" + (listAccount.size() + 1);
			
			//create account
			AccountDTO dto = new AccountDTO(accID, username, name, roleID, age, phone, address);
			dto.setPassword(password);
		
			if (dao.createAccount(dto)) {
				System.out.println("\nSuccessful!!!");
			} else {
				System.out.println("\nUnsuccessful!!!");
			}
			
		} catch (Exception e) {
			System.err.println("Something wrong in RegisterAccountController : " + e.getMessage());
		}

    }
}
