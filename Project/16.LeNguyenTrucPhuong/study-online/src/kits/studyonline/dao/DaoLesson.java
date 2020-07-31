package kits.studyonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.studyonline.config.ConnectionFactory;
import kits.studyonline.entity.LessonEntity;


public class DaoLesson {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	public DaoLesson() {
		
	}
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public void add(LessonEntity lessonentrity) {
		try {
			String queryString="INSERT INTO "
					+ "lesson(id,name,id_topic,body) "
					+ "Values(?,?,?,?)";
			
			connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, lessonentrity.getId());
			ptmt.setString(2,lessonentrity.getName() );
			ptmt.setInt(3, lessonentrity.getId_topic());
			ptmt.setString(4, lessonentrity.getBody());
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
	
	public void updateName(int id,String name) {
		try {
			String queryString="update lesson set "
					+"name=? where id=?";
					connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,name);
			ptmt.setInt(2, id);
			ptmt.executeUpdate();
		}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
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
	public void updateIdTopic(int id,int id_topic) {
		try {
			String queryString="update lesson set "
					+"id_topic=? where id=?";
					connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,id_topic);
			ptmt.setInt(2, id);
			ptmt.executeUpdate();
		}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
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
	public void updateBody(int id,String body) {
		try {
			String queryString="update lesson set "
					+"body=? where id=?";
					connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,body);
			ptmt.setInt(2, id);
			ptmt.executeUpdate();
		}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
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
	
	public void delete(String name,int id_topic) {
		try {String queryString = "delete from lesson where "
				
				+ "name=? and id_topic=?";
		connection =getConnection();
		ptmt = connection.prepareStatement(queryString);
		ptmt.setString(1, name);
		ptmt.setInt(2,id_topic);
		ptmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public List<LessonEntity> findLesson(int id_topic,int id){
		List<LessonEntity> lsLesson=new ArrayList();
		try {
			String queryString = "SELECT * FROM lesson where id_topic=?and id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_topic);
			ptmt.setInt(2, id);
			resultSet = ptmt.executeQuery(); //Select
			while(resultSet.next()) {
				LessonEntity lsLessonEntity = new LessonEntity();
				lsLessonEntity.setId(resultSet.getInt("id"));
				lsLessonEntity.setName(resultSet.getString("name"));
				lsLessonEntity.setId_topic(resultSet.getInt("id_topic"));
				lsLessonEntity.setBody(resultSet.getString("body"));
				lsLesson.add(lsLessonEntity);
				System.out.println(resultSet.getInt("id") +"\t"
						+resultSet.getString("name") +"\t"
						+resultSet.getString("body") +"\t"
						
						);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lsLesson;
		
	}
	public List<LessonEntity> findLesson(int id_topic){
		List<LessonEntity> lsLesson=new ArrayList();
		try {
			String queryString = "SELECT * FROM lesson where id_topic=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_topic);
			//ptmt.setInt(2, id);
			resultSet = ptmt.executeQuery(); //Select
			while(resultSet.next()) {
				LessonEntity lsLessonEntity = new LessonEntity();
				lsLessonEntity.setId(resultSet.getInt("id"));
				lsLessonEntity.setName(resultSet.getString("name"));
				lsLessonEntity.setId_topic(resultSet.getInt("id_topic"));
				lsLessonEntity.setBody(resultSet.getString("body"));
				lsLesson.add(lsLessonEntity);
				System.out.println(resultSet.getInt("id") +"\t"
						+resultSet.getString("name") +"\t"
						//+resultSet.getString("body") +"\t"
						
						);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lsLesson;
		
	}
	public List<LessonEntity> findLesson(int id_topic,String name){
		List<LessonEntity> lsLesson=new ArrayList();
		try {
			String queryString = "SELECT * FROM lesson where id_topic=? and name=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_topic);
			ptmt.setString(2, name);
			//ptmt.setInt(2, id);
			resultSet = ptmt.executeQuery(); //Select
			while(resultSet.next()) {
				LessonEntity lsLessonEntity = new LessonEntity();
				lsLessonEntity.setId(resultSet.getInt("id"));
				lsLessonEntity.setName(resultSet.getString("name"));
				lsLessonEntity.setId_topic(resultSet.getInt("id_topic"));
				lsLessonEntity.setBody(resultSet.getString("body"));
				lsLesson.add(lsLessonEntity);
				System.out.println(resultSet.getInt("id") +"\t"
						+resultSet.getString("name") +"\t"
						+resultSet.getString("body") +"\t"
						
						);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lsLesson;
		
	}
public List<LessonEntity> findAll(){
		List<LessonEntity> lsLesson=new ArrayList();
		try {
			String queryString = "SELECT * FROM lesson";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery(); //Select
			
			while(resultSet.next()) {
				LessonEntity lsLessonEntity = new LessonEntity();
				lsLessonEntity.setId(resultSet.getInt("id"));
				lsLessonEntity.setName(resultSet.getString("name"));
				lsLessonEntity.setId_topic(resultSet.getInt("id_topic"));
				lsLessonEntity.setBody(resultSet.getString("body"));
				lsLesson.add(lsLessonEntity);
			}

			
		}
		catch (Exception e) {
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
		
		return lsLesson;
		
	}
	
	

}
