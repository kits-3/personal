package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.ConnectWordDto;
import kits.learnvocab.dto.TopicDto;
import kits.learnvocab.dto.WordvnDto;

public class ConnectWordDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	static String nameAdd, nameDelete, nameUpdate;
	static int lang_id, idUpdate;
	
	public ConnectWordDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public List<ConnectWordDto> findAll() {
		List<ConnectWordDto> dtoList = new ArrayList<ConnectWordDto>();
		try {
			String queryString = "SELECT * FROM connectword where topic_id =1";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				ConnectWordDto lstp = new ConnectWordDto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setName((resultSet.getString("name")));
				lstp.setLang_id(resultSet.getInt("lang_id"));
				lstp.setVn_id(resultSet.getInt("vn_id"));
				lstp.setTopic_id(resultSet.getInt("topic_id"));
				
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
	
	public  List<ConnectWordDto> findByTopic() {
		List<ConnectWordDto> dtoList = new ArrayList<ConnectWordDto>();
		try {
			String queryString = "SELECT * FROM connectword where topic_id =1 ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			//ptmt.setInt(1, a);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				ConnectWordDto lstp = new ConnectWordDto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setName((resultSet.getString("name")));
				lstp.setLang_id((resultSet.getInt("lang_id")));
				lstp.setVn_id((resultSet.getInt("vn_id")));
				lstp.setTopic_id((resultSet.getInt("topic_id")));
				dtoList.add(lstp);

			}
			return dtoList;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
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
		
		return dtoList;
	}
	
	public boolean checkAddWordVn() {
		List<ConnectWordDto> ls = new ArrayList();
		ConnectWordDao cwdao = new ConnectWordDao();
		ls = cwdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Input word you want to add");
		nameAdd = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(nameAdd.equals(ls.get(i).getName())) {	
				
				return false;
			}
			
		}		
		return true;
}
	public boolean checkLangID() {
		
		System.out.println("Input lang_id ");
		Scanner sc = new Scanner(System.in);
		lang_id = sc.nextInt();
		if(lang_id==1) {
			return true;
		}
		return false;
	}
	public void addWord_vn(ConnectWordDto dto){
		List<TopicDto> ls = new ArrayList();
		TopicDao tpdao = new TopicDao();
		ls = tpdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Input word you want to add");
		String wordAdd = sc.next();
		
		while(checkLangID()==true ) {
			System.out.println("lang_id cannot equal 1");
		}
		 
		System.out.println("Input vn_id ");
		int vn_id = sc.nextInt();
		try {
			String queryString ="INSERT INTO connectword(id, name, lang_id, vn_id, topic_id)"
					+ " VALUES (?,?,?,?,?)";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,dto.getId());
			ptmt.setString(2,wordAdd);
			ptmt.setInt(3,lang_id);
			ptmt.setInt(4,vn_id);
			ptmt.setInt(5,dto.getTopic_id());
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
		System.out.println("add word success");
	}
	public boolean checkDeleteName() {
		List<ConnectWordDto> ls = new ArrayList();
		ConnectWordDao wvdao = new ConnectWordDao();
		ls = wvdao.findByTopic();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value's name above you want to delete");
		nameDelete = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(nameDelete.equals(ls.get(i).getName())) {	
				
				return true;
			}
			
		}		
		return false;
}
	public void delete(ConnectWordDto id) {
		while(checkDeleteName()==false) {
			System.out.println("The value of name you entered does not exit, ");
		}
		try {
			String queryString ="delete from connectword where name =?";		
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);											
			ptmt.setString(1,nameDelete);		
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
		System.out.println( nameDelete +" was removed success");
	}
	public boolean checkUpdateName() {
		List<ConnectWordDto> ls = new ArrayList();
		ConnectWordDao cwdao = new ConnectWordDao();
		ls = cwdao.findByTopic();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name's value you want to update");
		nameUpdate = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(nameUpdate.equals(ls.get(i).getName())) {			
				return true;
			}		
		}		
		return false;
}
	public boolean checkIdUpdateName(int a) {
		List<ConnectWordDto> ls = new ArrayList();
		ConnectWordDao cwdao = new ConnectWordDao();
		ls = cwdao.findByTopic();	
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
	public void update(ConnectWordDto dto) {
	while(checkUpdateName()==true) {
		System.out.println("your name's value you entered is duplicated");
	}		
		try {
			String queryString ="update connectword set name=?, lang_id=?, vn_id=?, topic_id=? where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);			
			ptmt.setString(1,nameUpdate);
			while(checkIdUpdateName(idUpdate)==false) {
				System.out.println("ID you choose is not exist, choose another");
			}
			Scanner sc =new Scanner(System.in);
			while(checkLangID()==true ) {
				System.out.println("lang_id cannot equal 1");
			}
			ptmt.setInt(2,lang_id);
			System.out.println("input vn_id");
			int vn_id = sc.nextInt();
			ptmt.setInt(3,vn_id);
			System.out.println("input topic_id");
			int topic_id = sc.nextInt();
			ptmt.setInt(4,topic_id);
			ptmt.setInt(5,idUpdate);
			
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
		System.out.println("Updated success");
	}
}
