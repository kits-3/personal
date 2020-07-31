package atm.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atm.connection.ConnectionFactory;
import atm.entity.History;
import atm.repository.HistoryRepository;

public class HistoryImpl implements HistoryRepository{

	private Connection conn = null;
	private PreparedStatement statement = null;
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = ConnectionFactory.getInstance().getConnection();
		return connection;
	}
	
	@Override
	public int create(int id, int type, double money, int transfer_id, int stt) {
		int status = 0;
		try {
			conn = getConnection();
			String sql = "INSERT INTO history(account_id, type, money, transfer_id, status) VALUES(?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, type);
			statement.setDouble(3, money);
			statement.setInt(4, transfer_id);
			statement.setInt(5, stt);
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
	public List<History> history() {
		List<History> list = new ArrayList<History>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM history";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {				
				History his = new History();
				his.setId(result.getInt("id"));
				his.setAccount_id(result.getInt("account_id"));
				his.setType(result.getInt("type"));
				his.setMoney(result.getDouble("money"));
				his.setTransfer_id(result.getInt("transfer_id"));
				his.setCreate_at(result.getTimestamp("create_at").toString());
				his.setStatus(result.getInt("status"));
				list.add(his);
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
	public List<History> findAll() {
		List<History> list = new ArrayList<History>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM history WHERE status = 1 ORDER BY create_at DESC";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				
				History his = new History();
				his.setId(result.getInt("id"));
				his.setAccount_id(result.getInt("account_id"));
				his.setType(result.getInt("type"));
				his.setMoney(result.getDouble("money"));
				his.setTransfer_id(result.getInt("transfer_id"));
				his.setCreate_at(result.getTimestamp("create_at").toString());
				his.setStatus(result.getInt("status"));
				list.add(his);
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
	public List<History> findWithraw() {
		List<History> list = new ArrayList<History>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM history WHERE type = 1 AND status = 1 ORDER BY create_at DESC";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				
				History his = new History();
				his.setId(result.getInt("id"));
				his.setAccount_id(result.getInt("account_id"));
				his.setType(result.getInt("type"));
				his.setMoney(result.getDouble("money"));
				his.setTransfer_id(result.getInt("transfer_id"));
				his.setCreate_at(result.getTimestamp("create_at").toString());
				his.setStatus(result.getInt("status"));
				list.add(his);
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
	public List<History> findDeposit() {
		List<History> list = new ArrayList<History>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM history WHERE type = 3 AND status = 1 ORDER BY create_at DESC";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {				
				History his = new History();
				his.setId(result.getInt("id"));
				his.setAccount_id(result.getInt("account_id"));
				his.setType(result.getInt("type"));
				his.setMoney(result.getDouble("money"));
				his.setTransfer_id(result.getInt("transfer_id"));
				his.setCreate_at(result.getTimestamp("create_at").toString());
				his.setStatus(result.getInt("status"));
				list.add(his);
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
	public List<History> findTransfer() {
		List<History> list = new ArrayList<History>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM history WHERE type = 2 AND status = 1 ORDER BY create_at DESC";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {				
				History his = new History();
				his.setId(result.getInt("id"));
				his.setAccount_id(result.getInt("account_id"));
				his.setType(result.getInt("type"));
				his.setMoney(result.getDouble("money"));
				his.setTransfer_id(result.getInt("transfer_id"));
				his.setCreate_at(result.getTimestamp("create_at").toString());
				his.setStatus(result.getInt("status"));
				list.add(his);
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
	public List<History> findById(int id) {
		List<History> list = new ArrayList<History>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM history WHERE account_id = ? OR transfer_id = ? ORDER BY create_at DESC";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {				
				History his = new History();
				his.setId(result.getInt("id"));
				his.setAccount_id(result.getInt("account_id"));
				his.setType(result.getInt("type"));
				his.setMoney(result.getDouble("money"));
				his.setTransfer_id(result.getInt("transfer_id"));
				his.setCreate_at(result.getTimestamp("create_at").toString());
				his.setStatus(result.getInt("status"));
				list.add(his);
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
	public ArrayList<List> banking() {
		ArrayList<List> list = new ArrayList<List>();
		try {
			conn = getConnection();
			String sql = "SELECT MONTH(create_at) AS M, type AS T, SUM(money) AS MO, COUNT(type) AS SL FROM history WHERE type <> 4 GROUP BY MONTH(create_at), type ORDER BY M DESC, T ASC";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			List<Integer> item = null;
			int month = 0;
			boolean checkList = false;
			while(result.next()) {
				if(result.getInt("M") != month) {
					month = result.getInt("M");
					if(month != 0)
						checkList = true;
					item = new ArrayList<Integer>();
					item.add(result.getInt("M"));
					item.add(1, 0);
					item.add(2, 0);
					item.add(3, 0);
					item.add(4, 0);
				}
				
				if(result.getInt("T") == 1) {
					item.set(1, result.getInt("MO"));
				}else if(result.getInt("T") == 2) {
					item.set(2, result.getInt("MO"));
				}if(result.getInt("T") == 3) {
					item.set(3, result.getInt("MO"));
				}
				
				item.set(4, item.get(4)+result.getInt("SL"));
					
				if(checkList) {
					list.add(item);
				}
				checkList = false;
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

}
