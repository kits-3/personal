package kits.learnvocab.dto;

import java.io.Serializable;
import java.util.List;

public class WordvnDto implements Serializable{
	private int id;
	private String name;
	private int topic_id;
	
	
	


	public WordvnDto(int id, String name, int topic_id) {
		super();
		this.id = id;
		this.name = name;
		this.topic_id = topic_id;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	public WordvnDto() {
		super();
		
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
