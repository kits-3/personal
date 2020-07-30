package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectSQL;
import entity.ReceiptEntity;

public class ReceiptRepositoryImpl implements ReceiptRepository {
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectSQL.getInstance().getConnection();
		return conn;
	}

	@Override
	public void add(ReceiptEntity repEntity) {
		String sql = "INSERT INTO "+
	"receipt(name_customer,phone_customer,name_game,price,producer,total)"+"VALUES(?,?,?,?,?,?)";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, repEntity.getName_customer());
			ptmt.setString(2, repEntity.getPhone_customer());
			ptmt.setString(3, repEntity.getName_game());
			ptmt.setInt(4, repEntity.getPrice());
			ptmt.setString(5, repEntity.getProducer());
			ptmt.setDouble(6, repEntity.getTotal());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ptmt!= null) {
					ptmt.close();
				}
				if(connection!= null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	@Override
	public void update(ReceiptEntity repEntity) {
		String sql = "UPDATE receipt set name_customer=?,"+
	"phone_customer=?,"+"name_game=?,"+"price=?,"+"producer=?,"+"total=? where id=?";
	try {
		connection = getConnection();
		ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, repEntity.getName_customer());
		ptmt.setString(2, repEntity.getPhone_customer());
		ptmt.setString(3, repEntity.getName_game());
		ptmt.setInt(4, repEntity.getPrice());
		ptmt.setString(5, repEntity.getProducer());
		ptmt.setDouble(6, repEntity.getTotal());
		ptmt.setInt(7, repEntity.getId());
		ptmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			if( ptmt!= null) {
				ptmt.close();
			}
			if(connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from receipt where id=?";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ptmt!=null) {
					ptmt.close();
				}
				if(connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
	}

	@Override
	public List<ReceiptEntity> printReceipt() {
		List<ReceiptEntity> lsReceiptEntities = new ArrayList();
		String sql = "select * from receipt";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				ReceiptEntity receiptEntity = new ReceiptEntity();
				receiptEntity.setId(rs.getInt(1));
				receiptEntity.setName_customer(rs.getString("name_customer"));
				receiptEntity.setId_customer(rs.getInt(3));
				receiptEntity.setPhone_customer(rs.getString("phone_customer"));
				receiptEntity.setId_game(rs.getInt(5));
				receiptEntity.setName_game(rs.getString("name_game"));
				receiptEntity.setPrice(rs.getInt(7));
				receiptEntity.setProducer(rs.getString("producer"));
				receiptEntity.setTotal(rs.getDouble(9));
				lsReceiptEntities.add(receiptEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(ptmt!=null) {
					ptmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
					
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		return lsReceiptEntities;
	}

	@Override
	public List<ReceiptEntity> findById(int id) {
		//ReceiptEntity receiptEntity = new ReceiptEntity();
		List<ReceiptEntity> lsReceiptEntities = new ArrayList();
		String sql = "select * from receipt where id=?";
		
		try {
			
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1,id);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				ReceiptEntity receiptEntity = new ReceiptEntity();
				receiptEntity.setId(rs.getInt(1));
				receiptEntity.setName_customer(rs.getString("name_customer"));
				receiptEntity.setName_game(rs.getString("name_game"));
				receiptEntity.setPhone_customer(rs.getString("phone_customer"));
				receiptEntity.setPrice(rs.getInt(7));
				receiptEntity.setTotal(rs.getDouble(9));
				 lsReceiptEntities.add(receiptEntity);
			}
			//lsReceiptEntities.add(receiptEntity);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(ptmt!=null) {
					ptmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lsReceiptEntities ;
	}

	@Override
	public List<ReceiptEntity> findByPhone(String numberphone) {
		List<ReceiptEntity> lsReceiptEntities = new ArrayList();
		String sql = "select * from receipt where phone_customer=?";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, numberphone);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				ReceiptEntity receiptEntity = new ReceiptEntity();
				receiptEntity.setId(rs.getInt(1));
				receiptEntity.setName_customer(rs.getString("name_customer"));
				receiptEntity.setId_customer(rs.getInt(3));
				receiptEntity.setPhone_customer(rs.getString("phone_customer"));
				receiptEntity.setId_game(rs.getInt(5));
				receiptEntity.setName_game(rs.getString("name_game"));
				receiptEntity.setPrice(rs.getInt(7));
				receiptEntity.setProducer(rs.getString("producer"));
				receiptEntity.setTotal(rs.getDouble(9));
				lsReceiptEntities.add(receiptEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(ptmt!=null) {
					ptmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lsReceiptEntities;
	}

}
