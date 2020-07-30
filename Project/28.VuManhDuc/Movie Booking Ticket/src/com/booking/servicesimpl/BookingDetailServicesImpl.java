package com.booking.servicesimpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.configuration.ConnectionFactory;
import com.booking.model.BookingDetailModel;
import com.booking.services.BookingDetailServices;

public class BookingDetailServicesImpl implements BookingDetailServices{
	Scanner sc = new Scanner(System.in);
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
	public void printReceipt(int id) {
		// TODO Auto-generated method stub
		String proc = "{CALL proc_get_booking_by_id(?)}";
		BookingDetailModel bookingDetailModel = new BookingDetailModel();
		try {
			connection = getConnection();
			cs = connection.prepareCall(proc);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			while(rs.next()) {
				bookingDetailModel.setNameuser(rs.getString("name_of_user"));
				bookingDetailModel.setMovieName(rs.getString("movie_name"));
				bookingDetailModel.setSeatPosition(rs.getString("seat_position"));
				bookingDetailModel.setPrice(rs.getInt("price"));
				bookingDetailModel.setMovieDay(rs.getString("movie_day"));
				bookingDetailModel.setTheaterName(rs.getString("theater_name"));
				bookingDetailModel.setTimeStart(rs.getString("time_start"));
				bookingDetailModel.setTimeEnd(rs.getString("time_end"));
				
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
		try {
			String billDir = "C:/Users/PC28/Desktop/movie ticket.txt";
			FileWriter fw = new FileWriter(billDir);
			BufferedWriter bu = new BufferedWriter(fw);
			bu.write("             MOVIE TICKET            ");
			bu.write("\r\n");
			bu.write("\r\n");
			bu.write("Client Name: "+bookingDetailModel.getNameuser());
			bu.write("\r\n");
			bu.write("-------------------------------------");
			bu.write("\r\n");
			java.util.Date day = new java.util.Date();
			bu.write(""+day);
			bu.write("\r\n");
			bu.write("=====================================");
			bu.write("\r\n");
			bu.write(bookingDetailModel.getMovieName());
			bu.write("\r\n");
			bu.write(bookingDetailModel.getMovieDay());
			bu.write("\r\n");
			bu.write(bookingDetailModel.getTimeStart()+" : "+bookingDetailModel.getTimeEnd());
			bu.write("\r\n");
			bu.write("Theater: "+bookingDetailModel.getTheaterName());
			bu.write("\r\n");
			bu.write("Seat position: "+bookingDetailModel.getSeatPosition());
			bu.write("\r\n");
			bu.write("-------------------------------------");
			bu.write("\r\n");
			bu.write("		   VND 	"+bookingDetailModel.getPrice());
			bu.write("\r\n");
			bu.write("		  (include 5% VAT)");
			bu.write("\r\n");
			bu.write("-------------------------------------");
			bu.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void showListBookingHistory(int idUser) {
		// TODO Auto-generated method stub
		String proc = "{CALL proc_get_list_booking_by_id(?)}";
		List<BookingDetailModel> list = new ArrayList<>();
		try {
			connection = getConnection();
			cs = connection.prepareCall(proc);
			cs.setInt(1, idUser);
			rs = cs.executeQuery();
			while(rs.next()) {
				BookingDetailModel b = new BookingDetailModel();
				b.setNameuser(rs.getString("name_of_user"));
				b.setMovieName(rs.getString("movie_name"));
				b.setSeatPosition(rs.getString("seat_position"));
				b.setPrice(rs.getInt("price"));
				b.setMovieDay(rs.getString("movie_day"));
				b.setTheaterName(rs.getString("theater_name"));
				b.setTimeStart(rs.getString("time_start"));
				b.setTimeEnd(rs.getString("time_end"));
				list.add(b);
			}
			for(int i = 1; i <= list.size();i++) {
				System.out.println(i+". "+list.get(i-1).getMovieName()+
						" Day: "+list.get(i-1).getMovieDay()+
						" Seat: "+list.get(i-1).getSeatPosition()+
						" Price: "+list.get(i-1).getPrice()+
						" Start: "+list.get(i-1).getTimeStart()+
						" End: "+list.get(i-1).getTimeEnd());
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
}
