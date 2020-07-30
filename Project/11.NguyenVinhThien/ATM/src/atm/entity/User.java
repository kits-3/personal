package atm.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	private int status;
	private String create_at;
	
	public static int session_id;
	public static String session_user;
	
	public User() {
		this.status = 1;
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_at = dateOnly.format(cal.getTime());
	}
	
	public User(int id, String usname) {
		session_id = id;
		session_user = usname;
	}

	public User(int id, String name, String username, String password, int status, String create_at) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.status = status;
		this.create_at = create_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	
}
