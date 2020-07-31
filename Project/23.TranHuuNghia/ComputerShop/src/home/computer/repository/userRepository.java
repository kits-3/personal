package home.computer.repository;

public interface userRepository {
	boolean signInUser(String u, String p);
	boolean signUpUser(String u, String p);
	
}
