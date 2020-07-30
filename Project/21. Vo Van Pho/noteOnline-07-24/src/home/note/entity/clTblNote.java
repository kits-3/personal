package home.note.entity;

import java.io.Serializable;

public class clTblNote implements Serializable {
	 static final long serialVersionUID = 42L;
	private String id;
	private String namec;
	private String connent;
	private String date_reg;
	private String date_upd;
	private String userid;
	public clTblNote(String id, String namec, String connent, String date_reg, String date_upd, String userid) {
		super();
		this.id = id;
		this.namec = namec;
		this.connent = connent;
		this.date_reg = date_reg;
		this.date_upd = date_upd;
		this.userid = userid;
	} 
	public clTblNote() {};
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNamec() {
		return namec;
	}
	public void setNamec(String namec) {
		this.namec = namec;
	}
	public String getConnent() {
		return connent;
	}
	public void setConnent(String connent) {
		this.connent = connent;
	}
	public String getDate_reg() {
		return date_reg;
	}
	public void setDate_reg(String date_reg) {
		this.date_reg = date_reg;
	}
	public String getDate_upd() {
		return date_upd;
	}
	public void setDate_upd(String date_upd) {
		this.date_upd = date_upd;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
