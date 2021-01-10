package trungnd.dto;

public class AccountDTO {
	private String accID;
	private String username;
	private String password;
	private String accName;
	private int roleID;
	private int age;
	private String phone;
	private String accAddress;
	
	
	
	public AccountDTO() {
		super();
	}

	public AccountDTO(String accID, int roleID) {
		super();
		this.accID = accID;
		this.roleID = roleID;
	}

	public AccountDTO(String accID, String username, String accName, int roleID, int age, String phone,
			String accAddress) {
		super();
		this.accID = accID;
		this.username = username;
		this.accName = accName;
		this.roleID = roleID;
		this.age = age;
		this.phone = phone;
		this.accAddress = accAddress;
	}
	
	public String getAccID() {
		return accID;
	}
	public void setAccID(String accID) {
		this.accID = accID;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAccAddress() {
		return accAddress;
	}
	public void setAccAddress(String accAddress) {
		this.accAddress = accAddress;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
