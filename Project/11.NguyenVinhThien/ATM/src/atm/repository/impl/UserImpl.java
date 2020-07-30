package atm.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atm.connection.ConnectionFactory;
import atm.entity.User;
import atm.repository.UserRepository;

public class UserImpl implements UserRepository{

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
			String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				status++;
				User.session_id = result.getInt("id");
				User.session_user = result.getString("username");
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
	public int create(User acc) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "INSERT INTO user(name, username, password, status, create_at) VALUES(?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, acc.getName());
			statement.setString(2, acc.getUsername());
			statement.setString(3, acc.getPassword());
			statement.setInt(4, acc.getStatus());
			statement.setString(5, acc.getCreate_at());
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
	public int update(User acc) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "UPDATE user SET name = ?, username = ?, password = ?, status = ?, create_at = ? WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, acc.getName());
			statement.setString(2, acc.getUsername());
			statement.setString(3, acc.getPassword());
			statement.setInt(4, acc.getStatus());
			statement.setString(5, acc.getCreate_at());
			statement.setInt(6, acc.getId());
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
	public int delete(String username) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM user WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
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
	public int block(int id, int stt) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "UPDATE user SET status = ? WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, stt);
			statement.setInt(2, id);
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
	public int setRole(int id, int role) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "INSERT INTO role(user_id, role) VALUES(?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, role);
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
	public int setUnRole(int id, int role) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM role WHERE user_id = ? AND role = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, role);
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
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		User acc = new User();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				acc.setId(result.getInt("id"));
				acc.setName(result.getString("name"));
				acc.setUsername(result.getString("username"));
				acc.setPassword(result.getString("password"));
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
	public User findByUser(String username) {
		User acc = new User();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM user WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				acc.setId(result.getInt("id"));
				acc.setName(result.getString("name"));
				acc.setUsername(result.getString("username"));
				acc.setPassword(result.getString("password"));
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
	public List<Integer> checkRole(int id) {
		List<Integer> list = new ArrayList<Integer>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM role WHERE user_id = ? ORDER BY role ASC";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				list.add(result.getInt("role"));
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
	public List<Double> getATM() {
		List<Double> list = new ArrayList<Double>();
		try {
			conn = getConnection();
			String sql = "SELECT bank_withdraw, bank_transfer, bank_invoice, bank_min, min_withdraw FROM setting";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				list.add(result.getDouble("bank_withdraw"));
				list.add(result.getDouble("bank_transfer"));
				list.add(result.getDouble("bank_invoice"));
				list.add(result.getDouble("bank_min"));
				list.add(result.getDouble("min_withdraw"));
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
	public int setATM(List<Double> list) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "UPDATE setting SET bank_withdraw = ?, bank_transfer = ?, bank_invoice = ?, bank_min = ?, min_withdraw = ? WHERE id = 1";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, list.get(0));
			statement.setDouble(2, list.get(1));
			statement.setDouble(3, list.get(2));
			statement.setDouble(4, list.get(3));
			statement.setDouble(5, list.get(4));
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
	
}
