package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.dao.TopicDao;
import kits.learnvocab.dao.UserDao;
import kits.learnvocab.dto.TopicDto;
import kits.learnvocab.dto.UserDto;

public class Login {
	static int role;
	static String user;
	private static boolean checkUser_Pass(){
		List<UserDto> ls = new ArrayList();
		UserDao usdao = new UserDao();
		ls = usdao.findAll();	
		Scanner sc = new Scanner(System.in);
		System.out.println("Input username");
		user = sc.next();
		System.out.println("Input pass");
		String pass = sc.next();
		for (int i =0; i < ls.size(); i++) {
			if(user.equals(ls.get(i).getUsername())&& pass.equals(ls.get(i).getPassword())) {
				role = ls.get(i).getRole();
				
				return true;
			}
			//System.out.println(ls.get(i).getUsername()+"\t"+ ls.get(i).getPassword());
		}
		
		
		
		
		return false;
	}
	
	public static void Login() {
		while(checkUser_Pass()==false) {
			System.out.println("Invalid username or password ");
		}
		System.out.println("login sucess");
		if (role==0) {
			System.out.println("Hello " +user);
			User user = new User();
			
		}
		if(role == 1) {
			System.out.println("Hello " +user);
			Admin admin = new Admin();
		}
	}
//	public static void main(String[] args) {
////		Login();
//		
//	}
}
