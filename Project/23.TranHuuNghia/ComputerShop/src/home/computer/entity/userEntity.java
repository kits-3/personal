package home.computer.entity;

public class userEntity {
	private int id;
	private String User;
	private String Password;
	private String Type;
	
	public userEntity() {
		super();
	}

	public userEntity(int id, String user, String password, String type) {
		super();
		this.id = id;
		User = user;
		Password = password;
		Type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
	
}
