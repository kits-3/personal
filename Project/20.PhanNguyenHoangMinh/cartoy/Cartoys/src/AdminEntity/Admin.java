package AdminEntity;

public class Admin {
	
	private int id;
	private String admin_name;
	private String password;
	
	public Admin(int id, String name, String password) {

		this.id = id;
		this.admin_name = name;
		this.password = password;
	}

	public Admin() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return admin_name;
	}

	public void setName(String name) {
		this.admin_name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
