package Entity;

public class EmployeeEntity{
	private int Emp_id;
	private String Emp_name;
	private String Email;
	private String Phone;
	private int Salary;
	private int Account_Id;
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeEntity( String Emp_name, String Email, String Phone , int Salary, int Account_Id) {
		super();
		
		this.Emp_name = Emp_name;
		this.Email = Email;
		this.Phone = Phone;
		this.Salary = Salary;
		this.Account_Id = Account_Id;
	}
	
	public int getEmp_id() {
		return Emp_id;
	}
	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}
	public String getEmp_name() {
		return Emp_name;
	}
	public void setEmp_name(String emp_name) {
		Emp_name = emp_name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public int getAccount_Id() {
		return Account_Id;
	}
	public void setAccount_Id(int account_Id) {
		Account_Id = account_Id;
	}
}