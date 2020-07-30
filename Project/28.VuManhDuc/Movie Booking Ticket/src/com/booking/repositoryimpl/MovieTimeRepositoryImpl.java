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
import com.booking.entity.MovieTimeEntity;
import com.booking.repository.MovieTimeRepository;

public class MovieTimeRepositoryImpl implements MovieTimeRepository{
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
	public List<MovieTimeEntity> findAll() {
		// TODO Auto-generated method stub
		List<MovieTimeEntity> list = new ArrayList<>();
		String sql = "select * from movtime";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MovieTimeEntity mt = new MovieTimeEntity();
				mt.setTimeStart(rs.getTime("time_start"));
				mt.setTimeEnd(rs.getTime("time_end"));
				mt.setNameMovTime(rs.getString("name_movtime"));
				list.add(mt);
			}
			for(int i = 1; i <= list.size();i++) {
				System.out.println(i+". "+list.get(i-1).getNameMovTime()+
						": From: "+list.get(i-1).getTimeStart()+
						" To: "+list.get(i-1).getTimeEnd());
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
	
}
