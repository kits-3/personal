package kits.studyonline.entity;

import java.io.Serializable;

public class CourseEntity implements Serializable{
	private int id;
	private String name;
	public CourseEntity(){
		 super();
		 
	 }
	public CourseEntity(int id, String name) {
		super();
		this.id=id;
		this.name=name;
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

}
