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
import kits.learnvocab.dto.NewDto;
import kits.learnvocab.dto.TableExtra1Dto;
import kits.learnvocab.dto.TopicDto;
import kits.learnvocab.dto.WordvnDto;

public class WordVnDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	static String nameAdd;
	static String nameDelete;
	static String nameUpdate;
	static int idUpdate;
	static String wordDelete;
	public WordVnDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public List<WordvnDto> findAll() {
		List<WordvnDto> dtoList = new ArrayList<WordvnDto>();
		try {
			String queryString = "SELECT * FROM word_vn";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				WordvnDto lswn = new WordvnDto();
				lswn.setId(resultSet.getInt("id"));
				lswn.setName((resultSet.getString("name")));
				dtoList.add(lswn);
				
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
	public  List<WordvnDto> findByTopic(int a) {
		List<WordvnDto> dtoList = new ArrayList<WordvnDto>();
		try {
			String queryString = "SELECT * from word_vn where topic_id=?   ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setInt(1, a);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				WordvnDto lstp = new WordvnDto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setName((resultSet.getString("name")));
				
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

	public void delete(TopicDto dto) {
		while(checkDeleteName()== false) {
			System.out.println("The name of topic you entered does not exit");
		}
		try {
			String queryString ="delete from word_vn where name =?";
			
		
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			Scanner sc = new Scanner(System.in);
			
		
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
		System.out.println("Delete word "+ wordDelete +" success");
	}
	public boolean checkAddWordVn() {
		List<WordvnDto> ls = new ArrayList();
		WordVnDao wndao = new WordVnDao();
		ls = wndao.findAll();	
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
	public void addWord_vn(WordvnDto dto){
		List<TopicDto> ls = new ArrayList();
		TopicDao tpdao = new TopicDao();
		ls = tpdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Input word you want to add");
		String wordAdd = sc.next();
	
		try {
			String queryString ="INSERT INTO word_vn(id, name, topic_id) VALUES (?,?,?)";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,dto.getId());
			ptmt.setString(2,wordAdd);
			
			ptmt.setInt(3,dto.getTopic_id());
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
		List<WordvnDto> ls = new ArrayList();
		WordVnDao wvdao = new WordVnDao();
		ls = wvdao.findAll();	
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

	public void delete(WordvnDto id) {
		while(checkDeleteName()==false) {
			System.out.println("The value of name you entered does not exit, ");
		}
		try {
			String queryString ="delete from word_vn where name =?";		
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
		List<WordvnDto> ls = new ArrayList();
		WordVnDao wvdao = new WordVnDao();
		ls = wvdao.findAll();	
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
		List<WordvnDto> ls = new ArrayList();
		WordVnDao wvdao = new WordVnDao();
		ls = wvdao.findAll();	
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
	public void update(WordvnDto dto) {
	while(checkUpdateName()==true) {
		System.out.println("your name's value you entered is duplicated");
	}		
		try {
			String queryString ="update word_vn set name=? where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);			
			ptmt.setString(1,nameUpdate);
			while(checkIdUpdateName(idUpdate)==false) {
				System.out.println("ID you choose is not exist, choose another");
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
		System.out.println("Updated success");
	}
}
