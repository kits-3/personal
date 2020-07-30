package kits.learnvocab.dto;

import java.io.Serializable;

public class ConnectWordDto implements Serializable{
	private int id;
	private String name;
	private int lang_id;
	private int vn_id;
	private int topic_id;
	
	
	
	public ConnectWordDto(int id, String name, int lang_id, int vn_id, int topic_id) {
		super();
		this.id = id;
		this.name = name;
		this.lang_id = lang_id;
		this.vn_id = vn_id;
		this.topic_id = topic_id;
	}
	public ConnectWordDto() {
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
	public int getLang_id() {
		return lang_id;
	}
	public void setLang_id(int lang_id) {
		this.lang_id = lang_id;
	}
	public int getVn_id() {
		return vn_id;
	}
	public void setVn_id(int vn_id) {
		this.vn_id = vn_id;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	
}
