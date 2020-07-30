package Entity;

public class AccountEntity {
 private int Account_id;
 private String username;
 private String password;
 private int Role_id;
public AccountEntity(int account_id, String username, String password, int role_id) {
	super();
	Account_id = account_id;
	this.username = username;
	this.password = password;
	Role_id = role_id;
}
public int getAccount_id() {
	return Account_id;
}
public void setAccount_id(int account_id) {
	Account_id = account_id;
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
public int getRole_id() {
	return Role_id;
}
public void setRole_id(int role_id) {
	Role_id = role_id;
}

}
