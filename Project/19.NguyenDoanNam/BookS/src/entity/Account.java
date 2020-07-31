package entity;

public class Account {

	private int Id_role;
	private String Role_name;
	
	public Account() {
	}

	public Account(int id_role, String role_name) {
		
		Id_role = id_role;
		Role_name = role_name;
	}

	public int getId_role() {
		return Id_role;
	}

	public void setId_role(int id_role) {
		Id_role = id_role;
	}

	public String getRole_name() {
		return Role_name;
	}

	public void setRole_name(String role_name) {
		Role_name = role_name;
	}
	
	
	
	
	
}
