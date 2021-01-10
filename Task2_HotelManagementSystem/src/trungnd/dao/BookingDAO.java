package trungnd.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import trungnd.connection.MyConnection;
import trungnd.dto.BookingDTO;

@SuppressWarnings("serial")
public class BookingDAO implements Serializable {
	private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public BookingDAO() {
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
    
    public boolean bookRoom(BookingDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into booking (BookingID, name, startdate, endtime, accID, roomID, status) "
                    + "Values (?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getBookingID());
            preStm.setString(2, dto.getBookingName());
            preStm.setString(3, dto.getStartTimeBook());
            preStm.setString(4, dto.getEndTimeBook());
            preStm.setString(5, dto.getAccID());
            preStm.setString(6, dto.getRoomID());
            preStm.setBoolean(7, dto.isBookingStatus());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
