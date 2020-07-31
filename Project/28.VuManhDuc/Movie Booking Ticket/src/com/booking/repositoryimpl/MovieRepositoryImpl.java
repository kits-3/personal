package com.booking.repositoryimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.booking.configuration.ConnectionFactory;
import com.booking.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository{
	Scanner scanner = new Scanner(System.in);
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
	public void addMovie(String day, int idTheater, String movieName, int idTimeSlot) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO movie(movie_day, id_theater, movie_name, id_movtime) VALUES (?,?,?,?)";
		String proc = "{CALL proc_insert_seatstate(?, ?)}";
		//update seatstate here
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, day);
			stmt.setInt(2, idTheater);
			stmt.setString(3, movieName);
			stmt.setInt(4, idTimeSlot);
			int insertMovie = stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();//id movie
			rs.next();
			int idMovie = rs.getInt(1);
			cs = connection.prepareCall(proc);
			cs.setInt(1, idMovie);
			cs.setInt(2, idTheater);
			int insertSeatState = cs.executeUpdate();
			if(insertMovie > 0 && insertSeatState > 0) {
				System.out.println("Add movie successfully");
			}else {
				System.err.println("Fail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
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
	}

	@Override
	public void updateMovie(int idMovie, String movieDay, int idTheater, String movieName, int idTimeSlot) {
		String proc = "{CALL proc_update_movie(?,?,?,?,?)}";
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			cs = connection.prepareCall(proc);
			cs.setInt(1, idMovie);
			cs.setString(2, movieDay);
			cs.setInt(3, idTheater);
			cs.setString(4, movieName);
			cs.setInt(5, idTimeSlot);
			cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMovie(int idMovie) {
		// TODO Auto-generated method stub
		String proc ="{CALL proc_delete_movie(?)}";
		try {
			connection = getConnection();
			cs = connection.prepareCall(proc);
			cs.setInt(1, idMovie);
			int result = cs.executeUpdate();
			if(result > 0)
				System.out.println("Deleted successully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
