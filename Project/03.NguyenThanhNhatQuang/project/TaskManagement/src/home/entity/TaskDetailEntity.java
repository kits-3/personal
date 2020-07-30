package home.entity;

public class TaskDetailEntity {
	private int id;
	private String content;
	private int task_id;
	private String create_date;
	private String update_date;
	private String delete_date;
	private int status;
	private int display;
	private String description;
	
	public TaskDetailEntity() {
		super();
	}

	public TaskDetailEntity(int id, String content, int task_id, String create_date, String update_date,
			String delete_date, int status, int display, String description) {
		super();
		this.id = id;
		this.content = content;
		this.task_id = task_id;
		this.create_date = create_date;
		this.update_date = update_date;
		this.delete_date = delete_date;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
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
