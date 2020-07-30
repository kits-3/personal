package kits.learnvocab.dto;

import java.io.Serializable;

public class TopicDto implements Serializable{
	private int id;
	private String name;
	public TopicDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TopicDto() {
		super();
		// TODO Auto-generated constructor stub
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
