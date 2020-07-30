package Main;
import java.util.Scanner;

public class Home {
	public void Home(boolean check) {
		
		Scanner scan = new Scanner(System.in);
		
		Admin login = new Admin();
		
		Viewer view = new Viewer();
	
		while(check) {
			System.out.print("Do you want to login? (y/n): ");
			String log = scan.next();
			if(log.equalsIgnoreCase("y")) {
				login.Login(true);			
			}else {
				view.Viewer(true);
				break;
			}
			
		}scan.close();
	}
}
