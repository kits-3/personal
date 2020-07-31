package kits.studyonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.studyonline.config.ConnectionFactory;
import kits.studyonline.entity.UserEntity;

public class DaoUser {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	public DaoUser(){
		
	}
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public void add(UserEntity userentrity) {
		// TODO Auto-generated method stub
		
		try {
			String queryString="INSERT INTO "
					+"user(id,name,pwd,role)"
					+ "VALUES(?,?,?,?)";
					
			connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, userentrity.getId());
			ptmt.setString(2,userentrity.getName() );
			ptmt.setString(3,userentrity.getPwd());
			ptmt.setInt(4, userentrity.getRole());
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}	
		}	
	}

	public void  delete(int id) {
		try {
			String queryString = "delete from user where "
					
					+ "id=?";
			connection =getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,id);
			ptmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public List<UserEntity> findAll() {
		List<UserEntity> lsUser = new ArrayList();
		try {
			String queryString = "SELECT * FROM user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery(); //Select

			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " \t "
						+resultSet.getString("name") + " \t\t "
						+resultSet.getInt("role")) ;
			} 
			} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				if(resultSet !=null) {
					resultSet.close();
				}
				if(ptmt != null) {
					ptmt.close(); //dong ptmt
				}
				if (connection != null) {
					connection.close();//dong ket noi
					
				}
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

		return lsUser;
	}
	public List<UserEntity> findUserPass(String user, String pass) {
		List<UserEntity> lsUser = new ArrayList();
		try {
			String queryString = "SELECT * FROM user where name=? and pwd=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			ptmt.setString(2, pass);
			resultSet = ptmt.executeQuery(); //Select

			while(resultSet.next()) {
				UserEntity lsUserEntity = new UserEntity();
				lsUserEntity.setId(resultSet.getInt("id"));
				lsUserEntity.setName(resultSet.getString("name"));
				lsUserEntity.setPwd(resultSet.getString("pwd"));
				lsUserEntity.setRole(resultSet.getInt("role"));
				lsUser.add(lsUserEntity);
			} 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				if(resultSet !=null) {
					resultSet.close();
				}
				if(ptmt != null) {
					ptmt.close(); //dong ptmt
				}
				if (connection != null) {
					connection.close();//dong ket noi
					
				}
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		return lsUser;
		
	}
	public int findUserPass1(String user, String pass) {
		List<UserEntity> lsUser = new ArrayList();
		int c =0;
		try {
			String queryString = "SELECT role FROM user where name=? and pwd=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			ptmt.setString(2, pass);
			resultSet = ptmt.executeQuery(); //Select
		while(resultSet.next()) {
			c=resultSet.getInt("role");
		} 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				if(resultSet !=null) {
					resultSet.close();
				}
				if(ptmt != null) {
					ptmt.close(); //dong ptmt
				}
				if (connection != null) {
					connection.close();//dong ket noi
					
				}
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		return c;
		
	}
	public List<UserEntity> findUser(String user) {
		List<UserEntity> lsUser = new ArrayList();
		try {
			String queryString = "SELECT * FROM user where name=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			resultSet = ptmt.executeQuery();
			while(resultSet.next()) {
				UserEntity lsUserEntity = new UserEntity();
				lsUserEntity.setId(resultSet.getInt("id"));
				lsUserEntity.setName(resultSet.getString("name"));
				lsUserEntity.setPwd(resultSet.getString("pwd"));
				lsUserEntity.setRole(resultSet.getInt("role"));
				lsUser.add(lsUserEntity);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				if(resultSet !=null) {
					resultSet.close();
				}
				if(ptmt != null) {
					ptmt.close(); //dong ptmt
				}
				if (connection != null) {
					connection.close();//dong ket noi
					
				}
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		return lsUser;
		
	}
	public List<UserEntity> findIdUser(int id) {
		List<UserEntity> lsUser = new ArrayList();
		try {
			String queryString = "SELECT * FROM user where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet = ptmt.executeQuery();
			while(resultSet.next()) {
				UserEntity lsUserEntity = new UserEntity();
				lsUserEntity.setId(resultSet.getInt("id"));
				lsUserEntity.setName(resultSet.getString("name"));
				lsUserEntity.setPwd(resultSet.getString("pwd"));
				lsUserEntity.setRole(resultSet.getInt("role"));
				lsUser.add(lsUserEntity);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				if(resultSet !=null) {
					resultSet.close();
				}
				if(ptmt != null) {
					ptmt.close(); //dong ptmt
				}
				if (connection != null) {
					connection.close();//dong ket noi
					
				}
			} 
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		return lsUser;
		
	}
}
