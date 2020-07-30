package kits.learnvocab.dto;

import java.io.Serializable;

public class NewDto implements Serializable{
	private int id;
	private String name_vn;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_vn() {
		return name_vn;
	}
	public void setName_vn(String name_vn) {
		this.name_vn = name_vn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
