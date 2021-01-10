package trungnd.main;

import java.util.Scanner;

import trungnd.controller.LoginController;
import trungnd.utils.MyUtils;

public class LoginForm {
	Scanner sc = new Scanner(System.in);
	MyUtils utl = new MyUtils();

	public void loginAccount() {	
		String username, password;
		System.out.print("Input your Username: ");
		username = sc.nextLine();
		System.out.print("Input your Password: ");
		password = sc.nextLine();
		int checkLogin = LoginController.checkLogin(username, password);
		checkLogin(checkLogin, username);
	}

	public void checkLogin(int checkLogin, String username) {
		boolean check = true;
		do {
            switch (checkLogin) {
            //customer
			case 1:
				CustomerForm customer = new CustomerForm();
				customer.customerForm(username);
				check = false;
				break;
			//clerk
			case 2:
				ClerkForm clerk = new ClerkForm();
				clerk.clerkForm(username);
				check = false;
				break;
			//admin
			case 3:
				AdminForm admin = new AdminForm();
				admin.adminForm();
				check = false;
				break;
			default:
				check = false;
				System.out.println("Log in again!");
				break;
			}
        } while (check == true);
		WelcomeForm welcome = new WelcomeForm();
    	welcome.mainMenu();
	}
	
}
