package trungnd.utils;

import java.util.Scanner;

public class MyUtils {
	private final Scanner sc = new Scanner(System.in);
    private final String VALID_USERNAME = "^\\S{4}\\S*$";
    private final String VALID_PASSWORD = "^\\S{4}\\S*$";
    
	public  int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
	
	public String checkInputString() {
        while (true) {
            String result = sc.nextLine();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
	
	public  String checkInputUsername() {
        System.out.print("Enter username: ");
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_USERNAME)) {
                return result;
            }
            System.err.println("You must enter least at 5 character, and no space!");
            System.out.print("Enter again: ");
        }
    }

    public  String checkInputPassword() {
        System.out.print("Enter password: ");
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PASSWORD)) {
                return result;
            }
            System.err.println("You must enter least at 6 character, and no space!");
            System.out.print("Enter again: ");
        }
    }
}
