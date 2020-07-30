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
import com.booking.entity.NotiEntity;
import com.booking.repository.NotiRepository;

public class NotiRepositoryImpl implements NotiRepository{
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
	public void findAll() {
		String sql = "SELECT * FROM noti GROUP BY noti_day, noti_time desc";
		List<NotiEntity> list = new ArrayList<>();
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				NotiEntity n = new NotiEntity();
				n.setNotiDay(rs.getString("noti_day"));
				n.setNotiTime(rs.getTime("noti_time"));
				n.setContent(rs.getString("content"));
				list.add(n);
			}
			for(int i = 1;i <= list.size();i++) {
				System.out.println(i+". "+list.get(i-1).getNotiDay()+" "+list.get(i-1).getNotiTime()+": "+list.get(i-1).getContent());
				System.out.println("---------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
