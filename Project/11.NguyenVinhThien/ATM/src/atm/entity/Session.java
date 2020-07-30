package atm.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import atm.connection.ConnectionFactory;

public class Session {
	public static int id = 0;
	public static String name = "";
	
	public Session() {}
	
	Connection conn = null;
	PreparedStatement statement = null;
	String sql = "SELECT * FROM setting";
	
	Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = ConnectionFactory.getInstance().getConnection();
		return connection;
	}
	
	public double getBank() {
		double bank = 0;
		
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				bank = result.getDouble("bank_money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return bank;
	}
	
	public double getWithdraw() {
		double withdraw = 0;
		
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				withdraw = result.getDouble("bank_withdraw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return withdraw;
	}
	
	public double getTransfer() {
		double transfer = 0;
		
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				transfer = result.getDouble("bank_transfer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return transfer;
	}
	
	public double getInvoice() {
		double invoice = 0;
		
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				invoice = result.getDouble("bank_invoice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return invoice;
	}
	
	public double getMin() {
		double min = 0;
		
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				min = result.getDouble("bank_min");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return min;
	}
	
	public double getMinWithdraw() {
		double min = 0;
		
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				min = result.getDouble("min_withdraw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return min;
	}
	
	public void updateWithdraw(double money) {
		try {
			conn = getConnection();
			String sql = "UPDATE setting SET bank_money = bank_money - ? WHERE id = 1";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, money);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateDeposit(int money) {
		try {
			conn = getConnection();
			String sql = "UPDATE setting SET bank_money = bank_money + ? WHERE id = 1";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, money);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
