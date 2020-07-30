package dung.dto;

public class Output {
	public Output(int id, int or_id, int users_id, String status_name) {
		this.id = id;
		this.or_id = or_id;
		this.users_id = users_id;
		this.status_name = status_name;
	}
	
	public Output() {}
	
	private int id;
	private int or_id;
	private int users_id;
	private String status_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOr_id() {
		return or_id;
	}
	public void setOr_id(int or_id) {
		this.or_id = or_id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public String toString() {
		String print = "Id: "+id+"\tOr_id: "+or_id+"\tUsers_id: "+users_id+"\tStatus_name: "+status_name;
		return print;
	}

}
