package kits.learnvocab.dto;

import java.io.Serializable;

public class LanguageDto implements Serializable{
	private int id;
	private String lang;
	public LanguageDto(int id, String lang) {
		super();
		this.id = id;
		this.lang = lang;
	}
	public LanguageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	
}
