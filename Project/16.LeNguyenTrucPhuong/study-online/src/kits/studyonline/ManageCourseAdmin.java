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

public class ManageCourseAdmin implements ManageCourse {
	static String sc2;
	static String sc3;
	static String sc4;
	static int c2;
	static int c3;
	static int c4;
	static int c6;
	@Override
	public boolean continue1() {
		// TODO Auto-generated method stub
		System.out.println("you choose \n 1 .Continue \n 2 .end");
		 Scanner sc = new Scanner(System.in);
		 int sc3 =sc.nextInt();
		 if (sc3==2) {
			 
				System.out.println("Bye");
				return true;
		}
		return false;
	}

	@Override
	public boolean CheckCourse() {
		// TODO Auto-generated method stub
		 DaoCourse daocourse = new DaoCourse();		 
		 List<CourseEntity> ls = new ArrayList();
		 System.out.println("input name of course");
		 Scanner sc = new Scanner(System.in);
		 sc2 =sc.nextLine();
		 ls=daocourse.findName(sc2);
		 if (ls.size()==0) {
			 return true;
			
		}
		 return false;
		 
	}

	@Override
	public boolean CheckIdCourse() {
		// TODO Auto-generated method stub
		 DaoCourse daocourse = new DaoCourse();		 
		 List<CourseEntity> ls = new ArrayList();
		 System.out.println("input Id of course");
		 Scanner sc = new Scanner(System.in);
		 c2 =sc.nextInt();
		 ls=daocourse.findId(c2);
		 if (ls.size()==0) {
			 return true;
		}
		 return false;
	}

