/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ObjectInputStream.GetField;
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
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String role;
    public static Connection connection = null;
	public static PreparedStatement ptmt = null;
	public ResultSet resultSet = null;
	public static User user = new User();
	
	private static Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
		}
    
    public User(){}
    
    public User(int id, String username, String password,String email, String fullname, String role){
        this.id = id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.fullname=fullname;
        this.role=role;
    }
    
    public void login(){
    	
        Scanner keyboard = new Scanner(System.in);

        ArrayList<User> list = UserList();
        String warning="";
        boolean userExist=false;
        boolean loginSuccess=false;
        String yesNo="N";
        String name, pass;

        do {
            System.out.println("\n========================");
            System.out.println("Login menu");
            System.out.print("Username: ");
            name = keyboard.nextLine();
            System.out.print("Password: ");
            pass = keyboard.nextLine();
            warning="";

            if(name.length() == 0){
                warning="Username cannot be empty.";
            } else {
                for(int i=0;i<list.size();i++){
                    if(name.equals(list.get(i).getName()) ){
                        warning+="\nUsername is correct.";
                        userExist=true;
                        user=list.get(i);
                        break;
                    }
                }
                if(userExist==false){
                    warning+="\nUser does not exist.";
                }
            }

            if(pass.length() == 0){
                warning+="\nPassword cannot be empty.";
            } else {
                if(pass.equals(user.getPassword())){
                    warning+="\nPassword is correct.";
                    loginSuccess=true;
                } else {
                    warning+="\nPassword is incorrect.";
                    user=new User();
                }
            }
            System.out.println(warning);

            if(!(user.isNull())){
                System.out.println("Login successful");                      
                this.id=user.id;
                this.username=user.username;
                this.password=user.password;
                this.email=user.email;
                this.fullname=user.fullname;
                this.role=user.role;
                yesNo="N";
            } else {
                System.out.println("Login failed.");
                System.out.println("Retry? Y/N");
                yesNo = keyboard.nextLine();
            }
        } while(yesNo.equals("Y")||yesNo.equals("y"));
    }
    
    public void register(){
        try{
            // Lấy ra đối tượng Connection kết nối vào DB.
           connection = getConnection();       
            Scanner keyboard = new Scanner(System.in);
            Statement statement = connection.createStatement();
            
            ArrayList<User> list = UserList();
            customer customer = new customer();
            String yesNo="N";
            
            String sql ="";
            String warning="";
            boolean registerOk=false;
            
            do {
                System.out.println("\n========================");
                System.out.println("Register menu");
                System.out.print("Username: ");
                String username = keyboard.nextLine();
                System.out.print("Password: ");
                String password = keyboard.nextLine();
                System.out.print("Email: ");
                String email = keyboard.nextLine();
                System.out.print("Fullname: ");
                String fullname = keyboard.nextLine();

                if(username.length() == 0){
                    warning="Username cannot be empty.";
                } else {
                    for(int i=0;i<list.size();i++){
                        if(username.equals(list.get(i).getName()) ){
                            warning+="\nUsername already exists.";
                            break;
                        }
                    }
                }

                if(password.length() == 0){
                    warning+="\nPassword cannot be empty.";
                }

                if(email.length() == 0){
                    warning+="\nEmail cannot be empty.";
                } else {
                    for(int i=0;i<list.size();i++){
                        if(email.equals(list.get(i).getEmail()) ){
                            warning+="\nEmail is already used.";
                            break;
                        }
                    }
                }

                if(fullname.length() == 0){
                    warning+="\nFullname cannot be empty.";
                }

                System.out.println(warning);
                
                if(warning.length()==0){
                    System.out.println("Register successful");
                    sql = "Insert into users(username, password, email, fullname, role) values('"+ username+ "','"+password+"','"+email+"','"+fullname+"','customer');";    
                    statement.executeUpdate(sql);
                    Hotel_Management.procLogin();
                    
                    
                   
                } else {
                    System.out.println("Register failed.");
                }

                if(sql.equals("")){
                    System.out.println("Retry? Y/N");
                    yesNo = keyboard.nextLine();
                }
            } while(yesNo.equals("Y")||yesNo.equals("y"));
            connection.close();
            } catch(Exception e){System.out.println(e);}
    }
    
    public boolean isNull(){
        boolean isNull=false;
        if(this.username==null){
            isNull=true;
        }
        return isNull;
    }
    
    public static ArrayList<User> UserList(){
        ArrayList<User> list = new ArrayList<>();
        try{
        // Lấy ra đối tượng Connection kết nối vào DB.
              
            
            // Tạo đối tượng Statement.
        	  connection = getConnection();   
        	

            String sql = "Select * from users;";
            ptmt = connection.prepareStatement(sql);
            
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
            ResultSet rs = ptmt.executeQuery(sql);
            
            // Duyệt trên kết quả trả về.
            while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
                int id = rs.getInt(1);
                String userName = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                String fullname = rs.getString(5);
                String role = rs.getString(6);
                User user1 = new User(id, userName, password, email, fullname, role);
                list.add(user1);
            }
            connection.close();
        } catch(Exception e){System.out.println(e);}
        return list;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public String getFullname(){
        return this.fullname;
    }
    public String getRole(){
        return this.role;
    }
    
    public void setName(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public void setRole(String role){
        this.role=role;
    }
}