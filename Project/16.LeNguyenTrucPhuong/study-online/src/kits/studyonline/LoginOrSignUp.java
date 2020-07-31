package kits.studyonline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.studyonline.dao.DaoUser;
import kits.studyonline.entity.UserEntity;

public class LoginOrSignUp implements LoginSignUp {
	static int role=2 ;
	static String s1;
	@Override
	public void loginOrSignUp() {
		// TODO Auto-generated method stub
		System.out.println("========== Login or Sign up !!!============ \n 1.Login \t 2.Sign up");
		Scanner sc = new Scanner(System.in);
		int sc1=sc.nextInt();
		if (sc1==1) {
			login();

		}
		else {
			signUp();
		}
		

	}
	@Override
	public boolean checkUserPass() {
		System.out.print("UserName : \t");
		Scanner sc = new Scanner(System.in);
		String sc1 =sc.next();
		System.out.print("Password : \t");
		String sc2 =sc.next();
		DaoUser d =new DaoUser();
		List<UserEntity> ls = new ArrayList();
		ls=d.findUserPass(sc1, sc2);
		if (ls.size()==0) {
			return false;	
		}

		role =d.findUserPass1(sc1, sc2);
		System.out.println(role);
		return true;
	}
	@Override
	public void login() {
		// TODO Auto-generated method stub
		int i=0;
		while(checkUserPass()==false) {
			System.out.println("Invalid password or username ");
			System.out.println("please again");
			i++;
			if(i>2) {
				System.out.println("=======================login failed ========================");
				System.exit(0);
				
			}
		}

			System.out.println("==============Login success!!!==============");
			if (role==0) {
			 User user =new User();
			}
			else {
				Admin admin =new Admin();
			}
			
		}
		
		
	
	@Override
	public boolean checkUserName() {
		// TODO Auto-generated method stub
		 DaoUser daouser = new DaoUser();
		System.out.println("input UserName");
		Scanner sc = new Scanner(System.in);
		s1 =sc.next();		
		List<UserEntity> ls = new ArrayList();
		ls = daouser.findUser(s1);
		
			if (ls.size()==0) {
				return true;
			}
			
			return false;
	}
	@Override
	public void signUp() {
		// TODO Auto-generated method stub
		System.out.println("you don't have account");
		
		while(checkUserName()==false) {
			System.out.println("Account was exist");
			//Check_UserName() ;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("in put Password");
		String sc2 =sc.next();
		
		UserEntity userentity =new UserEntity();
		userentity.setName(s1);
		userentity.setPwd(sc2);

		
		 DaoUser daouser = new DaoUser();
		daouser.add(userentity);
		System.out.println("Sign up success!!!");
		login();
	}

	


}
	



