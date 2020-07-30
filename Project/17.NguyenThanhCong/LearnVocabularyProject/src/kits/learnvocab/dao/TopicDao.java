package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.LanguageDto;
import kits.learnvocab.dto.TopicDto;

public class TopicDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	static String topicAdd;
	static String topicDelete;
	static String topicUpdate;
	static int idUpdate;
	public TopicDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	
	public List<TopicDto> findAll() {
		List<TopicDto> dtoList = new ArrayList<TopicDto>();
		try {
			String queryString = "SELECT * FROM topic";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				TopicDto lstp = new TopicDto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setName((resultSet.getString("name")));
				dtoList.add(lstp);
				
			}
			return dtoList;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return dtoList;
	}
	public boolean checkAddTopic() {
		List<TopicDto> ls = new ArrayList();
		TopicDao tpdao = new TopicDao();
		ls = tpdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Input topic name you want to add");
		topicAdd = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(topicAdd.equals(ls.get(i).getName())) {
				return false;
			}
		}
		return true;
	}
	public void add(TopicDto dto){
		while(checkAddTopic()==false) {
			System.out.println("The name of topic you have entered is duplicate, "
					+ "please enter another topic");
		}
		try {
			String queryString ="INSERT INTO topic(id, name) VALUES (?,?)";
			
		
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,dto.getId());
			ptmt.setString(2,dto.getName());
			
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		System.out.println("add topic success");
	}
	public boolean checkDeleteTopic() {
		List<TopicDto> ls = new ArrayList();
		TopicDao tpdao = new TopicDao();
		ls = tpdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter topic above you want to delete");
		topicDelete = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(topicDelete.equals(ls.get(i).getName())) {	
				
				return true;
			}
			
		}		
		return false;
}
	public void delete(TopicDto id) {
		while(checkDeleteTopic()== false) {
			System.out.println("The name of topic you entered does not exit");
		}
		try {
			String queryString ="delete from topic where name =?";
			
		
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			Scanner sc = new Scanner(System.in);
			
		
			ptmt.setString(1,topicDelete);
			
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		System.out.println("Delete topic "+ topicDelete +" success");
	}
	public boolean checkUpdateTopic() {
		List<TopicDto> ls = new ArrayList();
		TopicDao tpdao = new TopicDao();
		ls = tpdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of topic you want to update");
		topicUpdate = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(topicUpdate.equals(ls.get(i).getName())) {			
				return true;
			}		
		}		
		return false;
}
	public boolean checkIdUpdateTopic(int a) {
		List<TopicDto> ls = new ArrayList();
		TopicDao tpdao = new TopicDao();
		ls = tpdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		idUpdate = sc.nextInt();
		
		for (int i =0; i < ls.size(); i++) {
			if(idUpdate==ls.get(i).getId()) {			
				return true;
			}		
		}		
		return false;
}
	public void update(TopicDto dto) {
		while(checkUpdateTopic() == true) {
			System.out.println("your  topic's name  you entered is duplicated");
		}							
		try {
			String queryString ="update topic set name=? where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			Scanner sc = new Scanner(System.in);
			
		
			ptmt.setString(1,topicUpdate);
			while(checkIdUpdateTopic(idUpdate) == false) {
				System.out.println("id doesn't exist");
			}
			ptmt.setInt(2,idUpdate);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	}
	

