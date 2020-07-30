package project;

import java.util.Scanner;

import dao.StudentDao;
import dao.UserDao;
import dto.Student;
import dto.User;

public class UserBranch {
	public static void Student() {
		StudentDao studentDao = new StudentDao();
		Student student = new dto.Student();
		UserDao userDao = new UserDao();
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		int choose3;
		do {
			showMenuStudent();
			choose3 = scanner.nextInt();
			switch (choose3) {
			case 1:
				student.input();
				studentDao.save(student);
				break;
			case 2:
				student.input1();
				studentDao.update(student);
				break;
			case 3:
				studentDao.view();
				break;
			case 4:
				System.out.print("Input Id To Delete: ");
				int idDel = scanner.nextInt();
				studentDao.delete(idDel);
				break;
			case 5:
				System.out.println("Input Id To Search:");
				int idSearch = scanner.nextInt();
				studentDao.getStudentByRollno(idSearch);
				break;
			case 6:
				System.out.println("Input Name To Search:");
				String idString = scanner.next();
				studentDao.getStudentByName(idString);
				break;
			case 7:
				studentDao.due();
				break;
			case 8:
				user.input2();
				userDao.update(user);
				System.out.println("Update Successful!!!!");
				break;
			case 9:
				studentDao.outPut();
				break;
			case 10:
				System.err.println("Exit!!!");
				break;
			default:
				System.err.println("Fail!!!");
				break;
			}
		} while (choose3 != 10);
	}
	public static void showMenuStudent() {
		System.out.println(
				"1.Add Student------2.Update Student------3.View Student------4.Delete Student------5.Search By Id");
		System.out.println(
				"6.Search By Name------7.View Student Debt------8.Edit Your Account------9.Print to txt------10.Exit");
		System.out.print("Choose:  ");
	}
}
