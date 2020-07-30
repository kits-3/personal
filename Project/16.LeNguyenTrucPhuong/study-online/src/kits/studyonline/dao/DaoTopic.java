package kits.studyonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.studyonline.config.ConnectionFactory;
import kits.studyonline.entity.TopicEntity;

public class DaoTopic {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	public DaoTopic() {
		
		// TODO Auto-generated constructor stub
	}
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public void add(TopicEntity topicentrity) {
		try {
			String queryString="INSERT INTO "
							+ " topic(id,name,id_course)"
							+ " VALUEs(?,?,?) ";
			connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, topicentrity.getId());
			ptmt.setString(2,topicentrity.getName() );
			ptmt.setInt(3, topicentrity.getId_course());
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
			String queryString="update topic set "
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
	public void delete(int id,int id_course) {
		try {
			String queryString = "delete from topic where "
					
					+ "id=? and id_course=?";
			connection =getConnection();
			ptmt = connection.prepareStatement(queryString);
			//ptmt.setInt(1, courseentrity.getId());
			ptmt.setInt(1,id);
			ptmt.setInt(2,id_course);
			ptmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void updateIdCoursec(int id,int id_course) {
		try {
			String queryString="update topic set "
					+"id_course=? where id=?";
					connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,id_course);
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
	public List<TopicEntity> findTopic(int id_course,String name){
		List<TopicEntity> lsTopic = new ArrayList();
		try {
			String queryString = "SELECT * FROM topic where id_course=? and name=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_course);
			ptmt.setString(2, name);
			resultSet = ptmt.executeQuery(); //Select
			while(resultSet.next()) {
				TopicEntity lsTopicEntity = new TopicEntity();

				lsTopicEntity.setId(resultSet.getInt("id"));
				lsTopicEntity.setName(resultSet.getString("name"));
				lsTopicEntity.setId_course(resultSet.getInt("id_course"));
				
				lsTopic.add(lsTopicEntity);
				System.out.println(resultSet.getInt("id") +" \t "
						+resultSet.getString("name") +" \t "
						+resultSet.getInt("id_course")
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
		
		return lsTopic;
		
	}
	public List<TopicEntity> findTopic(int id_course){
		List<TopicEntity> lsTopic = new ArrayList();
		try {
			String queryString = "SELECT * FROM topic where id_course=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_course);
			//ptmt.setString(2, name);
			resultSet = ptmt.executeQuery(); //Select
			while(resultSet.next()) {
				TopicEntity lsTopicEntity = new TopicEntity();

				lsTopicEntity.setId(resultSet.getInt("id"));
				lsTopicEntity.setName(resultSet.getString("name"));
				lsTopicEntity.setId_course(resultSet.getInt("id_course"));
				
				lsTopic.add(lsTopicEntity);
				System.out.println(resultSet.getInt("id") +" \t "
						+resultSet.getString("name") +" \t "
						//+resultSet.getInt("id_course")
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
		
		return lsTopic;
		
	}
	public List<TopicEntity> findTopicId(int id,int id_course){
		List<TopicEntity> lsTopic = new ArrayList();
		try {
			String queryString = "SELECT * FROM topic where id=? and id_course=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.setInt(2, id_course);
			resultSet = ptmt.executeQuery(); //Select
			while(resultSet.next()) {
				TopicEntity lsTopicEntity = new TopicEntity();

				lsTopicEntity.setId(resultSet.getInt("id"));
				lsTopicEntity.setName(resultSet.getString("name"));
				lsTopicEntity.setId_course(resultSet.getInt("id_course"));
				
				lsTopic.add(lsTopicEntity);

//				System.out.println(resultSet.getInt("id") +" \t "
//						+resultSet.getString("name") +" \t "
//						+resultSet.getInt("id_course")
//						);
//			
				
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
		
		return lsTopic;
	}
		

	public List<TopicEntity> findTopicId(int id){
		List<TopicEntity> lsTopic = new ArrayList();
		try {
			String queryString = "SELECT * FROM topic where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet = ptmt.executeQuery(); //Select
			while(resultSet.next()) {
				TopicEntity lsTopicEntity = new TopicEntity();

				lsTopicEntity.setId(resultSet.getInt("id"));
				lsTopicEntity.setName(resultSet.getString("name"));
				lsTopicEntity.setId_course(resultSet.getInt("id_course"));
				
				lsTopic.add(lsTopicEntity);
				System.out.println(resultSet.getInt("id") +" \t "
						+resultSet.getString("name") +" \t "
						//+resultSet.getInt("id_course")
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
		
		return lsTopic;
		
	}
	public List<TopicEntity> findAll(){
		List<TopicEntity> lsTopic = new ArrayList();
		try {
			String queryString = "SELECT * FROM topic t ,course c where t.id_course=c.id";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery(); //Select

			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id") +" \t "
						+resultSet.getString("name") +" \t "
						+resultSet.getInt("id_course")
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
		
		return lsTopic;
		
	}
	
	
	

}
