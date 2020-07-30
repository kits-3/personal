package implement;

import java.util.List;

import dto.Student;

public interface studentImpl {
	public int save(Student s);
	public int update(Student s);
	public List<Student> view();
	public void outPut();
	public Student getStudentByRollno(int rollno);
	public Student getStudentByName(String name);
	public void delete(int rollno);
	public List<Student> due();
}
