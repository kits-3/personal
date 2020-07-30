package pj.tour.entity;

public class UserEntity {
	private int id;
	private String name;
	private String gmail;
	private String sex;
	private String birthday;
	private String phoneNumber;
	private String address;
	
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(int id, String name, String gmail, String sex, String birthday, String phoneNumber,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.gmail = gmail;
		this.sex = sex;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.address = address;
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
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
