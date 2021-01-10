package trungnd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import trungnd.dao.AccountDAO;
import trungnd.dto.AccountDTO;
import trungnd.utils.MyUtils;

public class SetRoleController {
	MyUtils utl = new MyUtils();
	Scanner sc = new Scanner(System.in);
	
	public void setRole() {
		AccountDAO dao = new AccountDAO();
		List<AccountDTO> listAccountAll = new ArrayList<>();
		try {
			listAccountAll = dao.getAllAccount();
		} catch (Exception e) {
			System.err.println("Something wrong in SetRoleController : " + e.getMessage());
		}
		System.out.println("No\tAccID\tRole");
		for (int i = 0; i < listAccountAll.size(); i++) {		
			if (listAccountAll.get(i).getRoleID() != 3) {
				System.out.print((i + 1) + "\t");
				System.out.print(listAccountAll.get(i).getAccID().trim().toString() + "\t" + listAccountAll.get(i).getUsername().trim().toString() + "\t");
				switch (listAccountAll.get(i).getRoleID()) {
					case 1 :
						System.out.print("Customer\n");
						break;
					case 2 : 
						System.out.print("Hotel Clerk\n");
						break;
				}
			}	
		}
		System.out.print("Choose number to set role: ");
		int choice = utl.checkInputIntLimit(1, listAccountAll.size());
		
		System.out.println("You choose " + choice +  " " + listAccountAll.get(choice - 1).getAccID().toString() + ".\nNow choose role to set up user's role!\nYour role's chosen: ");
		int choiceRole = roleMenu();
		String accID = listAccountAll.get(choice - 1).getAccID().toString();
		int roleID = listAccountAll.get(choice - 1).getRoleID();
		String username = listAccountAll.get(choice - 1).getUsername().toString();
		switch(choiceRole) {
			case 1:
			try {
				accID = "CT_" + (dao.checkAllAccIDByRole(1).size() + 1);
			} catch (Exception e1) {
				System.err.println("Something wrong in SetRoleController-choiceRole1 : " + e1.getMessage());
			}
				roleID = 1;
				break;
			case 2:
			try {
				accID = "CL_" + (dao.checkAllAccIDByRole(2).size() + 1);
			} catch (Exception e1) {
				System.err.println("Something wrong in SetRoleController-choiceRole2 : " + e1.getMessage());
			}
				roleID = 2;
				break;
		}
		
		//test
//		System.out.println("---" + accID + " " + username + " " + roleID);
		
		try {
			if (dao.updateRole(roleID, accID, username)) {
				System.out.println("Successful");
			}
		} catch (Exception e) {
			System.out.println("Unsuccessful");
			System.err.println("Something wrong in SetRoleController : " + e.getMessage());
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
