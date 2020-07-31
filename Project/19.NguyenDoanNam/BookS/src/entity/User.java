package entity;

public class User {

	private String Gmail;
	private int Password;
	private int Id_role;
	private int Status;
	private int Money;
	public User() {

	}

	public User(String gmail, int password, int id_role, int status, int money) {
		Gmail = gmail;
		Password = password;
		Id_role = id_role;
		Status = status;
		Money = money;
	}

	public String getGmail() {
		return Gmail;
	}

	public void setGmail(String gmail) {
		Gmail = gmail;
	}

	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}

	public int getId_role() {
		return Id_role;
	}

	public void setId_role(int id_role) {
		Id_role = id_role;
	}

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		Money = money;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

}
