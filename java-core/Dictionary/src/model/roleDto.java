package model;

public class roleDto {
	private Integer id;
	private String name;

	public roleDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public roleDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
