package kits.learnvocab.dto;

import java.io.Serializable;

public class TableExtra1Dto implements Serializable{
	private int id;
	private String name_vn;
	
	public TableExtra1Dto(int id, String name_vn) {
		super();
		this.id = id;
		this.name_vn = name_vn;
	}
	
	public TableExtra1Dto() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	
	
}
