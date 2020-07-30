
import java.util.Scanner;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;  
public class Hotel_Management {

	// make method for each menu
    public static void procLogin(){
    	Scanner sc = new Scanner(System.in);
    	User user1 = new User();	
    	String role = null;
    	int choice;
    	user1.login();
		if(user1.getRole().equals("customer"))
		{
			do {
				customer cus = new customer(user1.getId(),user1.getName(),user1.getPassword(),user1.getEmail(),user1.getFullname(),user1.getRole());
    			System.out.println("Customer Menu");
    			System.out.println("1.Book rooms");
    			System.out.println("2.Quit");
    			System.out.println("Your choice: ");
    			choice= sc.nextInt();
    			if(choice==1)
    			{
    				cus.book();
    				
    			}
    			else if(choice==2)
    			{
    				break;
    			}
			}
			while(choice!=1);	
		}

		else if(user1.getRole().equals("Admin"))
		{
			do {
				Admin admin = new Admin(user1.getId(),user1.getName(),user1.getPassword(),user1.getEmail(),user1.getFullname(),user1.getRole());
				room room1 = new room();
				System.out.println("Admin Menu");
    			System.out.println("1.Set role");
    			System.out.println("2.Create room");
    			System.out.println("3.Quit");
    			System.out.println("Your choice: ");
    			choice = sc.nextInt();
    			if(choice==1)
    			{

    				admin.setRole1();
    				choice=0;
    			}
    			else if(choice==2)
    			{
    				room1.insertRoom();
    				choice=0;
    				
    			}
    			else if(choice==3)
    			{
    				break;
    			}
			}
			while(choice!=1);	
		}
    }
    private static void procRegister(){
    	User user1 = new User();
    	user1.register();	
	}
    public static boolean procExit(boolean a){
    	System.out.println("Quit");
    	return a = false;
	}
    public static void main(String[]args) {// presentate program flow, no logic
    	Scanner sc ;
    	Admin admin1 = new Admin();
    	int choice ;
    	boolean a =true;
		// start on console
		while(a){
			try {
				sc = new Scanner(System.in);
				System.out.println("Welcome to CHIEDOE hotel");
				System.out.println("1.Log in\n2.Register\n3.Quit");
				System.out.println("Your choice is: ");
				choice = sc.nextInt();
				if( choice == 1){
					procLogin();
				}if(choice == 2){
					procRegister();
					
				}
				a=procExit(a);
			
			}
				
			catch (InputMismatchException e) {
				e.printStackTrace();
			}
			
		// end on console
			}
    }
}