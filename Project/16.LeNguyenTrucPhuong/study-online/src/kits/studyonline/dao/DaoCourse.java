package kits.studyonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.studyonline.config.ConnectionFactory;
import kits.studyonline.entity.CourseEntity;

public class DaoCourse {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	public DaoCourse() {
		
	}
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public void add(CourseEntity courseentrity) {
		try {
			String queryString="INSERT INTO "
							+ " course(id,name)"
							+ " VALUEs(?,?) ";
			connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, courseentrity.getId());
			ptmt.setString(2,courseentrity.getName() );
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
	public void update(CourseEntity courseentrity) {}
	public void delete(int id) {
		try {
			String queryString = "delete from course where "
					//+ "course(id=?,name=?)";
					+ " id=? ";
					//+ "name=?";
			connection =getConnection();
			ptmt = connection.prepareStatement(queryString);
			//ptmt.setInt(1, courseentrity.getId());
			ptmt.setInt(1,id);
			ptmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public List<CourseEntity> findAll() {
		List<CourseEntity> lsCourse = new ArrayList();
		try {
			String queryString = "SELECT * FROM course";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery(); //Select

			while(resultSet.next()) {
				CourseEntity lsCourseEntity = new CourseEntity();
				
				lsCourseEntity.setId(resultSet.getInt("id"));
				lsCourseEntity.setName(resultSet.getString("name"));
				lsCourse.add(lsCourseEntity);
				System.out.println(resultSet.getInt("id") +" \t "
						+resultSet.getString("name")
						);
			
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
		return lsCourse;
		
	}
	public List<CourseEntity> findName(String name ) {
		List<CourseEntity> lsCourse = new ArrayList();
		try {
			String queryString = "SELECT * FROM course where name=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, name);
			resultSet = ptmt.executeQuery(); //Select

			while(resultSet.next()) {
				CourseEntity lsCourseEntity = new CourseEntity();
				
				lsCourseEntity.setId(resultSet.getInt("id"));
				lsCourseEntity.setName(resultSet.getString("name"));
				lsCourse.add(lsCourseEntity);
			
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
		return lsCourse;
		
	}
	public List<CourseEntity> findId(int id) {
		List<CourseEntity> lsCourse = new ArrayList();
		try {
			String queryString = "SELECT * FROM course where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet = ptmt.executeQuery(); //Select

			while(resultSet.next()) {
				CourseEntity lsCourseEntity = new CourseEntity();
				
				lsCourseEntity.setId(resultSet.getInt("id"));
				lsCourse.add(lsCourseEntity);
			
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
		return lsCourse;
		
	}
}
