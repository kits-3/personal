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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class book {
    private int idUser;
    private int idRoom;
    private String dateIn;
    private String dateOut;
    public static Connection connection = null;
   	public static PreparedStatement ptmt = null;
   	public ResultSet resultSet = null;
   	
   	private static Connection getConnection() throws SQLException{
   		Connection conn;
   		conn = ConnectionFactory.getInstance().getConnection();
   		return conn;
   		}
       
    public book(){}

    public book(int idUser, int idRoom, String dateIn, String dateOut) {
        this.idUser = idUser;
        this.idRoom = idRoom;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public static ArrayList<book> BookList(){
        ArrayList<book> list = new ArrayList<>();
        try{
        // Lấy ra đối tượng Connection kết nối vào DB.
                 
        	connection = getConnection();
            // Tạo đối tượng Statement.
        
            
            String sql = "Select * from book;";
            ptmt = connection.prepareStatement(sql);

            
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
            ResultSet rs = ptmt.executeQuery(sql);
            
            // Duyệt trên kết quả trả về.
            while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
                int idUser = rs.getInt(2);
                int intRoom = rs.getInt(3);
                String dateIn = rs.getString(4);
                String dateOut = rs.getString(5);
                book book1 = new book(idUser, intRoom, dateIn, dateOut);
                list.add(book1);
              
            }
            connection.close();
        } catch(Exception e){System.out.println(e);}
        return list;
    }
    public ArrayList<room> showAvailableRoom()
    {
    	ArrayList<room> list = new ArrayList<>();
    	try {
    		connection = getConnection();
    		String queryString ="Select * from book";
    		ptmt = connection.prepareStatement(queryString);
    		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    					
		return null;    	
    }
    

    public ArrayList<room> showAvailableRoom(String inDate, String outDate, String type){
      	 ArrayList<room> list = new ArrayList<>();
           try{
           	  String sql="\r\n" + 
           	  		"Select * from rooms where type ='queen' and id NOT IN (Select idRoom from book WHERE  (dateIn <= '"+inDate+"' AND dateOut >= '"+inDate+"') OR (dateIn <='"+outDate+"' AND dateOut>='"+inDate+"'));";
               // Lấy ra đối tượng Connection kết nối vào DB.
          	 	connection = getConnection();          
               Scanner keyboard = new Scanner(System.in);           
               SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");  
               ptmt = connection.prepareStatement(sql);
               ResultSet rs = ptmt.executeQuery(sql);
               while (rs.next()) {
               	int idR = rs.getInt(1);
                   String numRoom = rs.getString(2);
                   int price = rs.getInt(3);
                   String typeF = rs.getString(4);
                   int status = rs.getInt(5);
                   room room1 = new room(idR, numRoom, price, typeF, status);
                   list.add(room1);	
                  
               }
           }catch(Exception e){}
           return list;
      }    
    public int getIdUser() {
        return this.idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public int getIdRoom() {
        return this.idRoom;
    }
    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

}