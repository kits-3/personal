package atm.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atm.connection.ConnectionFactory;
import atm.entity.Account;
import atm.entity.Session;
import atm.repository.AccountRepository;

public class AccountImpl implements AccountRepository {
	
	Connection conn = null;
	PreparedStatement statement = null;
	
	private Connection getConnection() throws SQLException {
		Connection connection = ConnectionFactory.getInstance().getConnection();
		return connection;
	}
	
	@Override
	public int login(String username, String password) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				status++;
				Session.id = result.getInt("id");
				Session.name = result.getString("name");
			}
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
		
		return status;
	}
	
	@Override
	public List<Account> findAll() {
		List<Account> list = new ArrayList<Account>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM account ORDER BY create_at DESC";
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Account acc = new Account();
				acc.setId(result.getInt("id"));
				acc.setName(result.getString("name"));
				acc.setUsername(result.getString("username"));
				acc.setMoney(result.getDouble("money"));
				acc.setContact(result.getString("contact"));
				acc.setStatus(result.getInt("status"));
				list.add(acc);
			}
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
		return list;
	}

	@Override
	public int create(Account acc) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "INSERT INTO account(name, username, password, id_card, money, contact) VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, acc.getName());
			statement.setString(2, acc.getUsername());
			statement.setString(3, acc.getPassword());
			statement.setString(4, acc.getId_card());
			statement.setDouble(5, acc.getMoney());
			statement.setString(6, acc.getContact());
			status = statement.executeUpdate();
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
		return status;
	}

	@Override
	public int update(Account acc) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "UPDATE account SET name = ?, username = ?, password = ?, id_card = ?, money = ?, status = ?  WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, acc.getName());
			statement.setString(2, acc.getUsername());
			statement.setString(3, acc.getPassword());
			statement.setString(4, acc.getId_card());
			statement.setDouble(5, acc.getMoney());
			statement.setInt(6, acc.getStatus());
			statement.setInt(7, acc.getId());
			status = statement.executeUpdate();
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
		return status;
		
	}

	@Override
	public int delete(int id) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM account WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			status = statement.executeUpdate();
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
		
		return status;
	}

	@Override
	public Account findById(int id) {
		Account acc = new Account();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM account WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				acc.setId(result.getInt("id"));
				acc.setName(result.getString("name"));
				acc.setUsername(result.getString("username"));
				acc.setPassword(result.getString("password"));
				acc.setId_card(result.getString("id_card"));
				acc.setMoney(result.getDouble("money"));
				acc.setContact(result.getString("contact"));
				acc.setStatus(result.getInt("status"));
				acc.setCreate_at(result.getString("create_at"));
				
			}
			
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
		return acc;
	}

	@Override
	public Account findByUser(String user) {
		Account acc = new Account();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM account WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				acc.setId(result.getInt("id"));
				acc.setName(result.getString("name"));
				acc.setUsername(result.getString("username"));
				acc.setPassword(result.getString("password"));
				acc.setId_card(result.getString("id_card"));
				acc.setMoney(result.getDouble("money"));
				acc.setContact(result.getString("contact"));
				acc.setStatus(result.getInt("status"));
				acc.setCreate_at(result.getString("create_at"));
			}
			
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
		return acc;
	}
}
