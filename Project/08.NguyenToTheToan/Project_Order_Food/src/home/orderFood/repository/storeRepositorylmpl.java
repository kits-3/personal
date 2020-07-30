package home.orderFood.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.orderFood.config.ConnectionFactory;
import home.orderFood.entity.storeEntity;

public class storeRepositorylmpl implements storeRepository {
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;	
	}
	@Override
	public List<storeEntity> findAll() {
		List<storeEntity> lsStore =new ArrayList<storeEntity>();
		String queryString ="SELECT * FROM store";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery();//select
			while(rs.next()) {
				storeEntity ad = new storeEntity();					
				ad.setId(rs.getInt("id"));
				ad.setNameStore(rs.getString("nameProduct"));
				ad.setNameStore(rs.getString("nameStore"));
				lsStore.add(ad);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		return lsStore;
	}
	@Override
	public List<String>  get() {
		//TODO Auto-generated method stub
		String queryString ="SELECT nameStore from store";
//		storeEntity ad =new storeEntity();
		List<String> list = new ArrayList<>();
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			
			
			rs = stmt.executeQuery();//Select
			while(rs.next()) {
				list.add(rs.getString("nameStore"));
			}
			return list;
			
		}catch(SQLException n) {
			n.printStackTrace();
			System.err.println("No database connection");
		}
		return null;
	}
	
	
	@Override
	public storeEntity findById(int id) {
		return null;
	}
	
	@Override
	public int update() {
		//TODO auto-generated method stub
		return 0;
	}
	@Override
	public int delete() {
		//TODO Auto-generated method stub
		return 0;
		
	}
	@Override
	public void add(storeEntity e) {
		// TODO Auto-generated method stub
		
	}
		
	
	
	
}
