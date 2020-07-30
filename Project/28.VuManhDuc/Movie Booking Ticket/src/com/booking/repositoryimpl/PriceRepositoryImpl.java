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
import com.booking.entity.PriceEntity;
import com.booking.repository.PriceRepository;

public class PriceRepositoryImpl implements PriceRepository{
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
	public void add() {
		// TODO Auto-generated method stub
		System.out.print("Price: ");
		int price = sc.nextInt();
		System.out.print("Description: ");
		String des = sc.nextLine();
		String query ="INSERT INTO price(price, description) VALUES (?, ?);";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, price);
			stmt.setString(2, des);
			int i = stmt.executeUpdate();
			
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
	public List<PriceEntity> findAll() {
		List<PriceEntity> list = new ArrayList<>();
		String query ="select * from price";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs.next()) {
				PriceEntity priceEntity = new PriceEntity();
				priceEntity.setIdPrice(rs.getInt("id_price"));
				priceEntity.setPrice(rs.getInt("price"));
				priceEntity.setDescription(rs.getString("description"));
				list.add(priceEntity);
				
			}
			for(int i = 1;i<= list.size();i++) {
				
				System.out.println(i+". Price: "+list.get(i-1).getPrice()+" Description: "+list.get(i-1).getDescription());
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
		// TODO Auto-generated method stub
		return list;
	}

}
