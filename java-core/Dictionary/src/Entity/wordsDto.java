package Entity;

public class wordsDto {
	private Integer id;
	private String content;
	private String description;
	private String translation;
	private String example;
	private Integer language_id;

	public wordsDto(Integer id, String content, String description, String translation, String example,
			Integer language_id) {
		super();
		this.id = id;
		this.content = content;
		this.description = description;
		this.translation = translation;
		this.example = example;
		this.language_id = language_id;
	}

	public wordsDto() {
		super();
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public Integer getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}

}
