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
import com.booking.model.TheaterTimeSlotModel;
import com.booking.services.TheaterTimeSlotServices;

public class TheaterTimeSlotServicesImpl implements TheaterTimeSlotServices{
	Scanner scanner = new Scanner(System.in);
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private CallableStatement cs = null;
	
	private List<TheaterTimeSlotModel> listEmpty = new ArrayList<>();
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	@Override
	public List<TheaterTimeSlotModel> getAllTimeSlot() {
		// TODO Auto-generated method stub
		List<TheaterTimeSlotModel> list = new ArrayList<>();
		
		String sql = "SELECT theater_name, movtime.name_movtime, id_theater, id_movtime, time_start, time_end FROM movtime, theater ORDER BY theater_name ASC, movtime.id_movtime";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				TheaterTimeSlotModel t = new TheaterTimeSlotModel();
				t.setIdTheater(rs.getInt("id_theater"));
				t.setTheaterName(rs.getString("theater_name"));
				t.setIdTimeSlot(rs.getInt("id_movtime"));
				t.setTimeSlot(rs.getString("name_movtime"));
				t.setTimeStart(rs.getTime("time_start"));
				t.setTimeEnd(rs.getTime("time_end"));
				list.add(t);
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
		return list;
	}

	@Override
	public List<TheaterTimeSlotModel> getEmptyTimeSlot(String day) {
		// TODO Auto-generated method stub
		List<TheaterTimeSlotModel> list = new ArrayList<>();
		String proc = "{CALL proc_get_theater_by_date(?)}";
		try {
			connection = getConnection();
			cs = connection.prepareCall(proc);
			cs.setString(1, day);
			rs = cs.executeQuery();
			while(rs.next()) {
				TheaterTimeSlotModel t = new TheaterTimeSlotModel();
				t.setIdTheater(rs.getInt("id_theater"));
				t.setTheaterName(rs.getString("theater_name"));
				t.setIdTimeSlot(rs.getInt("id_movtime"));
				t.setTimeSlot(rs.getString("name_movtime"));
				t.setTimeStart(rs.getTime("time_start"));
				t.setTimeEnd(rs.getTime("time_end"));
				list.add(t);
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
		
		listEmpty = getAllTimeSlot();

		for(int j = 0;j < list.size();j++) {
			for(int i = 0;i < listEmpty.size();i++) {
				if(listEmpty.get(i).getIdTheater() == list.get(j).getIdTheater() && listEmpty.get(i).getIdTimeSlot() == list.get(j).getIdTimeSlot()) {
					listEmpty.remove(i);
					break;
				}
			}
		}
//		for(int i = 1;i <= listEmpty.size();i++) {
//			System.out.println("Theater: "+listEmpty.get(i-1).getTheaterName()+
//					", "+ listEmpty.get(i-1).getIdTimeSlot()+
//					", "+ listEmpty.get(i-1).getIdTheater()+
//					", "+ listEmpty.get(i-1).getTimeStart()+
//					", "+ listEmpty.get(i-1).getTimeEnd()
//					);
//		}
		return listEmpty;
	}
	@Override
	public List<Integer> getAvailableTheater() {
		// TODO Auto-generated method stub
		
		List<String> listTheater = new ArrayList<>();
		List<Integer> listIdTheater = new ArrayList<>();
		
		for(int i = 0;i < listEmpty.size();i++) {
			if(!listTheater.contains(listEmpty.get(i).getTheaterName())) {
				listTheater.add(listEmpty.get(i).getTheaterName());
				listIdTheater.add(listEmpty.get(i).getIdTheater());
			}
				
		}
		for(int i = 1;i <= listTheater.size();i++) {
			System.out.println(i+". Theater: "+listTheater.get(i-1));
		}
		return listIdTheater;
	}
	@Override
	public List<TheaterTimeSlotModel> getAvailableTimeSlot(int id) {
		// TODO Auto-generated method stub
		List<TheaterTimeSlotModel> list = new ArrayList<>();
		for(int i = 0;i < listEmpty.size();i++) {
			if(listEmpty.get(i).getIdTheater() == id)
				list.add(listEmpty.get(i));
		}
		for(int i = 1;i <= list.size();i++) {
			System.out.println(i+". "+list.get(i-1).getTimeSlot()+" From: "+list.get(i-1).getTimeStart()+" To: "+list.get(i-1).getTimeEnd());
		}
		return list;
	}
	@Override
	public List<TheaterTimeSlotModel> getAvailableTheater1() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
