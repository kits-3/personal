package kits.personal.dto;

import java.sql.Date;

public class BookDto {
	private int id;
	private String name;
	private String author;
	private String publisher;
	private Date loanDate;

	public BookDto(String name, String author, String publisher) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public BookDto() {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
