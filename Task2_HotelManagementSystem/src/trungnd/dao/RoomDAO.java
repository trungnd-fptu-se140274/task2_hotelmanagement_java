package trungnd.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import trungnd.connection.MyConnection;
import trungnd.dto.RoomDTO;

@SuppressWarnings("serial")
public class RoomDAO implements Serializable {
	private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public RoomDAO() {
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
    
	public List<RoomDTO> getAllRooms() throws Exception {	
    	List<RoomDTO> list = null;
        try {
            String sql = "Select * From room";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String roomID = rs.getString("roomID");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                boolean status = rs.getBoolean("status");
                RoomDTO dto = new RoomDTO();
                dto.setRoomID(roomID);
                dto.setRoomName(name);
                dto.setRoomPrice(price);
                dto.setStatus(status);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
	
	public List<RoomDTO> searchRoom(String search) throws Exception {	
    	List<RoomDTO> list = null;
        try {
            String sql = "Select * From room where name Like ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, '%' + search + '%');
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String roomID = rs.getString("roomID");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                boolean status = rs.getBoolean("status");
                RoomDTO dto = new RoomDTO();
                dto.setRoomID(roomID);
                dto.setRoomName(name);
                dto.setRoomPrice(price);
                dto.setStatus(status);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
	
	public boolean updateStatus(String roomID, String name, double price, boolean status) throws Exception {
        boolean check = false;
        try {
            String sql = "Update room Set name = ?, price = ?, status = ? Where roomID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            preStm.setDouble(2, price);
            preStm.setBoolean(3, status);
            preStm.setString(4, roomID);
            check = preStm.executeUpdate() > 0;         
        } finally {
            closeConnection();
        }
        return check;
    }
	
	public boolean updateStatus1(String roomID, boolean status) throws Exception {
        boolean check = false;
        try {
            String sql = "Update room Set status = ? Where roomID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, status);
            preStm.setString(2, roomID);
            check = preStm.executeUpdate() > 0;         
        } finally {
            closeConnection();
        }
        return check;
    }
}
