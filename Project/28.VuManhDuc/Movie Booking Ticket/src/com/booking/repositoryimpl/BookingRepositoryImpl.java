package com.booking.repositoryimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.booking.configuration.ConnectionFactory;
import com.booking.entity.BookingEntity;
import com.booking.repository.BookingRepository;

public class BookingRepositoryImpl implements BookingRepository{
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private CallableStatement cs = null;
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	@Override
	public int addBooking(BookingEntity bookingEntity) {
		// TODO Auto-generated method stub
		int idBooking = 0;
		String proc = "{CALL proc_insert_booking(?,?,?,?)}";
		String insertBooking = "INSERT INTO booking(id_user, id_movie, id_price, seat_position) VALUES (?,?,?,?)";
		String updateSeatState = "UPDATE seat_state SET empty = empty - 1 WHERE seat_state.id_movie = ?;";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(insertBooking, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, bookingEntity.getIdUser());
			stmt.setInt(2, bookingEntity.getIdMovie());
			stmt.setInt(3, bookingEntity.getIdPrice());
			stmt.setString(4, bookingEntity.getSeatPosition());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			rs.next();
			idBooking = rs.getInt(1);
			stmt = connection.prepareStatement(updateSeatState);
			stmt.setInt(1, bookingEntity.getIdMovie());
			int status = stmt.executeUpdate();
			if(status > 0) {
				System.out.println("Booking successfully");
			}else {
				System.out.println("Booking fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return idBooking;
	}
	

}
