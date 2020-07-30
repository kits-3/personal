package Entity;

public class languageDto {
	private Integer id;
	private String name;

	public languageDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public languageDto() {
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
