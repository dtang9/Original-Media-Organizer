package omo;

import java.util.Date;

public class Post {
	private int id;
	private String username;
	private String text;
	private Date date;
	
	public Post(int id, String username, String text, Date date) {
		this.id = id;
		this.username = username;
		this.text = text;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
