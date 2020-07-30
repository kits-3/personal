package kits.studyonline.entity;

public class TopicEntity {
	private int id;
	private String name;
	private int id_course;
	public TopicEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TopicEntity(int id, String name,int id_course) {
		super();
		this.id=id;
		this.name=name;
		this.id_course=id_course;
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
	public int getId_course() {
		return id_course;
	}
	public void setId_course(int id_course) {
		this.id_course = id_course;
	}
	

}
