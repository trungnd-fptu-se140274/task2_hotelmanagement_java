package trungnd.main;

import java.util.Scanner;

import trungnd.controller.CreateAccountController;
import trungnd.controller.SetRoleController;
import trungnd.utils.MyUtils;

public class AdminForm {
	Scanner sc = new Scanner(System.in);
	MyUtils utl = new MyUtils();
	
	public int doMenu_Admin() {
		 System.out.println("\t\t\t@---++--- WELCOME ADMIN ---++---@");
		 System.out.println("\t\t\t\t1. Create New User.");
		 System.out.println("\t\t\t\t2. Set Role.");
		 System.out.println("\t\t\t\t3. Back.");
		 int choice = utl.checkInputIntLimit(1, 3);
		 return choice;
	}
	
	public void adminForm() {
		int choiceAdmin;
		do {
			choiceAdmin = doMenu_Admin();
			System.out.println("\t\t\t\t@@--@@--ADMIN--@@--@@");
			switch (choiceAdmin) {
            case 1:
                System.out.println("\t\t\t@---()--- Create New User ---()---@");
                CreateAccountController createAcc = new CreateAccountController();
                createAcc.createNewAccount();
                break;
            case 2:
            	System.out.println("\t\t\t@---()--- Set Role ---()---@");
            	SetRoleController setRole = new SetRoleController();
            	setRole.setRole();
                break;
            case 3:
            	System.out.println("Sign out to Main Menu!");
        		break;
			}
		} while (choiceAdmin != 3);	
	}
}
