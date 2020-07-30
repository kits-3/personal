package home.entity;

public class TaskEntity {
	private int id;
	private String header;
	private int owner;
	private String create_date;
	private String update_date;
	private String delete_date;
	private String deadline_date;
	private int status;
	private int display;
	private String description;
	
	public TaskEntity() {
		super();
	}

	public TaskEntity(int id, String header, int owner, String create_date, String update_date, String delete_date,
			String deadline_date, int status, int display, String description) {
		super();
		this.id = id;
		this.header = header;
		this.owner = owner;
		this.create_date = create_date;
		this.update_date = update_date;
		this.delete_date = delete_date;
		this.deadline_date = deadline_date;
		this.status = status;
		this.display = display;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getDelete_date() {
		return delete_date;
	}

	public void setDelete_date(String delete_date) {
		this.delete_date = delete_date;
	}

	public String getDeadline_date() {
		return deadline_date;
	}

	public void setDeadline_date(String deadline_date) {
		this.deadline_date = deadline_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
