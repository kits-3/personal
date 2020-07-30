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
import kits.learnvocab.dto.UserDto;

public class LanguageDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	static String langAdd;
	static String langDelete;
	static String langUpdate;
	static int idUpdate;
	
	public LanguageDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public List<LanguageDto> findAll() {
		List<LanguageDto> dtoList = new ArrayList<LanguageDto>();
		try {
			String queryString = "SELECT * FROM language";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				LanguageDto lstp = new LanguageDto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setLang((resultSet.getString("lang")));
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
	public void add(LanguageDto dto){
		while(checkAddLang()==false) {
			System.out.println("The language you have entered is duplicated, "
					+ "please enter another language");
		}try {
			String queryString ="INSERT INTO language(id, lang) VALUES (?,?)";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,dto.getId());
			ptmt.setString(2,langAdd);
			
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
		System.out.println("add language success");
	}
	public boolean checkAddLang() {
		List<LanguageDto> ls = new ArrayList();
		LanguageDao ladao = new LanguageDao();
		ls = ladao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Input language you want to add");
		langAdd = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(langAdd.equals(ls.get(i).getLang())) {	
				
				return false;
			}
			
		}		
		return true;
}
	public boolean checkDeleteLang() {
		List<LanguageDto> ls = new ArrayList();
		LanguageDao ladao = new LanguageDao();
		ls = ladao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter language above you want to delete");
		langDelete = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(langDelete.equals(ls.get(i).getLang())) {	
				
				return true;
			}
			
		}		
		return false;
}
	public boolean checkUpdateLang() {
		List<LanguageDto> ls = new ArrayList();
		LanguageDao ladao = new LanguageDao();
		ls = ladao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of language you want to update");
		langUpdate = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(langUpdate.equals(ls.get(i).getLang())) {			
				return true;
			}		
		}		
		return false;
}
	public boolean checkIdUpdateLang(int a) {
		List<LanguageDto> ls = new ArrayList();
		LanguageDao ladao = new LanguageDao();
		ls = ladao.findAll();	
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

	public void delete(LanguageDto id) {
		while(checkDeleteLang()==false) {
			System.out.println("The name of language you entered does not exit, ");
		}
		try {
			String queryString ="delete from language where lang =?";		
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);											
			ptmt.setString(1,langDelete);		
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
		System.out.println("Delete language "+ langDelete +" success");
	}
	public void update(LanguageDto dto) {
	while(checkUpdateLang()==true) {
		System.out.println("your language you entered is duplicated");
	}		
		try {
			String queryString ="update language set lang=? where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);			
			ptmt.setString(1,langUpdate);
			while(checkIdUpdateLang(idUpdate)==false) {
				System.out.println("id ko ton tai");
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