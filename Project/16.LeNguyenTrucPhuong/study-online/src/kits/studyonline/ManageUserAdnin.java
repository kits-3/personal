package kits.studyonline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.studyonline.dao.DaoUser;
import kits.studyonline.entity.UserEntity;

public class ManageUserAdnin implements ManageUser {
	static String sc1;
	static int c;
	@Override
	public void user() {
		// TODO Auto-generated method stub
			
			List<UserEntity> ls = new ArrayList();
			DaoUser daouser =new DaoUser();
			System.out.println("Id \t Username \t Role");
			ls=daouser.findAll();
			

			System.out.println("you want \n 1 .Add admin \n 2 .Delete user \n 3 .Manage Course");
			 System.out.print("your choice :\t");
			 Scanner sc = new Scanner(System.in);
			 int c =sc.nextInt();
			 if (c==1) {
				 addAdmin();
			}
			 else if (c==2) {
				 deleteUser();
			 }
			 else if (c==3) {
				 ManageCourseAdmin m =new ManageCourseAdmin();
				 m.course();
				
			}
			
			}
	@Override
	public void addAdmin() {
		// TODO Auto-generated method stub
		while(checkUserName()==false) {
			System.out.println("Account was exist");
			//Check_UserName() ;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("in put Password");
		String sc2 =sc.next();
		
		UserEntity userentity =new UserEntity();
		userentity.setName(sc1);
		userentity.setPwd(sc2);
		userentity.setRole(1);

		
		 DaoUser daouser = new DaoUser();
		daouser.add(userentity);
		System.out.println("Sign up success!!!");
		if (continue1()==false) {
			 System.exit(0);
		}
		user();
		
	}
	
		@Override
	public boolean checkUserName() {
			// TODO Auto-generated method stub
			 DaoUser daouser = new DaoUser();
				System.out.println("input UserName");
				Scanner sc = new Scanner(System.in);
				sc1 =sc.next();		
				List<UserEntity> ls = new ArrayList();
				ls = daouser.findUser(sc1);
				if (ls.size()==0) {
					return true;
				}

				return false;
		}
	@Override
	public boolean continue1() {
		// TODO Auto-generated method stub
		System.out.println("you  \n 1 .Continue \n 2 .end");
		 Scanner sc = new Scanner(System.in);
		 int sc3 =sc.nextInt();
		 if (sc3==2) {
			 
				System.out.println("Bye");
				return false;
		}
		return true;
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		while(checkIdUserName()==false) {
			System.out.println("Account wasn't exist");
		}
		DaoUser daouser = new DaoUser();
		daouser.delete(c);
		System.out.println("Delete Course success!!!");
		if (continue1()==false) {
			 System.exit(0);
		}
		user();
		
	}
	@Override
	public boolean checkIdUserName() {
		// TODO Auto-generated method stub
		List<UserEntity> ls = new ArrayList();
		DaoUser daouser = new DaoUser();
		System.out.println("input Id of UserName");
		Scanner sc = new Scanner(System.in);
		 c=sc.nextInt();
		ls = daouser.findIdUser(c);
		
			if (ls.size()==0) {
				return false;
			}

			return true;
	
	

	

}}

