package kits.studyonline;

public interface ManageCourse {
	boolean continue1();
	//boolean continue2();
	boolean CheckCourse();
	boolean CheckIdCourse();
	int chooseCourse();
	void course();
	boolean checkTopic(int a);
	boolean checkIdTopic(int a) ;
	void topic();
	void updateTopic(int b);
	boolean checkLesson(int b);
	boolean checkIdLesson(int b);
	boolean checkIdTopic();
	void lesson(int b) ;
	void updateLesson(int b);
}
