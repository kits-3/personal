package pj.tour.entity;

public class AccountEntity {
	private int id;
	private String username_ac;
	private String password_ac;
	private String nameaccount;
	private String date;
	private String access_right;
	

	public AccountEntity() {
		super();
	}
	
	public AccountEntity(int id, String username_ac, String password_ac, String nameaccount, String date, String access_right) {
		super();
		this.id = id;
		this.username_ac = username_ac;
		this.password_ac = password_ac;
		this.nameaccount = nameaccount;
		this.date = date;
		this.access_right = access_right;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername_ac() {
		return username_ac;
	}
	public void setUsername_ac(String username_ac) {
		this.username_ac = username_ac;
	}
	public String getPassword_ac() {
		return password_ac;
	}
	public void setPassword_ac(String password_ac) {
		this.password_ac = password_ac;
	}
	public String getNameaccount() {
		return nameaccount;
	}
	public void setNameaccount(String nameaccount) {
		this.nameaccount = nameaccount;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getAccess_right() {
		return access_right;
	}

	public void setAccess_right(String access_right) {
		this.access_right = access_right;
	}
}
