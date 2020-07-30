package home.computer.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import home.computer.config.connectionFactory;
import home.computer.entity.orderEntity;

public class orderRepositoryImpl implements orderRepository{
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet result = null;
	Scanner sc = new Scanner(System.in);
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = connectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	@Override
	public void insertOrder(String iduser,String idproduct) {
		try {
			java.util.Date date = new java.util.Date();
			Object orderdate = new java.sql.Timestamp(date.getTime());
			String queryString = "INSERT INTO `computer`.`order` (id_user, id_product, OrderDate) VALUES (?, ?, ?);";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setString(1, iduser);
			statement.setString(2, idproduct);
			statement.setObject(3, orderdate);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int findIdOrder(String iduser, String idproduct) {
		
		List<orderEntity> orderLs = new ArrayList<orderEntity>();
		int tmp = 0;
		try {
				
				String queryString = "SELECT * FROM computer.`order` WHERE id_user=? AND id_product=?";
				connection = getConnection();
				statement = connection.prepareStatement(queryString);
				statement.setString(1, iduser);
				statement.setString(2, idproduct);
				result = statement.executeQuery();
				
				while(result.next())
				{
					orderEntity orderE = new orderEntity();
					orderE.setId(result.getInt("id"));
					orderLs.add(orderE);
				}
		
				tmp = orderLs.get(0).getId();
			
				for (int i = 1; i < orderLs.size();i++)
				{
					if (tmp < orderLs.get(i).getId())
					{
						tmp = orderLs.get(i).getId();
					}
						
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tmp;
	}

}