	@Override
	public int chooseCourse() {
		// TODO Auto-generated method stub
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

	@Override
	public void course() {
		DaoCourse daocourse =new DaoCourse();
		List<CourseEntity> ls1 = new ArrayList();
		System.out.println("=================course==============");
		ls1=daocourse.findAll();
		 System.out.println("you want \n 1 .Add Course \n 2 .Delete Course \n 3 .Topic \n 4 .Manage User \n ");
		 System.out.print("your choice \t");
		 Scanner sc = new Scanner(System.in);
		 int sc1 = sc.nextInt();
		 CourseEntity courseentity = new CourseEntity();
		 if (sc1==1) {
			 while (CheckCourse()==false) {
				
				 System.out.println(" Course was exist!!!"); 
			}
			 courseentity.setName(sc2);
			 daocourse.add(courseentity);
			 System.out.println("Add Course success!!!");
			 if (continue1()==false) {
				 course();
			}
			 System.exit(0);
		}
		 else if (sc1==2) {
			 List<CourseEntity> ls = new ArrayList();
			 ls=daocourse.findAll();

			 while (CheckIdCourse()==true) {
					
				 System.out.println(" don't have Course!!!"); 
			}
			 daocourse.delete(c2);
			 System.out.println("Delete Course success!!!");
			 if (continue1()==false) { 
				 course();
			} 
			 System.exit(0);
		}
		 else if (sc1==3) {
			 topic();
		 }
		 else if (sc1==4) {
			 ManageUserAdnin m=new ManageUserAdnin();
				m.user();
			 
		 }

	}

	@Override
	public boolean checkTopic(int a) {
		// TODO Auto-generated method stub
		 DaoTopic daotopic = new DaoTopic();	 
		 List<TopicEntity> ls = new ArrayList();
		 System.out.println("input name of topic");
		 Scanner sc = new Scanner(System.in);
		 sc3 =sc.nextLine();
		 ls=daotopic.findTopic(a,sc3);
		 if (ls.size()==0) {
			 return true;
		}
		 return false;
	}

	@Override
	public boolean checkIdTopic(int a) {
		// TODO Auto-generated method stub
		 DaoTopic daotopic = new DaoTopic();	 
		 List<TopicEntity> ls = new ArrayList();
		 System.out.print("input ID of topic :\t");
		 Scanner sc = new Scanner(System.in);
		 c3 =sc.nextInt();
		 ls=daotopic.findTopicId(c3,a);
		 System.out.println(ls.size());
		 if (ls.size()==0) {
			 return true;
			
		}
		 return false;
	}

	@Override
	public void topic() {
		// TODO Auto-generated method stub
		 int a=0;
		 a=chooseCourse();
		 //System.out.println(a);

		 	TopicEntity topicentity =new TopicEntity();
		 	DaoTopic daotopic = new DaoTopic();
			List<TopicEntity> ls = new ArrayList();
			System.out.println("=========topic of course======");
			ls=daotopic.findTopic(a);
			 System.out.println("you want \n 1 .Add Topic \n 2 .Delete Topic \n 3 .Lesson \n 4 .Update \n 5 .Manage User");
			 System.out.print("your choice \t");
			 Scanner sc = new Scanner(System.in);
			 int sc1 = sc.nextInt();
				 if (sc1==1) {
					 while (checkTopic(a) ==false) {
						
						 System.out.println(" Topic was exist!!!"); 
					}
					 topicentity.setName(sc3);
					 topicentity.setId_course(a);
					 daotopic.add(topicentity);
					 System.out.println("Add Topic success!!!");
					 if (continue1()==true)  {
						 System.exit(0);
					}
					 topic();
			}
				 else if (sc1==2) {
					 while (checkIdTopic(a) ==true) {
						 System.out.println(" don't have Topic!!!"); 
					}
					 daotopic.delete(c3,a);
					 System.out.println("Delete Topic success!!!");
					 if (continue1()==true)  {
						 System.exit(0);
					}
					 topic();
				}
				 else if (sc1==3) {
					 while (checkIdTopic(a) ==true) {
						 System.out.println(" don't have Topic!!!"); 
					}
					 lesson(c3);
				 }
				 else if (sc1==4) {
					 while (checkIdTopic(a) ==true) {
						 System.out.println(" don't have Topic!!!"); 
					}
					 updateTopic(c3);
					 if (continue1()==true)  {
						 System.exit(0);
					}
					 topic();
				 }
				 else if (sc1==5) {
					 ManageUserAdnin m=new ManageUserAdnin();
						m.user(); 
				 }
	}
	@Override
	public void updateTopic(int b) {
		// TODO Auto-generated method stub
		TopicEntity topicentity =new TopicEntity();
	 	DaoTopic daotopic = new DaoTopic();
		List<TopicEntity> ls = new ArrayList();
		System.out.println("id \tName \tId_course"  );
		ls=daotopic.findTopicId(b);
				 System.out.println("=====================================\nyou want \t 1.Name \t 2 .Id_course");
				 System.out.print("your choice \t");
				 Scanner sc = new Scanner(System.in);
				 int sc6=sc.nextInt();
				 if (sc6==1) {
					 while (checkLesson(b) ==false) {
						 System.out.println(" Topic was exist!!!"); 
					}
					daotopic.updateName(b,sc4);
					 System.out.println("update success!!!");
					 if (continue1()==true)  {
						 System.exit(0);
					}
					 updateTopic(b);
				}
				 else if (sc6==2) {
					 while (CheckIdCourse()==true) {
						 System.out.println(" id_course wasn't exist");  
					}
					 daotopic.updateIdCoursec(b, c2);
					 System.out.println("update success!!!");
					 if (continue1()==true)  {
						 System.exit(0);
					}
					 updateTopic(b);
					}
				 else if (sc6==3) {

					 if (continue1()==true)  {
						 System.exit(0);
					}
				 }
	}

	@Override
	public boolean checkLesson(int b) {
		// TODO Auto-generated method stub
		 LessonEntity lessonentity =new LessonEntity();
		 	DaoLesson daolesson = new DaoLesson();
		 System.out.println("input name of Lesson");
		 Scanner sc = new Scanner(System.in);
		 sc4 =sc.nextLine();
		 List< LessonEntity> ls = new ArrayList();
			ls=daolesson.findLesson(b,sc4);
			if (ls.size()==0) {
				return true;
				
			}
		 return false;
	}

	@Override
	public boolean checkIdLesson(int b) {
		// TODO Auto-generated method stub
		 	DaoLesson daolesson = new DaoLesson();
		 System.out.println("input id of Lesson");
		 Scanner sc = new Scanner(System.in);
		 c4 =sc.nextInt();
		 List< LessonEntity> ls = new ArrayList();
			ls=daolesson.findLesson(b,c4);
			 if (ls.size()==0) {
				 return true;
			}
		 return false;
	}

	@Override
	public boolean checkIdTopic() {
		// TODO Auto-generated method stub
		 DaoTopic daotopic = new DaoTopic();	 
		 List<TopicEntity> ls = new ArrayList();
		 System.out.print("input ID of topic :\t");
		 Scanner sc = new Scanner(System.in);
		 c6 =sc.nextInt();
		 ls=daotopic.findTopicId(c6);
		 for (int i = 0; i < ls.size(); i++) {
			if (ls.size()==0) { 
				//System.out.println(ls.get(i).getId() +"\t"+ls.get(i).getName()  );
				
				return true;
				 }
		}
		 return false;
	}

	@Override
	public void lesson(int b) {
		// TODO Auto-generated method stub

		LessonEntity lessonentity =new LessonEntity();
	 	DaoLesson daolesson = new DaoLesson();
		List< LessonEntity> ls = new ArrayList();
		ls=daolesson.findLesson(b);
		System.out.println("============lesson of topic============");
		for (int i =0; i < ls.size(); i++) { 
			
			System.out.println(ls.get(i).getId() +"\t"+ls.get(i).getName() );
			}
			System.out.println("you want \n 1 .Add Lesson \n 2 .Delete Lesson \n 3 .Update ");
			System.out.print("your choice \t");
			 Scanner sc = new Scanner(System.in);
			 int sc1 = sc.nextInt();
			 if (sc1==1) {
				 while (checkLesson(b) ==false) {
					
					 System.out.println(" Lesson was exist!!!"); 
				}
				 System.out.print("in put body : \t");
				 String s=sc.nextLine();
				 lessonentity.setBody(s);
				 lessonentity.setName(sc4);
				 lessonentity.setId_topic(b);
				 daolesson.add(lessonentity);
				 System.out.println("Add Lesson success!!!");
				 if (continue1()==true)  {
					 System.exit(0);
				}
				 lesson(b);
				 
		}	
			 else if (sc1==2) {
				 ls=daolesson.findAll();
				 while (checkIdLesson(b) ==true) {
					 System.out.println(" don't have Lesson!!!"); 
				}
				 daolesson.delete(sc4,b);
				 System.out.println("Delete Lesson success!!!");
				 if (continue1()==true)  {
					 System.exit(0);
				}
				 //topic();
				
			}
			 else if (sc1==3) {
				 updateLesson( b); 
			 } 
			}
 
	@Override
	public void updateLesson(int b) {
		// TODO Auto-generated method stub

		 LessonEntity lessonentity =new LessonEntity();
		 	DaoLesson daolesson = new DaoLesson();
			List< LessonEntity> ls = new ArrayList();
			ls=daolesson.findLesson(b);
			System.out.println("============lesson of topic============");
			for (int i =0; i < ls.size(); i++) { 
				System.out.println(ls.get(i).getId() +"\t"+ls.get(i).getName() );
				}

		 System.out.println("you choose Id Lesson!");
		 Scanner sc = new Scanner(System.in);
		 int sc5=sc.nextInt();
		 for (int j =0; j < ls.size(); j++) { 
			 if (sc5==ls.get(j).getId()) {
				 System.out.println("id \tName \tId_topic \tBody"  );
				 System.out.println(ls.get(j).getId() +"\t"+ls.get(j).getName()+"\t"+b+"\t\t"+ls.get(j).getBody()   );
				 System.out.println("=====================================\nyou want \t 1.Name \t 2 .Id_topic \t 3 .Body");
				 System.out.print("your choice \t");
				 int sc6=sc.nextInt();
				 if (sc6==1) {
					 while (checkLesson(b) ==true) {
						 System.out.println(" name wasn exist!!!"); 
					}
			
					daolesson.updateName(sc5,sc4);
					 System.out.println("update success!!!");
					 if (continue1()==true)  {
						 System.exit(0);
					}
					 updateLesson(b);
				}
				 else if (sc6==2) {
					 while (checkIdTopic() ==true) {
						 System.out.println(" id_Topic wasn't exist!!!"); 
					}
					 
					 daolesson.updateIdTopic(sc5, c6);
					 System.out.println("update success!!!");
					 if (continue1()==true)  {
						 System.exit(0);
					}
					 updateLesson(b);
					}
				 else if (sc6==3) {
					 System.out.print("In put \t");
					 String sc7=sc.next();
					 daolesson.updateBody(sc5, sc7);
					 System.out.println("update success!!!");
					 if (continue1()==true)  {
						 System.exit(0);
					}
					 updateLesson(b);
				 }
			}
		
			} 

		 }

	


}
