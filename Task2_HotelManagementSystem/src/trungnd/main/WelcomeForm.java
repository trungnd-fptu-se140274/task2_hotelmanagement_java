package trungnd.main;

import java.util.Scanner;

import trungnd.controller.RegisterAccount;
import trungnd.utils.MyUtils;

public class WelcomeForm {
	Scanner sc = new Scanner(System.in);
	MyUtils utl = new MyUtils();
	
	public  int doMenu() {
		 System.out.println("\t\t\t@---++--- WELCOME ---++---@");
		 System.out.println("\t\t\t\t1. Login.");
		 System.out.println("\t\t\t\t2. Resister.");
		 System.out.println("\t\t\t\t3. Exit.");
		 int choice = utl.checkInputIntLimit(1, 3);
		 return choice;
	}
	
	public void mainMenu() {
		boolean return_more = true;
		do {
			return_more = true;
            int choice = doMenu();
            switch (choice) {
                case 1:
                    System.out.println("\t\t\t @---**--- LOGIN ---**---@");
                    LoginForm frmLogin = new LoginForm();
                    frmLogin.loginAccount();
                    break;
                case 2:
                	System.out.println("\t\t\t@---**--- REGISTER ---**---@");  
                	RegisterAccount registerAcc = new RegisterAccount();
                	registerAcc.registerAccount();
                	System.out.println("Please Login after Sign Up new account");
                    break;
                case 3:
                	System.out.println("Goodbye");
                	return_more = false;
                    break;
            }
		} while (return_more);
		System.out.println("!!! Closing !!!");
		System.out.println("!!! Program was Closed !!!");
		System.exit(0);
		
	}
}
