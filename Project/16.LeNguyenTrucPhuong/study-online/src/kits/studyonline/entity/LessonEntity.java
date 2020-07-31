package kits.studyonline.entity;

public class LessonEntity {
	private int id;
	private String name;
	private int id_topic;
	private String body;
	public LessonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LessonEntity(int id,String name,int id_topic,String body) {
		super();
		this.id=id;
		this.name=name;
		this.id_topic=id_topic;
		this.body=body;
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
	public int getId_topic() {
		return id_topic;
	}
	public void setId_topic(int id_topic) {
		this.id_topic = id_topic;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
