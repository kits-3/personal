package kits.learnvocab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import kits.learnvocab.dao.UserDao;
import kits.learnvocab.dto.UserDto;

public class SignUp {
	static UserDao usdao = new UserDao();
	static UserDto usdto = new UserDto();
	static String user;
	public static boolean checkUserName() {
		
		List<UserDto> ls = new ArrayList();
		
		ls = usdao.findAll();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("nhap username");
		user = sc.next();
//		System.out.println("nhap pass");
//		String pass = sc.next();
		
		for (int i =0; i < ls.size(); i++) {
			if(user.equals(ls.get(i).getUsername())) {
				return true;
				
			}
	}
		return false;
}
	public static void Sign_Up() {
		while(checkUserName()==true) {
			System.out.println("user name da ton tai ");
		}
		System.out.println("nhap pass");
		Scanner sc = new Scanner(System.in);
		String pass = sc.next();
		usdto.setUsername(user);
		usdto.setPassword(pass);
		usdao.add(usdto);
		System.out.println("Sign up success");
		System.out.println("Input username and password to login");
		Login lg = new Login();
		lg.Login();
		
	}
	public static void main(String[] args) {
		Sign_Up();
	}
}
