/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Duc
 * 
 */
public class Admin extends User {

    public Admin() {
		super();
	}
	public Admin(int id, String username, String password, String email,String fullname, String role){
        super(id, username, password, email, fullname, role);
    }
    public Connection connection = null;
	public PreparedStatement ptmt = null;
	public ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn; 
	}
	public void setRole1()
    {
    	System.out.println("List User");
    	System.out.println("N----UserName----Password----Email----FullName----Role");
    
    	int t=0;
    	for(User user1 : UserList()) {
    		t+=1;
    		System.out.println(t+"------"+user1.getName()+"-------"+user1.getPassword()+"-----"+user1.getEmail()+"--"+user1.getFullname()+"----"+user1.getRole());
        	}
    	Scanner sc = new Scanner(System.in);
    	System.out.print("input id user: ");
    	int id = sc.nextInt();
    	System.out.println("Set role into: ");
    	String role = sc.next();
    	try {
			String queryString ="Update users set role=? where idUser=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, role);
			ptmt.setInt(2, id);
			ptmt.executeUpdate();
			System.out.println("Update success");
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    


	
}
