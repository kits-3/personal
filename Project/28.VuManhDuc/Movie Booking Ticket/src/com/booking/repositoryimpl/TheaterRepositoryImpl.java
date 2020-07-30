package com.booking.repositoryimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.configuration.ConnectionFactory;
import com.booking.entity.TheaterEntity;
import com.booking.repository.TheaterRepository;

public class TheaterRepositoryImpl implements TheaterRepository{
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
	public void addTheater() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTheater(int idTheater) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTheater(int idTheater) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TheaterEntity> findAll() {
		// TODO Auto-generated method stub
		List<TheaterEntity> list = new ArrayList<>();
		String sql = "select * from theater";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				TheaterEntity t = new TheaterEntity();
				t.setIdTheater(rs.getInt("id_theater"));
				t.setTheaterName(rs.getString("theater_name"));
				t.setRowQuant(rs.getInt("row_quant"));
				t.setColQuant(rs.getInt("col_quant"));
				list.add(t);
			}
			for(int i = 1; i <= list.size();i++) {
				System.out.println(i+". Theater: "+list.get(i-1).getTheaterName()+
						" Seat row: "+list.get(i-1).getRowQuant()+
						" Seat col: "+list.get(i-1).getColQuant());
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
	public List<TheaterEntity> findTheaterByDay(String day) {
		// TODO Auto-generated method stub
		List<TheaterEntity> list = findAll();
		
		return null;
	}

}
