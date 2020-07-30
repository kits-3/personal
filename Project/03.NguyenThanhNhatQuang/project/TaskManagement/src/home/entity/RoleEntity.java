package home.entity;

public class RoleEntity {
	private int id;
	private String name;
	private int display;
	private String description;
	
	public RoleEntity() {
		super();
	}
	
	public RoleEntity(int id, String name, int display, String description) {
		super();
		this.id = id;
		this.name = name;
		this.display = display;
		this.description = description;
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