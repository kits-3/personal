package home.computer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import home.computer.config.connectionFactory;
import home.computer.entity.CustomerEntity;

public class CustomerRepositoryImpl implements CustomerRepository {
	
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet result = null;
	Scanner sc = new Scanner(System.in);
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = connectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	
	@Override
	public List<CustomerEntity> findALL() {
		List<CustomerEntity> lsCustomner = new ArrayList();
		String queryString = "SELECT * FROM customer";
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			result = statement.executeQuery(); 
			
			while(result.next()) {
				CustomerEntity cus = new CustomerEntity();
				
				cus.setId(result.getInt(1));
				cus.setId_user(result.getInt(1));
				cus.setName(result.getString("name"));
				cus.setAddress(result.getString("address"));
				cus.setSdt(result.getInt(1));
				cus.setMoney(result.getInt("money"));
				
				
				lsCustomner.add(cus);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (result != null) {
					result.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		return lsCustomner;
	}
	@Override
	public void UpdateMoney(String idUser, int money) {
		try {
			String queryString = "UPDATE customer SET Money=? WHERE id_user=?";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setInt(1, money);
			statement.setString(2, idUser);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Input Money Fail");
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (result != null) {
					result.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	@Override
	public int SelectMoney(String idUser) {
		int money = 0;
		try {
			String queryString = "SELECT Money FROM customer WHERE id_user=?";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setString(1, idUser);
			result = statement.executeQuery();
			if(result.next())
			{
				money = result.getInt("Money");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (result != null) {
					result.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return money;
	}
	
	@Override
	public void insert_id_user(String user) {
		
		try {
			String queryString = "INSERT INTO customer(id_user,money,name) VALUES(?,?,?)";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setString(1, user);
			statement.setInt(2, 0);
			statement.setString(3, "anonymous");
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Try again!");
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (result != null) {
					result.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
	
	



