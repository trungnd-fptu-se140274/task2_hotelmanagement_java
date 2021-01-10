package trungnd.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import trungnd.connection.MyConnection;
import trungnd.dto.AccountDTO;

@SuppressWarnings("serial")
public class AccountDAO implements Serializable {
	private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public AccountDAO() {
    }
    
    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        } 
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public AccountDTO checkLogin(String username, String password) throws Exception {
        AccountDTO dto = null;
        try {
            String sql = "Select * From account Where username = ? and password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String accID = rs.getString("accID");
                String name = rs.getString("name");
                int roleID = rs.getInt("roleID");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                dto = new AccountDTO(accID, username, name, roleID, age, phone, address);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean checkUsernameExist(String username) throws Exception {	
    	boolean check;
        try {
        	check = true;
            String sql = "Select * From account Where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = false;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public int checkUsernameExist_Role(String username) throws Exception {	
    	int result = 0;
        try {
            String sql = "Select roleID From account Where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("roleID");
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<AccountDTO> checkAllAccIDByRole(int roleID) throws Exception {	
    	List<AccountDTO> list = null;
        try {
            String sql = "Select accID, roleID From account Where roleID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, roleID);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String accID = rs.getString("accID");
                AccountDTO dto = new AccountDTO();
                dto.setAccID(accID);
                dto.setRoleID(roleID);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean createAccount(AccountDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into account (accID, username, password, name, roleID, age, phone, address) "
                    + "Values (?,?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getAccID());
            preStm.setString(2, dto.getUsername());
            preStm.setString(3, dto.getPassword());
            preStm.setString(4, dto.getAccName());
            preStm.setInt(5, dto.getRoleID());
            preStm.setInt(6, dto.getAge());
            preStm.setString(7, dto.getPhone());
            preStm.setString(8, dto.getAccAddress());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<AccountDTO> getAllAccount() throws Exception {	
    	List<AccountDTO> list = null;
        try {
            String sql = "Select accID, roleID, username From account";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String accID = rs.getString("accID");
                String username = rs.getString("username");
                int roleID = rs.getInt("roleID");
                AccountDTO dto = new AccountDTO();
                dto.setAccID(accID);
                dto.setUsername(username);
                dto.setRoleID(roleID);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean updateRole(int roleID, String accID, String username) throws Exception {
        boolean check = false;
        try {
            String sql = "Update account Set roleID = ?, accID = ? Where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, roleID);
            preStm.setString(2, accID);
            preStm.setString(3, username);
            check = preStm.executeUpdate() > 0;         
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public String getAccID(String username) throws Exception {	
    	String accID = null;
        try {
            String sql = "Select accID From account Where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                accID = rs.getString("accID");
            }
        } finally {
            closeConnection();
        }
        return accID;
    }
}
