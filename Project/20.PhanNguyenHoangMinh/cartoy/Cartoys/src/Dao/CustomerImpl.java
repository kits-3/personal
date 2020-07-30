package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectionFactory.ConnectionFactory;
import entity.Customer;


public class CustomerImpl implements CustomerDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(Customer dto) {
		try {
			String queryString = "INSERT INTO customer(id,name,address,phone,order_item,total,order_date)"
					+ "VALUES(?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getName());
			ptmt.setString(3, dto.getAddress());
			ptmt.setString(4, dto.getPhone());
			ptmt.setInt(6, dto.getTotal());
			ptmt.setString(5, dto.getOrder_item());
			ptmt.setString(7, dto.getOrder_date());
			ptmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
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
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addName(String name) {
		try {
			String queryString = "INSERT INTO customer(name)"+ "VALUES(?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);

			ptmt.setString(1, name);

			ptmt.executeUpdate();
			
			Customer cust = new Customer();
			
			while (resultSet.next()) {

				cust.setName(resultSet.getString(2));
		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
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
	public void addAddress(String address) {
		try {
			String queryString = "INSERT INTO customer(address)"+ "VALUES(?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);

			ptmt.setString(2, address);

			ptmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
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
	public void addPhone(String phone) {
		try {
			String queryString = "INSERT INTO customer(phone)"+ "VALUES(?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);

			ptmt.setString(3, phone);

			ptmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

//	@Override
//	public void addId(int id) {
//		// TODO Auto-generated method stub
//		
//	}

//	public void update(Customer dto) {
//		try {
//			String queryString = "update customer set name=?"
//								 + "dprtmt_id=?"
//								 + "rank_id=? where id = ?";
//			connection = getConnection();
//			ptmt = connection.prepareStatement(queryString);
//			ptmt.setInt(1, dto.getId());
//			ptmt.setString(2, dto.getName());
//			ptmt.setString(3, dto.getAddress());
//			ptmt.setString(4, dto.getPhone());
//			ptmt.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				if (ptmt != null) {
//					ptmt.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
	public void delete(int id) {
		try {
			String queryString = "delete from customer where id = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);		
			ptmt.executeUpdate();
			System.out.println(" ");
			System.out.println(" Delete bill Success!!!");
			System.out.println(" ");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
//
//	public List<Customer> findAll() {
//		try {
//			String queryString = "select * from customer ";
//			connection = getConnection();
//			ptmt = connection.prepareStatement(queryString);
//			resultSet = ptmt.executeQuery();
//			List<Customer> dtoList = new ArrayList<Customer>();
//			int i=1;
//			while (resultSet.next()) {
//				
//				System.out.println("id: "+resultSet.getInt("id")
//								  +" name: "+resultSet.getString("name")
//								  +" address: "+resultSet.getString("address")
//								  +" phone: "+resultSet.getString("phone"));
//				i++;
//			}
//			return dtoList;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				if (resultSet != null) {
//					resultSet.close();
//				}
//				if (ptmt != null) {
//					ptmt.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//		
//	}
	
}

