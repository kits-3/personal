package com.booking.servicesimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.configuration.ConnectionFactory;
import com.booking.model.ShowListMovieModel;
import com.booking.services.ShowListMovieServices;

public class ShowListMovieServicesImpl implements ShowListMovieServices{
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
	public List<ShowListMovieModel> showListMovie() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input day: ");
		String day = scanner.next();
		
		
		List<ShowListMovieModel> list = new ArrayList<>();
		String proc = "{call proc_search_movie(?)}";

		try {
			connection = getConnection();
			cs = connection.prepareCall(proc);
			cs.setString(1, day);
			rs = cs.executeQuery();
			while(rs.next()) {
				ShowListMovieModel listItem = new ShowListMovieModel();
				listItem.setIdMovie(rs.getInt("id_movie"));
				listItem.setMovieDay(rs.getString("movie_day"));
				listItem.setMovieName(rs.getString("movie_name"));
				listItem.setTimeStart(rs.getString("time_start"));
				listItem.setTimeEnd(rs.getString("time_end"));
				listItem.setNameTheater(rs.getString("theater_name"));
				listItem.setSeatQuant(rs.getInt("seat"));
				listItem.setEmpty(rs.getInt("empty"));
				list.add(listItem);
				
				connection.close();
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
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d. %s", i + 1, list.get(i).toString());
			System.out.println();
			System.out.println("----------------------------------------------------------------------------");
		}
		return list;
	}
	@Override
	public String showSeatPosition(int id) {
		List<String> listSeat = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String proc = "{CALL proc_get_seat_quantity_by_id_movie(?)}";
		int rowQuant = 0;
		int colQuant = 0;
		int empty = 0;
		listSeat = getSeatList(id);
		
		String seatPosition = null;
		
		try {
			
			connection = getConnection();
			cs = connection.prepareCall(proc);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			rs.next();
			rowQuant = rs.getInt("row_quant");
			colQuant = rs.getInt("col_quant");
			empty = rs.getInt("empty");
			int arrSeat[][] = new int[rowQuant][colQuant];
			for(int i = 0;i < listSeat.size();i++) {
				String e[] = listSeat.get(i).split("");
				if(e.length == 2)
					arrSeat[getASCII(e[0])-65][Integer.parseInt(e[1])-1] = 1;
				else {
					arrSeat[getASCII(e[0])-65][Integer.parseInt(e[1]+e[2])-1] = 1;
				}
			}
			
			///////////////
			for(int i = 1;i<=colQuant;i++){
				if(i == 1) System.out.print("*");
				System.out.print("-"+i);
			}
			System.out.println();
			for(int i = 0;i<rowQuant;i++){
				System.out.printf("%c", i+65);
				for(int j = 0;j<colQuant;j++){
					
					if(arrSeat[i][j] == 0)
						System.out.print("-o");
					else
						System.out.print("-x");
					if(j == colQuant-1)
						System.out.println();
				}
			}
			do {
				System.out.print("Choose seat (Ex. F5): ");
				seatPosition = scanner.next();
			} while (listSeat.contains(seatPosition));
			////////////////
			
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
		
		//return 0;
		// TODO Auto-generated method stub
		return seatPosition;
	}
	public int getASCII(String c){
		if(c.equalsIgnoreCase("A")){
			return 65;
		}
		if(c.equalsIgnoreCase("B")){
			return 66;
		}
		if(c.equalsIgnoreCase("C")){
			return 67;
		}
		if(c.equalsIgnoreCase("D")){
			return 68;
		}
		if(c.equalsIgnoreCase("E")){
			return 69;
		}
		if(c.equalsIgnoreCase("F")){
			return 70;
		}
		if(c.equalsIgnoreCase("G")){
			return 71;
		}
		if(c.equalsIgnoreCase("H")){
			return 72;
		}
		if(c.equalsIgnoreCase("I")){
			return 73;
		}
		if(c.equalsIgnoreCase("J")){
			return 74;
		}
		if(c.equalsIgnoreCase("K")){
			return 75;
		}
		if(c.equalsIgnoreCase("L")){
			return 76;
		}
		if(c.equalsIgnoreCase("M")){
			return 77;
		}
		if(c.equalsIgnoreCase("N")){
			return 78;
		}
		return 0;
	}
	@Override
	public List<String> getSeatList(int id) {
		List<String> list = new ArrayList<>();
		String proc = "{CALL proc_get_position_by_id_movie(?)}";
		try {
			connection = getConnection();
			cs = connection.prepareCall(proc);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString("seat_position"));
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
		// TODO Auto-generated method stub
		return list;
	}

}
