package project.management;

import java.util.Scanner;

import project.management.task.ILoginChoose;
import project.management.task.impl.LoginChoose;

public class ControlAndManagement {
// 이 클래스의 멤버 필드인 loginChoose 를 다른 클래스(객체)에서 사용하지 않을 것이므로 반드시 private 접근 지정을 한다.... 
	private ILoginChoose loginChoose;

	public ControlAndManagement() {
		// 여기 생성자가 있으므로 필드에 초기화는 여기서 한다.....
		this.loginChoose = new LoginChoose();

		// 생성자에서 처리를 작성하지 않는다...
	}
// 실행할 내용(logic)은 별도 method 로 따로 만드세요

	public void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("choose: 1.customer  2.staff 3.Out program");
		System.out.println("input: 1 or 2 or 3");

		String key = scan.next();
		loginChoose.loginOption(key);
		// have to close stream
		// Scanner 다른 객체에서 new 생성하면 close() 된 상태에서 new 하면 error 발생 ...... 조심할 것
		scan.close();

	}
// 깊게 생각하고 빠르게 행동하라....
// 마음은 급하고 몸은 느리면 프로젝트는 망가진다아~~~~~~~~~~

}
