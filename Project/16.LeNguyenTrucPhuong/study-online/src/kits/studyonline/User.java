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


public class User {
	User (){
		//System.out.println("hello"); 
			
			int a=0;
			a=chooseCourse();
			int b=0;
			b=chooseTopic(a);
			otherLesson(a,b);
		}
	private int chooseCourse() {
			
		DaoCourse daocourse =new DaoCourse();
		List<CourseEntity> ls = new ArrayList();
		ls=daocourse.findAll();

		System.out.print("Course : ");
		Scanner sc = new Scanner(System.in);
		int sc1 = sc.nextInt();
		ls=daocourse.findId(sc1);
				if (ls.size()==1) {
					return sc1;	
				}
		return 0;
}
	private void chooseLesson(int a) {
		DaoLesson daolesson =new DaoLesson();
		List<LessonEntity> ls = new ArrayList();
		ls=daolesson.findAll();
		System.out.println("Choose lesson please !!!");
		for (int i =0; i < ls.size(); i++) { 
			if (a==ls.get(i).getId_topic()) {
				System.out.println(+ls.get(i).getId() +"\t" +ls.get(i).getName());
				
			}
			
		}
		System.out.print("Lesson : \t");
		Scanner sc = new Scanner(System.in);
		int sc1 = sc.nextInt();
		for (int i =0; i < ls.size(); i++) {
			if (sc1==ls.get(i).getId() ){
				System.out.println("==================" +ls.get(i).getName() +"==================");
				System.out.println(ls.get(i).getBody());
			}
		}

		
		


	}
	private int chooseTopic(int a) {
		TopicEntity topicentity =new TopicEntity();
	 	DaoTopic daotopic = new DaoTopic();
		List<TopicEntity> ls = new ArrayList();
		System.out.println("=========topic of course======");
		ls=daotopic.findTopic(a);
	System.out.print("Topic : \t");
	Scanner sc = new Scanner(System.in);
	int sc1 = sc.nextInt();
	ls=daotopic.findTopicId(sc1,a);
	
		if (ls.size()==1){
			return sc1;
			
		
	}
	return 0;


	
}
	private void otherLesson(int b, int a) {
		chooseLesson(a);
		System.out.println("======================================= \n1 .Lesson other \t 2 .end");
		Scanner sc = new Scanner(System.in);
		int sc2 = sc.nextInt();
		if(sc2==1) {
			otherLesson(b,a);
		}
		else {
			System.out.println("======================================= \n1 .Topic other \t 2 .end");
			int sc3 = sc.nextInt();
			if(sc3==1) {
				otherTopic(b);
			}
			else {
				System.out.println("bye");
			}
		}

		}
	private void otherTopic(int a) {
		int b=0;
		chooseTopic(a);
		otherLesson(a,b);
		
	}
	

	}

