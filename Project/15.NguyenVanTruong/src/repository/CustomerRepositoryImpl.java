package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectSQL;
import entity.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {
	private  Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn =null;
		conn = ConnectSQL.getInstance().getConnection();
		return conn;
		
	}
	

	@Override
	public List<Customer> findAll() {
		List<Customer> lscus = new ArrayList();
		String sql = "select * from customer";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);					
			rs = ptmt.executeQuery();
			while(rs.next()) {
				Customer cus = new Customer();
				cus.setId_customer(rs.getInt(1));			
				cus.setId_user(rs.getInt(2));			
				cus.setName_customer(rs.getString("name_customer"));
				cus.setMoney(rs.getInt(4));			
				cus.setNumberphone(rs.getString("numberphone"));
				cus.setMail(rs.getString("mail"));		
	
				lscus.add(cus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
				if(rs !=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lscus;
	}

	@Override
	public List<Customer> findById(int id_customer) {
		List<Customer> lsCusById = new ArrayList();
		String sql = "select * from customer where id_customer=?";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1, id_customer);
			rs = ptmt.executeQuery();
			while(rs.next()) {
			Customer cus = new Customer();
			
			cus.setId_user(rs.getInt(2));
			cus.setName_customer(rs.getString("name_customer"));
			cus.setNumberphone(rs.getString("numberphone"));
			cus.setMail(rs.getString("mail"));
			cus.setMoney(rs.getInt(6));
			lsCusById.add(cus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection !=null) {
					connection.close();
				}
				if(rs!= null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lsCusById;
	}

	@Override
	public void update(Customer cus) {
		//Customer cus = new Customer();
		String sql = "update customer set name_customer=?,"+"money=?,"+"numberphone=?,"+"mail=? where id_customer=?";
		try {
			
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			
			ptmt.setString(1,cus.getName_customer());
			ptmt.setInt(2, cus.getMoney());
			ptmt.setString(3, cus.getNumberphone());
			ptmt.setString(4,cus.getMail());
			ptmt.setInt(5, cus.getId_customer());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ptmt!= null) {
					ptmt.close();
				}
				if(connection != null) {
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
	public void delete(int id_customer) {
		String sql = "delete from customer where id_customer=?";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1,id_customer);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ptmt!= null) {
					ptmt.close();
				}
				if(connection != null) {
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
	public void add(Customer cus) {
		String sql = "INSERT INTO "+"customer(name_customer,money,numberphone,mail)"
	+"VALUES(?,?,?,?)";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
		
			ptmt.setString(1, cus.getName_customer());
			ptmt.setInt(2, cus.getMoney());
			ptmt.setString(3, cus.getNumberphone());
			ptmt.setString(4, cus.getMail());
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
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}


	@Override
	public void updateMoney(Customer cus) {
		String sql = "UPDATE customer set money=? where id_customer=?";
		try {
			connection =getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1, cus.getMoney());
			ptmt.setInt(2, cus.getId_customer());
			ptmt.executeUpdate();
			
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
			} catch (SQLException e) {
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
