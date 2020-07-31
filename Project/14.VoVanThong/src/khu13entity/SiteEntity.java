package khu13entity;

public class SiteEntity {
	private int id;
	private String site;
	private String status;
	public SiteEntity() {
		super();
	}
	public SiteEntity(int id, String site, String status) {
		
		this.id = id;
		this.site = site;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
