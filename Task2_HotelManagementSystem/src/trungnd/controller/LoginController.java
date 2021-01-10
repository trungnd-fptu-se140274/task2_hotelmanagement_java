package trungnd.controller;

import trungnd.dao.AccountDAO;
import trungnd.dto.AccountDTO;

public class LoginController {
	public static int checkLogin(String username, String password) {
		int result = 0;
		try {
			result = 0;
			AccountDAO dao = new AccountDAO();
			AccountDTO dto = dao.checkLogin(username, password);
			if (dto == null) {
				System.out.println("Invalid Username Or Password");
				return result;
			} else {
				switch (dto.getRoleID()) {
					case 1: {
//						System.out.println("ROLE: CUSTOMER");
						result = 1;
						break;
					}
					case 2: {
//						System.out.println("ROLE: CLERK");
						result = 2;
						break;
					}
					case 3: {
//						System.out.println("ROLE: ADMIN");
						result = 3;
						break;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Something wrong in : " + ex.getMessage());
		}
		return result;
	}
}
