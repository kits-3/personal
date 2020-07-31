package kits.studyonline;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.studyonline.dao.DaoCourse;
import kits.studyonline.dao.DaoLesson;
import kits.studyonline.dao.DaoTopic;
import kits.studyonline.entity.CourseEntity;
import kits.studyonline.entity.LessonEntity;
import kits.studyonline.entity.TopicEntity;

public class Admin {
	static String sc2;
	static String sc3;
	static String sc4;
	static int c2;
	static int c3;
	static int c4;
	static int c6;
	
	Admin(){
		manage();
		
	}
	private  void manage() {
		System.out.println("you choose manage \n 1 .Course \n 2 .User");
		System.out.print("your choice \t");
		Scanner sc = new Scanner(System.in);
		int sc1 = sc.nextInt();
		if (sc1==1) {
			ManageCourseAdmin m =new ManageCourseAdmin();
			m.course();
		}
		else {
			ManageUserAdnin m=new ManageUserAdnin();
			m.user();
		}
	}


	
	
}


	 
	 
	 
	


//}

	 
	



